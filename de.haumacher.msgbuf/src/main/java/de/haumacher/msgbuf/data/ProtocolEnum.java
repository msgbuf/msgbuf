/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.data;

/**
 * Common interface for all enums used in protocol definitions.
 */
public interface ProtocolEnum {

	/**
	 * The value to use in the protocol (e.g. JSON string to serialize the enum constant)
	 */
	String protocolName();
	
}
