/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

/**
 * Internal data type of an object field encoded within the data stream.
 */
enum FieldTag {
	
	/**
	 * A variable sized integer value.
	 */
	VAR(ContentTag.VAR),
	
	/**
	 * A fixed size 8 bit value value.
	 */
	F8(ContentTag.F8),
	
	/**
	 * A fixed size 32 bit value value.
	 */
	F32(ContentTag.F32),
	
	/**
	 * A fixed size 64 bit value value.
	 */
	F64(ContentTag.F64),
	
	/**
	 * An object consisting of a stream of fields.
	 */
	OBJ(ContentTag.OBJ),
	
	/**
	 * End of an object marker. 
	 */
	STOP(ContentTag.NONE),
	
	/**
	 * An array consisting of a stream of values of the same type.
	 */
	REPEATED(ContentTag.REPEATED),
	
	/**
	 * An array consisting of a stream of values of the same type.
	 */
	CHUNKED(ContentTag.CHUNKED),
	
	;
	
	private final ContentTag _content;
	
	private FieldTag(ContentTag content) {
		_content = content;
	}
	
	/**
	 * The {@link ContentTag} to use for an array of this tag type.
	 */
	public ContentTag asContent() {
		return _content;
	}

}
