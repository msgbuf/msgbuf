package test.jsonbinary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import de.haumacher.msgbuf.binary.OctetDataReader;
import de.haumacher.msgbuf.binary.OctetDataWriter;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.jsonbinary.data.BinaryPatchEvent;

/**
 * Tests for the {@code json} field type with Binary serialization via JsonValue envelope.
 */
@SuppressWarnings("javadoc")
public class TestJsonBinary extends TestCase {

	public void testBinaryRoundtripObject() throws IOException {
		Map<String, Object> patch = new LinkedHashMap<>();
		Map<String, Object> nodes = new LinkedHashMap<>();
		Map<String, Object> n1 = new LinkedHashMap<>();
		n1.put("x", Long.valueOf(100));
		n1.put("y", Long.valueOf(200));
		nodes.put("n1", n1);
		patch.put("nodes", nodes);

		BinaryPatchEvent event = BinaryPatchEvent.create()
			.setControlId("c1")
			.setPatch(patch);

		BinaryPatchEvent copy = binaryRoundtrip(event);
		assertEquals("c1", copy.getControlId());
		assertTrue(copy.hasPatch());
		assertTrue(copy.getPatch() instanceof Map);

		@SuppressWarnings("unchecked")
		Map<String, Object> patchCopy = (Map<String, Object>) copy.getPatch();
		@SuppressWarnings("unchecked")
		Map<String, Object> n1Copy = (Map<String, Object>) ((Map<String, Object>) patchCopy.get("nodes")).get("n1");
		assertEquals(Long.valueOf(100), n1Copy.get("x"));
		assertEquals(Long.valueOf(200), n1Copy.get("y"));
	}

	public void testBinaryRoundtripArray() throws IOException {
		List<Object> patch = Arrays.asList("add", "/path", Long.valueOf(42));

		BinaryPatchEvent event = BinaryPatchEvent.create()
			.setControlId("c2")
			.setPatch(patch);

		BinaryPatchEvent copy = binaryRoundtrip(event);
		assertTrue(copy.getPatch() instanceof List);

		@SuppressWarnings("unchecked")
		List<Object> patchCopy = (List<Object>) copy.getPatch();
		assertEquals("add", patchCopy.get(0));
		assertEquals("/path", patchCopy.get(1));
		assertEquals(Long.valueOf(42), patchCopy.get(2));
	}

	public void testBinaryRoundtripPrimitives() throws IOException {
		// String
		BinaryPatchEvent strEvent = BinaryPatchEvent.create().setControlId("s").setPatch("hello");
		BinaryPatchEvent strCopy = binaryRoundtrip(strEvent);
		assertEquals("hello", strCopy.getPatch());

		// Number (double)
		BinaryPatchEvent dblEvent = BinaryPatchEvent.create().setControlId("d").setPatch(Double.valueOf(3.14));
		BinaryPatchEvent dblCopy = binaryRoundtrip(dblEvent);
		assertEquals(3.14, ((Number) dblCopy.getPatch()).doubleValue(), 0.001);

		// Number (long)
		BinaryPatchEvent longEvent = BinaryPatchEvent.create().setControlId("l").setPatch(Long.valueOf(42));
		BinaryPatchEvent longCopy = binaryRoundtrip(longEvent);
		assertEquals(Long.valueOf(42), longCopy.getPatch());

		// Boolean
		BinaryPatchEvent boolEvent = BinaryPatchEvent.create().setControlId("b").setPatch(Boolean.TRUE);
		BinaryPatchEvent boolCopy = binaryRoundtrip(boolEvent);
		assertEquals(Boolean.TRUE, boolCopy.getPatch());
	}

	public void testBinaryRoundtripNull() throws IOException {
		BinaryPatchEvent event = BinaryPatchEvent.create().setControlId("n");
		// patch is null by default
		assertFalse(event.hasPatch());

		BinaryPatchEvent copy = binaryRoundtrip(event);
		assertEquals("n", copy.getControlId());
		assertFalse(copy.hasPatch());
		assertNull(copy.getPatch());
	}

	public void testJsonRoundtripStillWorks() throws IOException {
		Map<String, Object> patch = new LinkedHashMap<>();
		patch.put("key", "value");

		BinaryPatchEvent event = BinaryPatchEvent.create()
			.setControlId("json-test")
			.setPatch(patch);

		String json = event.toString();
		// Should be native JSON, not string-wrapped
		assertTrue(json.contains("\"patch\":{"));

		BinaryPatchEvent copy = BinaryPatchEvent.readBinaryPatchEvent(new JsonReader(new StringR(json)));
		assertEquals("json-test", copy.getControlId());
		@SuppressWarnings("unchecked")
		Map<String, Object> patchCopy = (Map<String, Object>) copy.getPatch();
		assertEquals("value", patchCopy.get("key"));
	}

	private BinaryPatchEvent binaryRoundtrip(BinaryPatchEvent event) throws IOException {
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		event.writeTo(new OctetDataWriter(buffer));
		return BinaryPatchEvent.readBinaryPatchEvent(new OctetDataReader(new ByteArrayInputStream(buffer.toByteArray())));
	}
}
