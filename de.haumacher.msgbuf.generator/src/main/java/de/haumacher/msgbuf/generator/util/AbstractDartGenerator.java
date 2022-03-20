/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.util;

/**
 * Base class for generators creating Java code.
 */
public abstract class AbstractDartGenerator extends AbstractFileGenerator {

	@Override
	protected void docComment(String comment) {
		if (!comment.isEmpty()) {
			for (String line : comment.split("\n")) {
				line("/// " + (line.isEmpty() ? "" : " " + line));
			}
		}
	}

}
