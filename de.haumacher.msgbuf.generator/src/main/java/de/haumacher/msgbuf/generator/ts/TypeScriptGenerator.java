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

/**
 * Generator for a TypeScript module with type definitions describing the <code>msgbuf</code> JSON
 * format of all messages and enums of a <code>.proto</code> file.
 *
 * <p>
 * The module contains types only (no runtime code). Since the types describe the JSON format and
 * not the data itself, the name of a top-level type is the name of its definition with the suffix
 * {@value #JSON_SUFFIX}, e.g. <code>ShapeJson</code> for <code>message Shape</code>:
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
		line("// Type definitions for the msgbuf JSON format of the protocol (types only, no runtime code).");
		if (Util.getFlag(_proto, "SharedGraph")) {
			line("//");
			line("// Note: The protocol uses 'option SharedGraph'. Its JSON format (objects as [type, id, {...}],");
			line("// references as object IDs, incremental updates) is not described by these types.");
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
		if (Util.getFlag(fileOf(root(def)), "OpenWorld")) {
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
		return ref(fileOf(target), path, context);
	}

	private String polymorphicRef(MessageDef target, Definition context) {
		List<String> path = path(target);
		path.set(path.size() - 1, polymorphicName(target));
		return ref(fileOf(target), path, context);
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

	/**
	 * The file containing the given definition.
	 *
	 * <p>
	 * Only top-level definitions have a direct reference to their file.
	 * </p>
	 */
	private static DefinitionFile fileOf(Definition def) {
		Definition current = def;
		while (current.getOuter() != null) {
			current = current.getOuter();
		}
		return current.getFile();
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
