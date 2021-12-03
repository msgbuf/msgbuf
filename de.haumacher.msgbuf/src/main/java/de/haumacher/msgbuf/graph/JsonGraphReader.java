/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import de.haumacher.msgbuf.io.Reader;
import de.haumacher.msgbuf.json.JsonReader;

/**
 * {@link JsonReader} that is able to read object graphs with cross references.
 */
public class JsonGraphReader extends JsonReader implements ScopeMixin {

	private final Map<Object, Consumer<?>> _references = new HashMap<>();
	
	private final Map<Object, Object> _index = new HashMap<>();

	/** 
	 * Creates a {@link JsonGraphReader}.
	 */
	public JsonGraphReader(Reader in) {
		super(in);
	}

	@Override
	public Map<Object, Object> index() {
		return _index;
	}

	@Override
	public Map<Object, Consumer<?>> references() {
		return _references;
	}
	
	@Override
	public void close() throws IOException {
		super.close();
		finish();
	}

}
