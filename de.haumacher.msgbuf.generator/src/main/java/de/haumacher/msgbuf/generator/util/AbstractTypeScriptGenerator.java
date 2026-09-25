/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.util;

/**
 * Base class for generators creating TypeScript code.
 */
public abstract class AbstractTypeScriptGenerator extends AbstractFileGenerator {

	@Override
	protected void docComment(String comment) {
		if (comment != null && !comment.isEmpty()) {
			line("/**");
			for (String line : comment.split("\n")) {
				line(" *" + (line.isEmpty() ? "" : " " + line));
			}
			line(" */");
		}
	}

}
