/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.CodeUtil.*;

import java.util.List;
import java.util.stream.Collectors;

import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.ast.Type;

/**
 * Utility methods defining technical names of generated classes.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public class CodeConvention {

	public static String qTypeName(MessageDef def) {
		QName pkg = def.getFile().getPackage();
		return (pkg.getNames().size() == 0 ? "" : qName(pkg) + ".") + typeName(def);
	}

	public static String qTypeName(QName qName) {
		StringBuilder result = new StringBuilder();
		List<String> names = qName.getNames();
		for (int n = 0, cnt = names.size(); n < cnt; n++) {
			if (n > 0) {
				result.append('.');
			}
			String part = names.get(n);
			if (n < cnt - 1) {
				result.append(part);
			} else {
				result.append(typeName(part));
			}
		}
		return result.toString();
	}

	public static String typeName(Definition def) {
		return typeName(def.getName());
	}

	public static String typeName(String name) {
		return camelCase(name);
	}

	public static String suffix(Field field) {
		return camelCase(field.getName());
	}

	public static String binaryConstant(Field field) {
		return allUpperCase(field.getName()) + "__ID";
	}

	public static String constant(Field field) {
		return allUpperCase(field.getName());
	}

	/**
	 * Name of the factory method for the given {@link MessageDef}.
	 * 
	 * @param def
	 *        The {@link MessageDef} to produce a factory name for.
	 */
	public static String factoryName(MessageDef def) {
		return "create";
	}

	public static String getterName(Field field) {
		Type type = field.getType();
		if (type instanceof PrimitiveType && ((PrimitiveType) type).getKind() == PrimitiveType.Kind.BOOL) {
			return "is" + suffix(field);
		} else {
			return "get" + suffix(field);
		}
	}

	public static String adderName(Field field) {
		String suffix = suffix(field);
		if (suffix.endsWith("s")) {
			suffix = suffix.substring(0, suffix.length() - 1);
		}
		return "add" + suffix;
	}

	public static String hasName(Field field) {
		return "has" + suffix(field);
	}

	public static String name(Field field) {
		return firstLowerCase(camelCase(field.getName()));
	}

	public static String setterName(Field field) {
		return "set" + suffix(field);
	}

	public static String readerName(String name) {
		return "read" + name;
	}

	public static String readerName(Definition def) {
		return readerName(def.getName());
	}

	public static String packageName(QName packageName) {
		return qName(packageName);
	}

	public static String qName(QName qName) {
		return qName.getNames().stream().collect(Collectors.joining("."));
	}

	public static String jsonTypeConstant(MessageDef def) {
		return allUpperCase(def.getName()) + "__TYPE";
	}

	public static String jsonTypeConstantRef(MessageDef def) {
		return typeName(def) + "." + jsonTypeConstant(def);
	}

	public static String mkBinaryTypeConstant(MessageDef def) {
		return allUpperCase(def.getName()) + "__TYPE_ID";
	}

}
