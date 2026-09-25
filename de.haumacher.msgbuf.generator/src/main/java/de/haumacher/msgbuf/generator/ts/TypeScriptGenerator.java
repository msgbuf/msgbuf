/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;

import de.haumacher.msgbuf.generator.NameTable;
import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.ast.Type;
import de.haumacher.msgbuf.generator.common.DocTags;
import de.haumacher.msgbuf.generator.common.MsgBufJsonProtocol;
import de.haumacher.msgbuf.generator.common.Util;
import de.haumacher.msgbuf.generator.util.AbstractTypeScriptGenerator;
import de.haumacher.msgbuf.generator.util.CodeUtil;

/**
 * Generator for a TypeScript module with type definitions describing the <code>msgbuf</code> JSON
 * format of all messages and enums of a <code>.proto</code> file.
 *
 * <p>
 * The module contains types and, for type-tagged polymorphic values, small helper functions
 * operating on plain JSON values (no classes, no readers or writers, no runtime library). Since the
 * types describe the JSON format and not the data itself, the name of a top-level type is the name
 * of its definition with the suffix {@value #JSON_SUFFIX}, e.g. <code>ShapeJson</code> for <code>message Shape</code>:
 * </p>
 * <ul>
 * <li>A message becomes an <code>interface</code> whose properties are named with the JSON
 * property names of the message's fields. A property is required, if the Java writer always emits
 * it, and optional (<code>?</code>), if the Java writer omits it when the value is
 * <code>null</code> (fields marked <code>@Nullable</code> and non-repeated fields with message or
 * <code>json</code> type). A non-nullable <code>bytes</code> field is written as <code>null</code>
 * when it has no value and is therefore typed <code>string | null</code>. Note that the
 * <code>msgbuf</code> JSON reader is more lenient and accepts any subset of properties, using the
 * field default for a missing one.</li>
 * <li>A message that inherits from another message <code>extends</code> the interface of its
 * generalization.</li>
 * <li>An abstract message in a hierarchy with an abstract root is serialized polymorphically as
 * <code>[typeId, {...}]</code>. For such message, an additional union type
 * <code>Any&lt;Name&gt;Json</code> of type-tagged tuples of all known concrete specializations is
 * generated and used for fields referencing the abstract message.</li>
 * <li>An enum becomes a union of string literal types with the protocol names of its constants.</li>
 * <li>Nested definitions are placed in a namespace named after the outer message and keep their
 * names, e.g. <code>GroupJson.Info</code>.</li>
 * <li>Types from other <code>.proto</code> files are imported with <code>import type</code>.</li>
 * <li>For each <code>Any&lt;Name&gt;Json</code> union, a visitor interface
 * <code>&lt;Part&gt;JsonVisitor</code> with a method <code>visit&lt;Part&gt;</code> per concrete type
 * (and <code>visitDefault</code> for <code>option OpenWorld</code>), a dispatch function
 * <code>visit&lt;Part&gt;Json</code> and a type guard <code>isAny&lt;Part&gt;Json</code> checking the
 * type tag are generated. Each concrete message in such hierarchy gets a function
 * <code>tag&lt;Part&gt;</code> creating its type-tagged tuple. <code>&lt;Part&gt;</code> is the message
 * name qualified with the names of its outer messages, joined with <code>_</code>, e.g.
 * <code>Group_Info</code>. All helpers are declared at the top level of the module, also
 * for nested messages. No helpers are generated for <code>option SharedGraph</code>.</li>
 * </ul>
 */
public class TypeScriptGenerator extends AbstractTypeScriptGenerator {

	/**
	 * Prefix of the name of the union type describing polymorphic values of an abstract message.
	 */
	public static final String POLYMORPHIC_PREFIX = "Any";

	/**
	 * Suffix of the names of top-level types.
	 *
	 * <p>
	 * The generated types describe the JSON format only. The suffix keeps the plain names free for
	 * types that represent the data itself.
	 * </p>
	 */
	public static final String JSON_SUFFIX = "Json";

	private static final Pattern IDENTIFIER = Pattern.compile("[A-Za-z_$][A-Za-z0-9_$]*");

	private final File _file;

	private final DefinitionFile _proto;

	private final String _source;

	private final Function<DefinitionFile, String> _moduleSpecifier;

	private final NameTable _table;

	/**
	 * Whether helper functions for polymorphic values are generated, see {@link #hasHelpers(DefinitionFile)}.
	 */
	private final boolean _helpers;

	/**
	 * Local names bound per imported file (by top-level name in that file).
	 */
	private final Map<DefinitionFile, Map<String, String>> _imports = new LinkedHashMap<>();

	/**
	 * All names bound at the top level of the generated module.
	 */
	private final Set<String> _topLevelNames = new HashSet<>();

	/**
	 * Top-level aliases for references that are shadowed by nested declarations, alias name to
	 * referenced type.
	 */
	private final Map<String, String> _aliases = new LinkedHashMap<>();

	/**
	 * Whether the next block of declarations must be separated by an empty line.
	 */
	private boolean _separate;

	/**
	 * Creates a {@link TypeScriptGenerator}.
	 *
	 * @param file
	 *        The TypeScript module file to create.
	 * @param proto
	 *        The definitions to generate types for.
	 * @param source
	 *        A description of the source of the definitions for the header comment.
	 * @param moduleSpecifier
	 *        Function computing the module specifier (relative to the module being generated) of
	 *        the TypeScript module for another {@link DefinitionFile}.
	 * @param table
	 *        The {@link NameTable} for resolving type names in links of documentation comments.
	 */
	public TypeScriptGenerator(File file, DefinitionFile proto, String source, Function<DefinitionFile, String> moduleSpecifier, NameTable table) {
		_file = file;
		_proto = proto;
		_source = source;
		_moduleSpecifier = moduleSpecifier;
		_table = table;
		_helpers = hasHelpers(proto);
	}

	/**
	 * Runs the generation.
	 */
	public void run() {
		System.out.println("Generating '" + _file + "'.");
		File dir = _file.getParentFile();
		if (dir != null) {
			dir.mkdirs();
		}
		try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(_file), "utf-8")) {
			generate(out, 0);
		} catch (IOException ex) {
			throw new IOError(ex);
		}
	}

	@Override
	protected void generate() {
		resolveReferences();

		line("// Generated by msgbuf from '" + _source + "'. Do not edit.");
		line("//");
		if (hasHelpers()) {
			line("// Type definitions for the msgbuf JSON format of the protocol, and helper functions for its");
			line("// type-tagged polymorphic values (visitor dispatch, tagging, tag guards).");
		} else {
			line("// Type definitions for the msgbuf JSON format of the protocol (types only, no runtime code).");
		}
		if (Util.getFlag(_proto, "SharedGraph")) {
			line("//");
			line("// Note: The protocol uses 'option SharedGraph'. Its JSON format (objects as [type, id, {...}],");
			line("// references as object IDs, incremental updates) is not described by these types. No helper");
			line("// functions for polymorphic values are generated.");
		}
		_separate = true;

		String fileComment = fileComment();
		if (!fileComment.isEmpty()) {
			separate();
			docComment(fileComment);
		}

		if (!_imports.isEmpty()) {
			separate();
		}
		for (Map.Entry<DefinitionFile, Map<String, String>> entry : _imports.entrySet()) {
			List<String> names = new ArrayList<>();
			for (Map.Entry<String, String> binding : entry.getValue().entrySet()) {
				String name = binding.getKey();
				String local = binding.getValue();
				names.add(name.equals(local) ? name : name + " as " + local);
			}
			line("import type { " + String.join(", ", names) + " } from " + stringLiteral(_moduleSpecifier.apply(entry.getKey())) + ";");
		}
		for (Definition def : _proto.getDefinitions()) {
			generateDefinition(def);
			if (_helpers) {
				generateHelpers(def);
			}
		}

		for (Map.Entry<String, String> alias : _aliases.entrySet()) {
			separate();
			line("type " + alias.getKey() + " = " + alias.getValue() + ";");
		}
	}

	/**
	 * Starts a new block of declarations separated by an empty line from a preceding one in the
	 * same scope.
	 */
	private void separate() {
		if (_separate) {
			nl();
		}
		_separate = true;
	}

	/**
	 * Computes all type references in advance to be able to create the import statements and
	 * aliases before the definitions.
	 */
	private void resolveReferences() {
		for (Definition def : _proto.getDefinitions()) {
			_topLevelNames.add(jsonTypeName(def));
			if (hasPolymorphicType(def)) {
				_topLevelNames.add(polymorphicName(def));
			}
		}
		if (_helpers) {
			for (Definition def : _proto.getDefinitions()) {
				forEachMessage(def, message -> _topLevelNames.addAll(helperNames(message)));
			}
		}
		for (Definition def : _proto.getDefinitions()) {
			resolveReferences(def);
		}
		// Links in documentation comments may require further imports.
		fileComment();
		for (Definition def : _proto.getDefinitions()) {
			resolveDocReferences(def);
		}
	}

	private void resolveDocReferences(Definition def) {
		if (def instanceof EnumDef) {
			EnumDef enumDef = (EnumDef) def;
			doc(enumDef.getComment(), enumDef);
			for (Constant constant : enumDef.getConstants()) {
				doc(constant.getComment(), enumDef);
			}
		} else {
			MessageDef message = (MessageDef) def;
			messageComment(message);
			for (Field field : jsonFields(message)) {
				fieldComment(field, message);
			}
			for (Definition inner : message.getDefinitions()) {
				resolveDocReferences(inner);
			}
		}
	}

	private void resolveReferences(Definition def) {
		if (def instanceof MessageDef) {
			MessageDef message = (MessageDef) def;
			MessageDef extendedDef = message.getExtendedDef();
			if (extendedDef != null) {
				ref(extendedDef, message);
			}
			for (Field field : jsonFields(message)) {
				typeExpr(field, message);
			}
			if (hasPolymorphicType(message)) {
				polymorphicType(message);
				if (_helpers) {
					// References of the top-level helper declarations.
					ref(message, null);
					for (MessageDef specialization : Util.concreteTransitiveSpecializations(message)) {
						ref(specialization, null);
					}
				}
			}
			for (Definition inner : message.getDefinitions()) {
				resolveReferences(inner);
			}
		}
	}

	private void generateDefinition(Definition def) {
		if (def instanceof EnumDef) {
			generateEnum((EnumDef) def);
		} else {
			generateMessage((MessageDef) def);
		}
	}

	private void generateEnum(EnumDef def) {
		separate();
		docComment(doc(def.getComment(), def));
		List<Constant> constants = def.getConstants();
		if (constants.isEmpty()) {
			line("export type " + jsonTypeName(def) + " = never;");
		} else {
			line("export type " + jsonTypeName(def) + " =");
			for (int n = 0, cnt = constants.size(); n < cnt; n++) {
				Constant constant = constants.get(n);
				indentedDocComment(doc(constant.getComment(), def));
				line("\t| " + stringLiteral(MsgBufJsonProtocol.classifierId(constant)) + (n == cnt - 1 ? ";" : ""));
			}
		}
	}

	private void indentedDocComment(String comment) {
		if (comment != null && !comment.isEmpty()) {
			line("\t/**");
			for (String line : comment.split("\n")) {
				line("\t *" + (line.isEmpty() ? "" : " " + line));
			}
			line("\t */");
		}
	}

	private void generateMessage(MessageDef def) {
		separate();
		docComment(messageComment(def));
		MessageDef extendedDef = def.getExtendedDef();
		String extendsClause = extendedDef == null ? "" : " extends " + ref(extendedDef, def);
		List<Field> fields = jsonFields(def);
		if (fields.isEmpty()) {
			line("export interface " + jsonTypeName(def) + extendsClause + " {}");
		} else {
			line("export interface " + jsonTypeName(def) + extendsClause + " {");
			boolean first = true;
			for (Field field : fields) {
				if (first) {
					first = false;
				} else {
					nl();
				}
				docComment(fieldComment(field, def));
				line(propertyName(field) + (Util.isNullable(field) ? "?: " : ": ") + propertyType(field, def) + ";");
			}
			line("}");
		}

		if (hasPolymorphicType(def)) {
			separate();
			docComment("Polymorphic JSON representation of a {@link " + jsonTypeName(def) + "}: a tuple of the type ID and the properties of a concrete type.");
			line("export type " + polymorphicName(def) + " = " + polymorphicType(def) + ";");
		}

		if (!def.getDefinitions().isEmpty()) {
			separate();
			line("export namespace " + jsonTypeName(def) + " {");
			_separate = false;
			for (Definition inner : def.getDefinitions()) {
				generateDefinition(inner);
			}
			line("}");
			_separate = true;
		}
	}

	/**
	 * Whether helper functions for polymorphic values are generated for the given file.
	 *
	 * <p>
	 * The JSON format of <code>option SharedGraph</code> is not described by the generated types,
	 * helpers operating on these types would be misleading.
	 * </p>
	 */
	private static boolean hasHelpers(DefinitionFile file) {
		return !Util.getFlag(file, "SharedGraph");
	}

	/**
	 * Whether the generated module contains helper functions.
	 */
	private boolean hasHelpers() {
		if (!_helpers) {
			return false;
		}
		boolean[] result = { false };
		for (Definition def : _proto.getDefinitions()) {
			forEachMessage(def, message -> result[0] |= !helperNames(message).isEmpty());
		}
		return result[0];
	}

	private static void forEachMessage(Definition def, Consumer<MessageDef> action) {
		if (def instanceof MessageDef) {
			MessageDef message = (MessageDef) def;
			action.accept(message);
			for (Definition inner : message.getDefinitions()) {
				forEachMessage(inner, action);
			}
		}
	}

	/**
	 * Whether a value of the given message is written with a type tag, when referenced through one of
	 * its abstract generalizations.
	 *
	 * <p>
	 * This is the case for a concrete message whose hierarchy root is abstract.
	 * </p>
	 */
	private static boolean isTagged(MessageDef def) {
		return !def.isAbstract() && def.getExtendedDef() != null && root(def).isAbstract();
	}

	/**
	 * The top-level names of the helper declarations generated for the given message (not
	 * including the helpers of nested messages).
	 */
	private static List<String> helperNames(MessageDef def) {
		List<String> result = new ArrayList<>();
		if (hasPolymorphicType(def)) {
			result.add(visitorName(def));
			result.add(dispatchName(def));
			result.add(guardName(def));
		}
		if (isTagged(def)) {
			result.add(tagName(def));
		}
		return result;
	}

	/**
	 * The name part of helper declarations for the given message.
	 *
	 * <p>
	 * The name of the message qualified with the names of its outer messages, separated by
	 * <code>_</code>, with the first letter in upper case, e.g. <code>Group_Info</code> for
	 * message <code>Info</code> nested in <code>Group</code>. The package is not part of the name.
	 * </p>
	 */
	private static String helperPart(MessageDef def) {
		List<String> names = new ArrayList<>();
		for (Definition current = def; current != null; current = current.getOuter()) {
			names.add(0, current.getName());
		}
		return CodeUtil.firstUpperCase(String.join("_", names));
	}

	/**
	 * Name of the visitor interface for the given abstract message.
	 */
	private static String visitorName(MessageDef def) {
		return helperPart(def) + JSON_SUFFIX + "Visitor";
	}

	/**
	 * Name of the function dispatching a polymorphic value of the given abstract message to a
	 * visitor.
	 */
	private static String dispatchName(MessageDef def) {
		return "visit" + helperPart(def) + JSON_SUFFIX;
	}

	/**
	 * Name of the type guard for polymorphic values of the given abstract message.
	 */
	private static String guardName(MessageDef def) {
		return "is" + POLYMORPHIC_PREFIX + helperPart(def) + JSON_SUFFIX;
	}

	/**
	 * Name of the visitor method handling the given concrete message.
	 */
	private static String visitMethodName(MessageDef def) {
		return "visit" + helperPart(def);
	}

	/**
	 * Name of the function creating the type-tagged representation of the given concrete message.
	 */
	private static String tagName(MessageDef def) {
		return "tag" + helperPart(def);
	}

	/**
	 * Whether the polymorphic values of the given abstract message may have types that are not
	 * known to the generated module (<code>option OpenWorld</code> of the hierarchy root).
	 */
	private static boolean isOpen(MessageDef def) {
		return Util.getFlag(Util.definingFile(root(def)), "OpenWorld");
	}

	/**
	 * Checks that the names of the TypeScript helper declarations of the given file are unique.
	 *
	 * <p>
	 * The visitor method names of a hierarchy must be unique within the hierarchy (also across
	 * files), and the helper function names of a module must be unique within the module.
	 * </p>
	 *
	 * @param file
	 *        The file to generate a TypeScript module for.
	 * @param source
	 *        Description of a file for error messages.
	 * @param errors
	 *        The errors found.
	 */
	public static void validate(DefinitionFile file, Function<DefinitionFile, String> source, List<String> errors) {
		if (!hasHelpers(file)) {
			return;
		}
		Set<String> reported = new HashSet<>();
		Map<String, MessageDef> moduleNames = new LinkedHashMap<>();
		for (Definition def : file.getDefinitions()) {
			forEachMessage(def, message -> {
				for (String name : helperNames(message)) {
					MessageDef clash = moduleNames.putIfAbsent(name, message);
					if (clash != null) {
						errors.add(source.apply(file) + ": The TypeScript declaration '" + name + "' is generated for message '"
							+ protoName(clash) + "' and for message '" + protoName(message) + "'. " + renameHint());
					}
				}

				if (hasPolymorphicType(message)) {
					Map<String, MessageDef> methods = new LinkedHashMap<>();
					for (MessageDef specialization : Util.concreteTransitiveSpecializations(message)) {
						String method = visitMethodName(specialization);
						MessageDef clash = methods.putIfAbsent(method, specialization);
						if (clash != null && reported.add(protoName(clash) + " " + protoName(specialization))) {
							errors.add(source.apply(file) + ": The TypeScript visitor '" + visitorName(message) + "' of message '"
								+ protoName(message) + "' requires a method '" + method + "' for message '" + protoName(clash)
								+ "' of '" + source.apply(Util.definingFile(clash)) + "' and for message '"
								+ protoName(specialization) + "' of '" + source.apply(Util.definingFile(specialization))
								+ "'. " + renameHint());
						}
					}
				}
			});
		}
	}

	/**
	 * The name of the given definition qualified with its package and outer messages, as written in
	 * the <code>.proto</code> file.
	 */
	private static String protoName(Definition def) {
		List<String> names = new ArrayList<>();
		for (Definition current = def; current != null; current = current.getOuter()) {
			names.add(0, current.getName());
		}
		QName pkg = Util.definingFile(def).getPackage();
		if (pkg != null) {
			names.addAll(0, pkg.getNames());
		}
		return String.join(".", names);
	}

	private static String renameHint() {
		return "Rename one of the messages (TypeScript helper names are derived from the message name qualified with"
			+ " the names of its outer messages, joined with '_', without the package).";
	}

	/**
	 * Generates the helper declarations for the given top-level definition and its nested
	 * definitions.
	 *
	 * <p>
	 * All helpers are placed at the top level of the module, also for nested definitions: A
	 * namespace containing values is not erasable TypeScript syntax, only type declarations are
	 * placed in namespaces.
	 * </p>
	 */
	private void generateHelpers(Definition def) {
		forEachMessage(def, message -> {
			if (hasPolymorphicType(message)) {
				generateVisitor(message);
				generateDispatch(message);
				generateGuard(message);
			}
			if (isTagged(message)) {
				generateTag(message);
			}
		});
	}

	private void generateVisitor(MessageDef def) {
		List<MessageDef> specializations = Util.concreteTransitiveSpecializations(def);
		boolean open = isOpen(def);
		String type = ref(def, null);

		separate();
		String comment = "Handlers for all concrete types of {@link " + type + "}.";
		if (open) {
			comment += "\n\nThe hierarchy is open (option OpenWorld), a type not known to this module is handled by {@link "
				+ visitorName(def) + ".visitDefault}.";
		}
		docComment(comment);
		if (specializations.isEmpty() && !open) {
			line("export interface " + visitorName(def) + "<R> {}");
			return;
		}
		line("export interface " + visitorName(def) + "<R> {");
		boolean first = true;
		for (MessageDef specialization : specializations) {
			if (first) {
				first = false;
			} else {
				nl();
			}
			String specializationType = ref(specialization, null);
			docComment("Handles a {@link " + specializationType + "}.");
			line("" + visitMethodName(specialization) + "(self: " + specializationType + "): R;");
		}
		if (open) {
			if (!first) {
				nl();
			}
			docComment("Handles a type that is not known to this module, e.g. an extension defined in another module.\n\n"
				+ "@param self - The properties of the value.\n"
				+ "@param typeId - The type ID of the value.");
			line("visitDefault(self: " + type + ", typeId: string): R;");
		}
		line("}");
	}

	private void generateDispatch(MessageDef def) {
		boolean open = isOpen(def);
		separate();
		docComment("Dispatches a type-tagged {@link " + polymorphicRef(def, null)
			+ "} value to the handler of its concrete type.\n\n"
			+ (open
				? "A type ID not known to this module is dispatched to {@link " + visitorName(def) + ".visitDefault}."
				: "@throws Error if the type ID is not known."));
		line("export function " + dispatchName(def) + "<R>(value: " + polymorphicRef(def, null) + ", visitor: "
			+ visitorName(def) + "<R>): R {");
		line("switch (value[0]) {");
		for (MessageDef specialization : Util.concreteTransitiveSpecializations(def)) {
			String self = open ? "value[1] as " + ref(specialization, null) : "value[1]";
			line("case " + stringLiteral(MsgBufJsonProtocol.typeId(specialization)) + ": return visitor."
				+ visitMethodName(specialization) + "(" + self + ");");
		}
		if (open) {
			line("default: return visitor.visitDefault(value[1], value[0]);");
		} else {
			// A missing case is a compile error: the type ID is not narrowed to never.
			line("default: {");
			line("const unknownType: never = value[0];");
			line("throw new Error('Unknown type ID: ' + unknownType);");
			line("}");
		}
		line("}");
		line("}");
	}

	private void generateGuard(MessageDef def) {
		boolean open = isOpen(def);
		List<MessageDef> specializations = Util.concreteTransitiveSpecializations(def);
		String type = polymorphicRef(def, null);

		separate();
		docComment("Checks whether the given value is a type-tagged {@link " + type + "} value: a tuple of a "
			+ (open ? "type ID" : "known type ID") + " and an object.\n\n"
			+ "Only the type ID and the shape of the tuple are checked, not the properties of the object.");
		line("export function " + guardName(def) + "(value: unknown): value is " + type + " {");
		if (specializations.isEmpty() && !open) {
			line("// No concrete type is known.");
			line("return false;");
		} else {
			String tagCheck;
			if (open) {
				tagCheck = "typeof value[0] === 'string'";
			} else {
				List<String> checks = new ArrayList<>();
				for (MessageDef specialization : specializations) {
					checks.add("value[0] === " + stringLiteral(MsgBufJsonProtocol.typeId(specialization)));
				}
				tagCheck = checks.size() == 1 ? checks.get(0) : "(" + String.join(" || ", checks) + ")";
			}
			line("return Array.isArray(value) && value.length === 2");
			line("\t&& " + tagCheck);
			line("\t&& typeof value[1] === 'object' && value[1] !== null && !Array.isArray(value[1]);");
		}
		line("}");
	}

	private void generateTag(MessageDef def) {
		String type = ref(def, null);
		String tag = stringLiteral(MsgBufJsonProtocol.typeId(def));
		separate();
		docComment("Creates the type-tagged JSON representation of a {@link " + type + "}.");
		line("export function " + tagName(def) + "(self: " + type + "): [" + tag + ", " + type + "] {");
		line("return [" + tag + ", self];");
		line("}");
	}

	private String fileComment() {
		String comment = doc(_proto.getComment(), null);
		return comment == null || comment.isEmpty() ? "" : comment + "\n\n@packageDocumentation";
	}

	private String messageComment(MessageDef def) {
		String comment = doc(def.getComment(), def);
		if (def.isAbstract()) {
			String note = "Abstract type, the properties are only present in the JSON of its concrete specializations.";
			comment = comment == null || comment.isEmpty() ? note : comment + "\n\n" + note;
		}
		return comment;
	}

	private String fieldComment(Field field, MessageDef owner) {
		String comment = doc(field.getComment(), owner);
		String defaultValue = field.getDefaultValue();
		if (defaultValue != null) {
			String tag = "@defaultValue " + defaultValue;
			comment = comment == null || comment.isEmpty() ? tag : comment + "\n\n" + tag;
		}
		return comment;
	}

	/**
	 * Translates JavaDoc inline tags in the given documentation comment to TSDoc.
	 *
	 * <ul>
	 * <li><code>{@literal {@code x}}</code> becomes <code>`x`</code>, <code>{@literal {@literal x}}</code>
	 * becomes <code>x</code>.</li>
	 * <li><code>{@literal {@link Type}}</code> and <code>{@literal {@link Type#field label}}</code>
	 * become links to the TypeScript type and its property, e.g. <code>{@literal {@link Type.prop label}}</code>.
	 * A reference to an enum constant becomes its protocol name in back ticks. A target that cannot
	 * be resolved becomes its label, or the target name in back ticks.</li>
	 * </ul>
	 *
	 * @param comment
	 *        The comment to translate.
	 * @param owner
	 *        The message or enum whose members are referenced by <code>#member</code>, and whose
	 *        declaration contains the comment. <code>null</code> for the comment of the module.
	 */
	private String doc(String comment, Definition owner) {
		return DocTags.replaceInlineTags(comment, (tag, content) -> {
			switch (tag) {
				case "code":
					return "`" + content + "`";
				case "literal":
					return content;
				case "link":
				case "linkplain":
					return link(content, owner);
				default:
					return null;
			}
		});
	}

	private String link(String content, Definition owner) {
		int space = indexOfWhitespace(content);
		String target = space < 0 ? content : content.substring(0, space);
		String label = space < 0 ? null : content.substring(space).trim();

		int hash = target.indexOf('#');
		String typeName = hash < 0 ? target : target.substring(0, hash);
		String member = hash < 0 ? null : target.substring(hash + 1);

		Definition type;
		if (typeName.isEmpty()) {
			type = owner;
		} else {
			MessageDef lookupContext = owner instanceof MessageDef ? (MessageDef) owner : owner == null ? null : owner.getOuter();
			type = _table.resolve(lookupContext, QName.create().setNames(Arrays.asList(typeName.split("\\."))));
		}

		if (type != null) {
			if (member == null) {
				return "{@link " + ref(type, owner) + (label == null ? "" : " " + label) + "}";
			}
			if (type instanceof MessageDef) {
				MessageDef declaring = (MessageDef) type;
				Field field = null;
				while (declaring != null && (field = localField(declaring, member)) == null) {
					declaring = declaring.getExtendedDef();
				}
				if (field != null && !field.isTransient() && !field.isDerived()) {
					String property = MsgBufJsonProtocol.fieldId(field);
					if (IDENTIFIER.matcher(property).matches()) {
						return "{@link " + ref(declaring, owner) + "." + property + (label == null ? "" : " " + label) + "}";
					}
					return label != null ? label : "`" + property + "`";
				}
			} else {
				for (Constant constant : ((EnumDef) type).getConstants()) {
					if (constant.getName().equals(member)) {
						return label != null ? label : "`" + stringLiteral(MsgBufJsonProtocol.classifierId(constant)) + "`";
					}
				}
			}
		}

		// Not resolvable.
		if (label != null) {
			return label;
		}
		String text = typeName.isEmpty() ? member : member == null ? typeName : typeName + "." + member;
		return "`" + text + "`";
	}

	private static Field localField(MessageDef def, String name) {
		for (Field field : def.getFields()) {
			if (field.getName().equals(name)) {
				return field;
			}
		}
		return null;
	}

	private static int indexOfWhitespace(String text) {
		for (int n = 0, cnt = text.length(); n < cnt; n++) {
			if (Character.isWhitespace(text.charAt(n))) {
				return n;
			}
		}
		return -1;
	}

	/**
	 * The fields of the given message that are part of its JSON serialization.
	 */
	private static List<Field> jsonFields(MessageDef def) {
		List<Field> result = new ArrayList<>();
		for (Field field : def.getFields()) {
			if (field.isTransient() || field.isDerived()) {
				continue;
			}
			result.add(field);
		}
		return result;
	}

	private static String propertyName(Field field) {
		String name = MsgBufJsonProtocol.fieldId(field);
		return IDENTIFIER.matcher(name).matches() ? name : stringLiteral(name);
	}

	/**
	 * Whether values of the given definition are serialized with a type tag
	 * (<code>[typeId, {...}]</code>).
	 *
	 * <p>
	 * This is the case for an abstract message whose hierarchy root is abstract. A concrete message
	 * with a generalization is written without type information when referenced by its own type, and
	 * a message in a hierarchy with a concrete root is always written without type information.
	 * </p>
	 */
	private static boolean hasPolymorphicType(Definition def) {
		if (!(def instanceof MessageDef)) {
			return false;
		}
		MessageDef message = (MessageDef) def;
		return message.isAbstract() && root(message).isAbstract();
	}

	private static MessageDef root(MessageDef def) {
		MessageDef result = def;
		while (result.getExtendedDef() != null) {
			result = result.getExtendedDef();
		}
		return result;
	}

	private static String polymorphicName(Definition def) {
		return POLYMORPHIC_PREFIX + jsonTypeName(def);
	}

	/**
	 * The name of the TypeScript type describing the JSON format of the given definition.
	 *
	 * <p>
	 * Top-level types get the {@link #JSON_SUFFIX}. Nested types keep their name, since they are
	 * qualified with the namespace of their (suffixed) top-level type.
	 * </p>
	 */
	private static String jsonTypeName(Definition def) {
		return def.getOuter() == null ? def.getName() + JSON_SUFFIX : def.getName();
	}

	private String polymorphicType(MessageDef def) {
		List<String> alternatives = new ArrayList<>();
		for (MessageDef specialization : Util.concreteTransitiveSpecializations(def)) {
			alternatives.add("[" + stringLiteral(MsgBufJsonProtocol.typeId(specialization)) + ", " + ref(specialization, def) + "]");
		}
		if (Util.getFlag(Util.definingFile(root(def)), "OpenWorld")) {
			// Extension types from other modules.
			alternatives.add("[string, " + ref(def, def) + "]");
		}
		return alternatives.isEmpty() ? "never" : String.join(" | ", alternatives);
	}

	/**
	 * The type of the property for the given field, including <code>null</code> if the Java
	 * writer emits a <code>null</code> value for it.
	 */
	private String propertyType(Field field, MessageDef context) {
		String type = typeExpr(field, context);
		if (!field.isRepeated() && !Util.isNullable(field) && isBytes(field.getType())) {
			// Written with JsonUtil.writeBinaryOptional(), the default value is null.
			return type + " | null";
		}
		return type;
	}

	private static boolean isBytes(Type type) {
		return type instanceof PrimitiveType && ((PrimitiveType) type).getKind() == PrimitiveType.Kind.BYTES;
	}

	private String typeExpr(Field field, MessageDef context) {
		String elementType = typeExpr(field.getType(), context);
		if (field.isRepeated()) {
			return elementType.matches("[\\w$.]+") ? elementType + "[]" : "Array<" + elementType + ">";
		}
		return elementType;
	}

	private String typeExpr(Type type, MessageDef context) {
		if (type instanceof PrimitiveType) {
			return primitiveType(((PrimitiveType) type).getKind());
		} else if (type instanceof MapType) {
			MapType mapType = (MapType) type;
			Type keyType = mapType.getKeyType();
			String valueType = typeExpr(mapType.getValueType(), context);
			if (keyType instanceof PrimitiveType && ((PrimitiveType) keyType).getKind() == PrimitiveType.Kind.STRING) {
				return "Record<string, " + valueType + ">";
			} else {
				return "Array<{ key: " + typeExpr(keyType, context) + "; value: " + valueType + " }>";
			}
		} else if (type instanceof CustomType) {
			Definition definition = ((CustomType) type).getDefinition();
			if (definition == null) {
				System.err.println("ERROR: No definition found for type '" + type + "'.");
				return "unknown";
			}
			if (hasPolymorphicType(definition)) {
				return polymorphicRef((MessageDef) definition, context);
			}
			return ref(definition, context);
		}
		throw new IllegalArgumentException("Unsupported type: " + type);
	}

	private static String primitiveType(PrimitiveType.Kind kind) {
		switch (kind) {
			case BOOL:
				return "boolean";

			case FLOAT:
			case DOUBLE:
			case INT_32:
			case UINT_32:
			case SINT_32:
			case FIXED_32:
			case SFIXED_32:
			case INT_64:
			case UINT_64:
			case SINT_64:
			case FIXED_64:
			case SFIXED_64:
				return "number";

			case STRING:
				return "string";

			case BYTES:
				// Base64 encoded.
				return "string";

			case JSON:
				return "unknown";
		}
		throw new IllegalArgumentException("No such type: " + kind);
	}

	/**
	 * Reference to the given definition from within the given declaration.
	 *
	 * @param context
	 *        The declaration containing the reference (determines the namespace scope of the
	 *        reference), <code>null</code> for a reference at the top level of the module.
	 */
	private String ref(Definition target, Definition context) {
		List<String> path = path(target);
		return ref(Util.definingFile(target), path, context);
	}

	private String polymorphicRef(MessageDef target, Definition context) {
		List<String> path = path(target);
		path.set(path.size() - 1, polymorphicName(target));
		return ref(Util.definingFile(target), path, context);
	}

	private String ref(DefinitionFile file, List<String> path, Definition context) {
		String topLevel = path.get(0);
		String binding = file == _proto ? topLevel : importBinding(file, topLevel);
		StringBuilder buffer = new StringBuilder(binding);
		for (String name : path.subList(1, path.size())) {
			buffer.append('.').append(name);
		}
		String result = buffer.toString();
		if (isShadowed(binding, context)) {
			String alias = "__" + result.replace('.', '_');
			_aliases.put(alias, result);
			return alias;
		}
		return result;
	}

	/**
	 * Whether the given top-level name is hidden by a declaration in the namespace scopes in which
	 * the given declaration is placed.
	 */
	private static boolean isShadowed(String topLevelName, Definition context) {
		if (context == null) {
			return false;
		}
		for (MessageDef scope = context.getOuter(); scope != null; scope = scope.getOuter()) {
			for (Definition inner : scope.getDefinitions()) {
				if (jsonTypeName(inner).equals(topLevelName)) {
					return true;
				}
				if (hasPolymorphicType(inner) && polymorphicName(inner).equals(topLevelName)) {
					return true;
				}
			}
		}
		return false;
	}

	private String importBinding(DefinitionFile file, String name) {
		Map<String, String> bindings = _imports.computeIfAbsent(file, x -> new LinkedHashMap<>());
		String binding = bindings.get(name);
		if (binding == null) {
			binding = name;
			if (_topLevelNames.contains(binding)) {
				String prefix = file.getPackage() == null ? "" : Util.last(file.getPackage()) + "_";
				binding = prefix + name;
				int n = 2;
				while (_topLevelNames.contains(binding)) {
					binding = prefix + name + "_" + n++;
				}
			}
			_topLevelNames.add(binding);
			bindings.put(name, binding);
		}
		return binding;
	}

	private static List<String> path(Definition def) {
		List<String> result = new ArrayList<>();
		for (Definition current = def; current != null; current = current.getOuter()) {
			result.add(0, jsonTypeName(current));
		}
		return result;
	}

	private static String stringLiteral(String value) {
		return "'" + value.replace("\\", "\\\\").replace("'", "\\'") + "'";
	}

}
