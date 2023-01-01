/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.util.CodeUtil.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.ast.Type;
import de.haumacher.msgbuf.generator.common.Util;
import de.haumacher.msgbuf.generator.util.CodeUtil;

/**
 * Utility methods defining technical names of generated classes.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public class CodeConvention {

	public static String qTypeName(CustomType def) {
		Definition definition = def.getDefinition();
		if (definition == null) {
			return qTypeName(def.getName());
		} else {
			return qTypeName(definition);
		}
	}
	
	public static String qTypeName(Definition def) {
		return qName(null, def, CodeConvention::typeName);
	}
	
	public static String qImplName(String packageSuffix, Definition def) {
		return qName(packageSuffix, def, CodeConvention::implName);
	}
	
	public static String qName(String packageSuffix, Definition def, Function<String, String> localNameConvention) {
		String scope;
		
		DefinitionFile file = def.getFile();
		if (file == null) {
			scope = qName(packageSuffix, def.getOuter(), localNameConvention) + ".";
		} else {
			QName pkg = file.getPackage();
			scope = pkg.getNames().size() == 0 ? (packageSuffix == null ? "" : packageSuffix + ".") : qName(pkg) + "." + (packageSuffix == null ? "" : packageSuffix + ".");
		}
		
		return scope + localNameConvention.apply(def.getName());
	}

	public static String qTypeName(QName qName) {
		return qName(qName, CodeConvention::typeName);
	}
	
	public static String qImplName(QName qName) {
		return qName(qName, CodeConvention::implName);
	}
	
	public static String qName(QName qName, Function<String, String> localNameConvention) {
		StringBuilder result = new StringBuilder();
		List<String> names = qName.getNames();
		for (int n = 0, cnt = names.size(); n < cnt; n++) {
			if (n > 0) {
				result.append('.');
			}
			String part = names.get(n);
			result.append(localNameConvention.apply(part));
		}
		return result.toString();
	}

	public static String typeName(Definition def) {
		return typeName(def.getName());
	}

	public static String typeName(String name) {
		return camelCase(name);
	}

	public static String implName(Definition def) {
		return implName(def.getName());
	}

	public static String implName(String name) {
		return typeName(name) + "_Impl";
	}
	
	public static String suffix(Field field) {
		return camelCase(field.getName());
	}

	public static String binaryConstant(Field field) {
		return allUpperCase(field.getName()) + "__ID";
	}

	public static String constant(Field field) {
		return allUpperCase(field.getName()) + "__PROP";
	}

	/**
	 * Name of the factory method for the given {@link MessageDef}.
	 * 
	 * @param def
	 *        The {@link MessageDef} to produce a factory name for.
	 */
	public static String factoryName(MessageDef def) {
		return "create";
	}

	public static String getterName(Field field) {
		Type type = field.getType();
		if (type instanceof PrimitiveType && ((PrimitiveType) type).getKind() == PrimitiveType.Kind.BOOL && !Util.isNullable(field)) {
			return "is" + suffix(field);
		} else {
			return "get" + suffix(field);
		}
	}

	public static String adderName(Field field) {
		String suffix = singularSuffix(field);
		if (field.getType() instanceof MapType) {
			return "put" + suffix;
		} else {
			return "add" + suffix;
		}
	}

	public static String internalAdderName(Field field) {
		String suffix = singularSuffix(field);
		if (field.getType() instanceof MapType) {
			return "internalPut" + suffix;
		} else {
			return "internalAdd" + suffix;
		}
	}
	
	public static String removerName(Field field) {
		String suffix = singularSuffix(field);
		return "remove" + suffix;
	}

	private static String singularSuffix(Field field) {
		String suffix = suffix(field);
		if (suffix.endsWith("s")) {
			String singularSuffix = suffix.substring(0, suffix.length() - 1);
			String name = field.getName();
			String singularName = name.substring(0, name.length() - 1);
			
			MessageDef owner = (MessageDef) field.getOwner();
			if (getField(owner, singularName) == null) {
				// No clash with other singular field.
				return singularSuffix;
			}
		}
		return suffix;
	}
	
	public static String hasName(Field field) {
		return "has" + suffix(field);
	}

	public static String name(Field field) {
		return firstLowerCase(camelCase(field.getName()));
	}

	public static String setterName(Field field) {
		return "set" + suffix(field);
	}

	public static String internalSetterName(Field field) {
		return "internalSet" + suffix(field);
	}
	
	public static String readerName(String name) {
		return "read" + name;
	}

	public static String readerNameContent(String name) {
		return "read" + name + "_Content";
	}
	
	public static String readerName(Definition def) {
		return readerName(def.getName());
	}

	public static String readerNameContent(Definition def) {
		return readerNameContent(def.getName());
	}
	
	public static String packageName(QName packageName) {
		return qName(packageName);
	}

	public static String qName(QName qName) {
		return qName.getNames().stream().collect(Collectors.joining("."));
	}

	public static String jsonTypeConstant(MessageDef def) {
		return allUpperCase(def.getName()) + "__TYPE";
	}

	public static String jsonTypeConstantRef(MessageDef def) {
		return typeName(def) + "." + jsonTypeConstant(def);
	}

	public static String mkBinaryTypeConstant(MessageDef def) {
		return allUpperCase(def.getName()) + "__TYPE_ID";
	}

	public static String fieldMemberName(Field field) {
		return "_" + name(field);
	}

	public static String typeKindConstant(MessageDef caseDef) {
		return CodeUtil.allUpperCase(caseDef.getName());
	}

	static final String TYPE_KIND_NAME = "TypeKind";

	public static Field getField(MessageDef def, String name) {
		Field result = MessageGenerator.getLocalField(def, name);
		if (result != null) {
			return result;
		}
		MessageDef extendedDef = def.getExtendedDef();
		if (extendedDef != null) {
			return getField(extendedDef, name);
		}
		return null;
	}

	/** 
	 * The Java name of an enumeration classifier.
	 */
	public static String classifierName(Constant constant) {
		return CodeUtil.allUpperCase(constant.getName());
	}

	/**
	 * Enum method that resolves an enum value from a protocol string.
	 */
	public static final String ENUM_VALUE_OF_PROTOCOL = "valueOfProtocol";
	
	/**
	 * Enum method that returns the protocol string for the classifier.
	 */
	public static final String ENUM_PROTOCOL_NAME_FUN = "protocolName";

	/**
	 * The sub-package where to place implementations.
	 */
	public static final String IMPL_PACKAGE_SUFFIX = "impl";

}
