/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.dart;

import java.util.function.Function;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.Type;
import de.haumacher.msgbuf.generator.common.Util;
import de.haumacher.msgbuf.generator.util.AbstractDartGenerator;

/**
 * Generator of a read operation for reading a field value from a JSON stream.
 */
public class ReadOperationBuilder extends AbstractDartGenerator implements Type.Visitor<Void, Function<String,String>>, Definition.Visitor<Void, Function<String,String>> {
	
	private Field _field;
	private boolean _nullable;

	/** 
	 * Creates a {@link ReadOperationBuilder}.
	 */
	public ReadOperationBuilder(Field field) {
		_field = field;
	}
	
	@Override
	protected void generate() {
		boolean repeated = _field.isRepeated();
		String var = DartCoding.fieldName(_field);
		Type type = _field.getType();
		if (repeated) {
			_nullable = false;
			line("json.expectArray();");
			line(var + " = [];");
			line("while (json.hasNext()) {");
			{
				type.visit(this, value -> var + ".add(" + value + ");");
			}
			line("}");
		} else {
			_nullable = Util.isNullable(_field);
			type.visit(this, value -> var + " = " + value + ";");
		}
	}

	@Override
	public Void visit(CustomType self, Function<String,String> statementBuilder) {
		return self.getDefinition().visit(this, statementBuilder);
	}

	@Override
	public Void visit(PrimitiveType self, Function<String,String> statementBuilder) {
		switch (self.getKind()) {
		case BOOL: 
			line(statementBuilder.apply("json.expectBool()"));
			return null;
			
		case FLOAT:
		case DOUBLE:
			line(statementBuilder.apply("json.expectDouble()"));
			return null;
			
		case FIXED_32:
		case FIXED_64:
		case INT_32:
		case INT_64:
		case SFIXED_32:
		case SFIXED_64:
		case SINT_32:
		case SINT_64:
		case UINT_32:
		case UINT_64:
			line(statementBuilder.apply("json.expectInt()"));
			return null;
			
		case BYTES: 
		case STRING:
			line(statementBuilder.apply("json.expectString()"));
			return null;
		}
		throw new IllegalArgumentException("No such type: " + self);
	}

	@Override
	public Void visit(MapType self, Function<String,String> statementBuilder) {
		String var = "_" + DartCoding.fieldName(_field);
		
		line(self.visit(TypeNameBuilder.INSTANCE, null) + " " + var + " = " + "{};");
		line("json.expectObject();");
		line("while (json.hasNextKey()) {");
		{
			line("String __key = json.nextKey()!;");
			self.getValueType().visit(this, v -> var + "[__key] = " + v + ";");
		}
		line("}");
		line(statementBuilder.apply(var));
		return null;
	}

	@Override
	public Void visit(EnumDef self, Function<String,String> statementBuilder) {
		String value = DartCoding.readEnumMethod(self) + "(json)";
		if (_nullable) {
			value = "json.tryNull() ? null : " + value;
		}
		line(statementBuilder.apply(value));
		return null;
	}

	@Override
	public Void visit(MessageDef self, Function<String,String> statementBuilder) {
		String value = DartCoding.typeName(self) + ".read(json)";
		if (_nullable) {
			line(statementBuilder.apply("json.tryNull() ? null : " + value));
		} else {
			line("if (!json.tryNull()) {");
			{
				line(statementBuilder.apply(value));
			}
			line("}");
		}
		return null;
	}
}
