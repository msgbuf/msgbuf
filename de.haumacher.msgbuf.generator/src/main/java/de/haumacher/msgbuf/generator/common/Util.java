/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import de.haumacher.msgbuf.generator.CodeConvention;
import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.Flag;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.ast.Part;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.ast.Type;
import de.haumacher.msgbuf.generator.ast.WithOptions;
import de.haumacher.msgbuf.generator.parser.Token;

/**
 * Utilities for accessing <code>msgbuf</code> model.
 */
public class Util {

	public static String last(QName qName) {
		List<String> names = qName.getNames();
		return names.get(names.size() - 1);
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

	public static String toString(Definition def) {
		MessageDef outer = def.getOuter();
		if (outer == null) {
			QName pkg = def.getFile().getPackage();
			if (pkg == null) {
				return def.getName();
			} else {
				return CodeConvention.packageName(pkg) + "." + CodeConvention.typeName(def);
			}
		} else {
			return toString(outer) + "." + CodeConvention.typeName(def);
		}
	}

	public static String toString(Part part) {
		return toString(part.getOwner()) + "#" + part.getName();
	}

	public static Optional<Option> getOption(WithOptions field, String optionName) {
		return Optional.ofNullable(field.getOptions().get(optionName));
	}

	public static boolean getFlag(WithOptions field, String optionName) {
		Optional<Option> option = getOption(field, optionName);
		return option.isPresent() ? ((Flag) option.get()).isValue() : false;
	}

	public static boolean isNullable(Field field) {
		return getFlag(field, "Nullable") || (!field.isRepeated() && isNullable(field.getType()));
	}

	public static boolean isNullable(Type type) {
		return type instanceof CustomType && !isEnumType(type);
	}

	private static boolean isEnumType(Type type) {
		return type instanceof CustomType && ((CustomType) type).getDefinition() instanceof EnumDef;
	}

	public static List<MessageDef> concreteTransitiveSpecializations(MessageDef def) {
		return transitiveSpecializations(def).stream().filter(m -> !m.isAbstract()).collect(Collectors.toList());
	}

	private static ArrayList<MessageDef> transitiveSpecializations(MessageDef def) {
		ArrayList<MessageDef> result = new ArrayList<MessageDef>(def.getSpecializations());
		int n = 0;
		while (n < result.size()) {
			result.addAll(result.get(n++).getSpecializations());
		}
		return result;
	}
	
}
