/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.QName;

/**
 * TODO
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
				line("package " + Util.qName(packageName) + ";");
			}
		}
		nl();
		line("public enum " + _def.getName() + " {");
		generateConstants();
		
		nl();
		line("/** Writes this instance to the given output. */");
		line("public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {");
		{
			line("out.value(name());");
		}
		line("}");
		
		nl();
		line("/** Reads a new instance from the given reader. */");
		line("public static " + _def.getName() + " " + MessageGenerator.readerName(_def) + "(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {");
		{
			line("return valueOf(in.nextString());");
		}
		line("}");
		
		line("}");
	}

	private void generateConstants() {
		for (Constant constant : _def.getConstants()) {
			nl();
			line(constant.getName() + ",");
		}
		nl();
		line(";");
	}

}
