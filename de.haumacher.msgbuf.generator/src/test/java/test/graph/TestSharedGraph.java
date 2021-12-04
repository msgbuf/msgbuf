/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.graph;

import java.io.IOException;

import de.haumacher.msgbuf.graph.GraphObserver;
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

	/**
	 * Test for synchronizing two object graphs via patch transmissions.
	 */
	public void testUpdate() throws IOException {
		GraphObserver server = new GraphObserver();

		Group serverGroup = Group.create();
		serverGroup.registerListener(server);
		
		StringW dataMessage = new StringW();
		serverGroup.writeTo(server, new JsonWriter(dataMessage));

		GraphObserver client = new GraphObserver();
		
		Group clientGroup = (Group) Shape.readShape(client, new JsonReader(new StringR(dataMessage.toString())));

		// Modify server graph.
		serverGroup.addShape(Circle.create().setRadius(5).setXCoordinate(10).setYCoordinate(20));
		
		// Transmit patch to client.
		syncGraph(server, client);
		
		assertEquals(1, clientGroup.getShapes().size());
		assertEquals(5, ((Circle) clientGroup.getShapes().get(0)).getRadius());
		assertEquals(10, ((Circle) clientGroup.getShapes().get(0)).getXCoordinate());
		assertEquals(20, ((Circle) clientGroup.getShapes().get(0)).getYCoordinate());
		
		// Again modify the server graph.
		serverGroup.addShape(Car.create().setBody(Rectangle.create().setWidth(10).setHeight(20)).setXCoordinate(20).setYCoordinate(30));
		serverGroup.getShapes().get(0).setXCoordinate(11).setYCoordinate(22);
		
		// Transmit patch to client.
		syncGraph(server, client);
		
		assertEquals(2, clientGroup.getShapes().size());
		assertNotNull(((Car) clientGroup.getShapes().get(1)).getBody());
		assertEquals(11, ((Circle) clientGroup.getShapes().get(0)).getXCoordinate());
		assertEquals(22, ((Circle) clientGroup.getShapes().get(0)).getYCoordinate());
	}

	private void syncGraph(GraphObserver server, GraphObserver client) throws IOException {
		StringW patchMessage = new StringW();
		server.writeChanges(new JsonWriter(patchMessage));
		client.readChanges(new JsonReader(new StringR(patchMessage.toString())));
	}
	
}
