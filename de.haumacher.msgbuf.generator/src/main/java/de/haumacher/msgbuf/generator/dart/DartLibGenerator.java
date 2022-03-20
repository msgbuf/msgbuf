/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.dart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStreamWriter;

import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.util.AbstractDartGenerator;

/**
 * Generator for a <code>msgbuf</code> Dart library.
 */
public class DartLibGenerator extends AbstractDartGenerator implements Definition.Visitor<Void, Void> {

	private File _file;
	private DefinitionFile _proto;

	/** 
	 * Creates a {@link DartLibGenerator}.
	 */
	public DartLibGenerator(File file, DefinitionFile proto) {
		_file = file;
		_proto = proto;
	}

	/** 
	 * Runs the generation.
	 */
	public void run() {
		System.out.println("Generating '" + _file + "'.");
		try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(_file), "utf8")) {
			generate(out);
		} catch (IOException ex) {
			throw new IOError(ex);
		}
	}

	@Override
	protected void generate() {
		line("import 'package:jsontool/jsontool.dart';");
		nl();
		
		writeBaseClass();
		
		for (Definition def : _proto.getDefinitions()) {
			def.visit(this, null);
		}
	}

	private void writeBaseClass() {
		line("/// Common functionality for JSON generation and parsing.");
		line("abstract class _JsonObject {");
		{
			line("@override");
			line("String toString() {");
			{
				line("var buffer = StringBuffer();");
				line("writeTo(jsonStringWriter(buffer));");
				line("return buffer.toString();");
			}
			line("}");
			nl();
			
			line("/// The ID to announce the type of the object.");
			line("String _jsonType();");
			nl();

			line("/// Reads the object contents (after the type information).");
			line("void _readContent(JsonReader json) {");
			{
				line("json.expectObject();");
				line("while (json.hasNextKey()) {");
				{
					line("var key = json.nextKey();");
					line("_readProperty(key!, json);");
				}
				line("}");
			}
			line("}");
			nl();
			
			line("/// Reads the value of the property with the given name.");
			line("void _readProperty(String key, JsonReader json) {");
			{
				line("json.skipAnyValue();");
			}
			line("}");
			nl();
			
			line("/// Writes this object to the given writer (including type information).");
			line("void writeTo(JsonSink json) {");
			{
				line("json.startArray();");
			    {
			    	line("json.addString(_jsonType());");
			    	line("writeContent(json);");
			    }
			    line("json.endArray();");
			}
			line("}");
			nl();

			line("/// Writes the contents of this object to the given writer (excluding type information).");
			line("void writeContent(JsonSink json) {");
			{
				line("json.startObject();");
			    {
			    	line("_writeProperties(json);");
			    }
			    line("json.endObject();");
			}
			line("}");
			nl();
			  
			line("/// Writes all key/value pairs of this object.");
			line("void _writeProperties(JsonSink json) {");
			{
				line("// No properties.");
			}
			line("}");
		}
		line("}");
		nl();
	}

	@Override
	public Void visit(EnumDef self, Void arg) {
		new DartEnumGenerator(self).generateInner(this);
		return null;
	}

	@Override
	public Void visit(MessageDef self, Void arg) {
		new DartClassGenerator(self).generateInner(this);
		return null;
	}

}
