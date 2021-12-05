/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.NumberOption;
import de.haumacher.msgbuf.generator.ast.Option;

/**
 * Assigns type IDs in polymorphic hierarchies.
 */
public class TypeIdSynthesizer implements Definition.Visitor<Void, Void> {

	/** 
	 * Starts the ID assignment process.
	 */
	public void process(DefinitionFile file) {
		for (Definition<?> def : file.getDefinitions()) {
			def.visit(this, null);
		}
	}

	@Override
	public Void visit(EnumDef self, Void arg) {
		return null;
	}

	@Override
	public Void visit(MessageDef self, Void arg) {
		for (Definition<?> def : self.getDefinitions()) {
			def.visit(this, null);
		}
		
		if (self.isAbstract() && self.getExtendedDef() == null) {
			// Root of a polymorphic hierarchy.
			assignTypeIds(self);			
		}
		
		return null;
	}

	private void assignTypeIds(MessageDef def) {
		Map<Integer,MessageDef> typeById = new HashMap<Integer, MessageDef>();
		
		enterAnnotated(typeById, def);
		synthesize(typeById, def);
	}

	private void synthesize(Map<Integer, MessageDef> typeById, MessageDef def) {
		if (!def.isAbstract()) {
			synthesizeLocal(typeById, def);
		}
		
		for (MessageDef specialization : def.getSpecializations()) {
			synthesize(typeById, specialization);
		}
	}
	
	private void synthesizeLocal(Map<Integer, MessageDef> typeById,
			MessageDef def) {
		if (def.getId() != 0) {
			return;
		}
		
		int nextId = 1;
		while (typeById.containsKey(Integer.valueOf(nextId))) {
			nextId++;
		}
		
		def.setId(nextId);
		typeById.put(Integer.valueOf(nextId), def);
	}

	private void enterAnnotated(Map<Integer, MessageDef> typeById,
			MessageDef def) {
		if (!def.isAbstract()) {
			enterAnnotatedLocal(typeById, def);
		}
		
		for (MessageDef specialization : def.getSpecializations()) {
			enterAnnotated(typeById, specialization);
		}
	}

	private void enterAnnotatedLocal(Map<Integer, MessageDef> typeById, MessageDef def) {
		Optional<Option<?>> option = Util.getOption(def, "type_id");
		if (option.isPresent()) {
			int id = (int) ((NumberOption) option.get()).getValue();
			def.setId(id);
			
			MessageDef clash = typeById.put(Integer.valueOf(id), def);
			if (clash != null) {
				error("Type ID '" + id + "' assigned to '" + Util.toString(def) + "' and '" + Util.toString(clash) + "'.");
			}
		}
	}

	private void error(String message) {
		System.err.println(message);
	}

}
