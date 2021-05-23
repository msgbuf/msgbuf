/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

/**
 * Internal data type encoded within the data stream.
 */
enum Tag {
	
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
	 * End of an object marker. 
	 */
	STOP,
	
	/**
	 * An array consisting of a stream of values of the same type.
	 */
	REPEATED,

}
