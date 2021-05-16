/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

/**
 * TODO
 */
public class Field extends Named {

	private boolean _repeated;
	private Type _type;
	private int _index;
	
	public boolean isRepeated() {
		return _repeated;
	}
	
	public void setRepeated(boolean repeated) {
		_repeated = repeated;
	}
	
	public Type getType() {
		return _type;
	}
	
	public void setType(Type type) {
		_type = type;
	}
	
	public int getIndex() {
		return _index;
	}
	
	public void setIndex(int index) {
		_index = index;
	}

}
