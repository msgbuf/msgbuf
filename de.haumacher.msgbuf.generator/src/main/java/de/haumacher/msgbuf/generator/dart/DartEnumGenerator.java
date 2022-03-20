/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.dart;

import static de.haumacher.msgbuf.generator.dart.DartCoding.*;

import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.common.MsgBufJsonProtocol;
import de.haumacher.msgbuf.generator.util.AbstractDartGenerator;

/**
 * Generates code for a protocol enum in Dart.
 */
public class DartEnumGenerator extends AbstractDartGenerator {

	private EnumDef _def;

	/** 
	 * Creates a {@link DartEnumGenerator}.
	 */
	public DartEnumGenerator(EnumDef def) {
		_def = def;
	}

	@Override
	protected void generate() {
		docComment(_def.getComment());
		String typeName = typeName(_def);
		line("enum " + typeName + " {");
		{
			for (Constant constant : _def.getConstants()) {
				docComment(constant.getComment());
				line(literalName(constant) + ",");
			}
		}
		line("}");
		nl();
		
		line("/// Writes a value of " + typeName + " to a JSON stream.");
		line("void " + writeEnumMethod(_def) + "(JsonSink json, " + typeName + " value) {");
		{
			line("switch (value) {");
			{
				for (Constant constant : _def.getConstants()) {
					String protocolValue = nameLiteral(constant);
					line("case " + typeName + "." + literalName(constant) + ": json.addString(" + protocolValue + "); break;");
				}
				line("default: throw (\"No such literal: \" + value.name);");
			}
			line("}");
		}
		line("}");
		nl();

		line("/// Reads a value of " + typeName + " from a JSON stream.");
		line(typeName + " " + readEnumMethod(_def) + "(JsonReader json) {");
		{
			line("switch (json.expectString()) {");
			{
				for (Constant constant : _def.getConstants()) {
					line("case " + nameLiteral(constant) + ": return " + typeName + "." + literalName(constant) + ";");
				}
				line("default: return " + typeName + "." + literalName(_def.getConstants().get(0)) + ";");
			}
			line("}");
		}
		line("}");
		nl();
	}

	/** 
	 * Literal string with the given {@link Constant}s protocol value.
	 */
	private static String nameLiteral(Constant constant) {
		return DartCoding.stringLiteral(MsgBufJsonProtocol.classifierId(constant));
	}

}
