/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 */
public class EnumDef extends Definition {
	
	private final List<Constant> _constants = new ArrayList<Constant>();
	
	public List<Constant> getConstants() {
		return _constants;
	}
	
	public void addConstant(Constant value) {
		_constants.add(value);
	}
	
	@Override
	public <R, A> R visit(Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}
}
