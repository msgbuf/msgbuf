/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.CodeConvention.*;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.Type;

/**
 * Generator for Java types of {@link Field}s.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public class TypeGenerator implements Type.Visitor<String, Boolean> {
	
	/**
	 * Singleton {@link TypeGenerator} instance.
	 */
	public static final TypeGenerator INSTANCE = new TypeGenerator();

	private TypeGenerator() {
		// Singleton constructor.
	}

	public static String mkType(Field field) {
		return field.isRepeated() ? "java.util.List<" + mkTypeWrapped(field.getType()) + ">" : mkType(field.getType(), Util.isNullable(field));
	}

	public static String mkType(Type type) {
		return mkType(type, false);
	}
	
	public static String mkType(Type type, boolean nullable) {
		return type.visit(INSTANCE, Boolean.valueOf(nullable));
	}
	
	public static String mkTypeWrapped(Type type) {
		return type.visit(INSTANCE, Boolean.TRUE);
	}
	
	@Override
	public String visit(MapType type, Boolean wrapped) {
		return "java.util.Map<" + mkTypeWrapped(type.getKeyType()) + ", " + mkTypeWrapped(type.getValueType()) + ">";
	}
	
	@Override
	public String visit(CustomType type, Boolean wrapped) {
		return qTypeName(type.getName());
	}
	
	@Override
	public String visit(PrimitiveType type, Boolean wrapped) {
		switch (type.getKind()) {
		case BOOL:
			return wrapped ? "Boolean" : "boolean";
		case BYTES:
			return "byte[]";
		case FLOAT:
			return wrapped ? "Float" : "float";
		case DOUBLE:
			return wrapped ? "Double" : "double";
		case INT32:
		case UINT32:
		case FIXED32:
		case SINT32:
		case SFIXED32:
			return wrapped ? "Integer" : "int";
		case INT64:
		case UINT64:
		case FIXED64:
		case SINT64:
		case SFIXED64:
			return wrapped ? "Long" : "long";
		case STRING:
			return "String";
		}
		throw new RuntimeException("No such type: " + type.getKind());
	}

}
