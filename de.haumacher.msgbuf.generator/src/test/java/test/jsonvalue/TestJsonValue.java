package test.jsonvalue;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.jsonvalue.data.DynamicConfig;
import test.jsonvalue.data.PatchEvent;

/**
 * Tests for the {@code json} field type.
 */
@SuppressWarnings("javadoc")
public class TestJsonValue extends TestCase {

	public void testObjectPatch() throws IOException {
		Map<String, Object> patch = new LinkedHashMap<>();
		Map<String, Object> nodes = new LinkedHashMap<>();
		Map<String, Object> n1 = new LinkedHashMap<>();
		n1.put("x", Long.valueOf(100));
		n1.put("y", Long.valueOf(200));
		nodes.put("n1", n1);
		patch.put("nodes", nodes);

		PatchEvent event = PatchEvent.create()
			.setControlId("c1")
			.setPatch(patch);

		String json = event.toString();

		// Verify no double-serialization: patch should be a native JSON object, not a string
		assertFalse("Patch should not be string-wrapped", json.contains("\"patch\":\""));
		assertTrue("Patch should be native JSON object", json.contains("\"patch\":{"));

		// Roundtrip
		PatchEvent copy = PatchEvent.readPatchEvent(new JsonReader(new StringR(json)));
		assertEquals("c1", copy.getControlId());
		assertTrue(copy.hasPatch());
		assertTrue(copy.getPatch() instanceof Map);

		@SuppressWarnings("unchecked")
		Map<String, Object> patchCopy = (Map<String, Object>) copy.getPatch();
		assertNotNull(patchCopy.get("nodes"));

		@SuppressWarnings("unchecked")
		Map<String, Object> n1Copy = (Map<String, Object>) ((Map<String, Object>) patchCopy.get("nodes")).get("n1");
		assertEquals(Long.valueOf(100), n1Copy.get("x"));
		assertEquals(Long.valueOf(200), n1Copy.get("y"));
	}

	public void testArrayPatch() throws IOException {
		List<Object> patch = Arrays.asList("add", "/nodes/n2", Long.valueOf(42));

		PatchEvent event = PatchEvent.create()
			.setControlId("c2")
			.setPatch(patch);

		String json = event.toString();
		assertTrue("Patch should be native JSON array", json.contains("\"patch\":["));

		PatchEvent copy = PatchEvent.readPatchEvent(new JsonReader(new StringR(json)));
		assertTrue(copy.getPatch() instanceof List);

		@SuppressWarnings("unchecked")
		List<Object> patchCopy = (List<Object>) copy.getPatch();
		assertEquals("add", patchCopy.get(0));
		assertEquals("/nodes/n2", patchCopy.get(1));
		assertEquals(Long.valueOf(42), patchCopy.get(2));
	}

	public void testPrimitivePatchValues() throws IOException {
		// String value
		PatchEvent strEvent = PatchEvent.create().setControlId("s").setPatch("hello");
		PatchEvent strCopy = roundtrip(strEvent);
		assertEquals("hello", strCopy.getPatch());

		// Number value
		PatchEvent numEvent = PatchEvent.create().setControlId("n").setPatch(Double.valueOf(3.14));
		PatchEvent numCopy = roundtrip(numEvent);
		assertEquals(3.14, ((Number) numCopy.getPatch()).doubleValue(), 0.001);

		// Boolean value
		PatchEvent boolEvent = PatchEvent.create().setControlId("b").setPatch(Boolean.TRUE);
		PatchEvent boolCopy = roundtrip(boolEvent);
		assertEquals(Boolean.TRUE, boolCopy.getPatch());
	}

	public void testNullPatch() throws IOException {
		PatchEvent event = PatchEvent.create().setControlId("c3");
		// patch is null by default
		assertFalse(event.hasPatch());
		assertNull(event.getPatch());

		String json = event.toString();
		// null field should not be written
		assertFalse(json.contains("patch"));

		PatchEvent copy = PatchEvent.readPatchEvent(new JsonReader(new StringR(json)));
		assertEquals("c3", copy.getControlId());
		assertFalse(copy.hasPatch());
		assertNull(copy.getPatch());
	}

	public void testExplicitNullValue() throws IOException {
		// JSON with explicit null value for patch
		String json = "{\"controlId\":\"c4\",\"patch\":null}";
		PatchEvent copy = PatchEvent.readPatchEvent(new JsonReader(new StringR(json)));
		assertEquals("c4", copy.getControlId());
		assertFalse(copy.hasPatch());
		assertNull(copy.getPatch());
	}

	public void testMultipleJsonFields() throws IOException {
		Map<String, Object> config = new LinkedHashMap<>();
		config.put("debug", Boolean.TRUE);
		config.put("maxRetries", Long.valueOf(3));

		Map<String, Object> metadata = new LinkedHashMap<>();
		metadata.put("version", "1.0");
		metadata.put("tags", Arrays.asList("prod", "fast"));

		DynamicConfig dc = DynamicConfig.create()
			.setName("app")
			.setConfig(config)
			.setMetadata(metadata);

		String json = dc.toString();

		DynamicConfig copy = DynamicConfig.readDynamicConfig(new JsonReader(new StringR(json)));
		assertEquals("app", copy.getName());

		@SuppressWarnings("unchecked")
		Map<String, Object> configCopy = (Map<String, Object>) copy.getConfig();
		assertEquals(Boolean.TRUE, configCopy.get("debug"));
		assertEquals(Long.valueOf(3), configCopy.get("maxRetries"));

		@SuppressWarnings("unchecked")
		Map<String, Object> metaCopy = (Map<String, Object>) copy.getMetadata();
		assertEquals("1.0", metaCopy.get("version"));

		@SuppressWarnings("unchecked")
		List<Object> tags = (List<Object>) metaCopy.get("tags");
		assertEquals(2, tags.size());
		assertEquals("prod", tags.get(0));
	}

	private PatchEvent roundtrip(PatchEvent event) throws IOException {
		String json = event.toString();
		return PatchEvent.readPatchEvent(new JsonReader(new StringR(json)));
	}
}
