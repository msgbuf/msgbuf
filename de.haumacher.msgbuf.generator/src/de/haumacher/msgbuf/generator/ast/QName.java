/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 */
public class QName {
	
	private final List<String> _names = new ArrayList<>();
	
	public List<String> getNames() {
		return _names;
	}
	
	public void add(String name) {
		_names.add(name);
	}

	public String qName() {
		return _names.stream().collect(Collectors.joining("."));
	}

	/** 
	 * TODO
	 */
	public String last() {
		return _names.get(_names.size() - 1);
	}

}
