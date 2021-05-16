/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

/**
 * TODO
 */
public abstract class Type {
	
	public interface Visitor<R,A> {
		R visit(PrimitiveType type, A arg);
		R visit(MessageType type, A arg);
		R visit(MapType type, A arg);
	}

	@Override
	public abstract String toString();
	
	public abstract <R,A> R visit(Visitor<R,A> visitor, A arg);
	
}
