/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

/**
 * TODO
 */
public class DefinitionFile extends Scope {
	
	private QName _package;
	
	public QName getPackage() {
		return _package;
	}
	
	public void setPackage(QName value) {
		_package = value;
	}
	
}
