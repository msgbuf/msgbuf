/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;

import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;
import de.haumacher.msgbuf.observer.Observable;

/**
 * TODO
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public interface SharedGraphNode extends Observable {

	/** 
	 * TODO
	 *
	 * @param arg
	 * @param property
	 * @param element
	 * @throws IOException 
	 */
	void writeElement(Scope scope, JsonWriter arg, String property, Object element) throws IOException;

	/** 
	 * TODO
	 *
	 * @param arg
	 * @param property
	 * @return
	 */
	Object readElement(Scope scope, JsonReader arg, String property) throws IOException;

	/**
	 * Reads the given field from the given input.
	 * 
	 * @param scope
	 *        The shared graph {@link Scope}.
	 * @param in
	 *        The reader to take the value from.
	 * @param field
	 *        The name of the field whose value should be read.
	 */
	void readField(Scope scope, JsonReader in, String field) throws IOException;
	
	void writeFieldValue(Scope scope, JsonWriter in, String field) throws IOException;
	
	void writeTo(Scope scope, JsonWriter out) throws IOException;

	/**
	 * Writes the complete data of this node including type and ID to the given writer.
	 * 
	 * <p>
	 * Note: This method should only be called from a {@link Scope}'s
	 * {@link Scope#writeRefOrData(JsonWriter, SharedGraphNode)} if a fresh ID was assigned.
	 * </p>
	 *
	 * @param scope
	 *        The current {@link Scope} that assigns IDs.
	 * @param out
	 *        The writer to write to.
	 * @param id
	 *        The ID to use for this node.
	 */
	void writeData(Scope scope, JsonWriter out, int id) throws IOException;

	/**
	 * Reads all fields of this instance from the given input.
	 *
	 * @param scope
	 *        The shared graph {@link Scope}.
	 * @param in
	 *        The reader to take the input from.
	 */
	void readFields(Scope scope, JsonReader in) throws IOException;

}
