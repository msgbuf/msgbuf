/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

import static de.haumacher.msgbuf.binary.FieldTag.*;

/**
 * Declaration of the content-type of an array value.
 * 
 * @see DataWriter#beginArray(DataType, int)
 */
public enum DataType {
	
	/**
	 * Unsined <code>int</code> values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#value(int)}.
	 * </p>
	 */
	INT(VAR),

	/**
	 * sined <code>int</code> values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#valueSigned(int)}.
	 * </p>
	 */
	SINT(VAR),

	/**
	 * Fixed size 32 bit <code>int</code> values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#valueFixed(int)}.
	 * </p>
	 */
	FINT(F32),
	
	/**
	 * <code>float</code> values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#value(float)}.
	 * </p>
	 */
	FLOAT(F32),

	/**
	 * Unsined <code>long</code> values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#value(long)}.
	 * </p>
	 */
	LONG(VAR),
	
	/**
	 * Sined <code>long</code> values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#valueSigned(long)}.
	 * </p>
	 */
	SLONG(VAR),

	/**
	 * Fixed size 64 bit <code>long</code> values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#valueFixed(long)}.
	 * </p>
	 */
	FLONG(F64),
	
	/**
	 * <code>double</code> values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#value(double)}.
	 * </p>
	 */
	DOUBLE(F64),
	
	/**
	 * {@link String} values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#value(String)}.
	 * </p>
	 */
	STRING(REPEATED),
	
	/**
	 * Binary string values.
	 * 
	 * <p>
	 * All array entries must be written using {@link DataWriter#value(byte[])}.
	 * </p>
	 */
	BINARY(REPEATED),
	
	/**
	 * Object values.
	 * 
	 * <p>
	 * All array entries must be written with the {@link DataWriter#beginObject()} / {@link DataWriter#endObject()} pair of methods.
	 * </p>
	 */
	OBJECT(OBJ),
	
	;

	private FieldTag _tag;

	/** 
	 * Creates a {@link DataType}.
	 */
	DataType(FieldTag tag) {
		_tag = tag;
	}

	/** 
	 * The internal representation of this {@link DataType}.
	 */
	FieldTag tag() {
		return _tag;
	}

}
