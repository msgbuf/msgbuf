/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.dart;

import static de.haumacher.msgbuf.generator.util.CodeUtil.*;

import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.common.MsgBufJsonProtocol;
import de.haumacher.msgbuf.generator.common.Util;

/**
 * Coding conventions for Dart libraries.
 */
public class DartCoding {

	/** 
	 * Name of an enum literal.
	 */
	public static String literalName(Constant constant) {
		return firstLowerCase(camelCase(constant.getName()));
	}

	/** 
	 * Name of a class or enum.
	 */
	public static String typeName(Definition def) {
		return def.getName();
	}

	/** 
	 * Name of the method for writing an enum literal.
	 */
	public static String writeEnumMethod(EnumDef enumDef) {
		return "write" + typeName(enumDef);
	}

	/** 
	 * Name of the method for reading an enum literal.
	 */
	public static String readEnumMethod(EnumDef enumDef) {
		return "read" + typeName(enumDef);
	}
	
	/**
	 * A string literal with the given value.
	 */
	public static String stringLiteral(String value) {
		return '"' + value.replace("\"", "\\\"") + '"';
	}

	/** 
	 * Name of the visitor class for the given {@link MessageDef}.
	 */
	public static String visitorName(MessageDef def) {
		return typeName(def) + "Visitor";
	}

	/**
	 * String literal with the JSON type name of the given class. 
	 */
	public static String jsonTypeIdLiteral(MessageDef def) {
		return stringLiteral(MsgBufJsonProtocol.typeId(def));
	}

	/** 
	 * Visit method of the given concrete type.
	 */
	public static String visitCaseMethod(MessageDef def) {
		return "visit" + typeName(def);
	}

	/**
	 * Name of the type of the given field. 
	 */
	public static String typeName(Field field) {
		return field.getType().visit(TypeNameBuilder.INSTANCE, field);
	}

	/** 
	 * Name of the member variable for the given field.
	 */
	public static String fieldName(Field field) {
		return field.getName();
	}

	/** 
	 * The default value of the given field.
	 */
	public static String initializer(Field field) {
		if (Util.isNullable(field)) {
			return "";
		}
		return field.getType().visit(InitializerGenerator.INSTANCE, field);
	}

	/** 
	 * String literal denoting the field name in JSON format of the given field.
	 */
	public static String jsonName(Field field) {
		return stringLiteral(MsgBufJsonProtocol.fieldId(field));
	}

	/** 
	 * Name of the visit method of the given abstract type.
	 */
	public static String visitMethod(MessageDef def) {
		return "visit" + typeName(def);
	}

}
