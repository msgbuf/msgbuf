/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.io.IOException;

/**
 * TODO
 */
public interface FileGenerator {

	/** 
	 * TODO
	 * @throws IOException 
	 */
	void generate(Appendable out) throws IOException;

}
