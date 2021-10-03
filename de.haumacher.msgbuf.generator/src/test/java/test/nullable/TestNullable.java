/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.nullable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;

import de.haumacher.msgbuf.binary.OctetDataReader;
import de.haumacher.msgbuf.binary.OctetDataWriter;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.nullable.data.Decision;
import test.nullable.data.NullableValues;

/**
 * Test case for {@link NullableValues}.
 *
 * @author <a href="mailto:haui@haumacher.de">Bernhard Haumacher</a>
 */
public class TestNullable extends TestCase {

	public void testCreate() throws IOException {
		NullableValues values = NullableValues.create();
		check(values);
		
		check(writeAndReadBackJson(values));
		check(writeAndReadBackBinary(values));
		
		values.addIntList(42);
		values.addStringList("foo");
		values.putStringIntMap("hello", 10);
		values.setOptionalDecision(Decision.YES);

		assertTrue(values.hasIntList());
		assertTrue(values.hasStringList());
		assertTrue(values.hasStringIntMap());
		assertTrue(values.hasOptionalDecision());
	}

	public void testSetCollection() throws IOException {
		NullableValues values = NullableValues.create();
		
		values.setIntList(Collections.emptyList());
		values.setStringList(Collections.emptyList());
		values.setStringIntMap(Collections.emptyMap());
		
		assertTrue(values.hasIntList());
		assertTrue(values.hasStringList());
		assertTrue(values.hasStringIntMap());
		
		values.addIntList(42);
		values.addStringList("foo");
		values.putStringIntMap("hello", 10);
	}
	
	private void check(NullableValues values) {
		assertFalse(values.hasBoolean());
		assertFalse(values.hasInt());
		assertFalse(values.hasLong());
		assertFalse(values.hasString());
		assertFalse(values.hasIntList());
		assertFalse(values.hasStringList());
		assertFalse(values.hasStringIntMap());
		assertFalse(values.hasOptionalDecision());
		
		assertNull(values.getBoolean());
		assertNull(values.getInt());
		assertNull(values.getLong());
		assertNull(values.getString());
		assertNull(values.getIntList());
		assertNull(values.getStringList());
		assertNull(values.getStringIntMap());
		assertNull(values.getOptionalDecision());
	}
	
	private NullableValues writeAndReadBackJson(NullableValues shape) throws IOException {
		String data = shape.toString();
		return NullableValues.readNullableValues(new JsonReader(new StringR(data)));
	}
	
	private NullableValues writeAndReadBackBinary(NullableValues shape) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		shape.writeTo(new OctetDataWriter(buffer));
		return NullableValues.readNullableValues(new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray())));
	}
	
}
