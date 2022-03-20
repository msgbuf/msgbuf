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
 * Generator for type names of fields.
 */
public class TypeNameBuilder implements Type.Visitor<String, Field>, Definition.Visitor<String, Field> {
	
	/**
	 * Singleton {@link TypeNameBuilder} instance.
	 */
	public static final TypeNameBuilder INSTANCE = new TypeNameBuilder();

	private TypeNameBuilder() {
		// Singleton constructor.
	}

	@Override
	public String visit(CustomType self, Field arg) {
		return arg != null && arg.isRepeated() ? "List<" + self.getDefinition().visit(this, arg) + ">" : self.getDefinition().visit(this, arg);
	}

	@Override
	public String visit(PrimitiveType self, Field arg) {
		switch (self.getKind()) {
		case BOOL: 
			return "bool";
			
		case FLOAT:
		case DOUBLE:
			return "double";
			
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
			return "int";
			
		case BYTES: 
		case STRING:
			return "String";
		}
		throw new IllegalArgumentException("No such type: " + self);
	}

	@Override
	public String visit(MapType self, Field arg) {
		return "Map<" + self.getKeyType().visit(this, null) + ", " + self.getValueType().visit(this, null) + ">";
	}

	@Override
	public String visit(EnumDef self, Field arg) {
		return DartCoding.typeName(self);
	}

	@Override
	public String visit(MessageDef self, Field arg) {
		return DartCoding.typeName(self);
	}

}
