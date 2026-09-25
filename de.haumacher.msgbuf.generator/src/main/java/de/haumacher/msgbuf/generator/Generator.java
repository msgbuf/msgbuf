/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.Definition.Visitor;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.Flag;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.NumberOption;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.ast.StringOption;
import de.haumacher.msgbuf.generator.ast.Type;
import de.haumacher.msgbuf.generator.common.MsgBufJsonProtocol;
import de.haumacher.msgbuf.generator.common.Util;
import de.haumacher.msgbuf.generator.dart.DartLibGenerator;
import de.haumacher.msgbuf.generator.parser.ParseException;
import de.haumacher.msgbuf.generator.parser.ProtobufParser;
import de.haumacher.msgbuf.generator.parser.ProtobufParserConstants;
import de.haumacher.msgbuf.generator.parser.Token;
import de.haumacher.msgbuf.generator.plugins.XmlStreamingPlugin;
import de.haumacher.msgbuf.generator.ts.TypeScriptGenerator;
import de.haumacher.msgbuf.generator.util.FileGenerator;

/**
 * Main entry point to the <code>msgbuf</code> generator.
 */
public class Generator {
	
	/**
	 * Argument giving the output directory.
	 */
	public static final String OUTPUT_DIR_ARG = "-out";

	/**
	 * Argument giving the resource output directory for generated service descriptors.
	 */
	public static final String RESOURCE_DIR_ARG = "-resources";

	/**
	 * Argument giving the output directory for TypeScript type definitions.
	 *
	 * <p>
	 * If given, a TypeScript module is generated for each <code>.proto</code> file, see
	 * {@link #setTypeScriptOut(File)}.
	 * </p>
	 */
	public static final String TYPESCRIPT_DIR_ARG = "-ts";

	/**
	 * File option giving the location of the TypeScript module to generate for a
	 * <code>.proto</code> file (relative to the output directory).
	 */
	public static final String TYPESCRIPT_OPTION = "TypeScript";

	/**
	 * File extension of generated TypeScript modules.
	 */
	private static final String TS_EXTENSION = ".ts";

	/**
	 * Module name for a <code>.proto</code> file whose file name is unknown.
	 */
	private static final String DEFAULT_MODULE_NAME = "index";

	private NameTable _table = new NameTable();
	private File _out = new File(".");
	private File _resourceOut;
	private File _tsOut;
	private Map<DefinitionFile, String> _sourceNames = new HashMap<>();
	private List<DefinitionFile> _files = new ArrayList<>();
	private List<File> _includePaths = new ArrayList<>();
	private ClassLoader _importClassLoader;
	private Set<String> _loadedFiles = new HashSet<>();
	private Map<String, DefinitionFile> _fileByPath = new HashMap<>();
	private List<DefinitionFile> _importedFiles = new ArrayList<>();

	public void setOut(File out) {
		_out = out;
	}

	public void setResourceOut(File resourceOut) {
		_resourceOut = resourceOut;
	}

	/**
	 * Sets the root directory for TypeScript type definitions.
	 *
	 * <p>
	 * If set, a TypeScript module with type definitions for the JSON format is generated for each
	 * <code>.proto</code> file. The module for a file <code>name.proto</code> with
	 * <code>package a.b.c;</code> is written to <code>a/b/c/name.ts</code> within the given
	 * directory.
	 * </p>
	 */
	public void setTypeScriptOut(File tsOut) {
		_tsOut = tsOut;
	}

	public void addIncludePath(File path) {
		_includePaths.add(path);
	}

	/**
	 * Sets a class loader used to resolve imports from the classpath.
	 * Proto files packaged as resources in dependency JARs can be found this way.
	 */
	public void setImportClassLoader(ClassLoader classLoader) {
		_importClassLoader = classLoader;
	}

	public DefinitionFile load(String fileName) throws IOException, ParseException {
		return load(new File(fileName));
	}

	public DefinitionFile load(File file)
			throws ParseException, IOException, FileNotFoundException {
		String canonical = file.getCanonicalPath();
		DefinitionFile loaded = _fileByPath.get(canonical);
		if (loaded != null) {
			// The same file given twice, or given after being loaded as import of another file:
			// Generate code for it, but do not enter its definitions again.
			_importedFiles.remove(loaded);
			return loaded;
		}
		_loadedFiles.add(canonical);
		DefinitionFile content;
		try (InputStream in = new FileInputStream(file)) {
			content = load(parse(in));
		}
		_fileByPath.put(canonical, content);
		_sourceNames.put(content, file.getName());
		resolveImports(content, file);
		return content;
	}

	public DefinitionFile load(InputStream in) throws ParseException {
		return load(parse(in));
	}

	public static DefinitionFile parse(InputStream in) throws ParseException {
		ProtobufParser parser = new ProtobufParser(in, "utf-8");
		DefinitionFile definition = parser.file();
		Token nextToken = parser.getNextToken();
		if (nextToken.kind != ProtobufParserConstants.EOF) {
			throw new ParseException("Unexpected token '" + nextToken
					+ "' at line " + nextToken.beginLine + " column "
					+ nextToken.beginColumn + " .");
		}
		return definition;
	}

	public DefinitionFile load(DefinitionFile file) {
		_files.add(file);
		_table.enter(file);
		return file;
	}
	
	public void generate(GeneratorPlugin plugin) {
		for (DefinitionFile file : _files) {
			buildSpecializations(file);
		}

		List<String> errors = new ArrayList<>();
		// Duplicate definitions and ambiguous names.
		errors.addAll(_table.drainErrors(this::sourceDescription));
		if (!errors.isEmpty()) {
			throw new GeneratorException(errors);
		}
		for (DefinitionFile file : _files) {
			validateOpenWorld(file, errors);
		}

		// Propagate NoBinary and NoTypeKind to extension files that extend OpenWorld bases
		for (DefinitionFile file : _files) {
			propagateOpenWorldOptions(file);
		}

		for (DefinitionFile file : _files) {
			if (!_importedFiles.contains(file)) {
				validateGeneralizations(file, plugin, errors);
			}
		}
		if (!errors.isEmpty()) {
			// Checks below depend on a consistent hierarchy.
			throw new GeneratorException(errors);
		}
		for (DefinitionFile file : _files) {
			if (!_importedFiles.contains(file)) {
				validateFieldNames(file, errors);
				validateFormatReferences(file, plugin, errors);
			}
		}
		validateHierarchyNames(plugin, errors);
		if (!errors.isEmpty()) {
			throw new GeneratorException(errors);
		}

		TypeIdSynthesizer typeIdSynthesizer = new TypeIdSynthesizer();
		for (DefinitionFile file : _files) {
			if (!Util.getFlag(file, "OpenWorld")) {
				typeIdSynthesizer.process(file);
			}
		}

		FieldIDSynthesizer synthesizer = new FieldIDSynthesizer();
		for (DefinitionFile file : _files) {
			synthesizer.process(file);
		}

		for (DefinitionFile file : _files) {
			if (!_importedFiles.contains(file) && generatesTypeScript(file)) {
				TypeScriptGenerator.validate(file, this::sourceDescription, errors);
			}
		}
		if (!errors.isEmpty()) {
			throw new GeneratorException(errors);
		}

		for (DefinitionFile file : _files) {
			if (_importedFiles.contains(file)) {
				continue; // Imported for type resolution only, don't generate code
			}

			plugin.init(file.getOptions());

			File dir = mkdir(file.getPackage());

			PackageGenerator packageGenerator = new PackageGenerator(dir, file.getOptions(), plugin);
			for (Definition def : file.getDefinitions()) {
				def.visit(packageGenerator, null);
			}

			Option dartLib = file.getOptions().get("DartLib");
			if (dartLib != null) {
				new DartLibGenerator(new File(_out, ((StringOption) dartLib).getValue()), file).run();
			}

			if (generatesTypeScript(file)) {
				File tsFile = typeScriptModule(file);
				new TypeScriptGenerator(tsFile, file, sourceDescription(file),
					other -> moduleSpecifier(tsFile, typeScriptModule(other)), _table).run();
			}
		}

		// Generate registration classes and service loader descriptors for extension modules
		List<String> registrationClasses = new ArrayList<>();
		for (DefinitionFile file : _files) {
			if (_importedFiles.contains(file)) {
				continue;
			}
			List<MessageDef> crossFileExtensions = findCrossFileExtensions(file);
			if (!crossFileExtensions.isEmpty()) {
				String fqClassName = generateRegistrationClass(file, crossFileExtensions, plugin);
				registrationClasses.add(fqClassName);
			}
		}
		if (!registrationClasses.isEmpty() && _resourceOut != null) {
			generateServiceDescriptor(registrationClasses);
		}
	}

	/**
	 * Whether a TypeScript module is generated for the given definitions.
	 */
	private boolean generatesTypeScript(DefinitionFile file) {
		return _tsOut != null || file.getOptions().get(TYPESCRIPT_OPTION) != null;
	}

	/**
	 * The TypeScript module file for the given definitions.
	 *
	 * <p>
	 * An explicit {@link #TYPESCRIPT_OPTION} is resolved against the output directory. Otherwise,
	 * the module is placed in the directory of the file's package (within the TypeScript output
	 * directory, or the output directory, if none is set) and named after the <code>.proto</code>
	 * file.
	 * </p>
	 */
	private File typeScriptModule(DefinitionFile file) {
		Option explicit = file.getOptions().get(TYPESCRIPT_OPTION);
		if (explicit != null) {
			return new File(_out, ((StringOption) explicit).getValue()).toPath().normalize().toFile();
		}
		File result = _tsOut != null ? _tsOut : _out;
		if (file.getPackage() != null) {
			for (String name : file.getPackage().getNames()) {
				result = new File(result, name);
			}
		}
		return new File(result, moduleName(file) + TS_EXTENSION);
	}

	private String moduleName(DefinitionFile file) {
		String sourceName = _sourceNames.get(file);
		if (sourceName == null) {
			return DEFAULT_MODULE_NAME;
		}
		int dot = sourceName.lastIndexOf('.');
		return dot > 0 ? sourceName.substring(0, dot) : sourceName;
	}

	private String sourceDescription(DefinitionFile file) {
		String sourceName = _sourceNames.get(file);
		if (file.getPackage() == null) {
			return sourceName == null ? "<unknown>" : sourceName;
		}
		String packagePath = String.join("/", file.getPackage().getNames());
		return sourceName == null ? packagePath : packagePath + "/" + sourceName;
	}

	/**
	 * The relative module specifier (without file extension) to reference the given target module
	 * from the given module.
	 */
	private static String moduleSpecifier(File from, File to) {
		java.nio.file.Path fromDir = from.getAbsoluteFile().toPath().normalize().getParent();
		java.nio.file.Path target = to.getAbsoluteFile().toPath().normalize();
		String relative = fromDir.relativize(target).toString().replace(File.separatorChar, '/');
		if (relative.endsWith(TS_EXTENSION)) {
			relative = relative.substring(0, relative.length() - TS_EXTENSION.length());
		}
		return relative.startsWith("../") ? relative : "./" + relative;
	}

	private void validateOpenWorld(DefinitionFile file, List<String> errors) {
		boolean openWorld = Util.getFlag(file, "OpenWorld");
		if (!openWorld) {
			return;
		}
		// OpenWorld implies NoBinary
		file.getOptions().put("NoBinary", Flag.create().setValue(true));

		if (_importedFiles.contains(file)) {
			return;
		}
		for (String option : new String[] { "NoInterfaces", "SharedGraph" }) {
			if (Util.getFlag(file, option)) {
				errors.add(sourceDescription(file) + ": option OpenWorld cannot be combined with option " + option
					+ ". Remove one of the options.");
			}
		}
	}

	private void propagateOpenWorldOptions(DefinitionFile file) {
		if (Util.getFlag(file, "OpenWorld")) {
			// Already an OpenWorld file, options already set
			return;
		}
		if (extendsOpenWorldFromOtherFile(file, file.getDefinitions())) {
			// Extension file inherits NoBinary from OpenWorld base
			file.getOptions().put("NoBinary", Flag.create().setValue(true));
		}
	}

	private static boolean extendsOpenWorldFromOtherFile(DefinitionFile file, List<Definition> definitions) {
		for (Definition def : definitions) {
			if (def instanceof MessageDef) {
				MessageDef msg = (MessageDef) def;
				MessageDef extended = msg.getExtendedDef();
				if (extended != null) {
					DefinitionFile extendedFile = Util.definingFile(extended);
					if (extendedFile != file && Util.getFlag(extendedFile, "OpenWorld")) {
						return true;
					}
				}
				if (extendsOpenWorldFromOtherFile(file, msg.getDefinitions())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Rejects inheritance cycles and extensions of messages of other files that are inconsistent
	 * with <code>option OpenWorld</code>.
	 *
	 * <p>
	 * The readers of a hierarchy must know all its types. A message of another file can therefore
	 * only be extended if that file declares <code>option OpenWorld</code>, which makes its readers
	 * resolve extension types through a registry. The only exception is a closed hierarchy that is
	 * split into several files of the same package and generated together: then the readers of the
	 * extended message are generated with all its specializations.
	 * </p>
	 */
	private void validateGeneralizations(DefinitionFile file, GeneratorPlugin plugin, List<String> errors) {
		for (Definition def : file.getDefinitions()) {
			validateGeneralizations(file, def, plugin, errors);
		}
	}

	private void validateGeneralizations(DefinitionFile file, Definition def, GeneratorPlugin plugin, List<String> errors) {
		if (!(def instanceof MessageDef)) {
			return;
		}
		MessageDef message = (MessageDef) def;
		MessageDef extended = message.getExtendedDef();
		if (extended != null) {
			int errorCount = errors.size();
			List<MessageDef> path = new ArrayList<>();
			path.add(message);
			for (MessageDef current = extended; current != null; current = current.getExtendedDef()) {
				if (current == message) {
					path.add(current);
					errors.add(sourceDescription(file) + ": Message '" + Util.toString(message)
						+ "' is part of an inheritance cycle: "
						+ path.stream().map(Util::toString).collect(java.util.stream.Collectors.joining(" extends "))
						+ ". Remove one of the extends clauses.");
					break;
				}
				if (path.contains(current)) {
					// A cycle not containing this message, reported for its members.
					break;
				}
				path.add(current);
			}

			DefinitionFile extendedFile = Util.definingFile(extended);
			if (extendedFile != file && !Util.getFlag(extendedFile, "OpenWorld")
				&& !(samePackage(file, extendedFile) && !_importedFiles.contains(extendedFile))) {
				errors.add(sourceDescription(file) + ": Message '" + Util.toString(message) + "' extends message '"
					+ Util.toString(extended) + "' of '" + sourceDescription(extendedFile)
					+ "', which does not declare option OpenWorld. Add 'option OpenWorld;' to '"
					+ sourceDescription(extendedFile) + "' to extend its messages in other files"
					+ " (a hierarchy without OpenWorld can only be split into files of the same package"
					+ " that are generated together).");
			}

			if (Util.getFlag(file, "OpenWorld") && errors.size() == errorCount) {
				MessageDef root = extended;
				Set<MessageDef> seen = new HashSet<>();
				while (root.getExtendedDef() != null && seen.add(root)) {
					root = root.getExtendedDef();
				}
				DefinitionFile rootFile = Util.definingFile(root);
				if (!Util.getFlag(rootFile, "OpenWorld")) {
					errors.add(sourceDescription(file) + ": File declares option OpenWorld, but message '"
						+ Util.toString(message) + "' belongs to the hierarchy of '" + Util.toString(root) + "' of '"
						+ sourceDescription(rootFile) + "', which does not declare option OpenWorld. Add 'option OpenWorld;' to '"
						+ sourceDescription(rootFile) + "', or remove it from '" + sourceDescription(file) + "'.");
				}
			}

			if (extendedFile != file && errors.size() == errorCount) {
				validateExtensionOptions(file, message, extended, extendedFile, plugin, errors);
			}
		}

		for (Definition inner : message.getDefinitions()) {
			validateGeneralizations(file, inner, plugin, errors);
		}
	}

	/**
	 * Rejects an extension of a message of another file, if the two files generate incompatible
	 * code.
	 *
	 * <p>
	 * A specialization implements the abstract methods and overrides the methods of its
	 * generalization. So both files must generate the same serialization formats, visitors and type
	 * kinds, and use the same interface mode. A specialization may omit listener and reflection
	 * support of its generalization, but cannot add it.
	 * </p>
	 */
	private void validateExtensionOptions(DefinitionFile file, MessageDef message, MessageDef extended,
			DefinitionFile extendedFile, GeneratorPlugin plugin, List<String> errors) {
		String prefix = sourceDescription(file) + ": Message '" + Util.toString(message) + "' extends message '"
			+ Util.toString(extended) + "' of '" + sourceDescription(extendedFile) + "'";

		Set<String> formats = formats(file, plugin);
		Set<String> extendedFormats = formats(extendedFile, plugin);
		for (String format : extendedFormats) {
			if (!formats.contains(format) && !format.equals(GRAPH_JSON_FORMAT)) {
				errors.add(prefix + ", which is generated with " + format + " serialization, but '"
					+ sourceDescription(file) + "' is generated without (" + disabledBy(file, format)
					+ "). Use the same format options in both files.");
			}
		}

		Map<String, Option> options = file.getOptions();
		Map<String, Option> extendedOptions = extendedFile.getOptions();
		boolean visitor = !MessageGenerator.isTrue(options.get("NoVisitor"), false);
		boolean extendedVisitor = !MessageGenerator.isTrue(extendedOptions.get("NoVisitor"), false);
		checkSameOption(prefix, file, extendedFile, "NoVisitor", errors);
		if (visitor && extendedVisitor) {
			checkSameOption(prefix, file, extendedFile, "NoVisitorExceptions", errors);
		}
		checkSameOption(prefix, file, extendedFile, "NoTypeKind", errors);
		checkSameOption(prefix, file, extendedFile, "NoInterfaces", errors);

		boolean listener = MessageGenerator.isListener(options);
		boolean reflection = MessageGenerator.isReflection(options);
		if (listener && !MessageGenerator.isListener(extendedOptions)) {
			errors.add(prefix + ", which is generated without listener support (option NoListener), but '"
				+ sourceDescription(file) + "' is generated with it. Add 'option NoListener;' to '"
				+ sourceDescription(file) + "', or remove it from '" + sourceDescription(extendedFile) + "'.");
		} else if (reflection && !MessageGenerator.isReflection(extendedOptions)) {
			errors.add(prefix + ", which is generated without reflection (option NoReflection), but '"
				+ sourceDescription(file) + "' is generated with it. Add 'option NoReflection;' and 'option NoListener;' to '"
				+ sourceDescription(file) + "', or remove them from '" + sourceDescription(extendedFile) + "'.");
		}
	}

	private void checkSameOption(String prefix, DefinitionFile file, DefinitionFile extendedFile, String option,
			List<String> errors) {
		boolean set = MessageGenerator.isTrue(file.getOptions().get(option), false);
		boolean extendedSet = MessageGenerator.isTrue(extendedFile.getOptions().get(option), false);
		if (set != extendedSet) {
			DefinitionFile with = set ? file : extendedFile;
			DefinitionFile without = set ? extendedFile : file;
			errors.add(prefix + ", but only '" + sourceDescription(with) + "' declares option " + option
				+ ", '" + sourceDescription(without) + "' does not. Use the same setting in both files.");
		}
	}

	private static boolean samePackage(DefinitionFile file, DefinitionFile other) {
		QName pkg = file.getPackage();
		QName otherPkg = other.getPackage();
		if (pkg == null || otherPkg == null) {
			return pkg == otherPkg;
		}
		return pkg.getNames().equals(otherPkg.getNames());
	}

	/**
	 * Rejects fields whose generated names clash with the names of other fields of the same message,
	 * declared in the message itself or inherited from a generalization.
	 *
	 * <p>
	 * A sub-message cannot redeclare an inherited field (not even to narrow its type), since the
	 * generated accessors and property constants of both declarations would clash.
	 * </p>
	 */
	private void validateFieldNames(DefinitionFile file, List<String> errors) {
		for (Definition def : file.getDefinitions()) {
			validateFieldNames(def, errors);
		}
	}

	private void validateFieldNames(Definition def, List<String> errors) {
		if (!(def instanceof MessageDef)) {
			return;
		}
		MessageDef message = (MessageDef) def;

		// Generated names of the inherited fields, most general first.
		Map<String, Field> inherited = new HashMap<>();
		Map<Field, MessageDef> owners = new HashMap<>();
		List<MessageDef> generalizations = new ArrayList<>();
		Set<MessageDef> seen = new HashSet<>();
		seen.add(message);
		for (MessageDef current = message.getExtendedDef(); current != null && seen.add(current); current = current.getExtendedDef()) {
			generalizations.add(0, current);
		}
		for (MessageDef generalization : generalizations) {
			for (Field field : generalization.getFields()) {
				owners.put(field, generalization);
				for (String name : generatedNames(field)) {
					inherited.putIfAbsent(name, field);
				}
			}
		}

		Map<String, Field> local = new HashMap<>();
		for (Field field : message.getFields()) {
			Field clash = null;
			for (String name : generatedNames(field)) {
				clash = local.get(name);
				if (clash != null) {
					break;
				}
			}
			if (clash != null) {
				errors.add(fieldError(message, field) + (clash.getName().equals(field.getName())
					? " is declared twice. Rename or remove one of the declarations."
					: " clashes with field '" + clash.getName() + "' of the same message: both generate the same Java names ('"
						+ CodeConvention.getterName(field) + "()', '" + CodeConvention.constant(field)
						+ "'). Rename one of the fields."));
			} else {
				for (String name : generatedNames(field)) {
					clash = inherited.get(name);
					if (clash != null) {
						break;
					}
				}
				if (clash != null) {
					MessageDef owner = owners.get(clash);
					String origin = "'" + Util.toString(owner) + "' of '" + sourceDescription(Util.definingFile(owner)) + "'";
					errors.add(fieldError(message, field) + (clash.getName().equals(field.getName())
						? " redeclares the field inherited from " + origin
							+ ". A sub-message cannot redeclare an inherited field (not even to narrow its type)."
							+ " Remove the declaration or rename the field."
						: " clashes with field '" + clash.getName() + "' inherited from " + origin
							+ ": both generate the same Java names ('" + CodeConvention.getterName(field) + "()', '"
							+ CodeConvention.constant(field) + "'). Rename the field."));
				}
			}
			for (String name : generatedNames(field)) {
				local.putIfAbsent(name, field);
			}
		}

		for (Definition inner : message.getDefinitions()) {
			validateFieldNames(inner, errors);
		}
	}

	private String fieldError(MessageDef message, Field field) {
		return sourceDescription(Util.definingFile(message)) + ": Field '" + Util.toString(message) + "." + field.getName() + "'";
	}

	/**
	 * The names derived from a field that must be unique among all fields of a message and its
	 * generalizations.
	 */
	private static List<String> generatedNames(Field field) {
		return Arrays.asList("suffix:" + CodeConvention.suffix(field), "constant:" + CodeConvention.constant(field));
	}

	/**
	 * Rejects messages of a hierarchy whose identifiers in the generated code clash.
	 *
	 * <ul>
	 * <li>The concrete specializations of an abstract message must have distinct type IDs in all
	 * generated formats (the JSON type ID, explicit binary type IDs and plug-in identifiers such as
	 * XML element names). The readers of the abstract message dispatch on these IDs (and the
	 * registry of an <code>option OpenWorld</code> hierarchy is keyed by them), so equal IDs
	 * produce duplicate case labels or ambiguous data.</li>
	 * <li>The concrete messages of a hierarchy must have distinct constants in its
	 * <code>TypeKind</code> enum, unless <code>option NoTypeKind</code> is given.</li>
	 * <li>A message must not have the name of a nested definition of one of its generalizations:
	 * In the generated class of the message, the name of the inherited nested class would shadow
	 * the name of the class itself.</li>
	 * </ul>
	 *
	 * <p>
	 * All loaded files are considered, so that a clash of an extension with a message of another
	 * file of the hierarchy is found. A clash is only reported, if at least one of the messages is
	 * generated.
	 * </p>
	 */
	private void validateHierarchyNames(GeneratorPlugin plugin, List<String> errors) {
		List<MessageDef> messages = new ArrayList<>();
		for (DefinitionFile file : _files) {
			for (Definition def : file.getDefinitions()) {
				collectMessages(def, messages);
			}
		}

		Set<String> reported = new HashSet<>();
		for (MessageDef message : messages) {
			if (message.isAbstract()) {
				validateTypeIds(message, plugin, reported, errors);
			}
		}

		for (MessageDef message : messages) {
			if (message.getExtendedDef() == null && !message.getSpecializations().isEmpty()) {
				validateTypeKinds(message, errors);
			}
		}

		for (MessageDef message : messages) {
			if (isGenerated(message)) {
				validateInheritedNames(message, errors);
			}
		}
	}

	private static void collectMessages(Definition def, List<MessageDef> result) {
		if (def instanceof MessageDef) {
			MessageDef message = (MessageDef) def;
			result.add(message);
			for (Definition inner : message.getDefinitions()) {
				collectMessages(inner, result);
			}
		}
	}

	private boolean isGenerated(Definition def) {
		return !_importedFiles.contains(Util.definingFile(def));
	}

	private void validateTypeIds(MessageDef generalization, GeneratorPlugin plugin, Set<String> reported, List<String> errors) {
		List<MessageDef> specializations = new ArrayList<>();
		addConcreteSpecializations(generalization, specializations, new HashSet<>());
		List<Map<String, String>> ids = new ArrayList<>();
		for (MessageDef specialization : specializations) {
			ids.add(typeIds(specialization, plugin));
		}
		for (int n = 1; n < specializations.size(); n++) {
			MessageDef message = specializations.get(n);
			for (int m = 0; m < n; m++) {
				MessageDef other = specializations.get(m);
				if (!isGenerated(message) && !isGenerated(other)) {
					continue;
				}
				List<String> clashes = new ArrayList<>();
				Set<String> annotations = new java.util.LinkedHashSet<>();
				boolean renameHelps = false;
				for (Map.Entry<String, String> entry : ids.get(n).entrySet()) {
					if (!entry.getValue().equals(ids.get(m).get(entry.getKey()))) {
						continue;
					}
					java.util.regex.Matcher matcher = TYPE_ID_KIND.matcher(entry.getKey());
					String kind = matcher.matches() ? matcher.group(1) : entry.getKey();
					if (matcher.matches()) {
						annotations.add(matcher.group(2));
					}
					clashes.add("the same " + kind + " '" + entry.getValue() + "'");
					renameHelps |= !entry.getKey().equals(BINARY_TYPE_ID);
				}
				if (clashes.isEmpty() || !reported.add(Util.protoName(other) + " " + Util.protoName(message))) {
					continue;
				}
				MessageDef blamed = isGenerated(message) ? message : other;
				errors.add(sourceDescription(Util.definingFile(blamed)) + ": In the hierarchy of '" + Util.protoName(generalization)
					+ "', " + describe(other) + " and " + describe(message) + " have "
					+ String.join(" and ", clashes) + ", so that the readers of '" + Util.protoName(generalization)
					+ "' cannot distinguish them. "
					+ (annotations.isEmpty() ? "Rename one of the messages."
						: "Give one of the messages a distinct identifier with " + String.join(" or ", annotations)
							+ (renameHelps ? ", or rename it." : "."))
				);
			}
		}
	}

	/**
	 * Description of a type ID: the kind of identifier and the annotation that sets it.
	 */
	private static final java.util.regex.Pattern TYPE_ID_KIND = java.util.regex.Pattern.compile("(.*) \\((@\\w+)\\)");

	private static final String BINARY_TYPE_ID = "binary type ID (@type_id)";

	/**
	 * Adds the concrete specializations of the given message of all files in depth-first order.
	 */
	private static void addConcreteSpecializations(MessageDef def, List<MessageDef> result, Set<MessageDef> seen) {
		for (MessageDef specialization : def.getSpecializations()) {
			if (!seen.add(specialization)) {
				continue;
			}
			if (!specialization.isAbstract()) {
				result.add(specialization);
			}
			addConcreteSpecializations(specialization, result, seen);
		}
	}

	/**
	 * The identifiers of the given concrete message in polymorphic values of all generated formats,
	 * indexed by a description of the identifier and the annotation that sets it.
	 */
	private Map<String, String> typeIds(MessageDef message, GeneratorPlugin plugin) {
		DefinitionFile file = Util.definingFile(message);
		Map<String, Option> options = file.getOptions();
		Map<String, String> result = new java.util.LinkedHashMap<>();
		if (MessageGenerator.isJson(options) || generatesTypeScript(file)) {
			result.put("type ID (@Name)", MsgBufJsonProtocol.typeId(message));
		}
		if (MessageGenerator.isBinary(options)) {
			Option typeId = message.getOptions().get("type_id");
			if (typeId instanceof NumberOption) {
				result.put(BINARY_TYPE_ID, Integer.toString((int) ((NumberOption) typeId).getValue()));
			}
		}
		plugin.addTypeIds(options, message, result);
		return result;
	}

	private String describe(Definition def) {
		return "message '" + Util.protoName(def) + "' of '" + sourceDescription(Util.definingFile(def)) + "'";
	}

	/**
	 * Rejects clashing constants in the <code>TypeKind</code> enum generated for the given hierarchy
	 * root.
	 */
	private void validateTypeKinds(MessageDef root, List<String> errors) {
		DefinitionFile rootFile = Util.definingFile(root);
		if (!isGenerated(root) || MessageGenerator.isTrue(rootFile.getOptions().get("NoTypeKind"), false)) {
			return;
		}
		Map<String, MessageDef> constants = new HashMap<>();
		for (MessageDef message : AbstractMessageGenerator.concreteSpecializations(root)) {
			String constant = CodeConvention.typeKindConstant(message);
			MessageDef clash = constants.putIfAbsent(constant, message);
			if (clash != null) {
				errors.add(sourceDescription(Util.definingFile(message)) + ": In the hierarchy of '" + Util.protoName(root)
					+ "', " + describe(clash) + " and " + describe(message) + " generate the same constant '" + constant
					+ "' in the enum '" + Util.toString(root) + "." + CodeConvention.TYPE_KIND_NAME
					+ "'. Rename one of the messages, or add 'option NoTypeKind;' to '" + sourceDescription(rootFile)
					+ "'" + (Util.definingFile(message) != rootFile || Util.definingFile(clash) != rootFile
						? " and all files extending its hierarchy" : "")
					+ ".");
			}
		}
	}

	/**
	 * Rejects a message with the name of a nested definition of one of its generalizations.
	 */
	private void validateInheritedNames(MessageDef message, List<String> errors) {
		Set<MessageDef> seen = new HashSet<>();
		seen.add(message);
		for (MessageDef generalization = message.getExtendedDef(); generalization != null && seen.add(generalization);
				generalization = generalization.getExtendedDef()) {
			for (Definition member : generalization.getDefinitions()) {
				if (member != message && member.getName().equals(message.getName())) {
					errors.add(sourceDescription(Util.definingFile(message)) + ": Message '" + Util.protoName(message)
						+ "' extends message '" + Util.protoName(generalization) + "' of '"
						+ sourceDescription(Util.definingFile(generalization)) + "', which declares the nested "
						+ (member instanceof EnumDef ? "enum" : "message") + " '" + Util.protoName(member)
						+ "' with the same name. In the generated Java class of '" + Util.protoName(message)
						+ "', the name '" + message.getName() + "' would refer to the inherited nested type instead of the"
						+ " class itself. Rename one of them.");
					return;
				}
			}
		}
	}

	/**
	 * Rejects references to definitions of other files that are generated without a serialization
	 * format that the referencing code needs.
	 *
	 * <p>
	 * The generated read and write methods of a message call the corresponding methods of the
	 * messages and enums of its fields and of its generalization. If one of these is defined in
	 * another file that disables the format, the generated code would not compile.
	 * </p>
	 */
	private void validateFormatReferences(DefinitionFile file, GeneratorPlugin plugin, List<String> errors) {
		for (Definition def : file.getDefinitions()) {
			validateFormatReferences(file, def, plugin, errors);
		}
	}

	private void validateFormatReferences(DefinitionFile file, Definition def, GeneratorPlugin plugin, List<String> errors) {
		if (!(def instanceof MessageDef)) {
			return;
		}
		MessageDef message = (MessageDef) def;
		Set<String> formats = formats(file, plugin);

		MessageDef extended = message.getExtendedDef();
		if (extended != null) {
			checkFormats(file, formats, "Message '" + Util.toString(message) + "' extends", extended, plugin, errors);
		}

		for (Field field : message.getFields()) {
			Set<String> fieldFormats = fieldFormats(file, field, plugin);
			for (Definition target : referencedDefinitions(field.getType())) {
				checkFormats(file, fieldFormats,
					"Field '" + Util.toString(message) + "." + field.getName() + "' references", target, plugin, errors);
			}
		}

		for (Definition inner : message.getDefinitions()) {
			validateFormatReferences(file, inner, plugin, errors);
		}
	}

	private void checkFormats(DefinitionFile file, Set<String> formats, String reference, Definition target,
			GeneratorPlugin plugin, List<String> errors) {
		DefinitionFile targetFile = Util.definingFile(target);
		if (targetFile == file) {
			return;
		}
		boolean isEnum = target instanceof EnumDef;
		Set<String> targetFormats = isEnum ? enumFormats(targetFile.getOptions()) : formats(targetFile, plugin);
		String prefix = sourceDescription(file) + ": " + reference + (isEnum ? " enum '" : " message '")
			+ Util.toString(target) + "' of '" + sourceDescription(targetFile) + "'";
		for (String format : formats) {
			if (isEnum) {
				if (format.equals(GRAPH_JSON_FORMAT)) {
					// The JSON methods of an enum do not depend on the graph mode.
					format = JSON_FORMAT;
				} else if (!format.equals(JSON_FORMAT) && !format.equals(BINARY_FORMAT)) {
					// Enums are serialized in plug-in formats through their protocol names.
					continue;
				}
			}
			if (targetFormats.contains(format)) {
				continue;
			}
			if (format.equals(GRAPH_JSON_FORMAT) || (format.equals(JSON_FORMAT) && targetFormats.contains(GRAPH_JSON_FORMAT))) {
				errors.add(prefix + ", but only one of the files uses option SharedGraph. Use option SharedGraph in both"
					+ " files or in neither.");
			} else {
				errors.add(prefix + ", which is generated without " + format + " serialization ("
					+ disabledBy(targetFile, format) + "). Add 'option " + DISABLE_OPTION.get(format) + ";' to '"
					+ sourceDescription(file) + "', or enable " + format + " serialization in '"
					+ sourceDescription(targetFile) + "'.");
			}
		}
	}

	private static final String JSON_FORMAT = "JSON";

	/**
	 * JSON of the SharedGraph mode, which has its own read and write methods.
	 */
	private static final String GRAPH_JSON_FORMAT = "SharedGraph JSON";

	private static final String BINARY_FORMAT = "binary";

	private static final Map<String, String> DISABLE_OPTION =
		Map.of(JSON_FORMAT, "NoJson", BINARY_FORMAT, "NoBinary", XmlStreamingPlugin.XML_FORMAT, "NoXml");

	private static Set<String> formats(DefinitionFile file, GeneratorPlugin plugin) {
		Set<String> result = coreFormats(file.getOptions());
		plugin.addFormats(file.getOptions(), result);
		return result;
	}

	private static Set<String> fieldFormats(DefinitionFile file, Field field, GeneratorPlugin plugin) {
		Set<String> result = new HashSet<>();
		if (!field.isTransient() && !field.isDerived()) {
			result.addAll(coreFormats(file.getOptions()));
		}
		plugin.addFieldFormats(file.getOptions(), field, result);
		return result;
	}

	/**
	 * The formats of the generated read and write methods of messages.
	 */
	private static Set<String> coreFormats(Map<String, Option> options) {
		Set<String> result = new HashSet<>();
		if (MessageGenerator.isJson(options)) {
			result.add(MessageGenerator.isTrue(options.get("SharedGraph"), false) ? GRAPH_JSON_FORMAT : JSON_FORMAT);
		}
		if (MessageGenerator.isBinary(options)) {
			result.add(BINARY_FORMAT);
		}
		return result;
	}

	/**
	 * The formats of the generated read and write methods of enums.
	 */
	private static Set<String> enumFormats(Map<String, Option> options) {
		Set<String> result = new HashSet<>();
		if (MessageGenerator.isJson(options)) {
			result.add(JSON_FORMAT);
		}
		if (MessageGenerator.isBinary(options)) {
			result.add(BINARY_FORMAT);
		}
		return result;
	}

	private static String disabledBy(DefinitionFile file, String format) {
		if (format.equals(BINARY_FORMAT)) {
			if (Util.getFlag(file, "SharedGraph")) {
				return "option SharedGraph";
			}
			if (Util.getFlag(file, "OpenWorld")) {
				return "option OpenWorld implies NoBinary";
			}
		}
		return "option " + DISABLE_OPTION.get(format);
	}

	private static List<Definition> referencedDefinitions(Type type) {
		List<Definition> result = new ArrayList<>();
		type.visit(new Type.Visitor<Void, Void>() {
			@Override
			public Void visit(CustomType self, Void arg) {
				if (self.getDefinition() != null) {
					result.add(self.getDefinition());
				}
				return null;
			}

			@Override
			public Void visit(PrimitiveType self, Void arg) {
				return null;
			}

			@Override
			public Void visit(MapType self, Void arg) {
				self.getKeyType().visit(this, arg);
				self.getValueType().visit(this, arg);
				return null;
			}
		}, null);
		return result;
	}

	private void resolveImports(DefinitionFile file, File sourceFile) throws IOException, ParseException {
		for (String importPath : file.getImports()) {
			// Try file system first
			File resolved = resolveImportPathFromFileSystem(importPath, sourceFile);
			if (resolved != null) {
				String canonical = resolved.getCanonicalPath();
				if (_loadedFiles.contains(canonical)) {
					addImport(file, _fileByPath.get(canonical));
					continue;
				}
				_loadedFiles.add(canonical);
				DefinitionFile imported;
				try (InputStream in = new FileInputStream(resolved)) {
					imported = parse(in);
				}
				_fileByPath.put(canonical, imported);
				addImport(file, imported);
				_sourceNames.put(imported, resolved.getName());
				_files.add(imported);
				_table.enter(imported);
				_importedFiles.add(imported);
				resolveImports(imported, resolved);
				continue;
			}

			// Fall back to classpath
			if (_importClassLoader != null) {
				String resourceKey = "classpath:" + importPath;
				if (_loadedFiles.contains(resourceKey)) {
					addImport(file, _fileByPath.get(resourceKey));
					continue;
				}
				InputStream classpathStream = _importClassLoader.getResourceAsStream(importPath);
				if (classpathStream != null) {
					_loadedFiles.add(resourceKey);
					DefinitionFile imported;
					try (InputStream in = classpathStream) {
						imported = parse(in);
					}
					_fileByPath.put(resourceKey, imported);
					addImport(file, imported);
					_sourceNames.put(imported, new File(importPath).getName());
					_files.add(imported);
					_table.enter(imported);
					_importedFiles.add(imported);
					// Recursive imports from classpath-loaded files can only resolve via classpath
					resolveImportsFromClasspath(imported);
					continue;
				}
			}

			error("Cannot resolve import '" + importPath + "' from '" + sourceFile + "'.");
		}
	}

	private void addImport(DefinitionFile file, DefinitionFile imported) {
		if (imported != null && imported != file) {
			_table.addImport(file, imported);
		}
	}

	private void resolveImportsFromClasspath(DefinitionFile file) throws IOException, ParseException {
		for (String importPath : file.getImports()) {
			String resourceKey = "classpath:" + importPath;
			if (_loadedFiles.contains(resourceKey)) {
				addImport(file, _fileByPath.get(resourceKey));
				continue;
			}

			if (_importClassLoader != null) {
				InputStream classpathStream = _importClassLoader.getResourceAsStream(importPath);
				if (classpathStream != null) {
					_loadedFiles.add(resourceKey);
					DefinitionFile imported;
					try (InputStream in = classpathStream) {
						imported = parse(in);
					}
					_fileByPath.put(resourceKey, imported);
					addImport(file, imported);
					_sourceNames.put(imported, new File(importPath).getName());
					_files.add(imported);
					_table.enter(imported);
					_importedFiles.add(imported);
					resolveImportsFromClasspath(imported);
					continue;
				}
			}

			error("Cannot resolve import '" + importPath + "'.");
		}
	}

	private File resolveImportPathFromFileSystem(String importPath, File sourceFile) {
		if (sourceFile != null) {
			// 1. Relative to importing file's directory
			File relative = new File(sourceFile.getParentFile(), importPath);
			if (relative.isFile()) {
				return relative;
			}
		}
		// 2. From configured include paths
		for (File includePath : _includePaths) {
			File candidate = new File(includePath, importPath);
			if (candidate.isFile()) {
				return candidate;
			}
		}
		return null;
	}

	private void buildSpecializations(DefinitionFile file) {
		NameTable table = _table;
		
		Type.Visitor<Void, MessageDef> typeResolver = new Type.Visitor<Void, MessageDef>() {

			@Override
			public Void visit(CustomType self, MessageDef context) {
				self.setDefinition(table.lookup(context, self.getName()));
				return null;
			}

			@Override
			public Void visit(PrimitiveType self, MessageDef context) {
				return null;
			}

			@Override
			public Void visit(MapType self, MessageDef context) {
				self.getKeyType().visit(this, context);
				self.getValueType().visit(this, context);
				return null;
			}
			
		};
		
		Visitor<Void, Void> indexer = new Visitor<Void, Void>() {
			@Override
			public Void visit(MessageDef def, Void arg) {
				QName generalizationName = def.getExtends();
				if (generalizationName != null) {
					MessageDef ref = (MessageDef) table.lookup(def, generalizationName);
					if (ref ==  null) {
						error("Referenced type '" + CodeConvention.qTypeName(generalizationName) + "' not found.");
					} else {
						def.setExtendedDef(ref);
						ref.addSpecialization(def);
					}
				}
				
				for (Definition inner : def.getDefinitions()) {
					inner.visit(this, arg);
				}
				
				for (Field field : def.getFields()) {
					field.getType().visit(typeResolver, def);
				}
				return null;
			}

			@Override
			public Void visit(EnumDef def, Void arg) {
				return null;
			}
		};
		for (Definition def : file.getDefinitions()) {
			def.visit(indexer, null);
		}
	}
	
	private List<MessageDef> findCrossFileExtensions(DefinitionFile file) {
		List<MessageDef> result = new ArrayList<>();
		for (Definition def : file.getDefinitions()) {
			if (def instanceof MessageDef) {
				collectCrossFileExtensions((MessageDef) def, file, result);
			}
		}
		return result;
	}

	/**
	 * Collects the concrete messages of the given file that must be registered with the registry of
	 * an <code>option OpenWorld</code> hierarchy.
	 *
	 * <p>
	 * These are all concrete messages with a generalization defined in another file with
	 * <code>option OpenWorld</code>. The readers of this generalization (and of its generalizations)
	 * only find these types through the registry of the hierarchy root. This includes messages
	 * that extend a message of the same file that extends a message of another file, and messages
	 * that extend a message of an extension file.
	 * </p>
	 */
	private void collectCrossFileExtensions(MessageDef def, DefinitionFile file, List<MessageDef> result) {
		if (!def.isAbstract() && hasOpenWorldGeneralizationInOtherFile(def, file)) {
			result.add(def);
		}
		for (Definition inner : def.getDefinitions()) {
			if (inner instanceof MessageDef) {
				collectCrossFileExtensions((MessageDef) inner, file, result);
			}
		}
	}

	private static boolean hasOpenWorldGeneralizationInOtherFile(MessageDef def, DefinitionFile file) {
		Set<MessageDef> seen = new HashSet<>();
		for (MessageDef current = def.getExtendedDef(); current != null && seen.add(current); current = current.getExtendedDef()) {
			DefinitionFile currentFile = Util.definingFile(current);
			if (currentFile != file && Util.getFlag(currentFile, "OpenWorld")) {
				return true;
			}
		}
		return false;
	}

	private static MessageDef hierarchyRoot(MessageDef def) {
		Set<MessageDef> seen = new HashSet<>();
		MessageDef result = def;
		while (result.getExtendedDef() != null && seen.add(result)) {
			result = result.getExtendedDef();
		}
		return result;
	}

	private String generateRegistrationClass(DefinitionFile file, List<MessageDef> extensions, GeneratorPlugin plugin) {
		String packageName = CodeConvention.packageName(file.getPackage());
		String[] parts = packageName.split("\\.");
		String baseName = parts[parts.length - 1];
		String className = Character.toUpperCase(baseName.charAt(0)) + baseName.substring(1) + "Types";

		File dir = mkdir(file.getPackage());
		File out = new File(dir, className + ".java");

		boolean xml = formats(file, plugin).contains(XmlStreamingPlugin.XML_FORMAT);

		try (FileOutputStream os = new FileOutputStream(out)) {
			try (PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "utf-8"))) {
				System.out.println("Generating '" + out + "'.");
				w.println("package " + packageName + ";");
				w.println();
				w.println("/**");
				w.println(" * Registration of extension types for the OpenWorld protocol.");
				w.println(" */");
				w.println("public class " + className + " implements de.haumacher.msgbuf.data.TypeRegistration {");
				w.println();
				w.println("\t@Override");
				w.println("\tpublic void register() {");
				for (MessageDef ext : extensions) {
					MessageDef root = hierarchyRoot(ext);
					String rootQName = CodeConvention.qTypeName(root);
					String extQName = CodeConvention.qTypeName(ext);
					String typeConstant = CodeConvention.jsonTypeConstant(ext);
					w.println("\t\t" + rootQName + ".register(" + extQName + "." + typeConstant + ", " + extQName + "::create);");
					if (xml && formats(Util.definingFile(root), plugin).contains(XmlStreamingPlugin.XML_FORMAT)) {
						// The XML readers of the hierarchy dispatch unknown element names through the registry of the root.
						String extImplQName = CodeConvention.qImplName(CodeConvention.IMPL_PACKAGE_SUFFIX, ext);
						w.println("\t\t" + rootQName + "." + XmlStreamingPlugin.REGISTER_XML + "(" + extImplQName + "."
							+ XmlStreamingPlugin.xmlElementConstant(ext) + ", " + extQName + "::create);");
					}
				}
				w.println("\t}");
				w.println();
				w.println("\t/**");
				w.println("\t * Explicit initialization for GWT or manual use.");
				w.println("\t */");
				w.println("\tpublic static void init() {");
				w.println("\t\tnew " + className + "().register();");
				w.println("\t}");
				w.println("}");
			}
		} catch (IOException ex) {
			error("Error writing file '" + out + "'.", ex);
		}
		return packageName + "." + className;
	}

	private void generateServiceDescriptor(List<String> registrationClasses) {
		File servicesDir = new File(_resourceOut, "META-INF/services");
		servicesDir.mkdirs();
		File descriptor = new File(servicesDir, "de.haumacher.msgbuf.data.TypeRegistration");

		// Read existing entries to avoid duplicates (supports multiple generator runs)
		Set<String> existing = new HashSet<>();
		if (descriptor.isFile()) {
			try (java.io.BufferedReader r = new java.io.BufferedReader(new java.io.InputStreamReader(new FileInputStream(descriptor), "utf-8"))) {
				String line;
				while ((line = r.readLine()) != null) {
					line = line.trim();
					if (!line.isEmpty()) {
						existing.add(line);
					}
				}
			} catch (IOException ex) {
				// Ignore, will overwrite
			}
		}
		existing.addAll(registrationClasses);

		try (FileOutputStream os = new FileOutputStream(descriptor)) {
			try (PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "utf-8"))) {
				System.out.println("Generating '" + descriptor + "'.");
				for (String className : existing) {
					w.println(className);
				}
			}
		} catch (IOException ex) {
			error("Error writing file '" + descriptor + "'.", ex);
		}
	}

	class PackageGenerator implements Definition.Visitor<Void, Void> {
		private final File _dir;
		private final Map<String, Option> _options;
		private final GeneratorPlugin _plugin;

		public PackageGenerator(File dir, Map<String, Option> options, GeneratorPlugin plugin) {
			_dir = dir;
			_options = options;
			_plugin = plugin;
		}

		@Override
		public Void visit(EnumDef def, Void arg) {
			return generateJava(CodeConvention.typeName(def), null, new EnumGenerator(_options, def));
		}
		
		@Override
		public Void visit(MessageDef def, Void arg) {
			boolean noInterfaces = MessageGenerator.isTrue(_options.get("NoInterfaces"), false);
			if (!noInterfaces) {
				generateJava(CodeConvention.typeName(def), null, new MessageGenerator(_table, _options, true, null, def, _plugin));
			}
			String packageSuffix = noInterfaces ? null : CodeConvention.IMPL_PACKAGE_SUFFIX;
			return generateJava(noInterfaces ? CodeConvention.typeName(def) : CodeConvention.implName(def), packageSuffix, new MessageGenerator(_table, _options, false, packageSuffix, def, _plugin));
		}
		
		private <D extends Definition> Void generateJava(String name, String packageSuffix, FileGenerator generator) {
			File dir = _dir;
			if (packageSuffix != null) {
				// Delete legacy file.
				File old = new File(_dir, name + ".java");
				old.delete();
				
				dir = new File(dir, packageSuffix);
			}
			dir.mkdirs();
			File out = new File(dir, name + ".java");
			try (FileOutputStream os = new FileOutputStream(out)) {
				try (PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "utf-8"))) {
					System.out.println("Generating '" + out + "'.");
					generator.generate(w, 0);
				}
			} catch (IOException ex) {
				error("Error writing file '" + out + "'.", ex);
			}
			return null;
		}

	}

	private File mkdir(QName pkgName) {
		File result = _out;
		if (pkgName != null) {
			for (String name : pkgName.getNames()) {
				result = new File(result, name);
			}
		}
		result.mkdirs();
		return result;
	}

	protected void error(String message) {
		error(message, null);
	}
	
	protected void error(String message, IOException ex) {
		System.out.println(message);
		if (ex != null) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Main entry point invoked from the command line.
	 */
	public static void main(String... args) throws ParseException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		if (args.length == 0) {
			printHelp();
			return;
		}
		File out = null;
		Generator generator = new Generator();
		for (int n = 0, cnt = args.length; n < cnt; ) {
			String arg = args[n++];
			if (arg.equals(OUTPUT_DIR_ARG)) {
				out = new File(args[n++]);
			} else if (arg.equals(RESOURCE_DIR_ARG)) {
				generator.setResourceOut(new File(args[n++]));
			} else if (arg.equals(TYPESCRIPT_DIR_ARG)) {
				generator.setTypeScriptOut(new File(args[n++]));
			} else if (arg.equals("-h")) {
				printHelp();
				return;
			} else if (arg.equals("-I")) {
				generator.addIncludePath(new File(args[n++]));
			} else if (arg.equals("-cp")) {
				String classpath = args[n++];
				String[] entries = classpath.split(File.pathSeparator);
				URL[] urls = new URL[entries.length];
				for (int i = 0; i < entries.length; i++) {
					urls[i] = new File(entries[i]).toURI().toURL();
				}
				generator.setImportClassLoader(new URLClassLoader(urls, null));
			} else {
				File file = new File(arg);
				DefinitionFile content = generator.load(file);
				if (out == null) {
					out = findBase(file, content);
				}
			}
		}
		if (out != null) {
			generator.setOut(out);
		}
		
		try {
			generator.generate(loadPlugins());
		} catch (GeneratorException ex) {
			for (String error : ex.getErrors()) {
				System.err.println("ERROR: " + error);
			}
			System.exit(1);
		}
	}

	/**
	 * Loads generator plugins via {@link ServiceLoader}.
	 */
	public static GeneratorPlugin loadPlugins() {
		ServiceLoader<GeneratorPlugin> pluginLoader = ServiceLoader.load(GeneratorPlugin.class);
		GeneratorPlugin plugin = GeneratorPlugin.none();
		for (GeneratorPlugin p : pluginLoader) {
			plugin = plugin.andThen(p);
		}
		return plugin;
	}

	private static void printHelp() {
		System.err.println("Usage: java -jar " + Generator.class.getName() + " -out <java-output-dir> [-resources <resource-output-dir>] [-ts <typescript-output-dir>] [-I <include-dir>]* [-cp <classpath>] <protocol-definition.proto>*");
	}

	private static File findBase(File protoFile, DefinitionFile content) {
		File result = protoFile.getParentFile();
		if (content.getPackage() != null) {
			for (int n = 0, cnt = content.getPackage().getNames().size(); n < cnt; n++) {
				result = result.getParentFile();
			}
		}
		return result;
	}

}
