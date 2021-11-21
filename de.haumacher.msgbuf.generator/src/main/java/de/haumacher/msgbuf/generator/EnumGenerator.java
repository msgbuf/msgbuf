/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.CodeConvention.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.ast.StringOption;

/**
 * Generates a binding for a protocol enumeration.
 */
public class EnumGenerator extends AbstractFileGenerator {

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
		line("public enum " + CodeConvention.typeName(_def) + " {");

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
				line("case " + CodeUtil.stringLiteral(protocolName(constant)) + ": return " + CodeConvention.classifierName(constant) + ";");
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
			line(CodeConvention.classifierName(constant) + "(" + CodeUtil.stringLiteral(protocolName(constant)) +  "),");
		}
		nl();
		line(";");
	}

	private String defaultValue() {
		List<Constant> constants = _def.getConstants();
		return constants.size() > 0 ? CodeConvention.classifierName(constants.get(0)) : "null";
	}

	/**
	 * The name of the given enumeration classifier as used in the protocol (e.g. JSON format).
	 */
	private String protocolName(Constant constant) {
		Option nameOption = constant.getOptions().get("Name");
		if (nameOption != null) {
			if (nameOption instanceof StringOption) {
				return ((StringOption) nameOption).getValue();
			} else {
				// TODO: Error.
			}
		}
		return constant.getName();
	}

}
