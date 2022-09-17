/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.parser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import de.haumacher.msgbuf.generator.Generator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test case for {@link ProtobufParser} and {@link Generator}.
 */
@SuppressWarnings("javadoc")
public class TestParser extends TestCase {
	
	private File _proto;

	/** 
	 * Creates a {@link TestParser}.
	 *
	 */
	public TestParser(File proto) {
		_proto = proto;
	}
	
	@Override
	public String getName() {
		return _proto.getName();
	}

	@Override
	protected void runTest() throws Throwable {
		System.out.println("Processing: " + _proto.getName());
		Generator generator = new Generator();
		generator.setOut(testDir());
		generator.load(_proto);
		generator.generate();
	}

	private static File testDir() {
		return new File("src" + File.separator + "test" + File.separator + "java");
	}
	
	public static Test suite() throws IOException {
		TestSuite result = new TestSuite();
		File fixturesDir = new File(testDir(), "test");
		
		Files.walk(fixturesDir.toPath())
			.map(p -> p.toFile())
			.filter(f -> f.isFile())
			.filter(p -> p.getName().endsWith(".proto"))
			.map(f -> new TestParser(f))
			.forEach(t -> result.addTest(t));
		
		return result;
	}

}
