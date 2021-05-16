/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

/**
 * TODO
 */
public abstract class Named {

	private String _name;

	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}

}
