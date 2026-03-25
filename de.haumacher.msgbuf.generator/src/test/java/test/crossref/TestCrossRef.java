package test.crossref;

import java.io.IOException;

import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.crossref.composite.DeliveryOrder;
import test.crossref.composite.Item;
import test.crossref.composite.Person;
import test.crossref.shared.Address;
import test.crossref.shared.Coordinate;

/**
 * Tests cross-file message embedding: composite protocol references types from shared protocol.
 */
@SuppressWarnings("javadoc")
public class TestCrossRef extends TestCase {

	public void testPersonWithAddress() throws IOException {
		Person person = Person.create()
			.setName("Alice")
			.setAddress(Address.create()
				.setStreet("Main St 1")
				.setCity("Springfield")
				.setZip("12345"))
			.setLocation(Coordinate.create()
				.setLat(48.137154)
				.setLon(11.576124));

		String json = person.toString();

		// Deserialize and verify
		Person copy = Person.readPerson(new JsonReader(new StringR(json)));
		assertEquals("Alice", copy.getName());
		assertTrue(copy.hasAddress());
		assertEquals("Main St 1", copy.getAddress().getStreet());
		assertEquals("Springfield", copy.getAddress().getCity());
		assertEquals("12345", copy.getAddress().getZip());
		assertTrue(copy.hasLocation());
		assertEquals(48.137154, copy.getLocation().getLat(), 0.0001);
		assertEquals(11.576124, copy.getLocation().getLon(), 0.0001);
	}

	public void testDeliveryOrderWithSharedAddresses() throws IOException {
		DeliveryOrder order = DeliveryOrder.create()
			.setOrderId("ORD-42")
			.setSender(Address.create()
				.setStreet("Warehouse Ave 10")
				.setCity("Munich")
				.setZip("80331"))
			.setRecipient(Address.create()
				.setStreet("Elm St 5")
				.setCity("Berlin")
				.setZip("10115"));
		order.addItem(Item.create().setProductName("Widget").setQuantity(3));
		order.addItem(Item.create().setProductName("Gadget").setQuantity(1));

		String json = order.toString();

		// Deserialize and verify
		DeliveryOrder copy = DeliveryOrder.readDeliveryOrder(new JsonReader(new StringR(json)));
		assertEquals("ORD-42", copy.getOrderId());

		// Sender from shared protocol
		assertTrue(copy.hasSender());
		assertEquals("Warehouse Ave 10", copy.getSender().getStreet());
		assertEquals("Munich", copy.getSender().getCity());

		// Recipient from shared protocol
		assertTrue(copy.hasRecipient());
		assertEquals("Elm St 5", copy.getRecipient().getStreet());
		assertEquals("Berlin", copy.getRecipient().getCity());

		// Items from composite protocol
		assertEquals(2, copy.getItems().size());
		assertEquals("Widget", copy.getItems().get(0).getProductName());
		assertEquals(3, copy.getItems().get(0).getQuantity());
		assertEquals("Gadget", copy.getItems().get(1).getProductName());
	}

	public void testNullEmbeddedField() throws IOException {
		Person person = Person.create().setName("Bob");

		String json = person.toString();
		Person copy = Person.readPerson(new JsonReader(new StringR(json)));
		assertEquals("Bob", copy.getName());
		assertFalse(copy.hasAddress());
		assertNull(copy.getAddress());
		assertFalse(copy.hasLocation());
		assertNull(copy.getLocation());
	}

	public void testSharedTypeIndependentRoundTrip() throws IOException {
		// Shared types can also be used standalone
		Address addr = Address.create()
			.setStreet("Solo St 99")
			.setCity("Hamburg")
			.setZip("20095");

		String json = addr.toString();
		Address copy = Address.readAddress(new JsonReader(new StringR(json)));
		assertEquals("Solo St 99", copy.getStreet());
		assertEquals("Hamburg", copy.getCity());
		assertEquals("20095", copy.getZip());
	}
}
