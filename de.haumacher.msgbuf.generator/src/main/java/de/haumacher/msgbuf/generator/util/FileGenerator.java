/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.util;

import java.io.IOException;

/**
 * Common interface for code generators.
 */
public interface FileGenerator {

	/** 
	 * Generates the file contents to the given {@link Appendable}. 
	 */
	void generate(Appendable out) throws IOException;

}
