/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.ast.StringOption;
import de.haumacher.msgbuf.generator.ast.Type;

/**
 * Mix-in interface for {@link Field} providing operations.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public interface FieldOperations {

	/** 
	 * The implementation.
	 */
	Field self();

	/** Whether this field cannot be set by the application */
	default boolean isDerived() {
		return isReverse() || isContainer();
	}

	/** 
	 * Whether this is a derived reference pointing to the owner of the object this referenec belongs to.
	 */
	default boolean isContainer() {
		return self().getOptions().get("Container") != null;
	}


	/** 
	 * Whether this is a reverse reference.
	 */
	default boolean isReverse() {
		return getReverseAnnotation() != null;
	} 

	/**
	 * Whether this field is the reverse to the reference with the given name.
	 */
	default boolean isReverseOf(String name) {
		return name.equals(getReverse());
	}

	/**
	 * The name of the inverse reference of this one.
	 * 
	 * @return The name of the reverse reference to this one, or <code>null</code> if no such
	 *         reference exists.
	 */
	default String getReverse() {
		StringOption reverseOption = (StringOption) getReverseAnnotation();
		if (reverseOption == null) {
			return null;
		}
		return reverseOption.getValue();
	}


	/** 
	 * The annotation marking this reference as "reverse".
	 */
	default Option getReverseAnnotation() {
		return self().getOptions().get("Reverse");
	}

	/**
	 * The {@link Field} in this field's type that is marked as {@link #isContainer() container}, or
	 * <code>null</code> if no such field exists.
	 */
	default Field container() {
		if (!isDerived()) {
			Type contentType = self().getType();
			if (contentType instanceof MapType) {
				contentType = ((MapType) contentType).getValueType();
			}
			if (contentType instanceof CustomType) {
				Definition contentDef = ((CustomType) contentType).getDefinition();
				if (contentDef instanceof MessageDef) {
					// Field is a composition reference.
					return ((MessageDef) contentDef).container();
				}
			}
		}
		return null;
	}



}
