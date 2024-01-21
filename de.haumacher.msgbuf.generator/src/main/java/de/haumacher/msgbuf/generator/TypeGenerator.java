/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.CodeConvention.*;

import java.util.function.Function;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.Type;
import de.haumacher.msgbuf.generator.common.Util;

/**
 * Generator for Java types of {@link Field}s.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public class TypeGenerator implements Type.Visitor<String, Boolean> {
	
	/**
	 * Singleton {@link TypeGenerator} instance.
	 */
	public static final TypeGenerator INSTANCE = new TypeGenerator(null, CodeConvention::typeName);
	
	/**
	 * Singleton {@link TypeGenerator} instance.
	 */
	public static final TypeGenerator IMPL_INSTANCE = new TypeGenerator(CodeConvention.IMPL_PACKAGE_SUFFIX, CodeConvention::implName);
	
	private Function<String, String> _typeNameConvention;

	private String _packageSuffix;

	private TypeGenerator(String packageSuffix, Function<String, String> typeNameConvention) {
		_packageSuffix = packageSuffix;
		_typeNameConvention = typeNameConvention;
	}

	public static String mkType(Field field) {
		return mkType(field, false);
	}
	
	public static String mkTypeReadOnly(Field field) {
		return mkType(field, true);
	}
	
	private static String mkType(Field field, boolean readOnly) {
		return field.isRepeated() ? "java.util.List<" + (readOnly ? "? extends " : "") + mkTypeWrapped(field.getType()) + ">" : mkType(field.getType(), Util.isNullable(field));
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
	
	public static String mkTypeWrappedImpl(Type type) {
		return type.visit(IMPL_INSTANCE, Boolean.TRUE);
	}
	
	@Override
	public String visit(MapType type, Boolean wrapped) {
		return "java.util.Map<" + mkTypeWrapped(type.getKeyType()) + ", " + mkTypeWrapped(type.getValueType()) + ">";
	}
	
	@Override
	public String visit(CustomType type, Boolean wrapped) {
		Definition definition = type.getDefinition();
		if (definition == null) {
			return qName(type.getName());
		}
		return qName(_packageSuffix, definition, _typeNameConvention);
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
		case INT_32:
		case UINT_32:
		case FIXED_32:
		case SINT_32:
		case SFIXED_32:
			return wrapped ? "Integer" : "int";
		case INT_64:
		case UINT_64:
		case FIXED_64:
		case SINT_64:
		case SFIXED_64:
			return wrapped ? "Long" : "long";
		case STRING:
			return "String";
		}
		throw new RuntimeException("No such type: " + type.getKind());
	}

}
