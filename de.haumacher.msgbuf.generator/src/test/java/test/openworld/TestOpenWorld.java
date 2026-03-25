package test.openworld;

import java.io.IOException;

import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.openworld.base.SSEEvent;
import test.openworld.base.TextEvent;
import test.openworld.ext1.GraphPatchEvent;
import test.openworld.ext2.AnalyticsPatchEvent;

/**
 * Test case for OpenWorld extensible type hierarchies.
 */
@SuppressWarnings("javadoc")
public class TestOpenWorld extends TestCase {

	public void testBaseTypeRoundTrip() throws IOException {
		TextEvent event = TextEvent.create().setText("hello").setTimestamp(12345);
		String json = event.toString();
		SSEEvent copy = readEvent(json);
		assertTrue(copy instanceof TextEvent);
		assertEquals("hello", ((TextEvent) copy).getText());
		assertEquals(12345, copy.getTimestamp());
	}

	public void testExtensionRegistration() throws IOException {
		GraphPatchEvent event = GraphPatchEvent.create()
			.setControlId("c1")
			.setPatch("{\"x\":1}")
			.setTimestamp(100);
		String json = event.toString();
		SSEEvent copy = readEvent(json);
		assertTrue("Expected GraphPatchEvent, got: " + (copy == null ? "null" : copy.getClass().getName()),
			copy instanceof GraphPatchEvent);
		assertEquals("c1", ((GraphPatchEvent) copy).getControlId());
		assertEquals("{\"x\":1}", ((GraphPatchEvent) copy).getPatch());
		assertEquals(100, copy.getTimestamp());
	}

	public void testMultipleExtensions() throws IOException {
		GraphPatchEvent graph = GraphPatchEvent.create().setControlId("c1").setTimestamp(1);
		AnalyticsPatchEvent analytics = AnalyticsPatchEvent.create()
			.setMetricName("cpu")
			.setMetricValue(0.95)
			.setTimestamp(2);

		SSEEvent graphCopy = readEvent(graph.toString());
		SSEEvent analyticsCopy = readEvent(analytics.toString());

		assertTrue(graphCopy instanceof GraphPatchEvent);
		assertTrue(analyticsCopy instanceof AnalyticsPatchEvent);
		assertEquals("cpu", ((AnalyticsPatchEvent) analyticsCopy).getMetricName());
		assertEquals(0.95, ((AnalyticsPatchEvent) analyticsCopy).getMetricValue(), 0.001);
	}

	public void testVisitorDefault() {
		GraphPatchEvent event = GraphPatchEvent.create().setControlId("c1");
		final boolean[] defaultCalled = {false};

		event.visit(new SSEEvent.Visitor<Void, Void, RuntimeException>() {
			@Override
			public Void visit(TextEvent self, Void arg) {
				fail("Should not visit TextEvent");
				return null;
			}

			@Override
			public Void visitDefault(SSEEvent self, Void arg) {
				defaultCalled[0] = true;
				assertTrue(self instanceof GraphPatchEvent);
				return null;
			}
		}, null);

		assertTrue("visitDefault should have been called", defaultCalled[0]);
	}

	public void testExtendedVisitor() {
		GraphPatchEvent event = GraphPatchEvent.create().setControlId("c1");
		final String[] result = {null};

		SSEEvent.Visitor<Void, Void, RuntimeException> visitor =
			new GraphPatchEvent.Visitor<Void, Void, RuntimeException>() {
				@Override
				public Void visit(TextEvent self, Void arg) {
					result[0] = "text";
					return null;
				}

				@Override
				public Void visit(GraphPatchEvent self, Void arg) {
					result[0] = self.getControlId();
					return null;
				}

				@Override
				public Void visitDefault(SSEEvent self, Void arg) {
					result[0] = "default";
					return null;
				}
			};

		event.visit(visitor, null);
		assertEquals("c1", result[0]);
	}

	public void testUnknownType() throws IOException {
		String json = "[\"CompletelyUnknown\", {}]";
		SSEEvent result = readEvent(json);
		assertNull(result);
	}

	private SSEEvent readEvent(String json) throws IOException {
		return SSEEvent.readSSEEvent(new JsonReader(new StringR(json)));
	}
}
