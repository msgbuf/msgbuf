/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.HashMap;
import java.util.Map;

import de.haumacher.msgbuf.generator.ast.Constant;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Part;
import de.haumacher.msgbuf.generator.common.Util;

/**
 * Algorithm assigning identifiers to {@link Part}s that have no identifier
 * assigned in the message definition.
 */
public class FieldIDSynthesizer implements Definition.Visitor<Map<Integer, String>, Void> {

	/**
	 * Names of all fields by index for each processed message, including inherited fields.
	 */
	private final Map<MessageDef, Map<Integer, String>> _indexes = new HashMap<>();
	
	/** 
	 * Assigns IDs in the given file.
	 */
	public void process(DefinitionFile file) {
		for (Definition def : file.getDefinitions()) {
			def.visit(this, null);
		}
	}

	@Override
	public Map<Integer, String> visit(EnumDef self, Void arg) {
		Map<Integer, String> partByIndex = new HashMap<>();
		for (Constant constant : self.getConstants()) {
			int index = constant.getIndex();
			if (index > 0) {
				String clash = partByIndex.put(Integer.valueOf(index), constant.getName());
				if (clash != null) {
					error("Duplicate index '" + index + "' for '" + constant.getName() + "' and '" + clash + "' in type '" + Util.toString(self) + "'.");
				}
			}
		}
		
		int nextIndex = 1;
		for (Constant constant : self.getConstants()) {
			int index = constant.getIndex();
			if (index == 0) {
				while (partByIndex.containsKey(Integer.valueOf(nextIndex))) {
					nextIndex++;
				}
				partByIndex.put(Integer.valueOf(nextIndex), constant.getName());
				
				constant.setIndex(nextIndex);
			}
		}
		
		return partByIndex;
	}

	private void error(String message) {
		System.err.println(message);
	}

	@Override
	public Map<Integer, String> visit(MessageDef self, Void arg) {
		Map<Integer, String> result = indexes(self);
		for (Definition inner : self.getDefinitions()) {
			inner.visit(this, arg);
		}
		return result;
	}

	/**
	 * Assigns the field indexes of the given message (and its generalizations) and returns the
	 * names of all its fields, including the inherited ones, by index.
	 *
	 * <p>
	 * Walks the generalizations only, not the nested definitions: a nested message may extend its
	 * outer message.
	 * </p>
	 */
	private Map<Integer, String> indexes(MessageDef self) {
		Map<Integer, String> cached = _indexes.get(self);
		if (cached != null) {
			return cached;
		}
		// Guards against an inheritance cycle, which the generator rejects before.
		_indexes.put(self, new HashMap<>());

		Map<Integer, String> partByIndex;
		if (self.getExtendedDef() != null) {
			partByIndex = new HashMap<>(indexes(self.getExtendedDef()));
		} else {
			partByIndex = new HashMap<>();
		}
		
		for (Field field : self.getFields()) {
			int index = field.getIndex();
			if (index > 0) {
				String clash = partByIndex.put(Integer.valueOf(index), field.getName());
				if (clash != null) {
					error("Duplicate index '" + index + "' for '" + field.getName() + "' and '" + clash + "' in type '" + Util.toString(self) + "'.");
				}
			}
		}
		
		int nextIndex = 1;
		for (Field field : self.getFields()) {
			int index = field.getIndex();
			if (index == 0) {
				while (partByIndex.containsKey(Integer.valueOf(nextIndex))) {
					nextIndex++;
				}
				partByIndex.put(Integer.valueOf(nextIndex), field.getName());
				
				field.setIndex(nextIndex);
			}
		}

		_indexes.put(self, partByIndex);
		return partByIndex;
	}

}
