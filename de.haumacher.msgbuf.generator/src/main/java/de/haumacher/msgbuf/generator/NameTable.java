/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.common.Util;

/**
 * Index of all definitions of the files processed together, resolving type names.
 *
 * <p>
 * A name is resolved in the context of the message it is used in, see
 * {@link #resolve(DefinitionFile, MessageDef, QName)}.
 * </p>
 */
public class NameTable implements Definition.Visitor<Void, Void> {

	private final Map<String, Package> _packageByName = new HashMap<>();

	/**
	 * The files imported by a file (its <code>import</code> declarations), in declaration order.
	 */
	private final Map<DefinitionFile, List<DefinitionFile>> _imports = new HashMap<>();

	/**
	 * Errors to report, formatted with a function describing the source of a file.
	 */
	private final List<Function<Function<DefinitionFile, String>, String>> _errors = new ArrayList<>();

	public void enter(DefinitionFile file) {
		Package pkg = mkPackage(file.getPackage());

		for (Definition def : file.getDefinitions()) {
			pkg.enter(file, def);
			def.visit(this, null);
		}
	}

	/**
	 * Records that the given file imports the other file.
	 */
	public void addImport(DefinitionFile file, DefinitionFile imported) {
		List<DefinitionFile> list = _imports.computeIfAbsent(file, x -> new ArrayList<>());
		if (!list.contains(imported)) {
			list.add(imported);
		}
	}

	@Override
	public Void visit(EnumDef self, Void arg) {
		for (Constant part : self.getConstants()) {
			part.setOwner(self);
		}
		return null;
	}

	@Override
	public Void visit(MessageDef self, Void arg) {
		for (Field part : self.getFields()) {
			part.setOwner(self);
		}
		for (Definition inner : self.getDefinitions()) {
			inner.setOuter(self);
			inner.visit(this, arg);
		}
		return null;
	}

	private Package mkPackage(QName qName) {
		String name = packageName(qName);
		Package result = _packageByName.get(name);
		if (result == null) {
			result = new Package(name);
			_packageByName.put(name, result);
		}
		return result;
	}

	private static String packageName(QName qName) {
		return qName == null ? "" : CodeConvention.packageName(qName);
	}

	class Package {

		private final String _name;

		private final Map<String, Definition> _definitionsByName = new HashMap<>();

		/**
		 * Creates a {@link Package}.
		 */
		public Package(String name) {
			_name = name;
		}

		public String getName() {
			return _name;
		}

		/**
		 * Enters the given top-level definition of the given file.
		 */
		public void enter(DefinitionFile file, Definition def) {
			def.setFile(file);
			Definition clash = _definitionsByName.putIfAbsent(def.getName(), def);
			if (clash != null) {
				String qName = (getName().isEmpty() ? "" : getName() + ".") + def.getName();
				DefinitionFile clashFile = clash.getFile();
				_errors.add(source -> source.apply(file) + ": Duplicate definition of '" + qName + "'"
					+ (clashFile == file
						? ". Rename or remove one of the definitions."
						: ", it is also defined in '" + source.apply(clashFile)
							+ "'. Rename one of the definitions, or do not pass both files to the generator."));
			}
		}
	}

	/**
	 * Reports the errors found so far (duplicate definitions and ambiguous names) and forgets them.
	 *
	 * @param source
	 *        Function describing the source of a file in error messages.
	 * @return The error messages.
	 */
	public List<String> drainErrors(Function<DefinitionFile, String> source) {
		List<String> result = _errors.stream().map(e -> e.apply(source)).collect(Collectors.toList());
		_errors.clear();
		return result;
	}

	/**
	 * Reports a problem that does not stop the generation.
	 */
	public void error(String message) {
		System.err.println(message);
	}

	/**
	 * Resolves the given name used in the given message and reports an error, if the name cannot
	 * be resolved.
	 *
	 * @see #resolve(DefinitionFile, MessageDef, QName)
	 */
	public Definition lookup(MessageDef context, QName name) {
		DefinitionFile file = context == null ? null : Util.definingFile(context);
		int errorCount = _errors.size();
		Definition result = resolve(file, context, name, true);
		if (result == null && _errors.size() == errorCount) {
			error("Name cannot be resolved" + (context == null ? "" : " in '" + context.getName() + "'") + ": " + CodeConvention.qTypeName(name));
		}
		return result;
	}

	/**
	 * Resolves the given name in the given context without reporting an error.
	 *
	 * @param context
	 *        The message in which the name is used, <code>null</code> for top-level usage.
	 * @param name
	 *        The name to resolve.
	 * @return The resolved definition, or <code>null</code> if the name cannot be resolved.
	 *
	 * @see #resolve(DefinitionFile, MessageDef, QName)
	 */
	public Definition resolve(MessageDef context, QName name) {
		return resolve(context == null ? null : Util.definingFile(context), context, name);
	}

	/**
	 * Resolves the given name in the given context without reporting an error.
	 *
	 * <p>
	 * The first part of the name is resolved as follows:
	 * </p>
	 * <ol>
	 * <li>A nested definition of the context message or one of its outer messages.</li>
	 * <li>A top-level definition of the package of the given file (in any of the files processed
	 * together).</li>
	 * <li>A top-level definition of a file imported by the given file, if it is unique among these
	 * files. If none of them defines the name, the files imported by these files, and so on.</li>
	 * <li>For compatibility, a top-level definition of any other file processed together, if it is
	 * unique.</li>
	 * </ol>
	 * <p>
	 * The remaining parts are resolved as nested definitions. If this fails, the name is resolved as
	 * a package-qualified name.
	 * </p>
	 *
	 * @param file
	 *        The file in which the name is used, <code>null</code> if unknown.
	 * @param context
	 *        The message in which the name is used, <code>null</code> for top-level usage.
	 * @param name
	 *        The name to resolve.
	 * @return The resolved definition, or <code>null</code> if the name cannot be resolved (or is
	 *         ambiguous).
	 */
	public Definition resolve(DefinitionFile file, MessageDef context, QName name) {
		return resolve(file, context, name, false);
	}

	private Definition resolve(DefinitionFile file, MessageDef context, QName name, boolean report) {
		String baseName = name.getNames().get(0);

		boolean[] fromImports = { false };
		List<Definition> candidates = lookupBase(file, context, baseName, fromImports);
		if (candidates.size() == 1) {
			Definition base = candidates.get(0);
			// Try resolving remaining parts as inner definitions
			boolean resolved = true;
			for (int n = 1; n < name.getNames().size(); n++) {
				String nextName = name.getNames().get(n);
				Definition inner = lookupInner(base, nextName);
				if (inner == null) {
					resolved = false;
					break;
				}
				base = inner;
			}
			if (resolved) {
				return base;
			}
		}

		// Try as package-qualified name.
		// Try progressively longer package prefixes: a.b.c.Type -> try "a.b.c", "a.b", "a" as package
		List<String> names = name.getNames();
		for (int split = names.size() - 1; split >= 1; split--) {
			String pkgName = String.join(".", names.subList(0, split));
			Package pkg = _packageByName.get(pkgName);
			if (pkg != null) {
				String typeName = names.get(split);
				Definition found = pkg._definitionsByName.get(typeName);
				if (found != null) {
					// Resolve remaining parts (if any) as inner definitions
					for (int n = split + 1; n < names.size(); n++) {
						found = lookupInner(found, names.get(n));
						if (found == null) break;
					}
					if (found != null) return found;
				}
			}
		}

		if (report && candidates.size() > 1) {
			String usage = context == null ? "" : " in '" + Util.protoName(context) + "'";
			String pkgName = file == null ? null : packageName(file.getPackage());
			_errors.add(source -> (file == null ? "" : source.apply(file) + ": ") + "The name '"
				+ CodeConvention.qTypeName(name) + "'" + usage + " is ambiguous, it could refer to "
				+ candidates.stream().map(c -> "'" + Util.protoName(c) + "' of '" + source.apply(c.getFile()) + "'")
					.collect(Collectors.joining(" and "))
				+ (pkgName == null ? ""
					: fromImports[0]
						? ", which are defined in files imported by '" + source.apply(file) + "', and "
							+ packageDescription(pkgName) + " does not define this name"
						: ". Neither " + packageDescription(pkgName) + " nor the files imported by '" + source.apply(file)
							+ "' define this name, and the candidates are defined in files that are not imported, but"
							+ " generated together")
				+ ". Use a qualified name, e.g. '" + Util.protoName(candidates.get(0)) + "'.");
		}
		return null;
	}

	private static String packageDescription(String pkgName) {
		return pkgName.isEmpty() ? "the default package" : "package '" + pkgName + "'";
	}

	private Definition lookupInner(Definition base, String nextName) {
		if (base instanceof MessageDef) {
			Optional<Definition> match = ((MessageDef) base).getDefinitions().stream().filter(d -> nextName.equals(d.getName())).findFirst();
			if (match.isPresent()) {
				return match.get();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * The candidates for the first part of a name.
	 *
	 * @param fromImports
	 *        Output: whether the result consists of definitions of imported files.
	 * @return A single definition, if the name is resolved, more than one, if the name is
	 *         ambiguous.
	 */
	private List<Definition> lookupBase(DefinitionFile file, MessageDef context, String baseName, boolean[] fromImports) {
		while (context != null) {
			Definition inner = lookupInner(context, baseName);
			if (inner != null) {
				return List.of(inner);
			}
			context = context.getOuter();
		}

		if (file != null) {
			Package pkg = _packageByName.get(packageName(file.getPackage()));
			Definition local = pkg == null ? null : pkg._definitionsByName.get(baseName);
			if (local != null) {
				return List.of(local);
			}

			// Definitions of the files imported directly, then of the files imported by these, and so on.
			java.util.Set<DefinitionFile> seen = new java.util.HashSet<>();
			seen.add(file);
			List<DefinitionFile> level = List.of(file);
			while (!level.isEmpty()) {
				List<DefinitionFile> next = new ArrayList<>();
				for (DefinitionFile current : level) {
					for (DefinitionFile imported : _imports.getOrDefault(current, List.of())) {
						if (seen.add(imported)) {
							next.add(imported);
						}
					}
				}
				List<Definition> found = new ArrayList<>();
				for (DefinitionFile imported : next) {
					for (Definition def : imported.getDefinitions()) {
						if (def.getName().equals(baseName) && !found.contains(def)) {
							found.add(def);
						}
					}
				}
				if (!found.isEmpty()) {
					fromImports[0] = true;
					found.sort(Comparator.comparing(Util::protoName));
					return found;
				}
				level = next;
			}
		}

		// For compatibility, a definition of a file that is not imported can be referenced by its
		// simple name, if it is unique among all files processed together.
		List<Definition> global = new ArrayList<>();
		for (Package pkg : _packageByName.values()) {
			Definition def = pkg._definitionsByName.get(baseName);
			if (def != null) {
				global.add(def);
			}
		}
		global.sort(Comparator.comparing(Util::protoName));
		return global;
	}
}
