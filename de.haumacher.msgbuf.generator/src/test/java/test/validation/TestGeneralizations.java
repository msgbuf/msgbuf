/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.validation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import de.haumacher.msgbuf.generator.Generator;
import de.haumacher.msgbuf.generator.GeneratorException;
import de.haumacher.msgbuf.generator.parser.ParseException;
import de.haumacher.msgbuf.generator.plugins.XmlStreamingPlugin;
import junit.framework.TestCase;

/**
 * Test case for rejecting extensions of messages of other files that are inconsistent with
 * <code>option OpenWorld</code> (issue #25), and inheritance cycles.
 */
@SuppressWarnings("javadoc")
public class TestGeneralizations extends TestCase {

	private static final File FIXTURES = new File("src/test/resources/reject/openworld");

	private static final String HINT = " to extend its messages in other files (a hierarchy without OpenWorld can only"
		+ " be split into files of the same package that are generated together).";

	public void testOtherPackage() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/ow/ext/other-package.proto: Message 'reject.ow.ext.Circle' extends message 'reject.ow.base.Shape' of"
				+ " 'reject/ow/base/closed.proto', which does not declare option OpenWorld. Add 'option OpenWorld;' to"
				+ " 'reject/ow/base/closed.proto'" + HINT,
			"reject/ow/ext/other-package.proto: Message 'reject.ow.ext.Holder.Nested' extends message"
				+ " 'reject.ow.base.Shape' of 'reject/ow/base/closed.proto', which does not declare option OpenWorld."
				+ " Add 'option OpenWorld;' to 'reject/ow/base/closed.proto'" + HINT),
			reject("ext/other-package.proto"));
	}

	/** The base file is only imported, its readers were generated without the specialization. */
	public void testSamePackageImported() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/ow/base/same-package.proto: Message 'reject.ow.base.Square' extends message 'reject.ow.base.Shape'"
				+ " of 'reject/ow/base/closed.proto', which does not declare option OpenWorld. Add 'option OpenWorld;'"
				+ " to 'reject/ow/base/closed.proto'" + HINT),
			reject("base/same-package.proto"));
	}

	/** A closed hierarchy split into files of the same package that are generated together. */
	public void testSamePackageTogether() throws IOException, ParseException {
		File out = newOutputDir();
		Generator generator = new Generator();
		generator.setOut(out);
		generator.load(new File(FIXTURES, "base/closed.proto"));
		generator.load(new File(FIXTURES, "base/same-package.proto"));
		generator.generate(new XmlStreamingPlugin());
		assertTrue(new File(out, "reject/ow/base/Square.java").isFile());
	}

	/** Extending an intermediate requires OpenWorld in the intermediate's file, not only in the root's. */
	public void testIntermediateWithoutOpenWorld() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/ow/ext/leaf.proto: Message 'reject.ow.ext.Beep' extends message 'reject.ow.mid.Signal' of"
				+ " 'reject/ow/mid/mid.proto', which does not declare option OpenWorld. Add 'option OpenWorld;' to"
				+ " 'reject/ow/mid/mid.proto'" + HINT),
			reject("ext/leaf.proto"));
	}

	public void testCycle() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/ow/cycle.proto: Message 'reject.ow.A' is part of an inheritance cycle: reject.ow.A extends"
				+ " reject.ow.B extends reject.ow.A. Remove one of the extends clauses.",
			"reject/ow/cycle.proto: Message 'reject.ow.B' is part of an inheritance cycle: reject.ow.B extends"
				+ " reject.ow.A extends reject.ow.B. Remove one of the extends clauses."),
			reject("cycle.proto"));
	}

	private List<String> reject(String proto) throws IOException, ParseException {
		File out = newOutputDir();
		Generator generator = new Generator();
		generator.setOut(out);
		generator.load(new File(FIXTURES, proto));
		try {
			generator.generate(new XmlStreamingPlugin());
			fail("Expected rejection of '" + proto + "'.");
			return null;
		} catch (GeneratorException ex) {
			String[] written = out.list();
			assertTrue("No code must be generated for rejected definitions.", written == null || written.length == 0);
			return ex.getErrors();
		}
	}

	private File newOutputDir() throws IOException {
		File target = new File("target");
		target.mkdirs();
		return Files.createTempDirectory(target.toPath(), getName()).toFile();
	}

}
