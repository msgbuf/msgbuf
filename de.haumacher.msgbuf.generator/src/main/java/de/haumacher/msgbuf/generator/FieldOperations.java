/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.Option;

/**
 * Mix-in interface for {@link Field} providing operations.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public interface FieldOperations {

	/**
	 * Annotations to this definition.
	 */
	java.util.Map<String, Option<?>> getOptions();
	

	/** Whether this field cannot be set by the application */
	default boolean isDerived() {
		return getOptions().get("Reverse") != null || getOptions().get("Container") != null;
	} 

}
