/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.CodeConvention.*;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.Type;

/**
 * Generator for default values for {@link Field}s.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
final class DefaultValueGenerator implements Type.Visitor<String, Void> {
	
	public static String mkDefaultValue(Field field) {
		boolean nullable = Util.isNullable(field);
		if (nullable) {
			return "null";
		}
		
		return mkDefaultValueNonNullable(field);
	}

	public static String mkDefaultValueNonNullable(Field field) {
		if (field.isRepeated()) {
			return "new java.util.ArrayList<>()";
		} else {
			return mkDefaultValue(field.getType());
		}
	}

	public static String mkDefaultValue(Type type) {
		return type.visit(INSTANCE, null);
	}

	private static final Type.Visitor<String, Void> INSTANCE = new DefaultValueGenerator();

	@Override
	public String visit(PrimitiveType self, Void arg) {
		switch (self.getKind()) {
		case BOOL: return "false";
		case BYTES: return "null";
		case DOUBLE: return "0.0d";
		case FLOAT: return "0.0f";
		case STRING: return "\"\"";
		case INT_32:
		case SINT_32:
		case UINT_32:
		case FIXED_32: 
		case SFIXED_32:
			return "0";
		case INT_64:
		case SINT_64:
		case UINT_64:
		case FIXED_64:
		case SFIXED_64:
			return "0L";
		}
		throw new UnsupportedOperationException("Unsupported type: " + self.getKind());
	}

	@Override
	public String visit(CustomType self, Void arg) {
		Definition definition = self.getDefinition();
		if (definition instanceof EnumDef) {
			return qTypeName(definition) + "." + classifierName(((EnumDef) definition).getConstants().get(0));
		} else {
			return "null";
		}
	}

	@Override
	public String visit(MapType self, Void arg) {
		return "new java.util.HashMap<>()";
	}
}