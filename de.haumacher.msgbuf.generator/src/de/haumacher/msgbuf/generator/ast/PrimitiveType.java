/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

/**
 * TODO
 */
public class PrimitiveType extends Type {
	
	public enum Kind {
	    DOUBLE,
	    FLOAT,
	    INT32,
	    INT64,
	    UINT32,
	    UINT64,
	    SINT32,
	    SINT64,
	    FIXED32,
	    FIXED64,
	    SFIXED32,
	    SFIXED64,
	    BOOL,
	    STRING,
	    BYTES,
	    ;
	}

	private Kind _kind;
	
	/** 
	 * Creates a {@link PrimitiveType}.
	 */
	public PrimitiveType(String name) {
		_kind = Kind.valueOf(name.toUpperCase());
	}
	
	public Kind getKind() {
		return _kind;
	}
	
	@Override
	public String toString() {
		return _kind.name();
	}

	@Override
	public <R, A> R visit(Visitor<R, A> visitor, A arg) {
		return visitor.visit(this, arg);
	}
}
