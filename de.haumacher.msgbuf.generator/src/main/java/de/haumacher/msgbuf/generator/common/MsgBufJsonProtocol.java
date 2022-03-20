/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.common;

import java.util.Optional;

import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.ast.Part;
import de.haumacher.msgbuf.generator.ast.StringOption;

/**
 * Mapping of the <code>msgbuf</code> JSON protocol definition to protocol implementations.
 */
public class MsgBufJsonProtocol {

	/**
	 * The name of the given enumeration classifier as used in the protocol (e.g. JSON format).
	 */
	public static String classifierId(Constant constant) {
		return protocolName(constant);
	}

	/** 
	 * Identifier used to announce an object of the given type.
	 */
	public static String typeId(MessageDef def) {
		return protocolName(def);
	}

	/** 
	 * Identifier for the given field.
	 */
	public static String fieldId(Field field) {
		return protocolName(field);
	}

	private static String protocolName(Definition part) {
		Optional<Option> fieldName = Util.getOption(part, "Name");
		return fieldName.isPresent() ? ((StringOption) fieldName.get()).getValue() : part.getName();
	}

	private static String protocolName(Part part) {
		Optional<Option> fieldName = Util.getOption(part, "Name");
		return fieldName.isPresent() ? ((StringOption) fieldName.get()).getValue() : part.getName();
	}

}
