/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 */
public class MessageDef extends Definition {
	
	private boolean _abstract;
	private QName _extends;
	private List<Definition> _definitions = new ArrayList<Definition>();
	private final List<Field> _fields = new ArrayList<>();
	private List<MessageDef> _specializations = new ArrayList<>();
	private MessageDef _extendedDef;

	public QName getExtends() {
		return _extends;
	}
	
	public void setExtends(QName value) {
		_extends = value;
	}
	
	public boolean isAbstract() {
		return _abstract;
	}
	
	public void setAbstract(boolean value) {
		_abstract = value;
	}

	public List<Definition> getDefinitions() {
		return _definitions;
	}
	
	public void addDefinition(Definition definition) {
		_definitions.add(definition);
	}

	public List<Field> getFields() {
		return _fields;
	}
	
	public void addField(Field field) {
		_fields.add(field);
	}

	@Override
	public <R, A> R visit(Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

	/** 
	 * TODO
	 */
	public void addSpecialization(MessageDef specialization) {
		_specializations.add(specialization);
	}
	
	public List<MessageDef> getSpecializations() {
		return _specializations;
	}

	public void setExtendedDef(MessageDef extendsDef) {
		_extendedDef = extendsDef;
	}
	
	/** 
	 * TODO
	 */
	public MessageDef getExtendedDef() {
		return _extendedDef;
	}
}
