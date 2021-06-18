/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

/**
 * Internal data type of an array encoded within the data stream for a {@link FieldTag#REPEATED} field.
 */
enum ContentTag {
	
	/**
	 * A variable sized integer value.
	 */
	VAR,
	
	/**
	 * A character value.
	 */
	CHAR,
	
	/**
	 * A fixed size 8 bit value value.
	 */
	F8,
	
	/**
	 * A fixed size 32 bit value value.
	 */
	F32,
	
	/**
	 * A fixed size 64 bit value value.
	 */
	F64,
	
	/**
	 * An object consisting of a stream of fields.
	 */
	OBJ,

	/**
	 * Potentially multiple chunks of fixed size 8 bit values.
	 * 
	 * <p>
	 * Each chunk starts with a {@link FieldTag#VAR variable length encoded}
	 * integer value determining the length of the following chunk. The sequence
	 * of chunks ends with a chunk of size zero.
	 * </p>
	 */
	CHUNKED,
	
	/**
	 * A string value.
	 */
	REPEATED,
	
	/**
	 * Invalid content.
	 */
	NONE,
	
	;
	
	FieldTag toFieldTag() {
		switch (this) {
		case F32: return FieldTag.F32;
		case F64: return FieldTag.F64;
		case F8: return FieldTag.F8;
		case CHUNKED: return FieldTag.CHUNKED;
		case OBJ: return FieldTag.OBJ;
		case VAR: return FieldTag.VAR;
		case CHAR: return FieldTag.F8;
		case REPEATED: return FieldTag.REPEATED;
		case NONE: 
		}
		throw new IllegalArgumentException("There is not field tag for "  + this);
	}

}
