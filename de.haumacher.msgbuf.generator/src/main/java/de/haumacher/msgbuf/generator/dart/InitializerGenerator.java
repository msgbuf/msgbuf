/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.dart;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.Type;

/**
 * Generator for default values for fields of certain types.
 */
public class InitializerGenerator implements Type.Visitor<String, Field>, Definition.Visitor<String, Field> {
	
	/**
	 * Singleton {@link InitializerGenerator} instance.
	 */
	public static final InitializerGenerator INSTANCE = new InitializerGenerator();

	private InitializerGenerator() {
		// Singleton constructor.
	}

	@Override
	public String visit(CustomType self, Field field) {
		return field.isRepeated() ? " = const []" : self.getDefinition().visit(this, field);
	}
	
	@Override
	public String visit(EnumDef self, Field arg) {
		return " = " + DartCoding.typeName(self) + "." + DartCoding.literalName(self.getConstants().get(0));
	}
	
	@Override
	public String visit(MessageDef self, Field arg) {
		return "";
	}
	
	@Override
	public String visit(PrimitiveType self, Field field) {
		switch (self.getKind()) {
		case BOOL: 
			return " = false";
			
		case FLOAT:
		case DOUBLE:
			return " = 0.0";
			
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
			return " = 0";
			
		case BYTES: 
		case STRING:
			return " = \"\"";
		}
		throw new IllegalArgumentException("No such type: " + self);
	}

	@Override
	public String visit(MapType self, Field field) {
		return " = const {}";
	}

}
