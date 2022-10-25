/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.dart;

import static de.haumacher.msgbuf.generator.dart.DartCoding.*;

import java.util.stream.Collectors;

import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.common.Util;
import de.haumacher.msgbuf.generator.util.AbstractDartGenerator;

/**
 * Generator for a Dart protocol class.
 */
public class DartClassGenerator extends AbstractDartGenerator {

	private MessageDef _def;

	/** 
	 * Creates a {@link DartClassGenerator}.
	 */
	public DartClassGenerator(MessageDef def) {
		_def = def;
	}

	@Override
	protected void generate() {
		String typeName = typeName(_def);
		
		if (_def.isAbstract()) {
			line("/// Visitor interface for " + typeName + ".");
			line("abstract class " + visitorName(_def) + "<R, A>" + visitorExtends() + " {");
			{
				for (MessageDef specialization : _def.getSpecializations()) {
					if (specialization.isAbstract()) {
						continue;
					}
					String caseName = typeName(specialization); 
					line("R visit" + caseName + "(" + caseName + " self, A arg);");
				}
			}
			line("}");
			nl();
		}
		
		docComment(_def.getComment());
		line(abstractModifier() + "class " + typeName + " extends " + extendsName() + " {");
		{
			for (Field field : _def.getFields()) {
				docComment(field.getComment());
				line(typeName(field) + nullableModifier(field) + " " + fieldName(field) + ";");
				nl();
			}
			
			line("/// Creates a " + typeName + ".");
			if (_def.getFields().isEmpty()) {
				line(typeName + "();");
			} else {
				line(typeName + "({");
				for (Field field : _def.getFields()) {
					line("this." + fieldName(field) + initializer(field) + ", ");
				}
				line("});");
			}
			nl();
			
			line("/// Parses a " + typeName + " from a string source.");
			line("static " + typeName + "? fromString(String source) {");
			{
				line("return read(JsonReader.fromString(source));");
			}
			line("}");
			nl();
			
			line("/// Reads a " + typeName + " instance from the given reader.");
			if (_def.isAbstract()) {
				line("static " + typeName + "? read(JsonReader json) {");
				{
					line(typeName + "? result;");
					nl();
					
					line("json.expectArray();");
					{
						line("if (!json.hasNext()) {");
						{
							line("return null;");
						}
						line("}");
						nl();

						line("switch (json.expectString()) {");
						{
							for (MessageDef specialization : Util.concreteTransitiveSpecializations(_def)) {
								line("case " + jsonTypeIdLiteral(specialization) + ": result = " + typeName(specialization) + "(); break;");
							}
							line("default: result = null;");
						}
						line("}");
						nl();
						
						line("if (!json.hasNext() || json.tryNull()) {");
						{
							line("return null;");
						}
						line("}");
						nl();
						
						line("if (result == null) {");
						{
							line("json.skipAnyValue();");
						}
						line("} else {");
						{
							line("result._readContent(json);");
						}
						line("}");
					}
					line("json.endArray();");
					nl();
					
					line("return result;");
				}
				line("}");
				nl();
			} else {
				line("static " + typeName + " read(JsonReader json) {");
				{
					line(typeName + " result = " + typeName + "();");
					line("result._readContent(json);");
					line("return result;");
				}
				line("}");
				nl();
				
				line("@override");
				line("String _jsonType() => " + jsonTypeIdLiteral(_def) + ";");
				nl();
			}

			if (!_def.getFields().isEmpty()) {
				line("@override");
				line("void _readProperty(String key, JsonReader json) {");
				{
					line("switch (key) {");
					{
						for (Field field : _def.getFields()) {
							if (field.isTransient()) {
								continue;
							}

							line("case " + jsonName(field) + ": {");
							{
								include(new ReadOperationBuilder(field));
								line("break;");
							}
							line("}");
						}
						line("default: super._readProperty(key, json);");
					}
					line("}");
				}
				line("}");
				nl();
				
				line("@override");
				line("void _writeProperties(JsonSink json) {");
				{
					line("super._writeProperties(json);");
					
					for (Field field : _def.getFields()) {
						if (field.isTransient()) {
							continue;
						}

						nl();
						boolean nullable = Util.isNullable(field);
						String value = DartCoding.fieldName(field);
						String var;
						if (nullable) {
							var = "_" + value;
							
							line("var " + var + " = " + value + ";");
							line("if (" + var + " != null) {");
						} else {
							var = value;
						}
						{
							line("json.addKey(" + jsonName(field) + ");");
							this.include(new WriteOperationBuilder(field.isRepeated(), field.getType(), var));
						}
						if (nullable) {
							line("}");
						}
					}
				}
				line("}");
				nl();
			}
			
			if (_def.isAbstract()) {
				line("R " + visitMethod(_def) + "<R, A>(" + visitorName(_def) + "<R, A> v, A arg);");
				nl();
			} 

			if (_def.getExtendedDef() != null) {
				String impl = _def.isAbstract() ? 
					visitMethod(_def) + "(v, arg)" :
					"v." + DartCoding.visitCaseMethod(_def) + "(this, arg)" ;
				
				line("@override");
				line("R " + visitMethod(_def.getExtendedDef()) + "<R, A>(" + visitorName(_def.getExtendedDef()) + "<R, A> v, A arg) => " + impl + ";");
				nl();
			}
		} 
		line("}");
		nl();
	}

	private String nullableModifier(Field field) {
		return Util.isNullable(field) ? "?" : "";
	}

	private String abstractModifier() {
		return _def.isAbstract() ? "abstract " : "";
	}

	private String extendsName() {
		return _def.getExtendedDef() == null ? "_JsonObject" : typeName(_def.getExtendedDef());
	}

	private String visitorExtends() {
		String extendsList = _def.getSpecializations().stream().filter(s -> s.isAbstract()).map(s ->  visitorName(s) + "<R, A>").collect(Collectors.joining(", "));
		if (extendsList.isEmpty()) {
			return "";
		}
		return " implements " + extendsList;
	}

}
