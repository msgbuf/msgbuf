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
	 * 
	 * @param indent
	 *        The initial indentation level to start with.
	 */
	void generate(Appendable out, int indent) throws IOException;

}
