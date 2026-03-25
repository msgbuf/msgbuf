/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.CodeConvention.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.common.Util;

import de.haumacher.msgbuf.generator.ast.Flag;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.util.AbstractJavaGenerator;

/**
 * Base class for generating message contents.
 */
public abstract class AbstractMessageGenerator extends AbstractJavaGenerator {

	private Map<String, Option> _options;
	
	protected final boolean _noInterfaces;

	protected final String _packageSuffix;
	
	/** 
	 * Creates a {@link AbstractMessageGenerator}.
	 */
	public AbstractMessageGenerator(Map<String, Option> options, String packageSuffix) {
		_options = options;
		_noInterfaces = isTrue(options.get("NoInterfaces"), false);
		_packageSuffix = packageSuffix;
	}
	
	/**
	 * Creates a {@link AbstractMessageGenerator} that does not create top-level file contents.
	 */
	protected AbstractMessageGenerator(Map<String, Option> options) {
		this(options, null);
	}
	
	public Map<String, Option> getOptions() {
		return _options;
	}

	public static boolean isTrue(Option option, boolean defaultValue) {
		return option == null ? defaultValue : ((Flag) option).isValue();
	}
	
	protected final String implName(MessageDef def) {
		if (_noInterfaces) {
			return CodeConvention.typeName(def);
		} else {
			return CodeConvention.implName(def);
		}
	}

	protected String qImplName(MessageDef def) {
		if (_noInterfaces) {
			return qTypeName(def);
		} else {
			return CodeConvention.qImplName(CodeConvention.IMPL_PACKAGE_SUFFIX, def);
		}
	}

	protected static List<MessageDef> concreteSpecializations(MessageDef def) {
		ArrayList<MessageDef> result = new ArrayList<>();
		addConcreteSpecializations(result, def, def.getFile());
		return result;
	}

	private static void addConcreteSpecializations(ArrayList<MessageDef> result, MessageDef def, DefinitionFile originFile) {
		if (!def.isAbstract()) {
			result.add(def);
		}

		for (MessageDef specialization : localSpecializations(def, originFile)) {
			addConcreteSpecializations(result, specialization, originFile);
		}
	}

	/**
	 * Returns the direct specializations of the given type. For OpenWorld protocols,
	 * only specializations from the same proto file as {@code originFile} are included.
	 * Cross-file extensions are discovered at runtime via the dynamic registry.
	 */
	protected static List<MessageDef> localSpecializations(MessageDef def, DefinitionFile originFile) {
		if (!Util.getFlag(originFile, "OpenWorld")) {
			return def.getSpecializations();
		}
		return def.getSpecializations().stream()
			.filter(s -> s.getFile() == originFile)
			.collect(Collectors.toList());
	}
	
}
