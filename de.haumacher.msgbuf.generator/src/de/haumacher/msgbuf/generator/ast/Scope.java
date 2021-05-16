/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 */
public abstract class Scope {

	private List<Definition> _definitions = new ArrayList<Definition>();

	public List<Definition> getDefinitions() {
		return _definitions;
	}
	
	public void addDefinition(Definition definition) {
		_definitions.add(definition);
	}


}
