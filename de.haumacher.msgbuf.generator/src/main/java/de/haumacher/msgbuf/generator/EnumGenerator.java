/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.CodeConvention.*;
import static de.haumacher.msgbuf.generator.common.MsgBufJsonProtocol.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.common.MsgBufJsonProtocol;
import de.haumacher.msgbuf.generator.util.AbstractJavaGenerator;
import de.haumacher.msgbuf.generator.util.CodeUtil;

/**
 * Generates a binding for a protocol enumeration.
 */
public class EnumGenerator extends AbstractJavaGenerator {

	private EnumDef _def;

	/** 
	 * Creates a {@link EnumGenerator}.
	 *
	 * @param def
	 */
	public EnumGenerator(EnumDef def) {
		_def = def;
	}

	@Override
	protected void generate() {
		DefinitionFile file = _def.getFile();
		if (file != null) {
			QName packageName = file.getPackage();
			if (packageName != null) {
				line("package " + CodeConvention.packageName(packageName) + ";");
			}
		}
		nl();
		docComment(_def.getComment());
		line("public enum " + CodeConvention.typeName(_def) + " implements de.haumacher.msgbuf.data.ProtocolEnum {");

		generateConstants();
		
		nl();
		line("private final String _protocolName;");
		
		nl();
		line("private " + typeName(_def) + "(String protocolName) {");
		{
			line("_protocolName = protocolName;");
		}
		line("}");
		
		nl();
		line("/**");
		line(" * The protocol name of a {@link " + typeName(_def) + "} constant.");
		line(" *");
		line(" * @see #valueOfProtocol(String)");
		line(" */");
		line("@Override");
		line("public String protocolName() {");
		{
			line("return _protocolName;");
		}
		line("}");
		
		nl();
		line("/** Looks up a {@link " + typeName(_def) + "} constant by it's protocol name. */");
		line("public static " + typeName(_def) + " valueOfProtocol(String protocolName) {");
		List<Constant> constants = _def.getConstants();
		{
			line("if (protocolName == null) { return null; }");
			line("switch (protocolName) {");
			for (Constant constant : constants) {
				line("case " + CodeUtil.stringLiteral(MsgBufJsonProtocol.classifierId(constant)) + ": return " + CodeConvention.classifierName(constant) + ";");
			}
			line("}");
			line("return " + defaultValue() + ";");
		}
		line("}");
		
		nl();
		line("/** Writes this instance to the given output. */");
		line("public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {");
		{
			line("out.value(protocolName());");
		}
		line("}");
		
		nl();
		line("/** Reads a new instance from the given reader. */");
		line("public static " + typeName(_def) + " " + CodeConvention.readerName(_def) + "(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {");
		{
			line("return valueOfProtocol(in.nextString());");
		}
		line("}");
		
		nl();
		line("/** Writes this instance to the given binary output. */");
		line("public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {");
		{
			line("switch (this) {");
			for (Constant constant : constants) {
				line("case " + CodeConvention.classifierName(constant) + ": out.value(" + constant.getIndex() + "); break;");
			}
			line("default: out.value(0);");
			line("}");
		}
		line("}");
		
		nl();
		line("/** Reads a new instance from the given binary reader. */");
		line("public static " + CodeConvention.typeName(_def) + " " + CodeConvention.readerName(_def) + "(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {");
		{
			line("switch (in.nextInt()) {");
			Set<Integer> ids = new HashSet<>(); 
			for (Constant constant : constants) {
				if (ids.add(Integer.valueOf(constant.getIndex()))) {
					line("case " + constant.getIndex() + ": return " + CodeConvention.classifierName(constant) + ";");
				}
			}
			line("default: return " + defaultValue() + ";");
			line("}");
		}
		line("}");
		
		line("}");
	}

	private void generateConstants() {
		for (Constant constant : _def.getConstants()) {
			nl();
			docComment(constant.getComment());
			line(CodeConvention.classifierName(constant) + "(" + CodeUtil.stringLiteral(classifierId(constant)) +  "),");
		}
		nl();
		line(";");
	}

	private String defaultValue() {
		List<Constant> constants = _def.getConstants();
		return constants.size() > 0 ? CodeConvention.classifierName(constants.get(0)) : "null";
	}

}
