/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.graph;

import java.io.IOException;

import de.haumacher.msgbuf.graph.DefaultScope;
import de.haumacher.msgbuf.graph.Scope;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.io.StringW;
import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.json.JsonWriter;
import junit.framework.TestCase;
import test.graph.data.Car;
import test.graph.data.Circle;
import test.graph.data.Group;
import test.graph.data.Rectangle;
import test.graph.data.Shape;

/**
 * Test case for shared graph synchronization.
 */
public class TestSharedGraph extends TestCase {

	private DefaultScope _server;
	private DefaultScope _client;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		_server = DefaultScope.newServerInstance();
		_client = DefaultScope.newClientInstance();
	}

	/**
	 * Test for synchronizing two object graphs via patch transmissions.
	 */
	public void testUpdate() throws IOException {
		Group serverGroup = Group.create();
		serverGroup.registerListener(_server);
		
		Group clientGroup = transmit(_server, _client, serverGroup);

		// Modify server graph.
		serverGroup.addShape(Circle.create().setRadius(5).setXCoordinate(10).setYCoordinate(20));
		
		// Transmit patch to client.
		syncGraph(_server, _client);
		
		assertEquals(1, clientGroup.getShapes().size());
		assertEquals(5, ((Circle) clientGroup.getShapes().get(0)).getRadius());
		assertEquals(10, ((Circle) clientGroup.getShapes().get(0)).getXCoordinate());
		assertEquals(20, ((Circle) clientGroup.getShapes().get(0)).getYCoordinate());
		
		// Again modify the server graph.
		serverGroup.addShape(Car.create().setBody(Rectangle.create().setWidth(10).setHeight(20)).setXCoordinate(20).setYCoordinate(30));
		serverGroup.getShapes().get(0).setXCoordinate(11).setYCoordinate(22);
		
		// Transmit patch to client.
		syncGraph(_server, _client);
		
		assertEquals(2, clientGroup.getShapes().size());
		assertNotNull(((Car) clientGroup.getShapes().get(1)).getBody());
		assertEquals(11, ((Circle) clientGroup.getShapes().get(0)).getXCoordinate());
		assertEquals(22, ((Circle) clientGroup.getShapes().get(0)).getYCoordinate());
		
		// Modifiy graph on the client and transmit changes back.
		((Car) clientGroup.getShapes().get(1))
			.setWheel1((Circle) Circle.create().setRadius(5).setXCoordinate(25).setYCoordinate(30))
			.setWheel2((Circle) Circle.create().setRadius(5).setXCoordinate(45).setYCoordinate(30))
			.getBody().setWidth(50);
		
		syncGraph(_client, _server);
		
		assertNotNull(((Car) serverGroup.getShapes().get(1)).getWheel1());
		assertNotNull(((Car) serverGroup.getShapes().get(1)).getWheel2());
		assertEquals(50, ((Car) serverGroup.getShapes().get(1)).getBody().getWidth());
	}

	/**
	 * Test that the same object can be referenced multiple times but is only transmitted once.
	 */
	public void testSameTarget() throws IOException {
		Circle sharedServerWheel = (Circle) Circle.create().setRadius(20).setXCoordinate(10).setYCoordinate(10);
		Car serverGroup = Car.create().setWheel1(sharedServerWheel).setWheel2(sharedServerWheel);
		serverGroup.registerListener(_server);
		
		Car clientGroup = transmit(_server, _client, serverGroup);
	
		assertSame(clientGroup.getWheel1(), clientGroup.getWheel2());
	}

	private <S extends Shape> S transmit(Scope server, Scope client, S shape) throws IOException {
		StringW dataMessage = new StringW();
		shape.writeTo(server, new JsonWriter(dataMessage));

		@SuppressWarnings("unchecked")
		S clientShape = (S) Shape.readShape(client, new JsonReader(new StringR(dataMessage.toString())));
		
		return clientShape;
	}
	
	private void syncGraph(DefaultScope source, DefaultScope target) throws IOException {
		StringW patchMessage = new StringW();
		source.createPatch(new JsonWriter(patchMessage));
		target.applyChanges(new JsonReader(new StringR(patchMessage.toString())));
	}
	
}
