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
import de.haumacher.msgbuf.generator.ast.QName;

/**
 * TODO
 */
public class NameTable implements Definition.Visitor<Void, Void> {
	
	private final Map<String, Package> _packageByName = new HashMap<>();
	private final Map<String, Definition> _definitionByName = new HashMap<>();
	
	public void enter(DefinitionFile file) {
		Package pkg = mkPackage(file.getPackage());
		
		for (Definition def : file.getDefinitions()) {
			pkg.enter(file, def);
			def.visit(this, null);
		}
	}
	
	@Override
	public Void visit(EnumDef self, Void arg) {
		enterDef(self);
		for (Constant part : self.getConstants()) {
			part.setOwner(self);
		}
		return null;
	}
	
	@Override
	public Void visit(MessageDef self, Void arg) {
		enterDef(self);
		for (Field part : self.getFields()) {
			part.setOwner(self);
		}
		for (Definition inner : self.getDefinitions()) {
			inner.setOuter(self);
			enterDef(inner);
		}
		return null;
	}

	private void enterDef(Definition def) {
		_definitionByName.put(def.getName(), def);
	}
	
	private Package mkPackage(QName qName) {
		String name;
		if (qName == null) {
			name = "";
		} else {
			name = Util.qName(qName);
		}
		Package result = _packageByName.get(name);
		if (result == null) {
			result = new Package(name);
			_packageByName.put(name, result);
		}
		return result;
	}

	class Package {
		
		private final String _name;
		
		private final Map<String, Definition> _definitionsByName = new HashMap<>();

		/** 
		 * Creates a {@link Package}.
		 */
		public Package(String name) {
			_name = name;
		}

		public String getName() {
			return _name;
		}
		
		/** 
		 * TODO
		 * @param file 
		 */
		public void enter(DefinitionFile file, Definition def) {
			def.setFile(file);
			Definition clash = _definitionsByName.put(def.getName(), def);
			if (clash != null) {
				error("Duplicate definition '" + def.getName() + "' in package '" + getName() + "'.");
			}
		}
	}

	/** 
	 * TODO
	 */
	public void error(String message) {
		System.err.println(message);
	}

	/** 
	 * TODO
	 */
	public Definition lookup(MessageDef context, QName name) {
		return _definitionByName.get(Util.last(name));
	}
}
