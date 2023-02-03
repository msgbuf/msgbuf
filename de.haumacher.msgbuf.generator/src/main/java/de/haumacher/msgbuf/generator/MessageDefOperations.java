/*
 * Copyright (c) 2023 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MessageDef;

/**
 * Mix-in interface for {@link MessageDef}.
 * 
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public interface MessageDefOperations {

	MessageDef self();
	
	default Field container() {
		Field local = self().getFields().stream().filter(Field::isContainer).findAny().orElse(null);
		if (local != null) {
			return local;
		}

		MessageDef generalization = self().getExtendedDef();
		if (generalization == null) {
			return null;
		}
		
		return generalization.container();
	}
	
}
