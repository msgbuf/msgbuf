/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Rejection of the input definitions: code generation was not started, because the definitions
 * are invalid.
 */
public class GeneratorException extends RuntimeException {

	private final List<String> _errors;

	/**
	 * Creates a {@link GeneratorException}.
	 *
	 * @param errors
	 *        The problems found, each naming the file and the definition concerned.
	 */
	public GeneratorException(List<String> errors) {
		super(String.join("\n", errors));
		_errors = Collections.unmodifiableList(new ArrayList<>(errors));
	}

	/**
	 * The problems found, each naming the file and the definition concerned.
	 */
	public List<String> getErrors() {
		return _errors;
	}

}
