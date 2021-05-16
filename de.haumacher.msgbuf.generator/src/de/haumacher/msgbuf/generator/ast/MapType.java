/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

/**
 * TODO
 */
public class MapType extends Type {

	private final Type _keyType;
	private final Type _valueType;

	/** 
	 * Creates a {@link MapType}.
	 */
	public MapType(Type keyType, Type valueType) {
		_keyType = keyType;
		_valueType = valueType;
	}

	public Type getKeyType() {
		return _keyType;
	}
	
	public Type getValueType() {
		return _valueType;
	}

	@Override
	public String toString() {
		return "Map<" + getKeyType() + ", " + getValueType() + ">";
	}
	
	@Override
	public <R, A> R visit(Visitor<R, A> visitor, A arg) {
		return visitor.visit(this, arg);
	}
}
