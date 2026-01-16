/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.CodeConvention.*;

import java.util.Map;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.Type;
import de.haumacher.msgbuf.generator.common.Util;

/**
 * Generator for default values for {@link Field}s.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
final class DefaultValueGenerator implements Type.Visitor<String, Void> {

	private final Map<String, Option> _options;

	/**
	 * Creates a {@link DefaultValueGenerator}.
	 *
	 * @param options The global protocol options.
	 */
	public DefaultValueGenerator(Map<String, Option> options) {
		_options = options;
	}

	public String mkDefaultValue(Field field) {
		String defaultValue = field.getDefaultValue();
		if (defaultValue != null) {
			return defaultValue;
		}

		boolean nullable = Util.isNullable(field);
		if (nullable) {
			return "null";
		}

		return mkDefaultValueNonNullable(field);
	}

	public String mkDefaultValueNonNullable(Field field) {
		if (field.isRepeated()) {
			return "new java.util.ArrayList<>()";
		} else {
			return mkDefaultValue(field.getType());
		}
	}

	public String mkDefaultValue(Type type) {
		return type.visit(this, null);
	}

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
		// Use LinkedHashMap by default to preserve insertion order
		// Use HashMap only if UnorderedMaps option is explicitly set for performance reasons
		boolean useUnorderedMaps = _options != null && AbstractMessageGenerator.isTrue(_options.get("UnorderedMaps"), false);
		if (useUnorderedMaps) {
			return "new java.util.HashMap<>()";
		} else {
			return "new java.util.LinkedHashMap<>()";
		}
	}
}