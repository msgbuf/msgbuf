/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.binary;

/**
 * Reader/writer state.
 */
enum State {
	/**
	 * The start of the data expecting the start of an object.
	 */
	START, 
	
	/**
	 * Within an object expecting the next field to be written.
	 */
	FIELD, 
	
	/**
	 * A field has started, the field ID is provided, expecting a value to be written.
	 */
	FIELD_VALUE, 
	
	/**
	 * An array has started, the array length is initialized, expecting a value to be written.
	 */
	ARRAY_VALUE,
	
	/**
	 * A chunked array value has been started but not yet finished.
	 */
	CHUNKED_VALUE
	
	;
}