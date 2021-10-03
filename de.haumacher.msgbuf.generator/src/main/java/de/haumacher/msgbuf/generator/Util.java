/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.List;
import java.util.stream.Collectors;

import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Part;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.parser.Token;

/**
 * TODO
 */
public class Util {

	/** 
	 * TODO
	 */
	public static String last(QName qName) {
		List<String> names = qName.getNames();
		return names.get(names.size() - 1);
	}

	/** 
	 * TODO
	 */
	public static String qName(QName qName) {
		return qName.getNames().stream().collect(Collectors.joining("."));
	}
	
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

	public static String stripComment(Token t) {
		return t == null ? "" : t.specialToken == null ? "" : stripComment(t.specialToken.image);
	}
	
	public static String stripComment(String comment) {
		return comment.replaceAll("^/\\*+ ?(?:\\s+\\r?\\n)?", "").replaceAll("(?:\\s*\\r?\\n)?\\s*\\*+/$", "").replaceAll("(?m)^\\s*\\*+ ?", "");
	}
	
	public static String stringContent(String stringLiteral) {
		return stringLiteral.substring(1, stringLiteral.length() - 1).replaceAll("\\\\(.)", "$1");
	}

	/** 
	 * TODO
	 */
	public static String toString(Part part) {
		return toString(part.getOwner()) + "#" + part.getName();
	}

	/** 
	 * TODO
	 */
	public static String toString(Definition def) {
		MessageDef outer = def.getOuter();
		if (outer == null) {
			QName pkg = def.getFile().getPackage();
			if (pkg == null) {
				return def.getName();
			} else {
				return qName(pkg) + "." + typeName(def);
			}
		} else {
			return toString(outer) + "." + typeName(def);
		}
	}

	static String camelCase(String name) {
		StringBuilder result = new StringBuilder();
		for (String part : name.split("_+")) {
			result.append(MessageGenerator.firstUpperCase(part));
		}
		return result.toString();
	}

	static String typeName(Definition def) {
		return typeName(def.getName());
	}

	private static String typeName(String name) {
		return camelCase(name);
	}

}
