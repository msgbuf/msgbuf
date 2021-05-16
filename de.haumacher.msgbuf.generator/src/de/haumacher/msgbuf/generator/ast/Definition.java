/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ast;

/**
 * TODO
 */
public abstract class Definition extends Named {
	
	public interface Visitor<R,A> {
		R visit(MessageDef def, A arg);
		R visit(EnumDef def, A arg);
	}
	
	
	private DefinitionFile _file;
	public DefinitionFile getFile() {
		return _file;
	}
	
	public void setFile(DefinitionFile file) {
		_file = file;
	}

	/** 
	 * TODO
	 */
	public abstract <R,A> R visit(Visitor<R,A> v, A arg);
	
}
