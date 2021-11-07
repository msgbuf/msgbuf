/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.references;

import java.io.IOException;

import de.haumacher.msgbuf.json.JsonReader;

public interface Loader<T> {

	T load(JsonReader jsonReader) throws IOException;

}
