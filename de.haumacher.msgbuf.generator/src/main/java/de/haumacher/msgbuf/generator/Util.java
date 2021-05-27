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
				return qName(pkg) + "." + def.getName();
			}
		} else {
			return toString(outer) + "." + def.getName();
		}
	}

}
