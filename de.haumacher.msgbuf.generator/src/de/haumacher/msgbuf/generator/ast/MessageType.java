/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

/**
 * TODO
 */
public class MessageType extends Type {
	
	private final QName _name;
	
	/** 
	 * Creates a {@link MessageType}.
	 */
	public MessageType(QName name) {
		_name = name;
	}
	
	public QName getName() {
		return _name;
	}
	
	@Override
	public String toString() {
		return _name.qName();
	}
	
	@Override
	public <R, A> R visit(Visitor<R, A> visitor, A arg) {
		return visitor.visit(this, arg);
	}
}
