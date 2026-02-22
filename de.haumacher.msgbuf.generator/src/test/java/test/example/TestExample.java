/*
 * Copyright (c) 2024 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.example;

import java.io.IOException;

import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.example.data.LoginRequest;
import test.example.data.LogoutRequest;
import test.example.data.QueryRequest;
import test.example.data.Request;

/**
 * Test case for the messaging example demonstrating the visitor pattern for type-safe request dispatch.
 */
@SuppressWarnings("javadoc")
public class TestExample extends TestCase {

	public void testVisitorDispatch() {
		Request.Visitor<String, Void, RuntimeException> describer = new Request.Visitor<String, Void, RuntimeException>() {
			@Override
			public String visit(LoginRequest self, Void arg) {
				return "login:" + self.getUsername();
			}

			@Override
			public String visit(QueryRequest self, Void arg) {
				return "query:" + self.getQuery();
			}

			@Override
			public String visit(LogoutRequest self, Void arg) {
				return "logout:" + self.getSessionId();
			}
		};

		assertEquals("login:alice",
			LoginRequest.create().setUsername("alice").setPassword("secret").visit(describer, null));

		assertEquals("query:SELECT *",
			QueryRequest.create().setQuery("SELECT *").setLimit(10).visit(describer, null));

		assertEquals("logout:sess-42",
			LogoutRequest.create().setSessionId("sess-42").visit(describer, null));
	}

	public void testJsonRoundTrip() throws IOException {
		LoginRequest original = LoginRequest.create()
			.setSessionId("s1")
			.setUsername("bob")
			.setPassword("pass123");

		String json = original.toString();
		Request result = Request.readRequest(new JsonReader(new StringR(json)));

		assertTrue(result instanceof LoginRequest);
		LoginRequest copy = (LoginRequest) result;
		assertEquals(original.getSessionId(), copy.getSessionId());
		assertEquals(original.getUsername(), copy.getUsername());
		assertEquals(original.getPassword(), copy.getPassword());
	}

	public void testPolymorphicJsonRoundTrip() throws IOException {
		Request original = LoginRequest.create()
			.setSessionId("s2")
			.setUsername("carol")
			.setPassword("pw");

		String json = original.toString();
		Request copy = Request.readRequest(new JsonReader(new StringR(json)));

		assertNotNull(copy);
		assertTrue(copy instanceof LoginRequest);
		LoginRequest loginCopy = (LoginRequest) copy;
		assertEquals("s2", loginCopy.getSessionId());
		assertEquals("carol", loginCopy.getUsername());
		assertEquals("pw", loginCopy.getPassword());
	}

	public void testPolymorphicJsonRoundTripQuery() throws IOException {
		Request original = QueryRequest.create()
			.setSessionId("s3")
			.setQuery("find users")
			.setLimit(25);

		String json = original.toString();
		Request copy = Request.readRequest(new JsonReader(new StringR(json)));

		assertNotNull(copy);
		assertTrue(copy instanceof QueryRequest);
		QueryRequest queryCopy = (QueryRequest) copy;
		assertEquals("s3", queryCopy.getSessionId());
		assertEquals("find users", queryCopy.getQuery());
		assertEquals(25, queryCopy.getLimit());
	}

	public void testPolymorphicJsonRoundTripLogout() throws IOException {
		Request original = LogoutRequest.create()
			.setSessionId("s4");

		String json = original.toString();
		Request copy = Request.readRequest(new JsonReader(new StringR(json)));

		assertNotNull(copy);
		assertTrue(copy instanceof LogoutRequest);
		assertEquals("s4", copy.getSessionId());
	}

}
