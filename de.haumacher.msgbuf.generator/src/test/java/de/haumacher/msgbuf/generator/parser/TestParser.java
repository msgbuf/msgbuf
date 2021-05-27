/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.parser;

import java.io.File;

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
		Generator generator = new Generator();
		generator.setOut(testDir());
		generator.load(_proto);
		generator.generate();
	}

	private static File testDir() {
		return new File("test");
	}
	
	public static Test suite() {
		TestSuite result = new TestSuite();
		File fixturesDir = new File(testDir(), "test");
		for (File testPkg : fixturesDir.listFiles(f -> f.isDirectory())) {
			File[] testFiles = testPkg.listFiles(f -> f.getName().endsWith(".proto"));
			for (File proto : testFiles) {
				result.addTest(new TestParser(proto));
			}
		}
		return result;
	}

}
