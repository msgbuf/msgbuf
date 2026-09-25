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
 * Test case for rejecting extensions across files whose options generate incompatible code
 * (issues #37, #38, #40, #41).
 */
@SuppressWarnings("javadoc")
public class TestExtensionOptions extends TestCase {

	private static final File FIXTURES = new File("src/test/resources/reject/options");

	/** Formats, visitors, type kinds must agree; listener support must not be added (#37, #40). */
	public void testMismatchingOptions() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/opt/ext/mismatch.proto: Message 'reject.opt.ext.Ping' extends message 'reject.opt.base.Event' of 'reject/opt/base/events.proto', which is generated with JSON serialization, but 'reject/opt/ext/mismatch.proto' is generated without (option NoJson). Use the same format options in both files.",
			"reject/opt/ext/mismatch.proto: Message 'reject.opt.ext.Ping' extends message 'reject.opt.base.Event' of 'reject/opt/base/events.proto', but only 'reject/opt/ext/mismatch.proto' declares option NoVisitor, 'reject/opt/base/events.proto' does not. Use the same setting in both files.",
			"reject/opt/ext/mismatch.proto: Message 'reject.opt.ext.Ping' extends message 'reject.opt.base.Event' of 'reject/opt/base/events.proto', but only 'reject/opt/ext/mismatch.proto' declares option NoTypeKind, 'reject/opt/base/events.proto' does not. Use the same setting in both files.",
			"reject/opt/ext/mismatch.proto: Message 'reject.opt.ext.Loud' extends message 'reject.opt.base.Quiet' of 'reject/opt/base/quiet.proto', which is generated with JSON serialization, but 'reject/opt/ext/mismatch.proto' is generated without (option NoJson). Use the same format options in both files.",
			"reject/opt/ext/mismatch.proto: Message 'reject.opt.ext.Loud' extends message 'reject.opt.base.Quiet' of 'reject/opt/base/quiet.proto', but only 'reject/opt/ext/mismatch.proto' declares option NoVisitor, 'reject/opt/base/quiet.proto' does not. Use the same setting in both files.",
			"reject/opt/ext/mismatch.proto: Message 'reject.opt.ext.Loud' extends message 'reject.opt.base.Quiet' of 'reject/opt/base/quiet.proto', but only 'reject/opt/ext/mismatch.proto' declares option NoTypeKind, 'reject/opt/base/quiet.proto' does not. Use the same setting in both files.",
			"reject/opt/ext/mismatch.proto: Message 'reject.opt.ext.Loud' extends message 'reject.opt.base.Quiet' of 'reject/opt/base/quiet.proto', which is generated without listener support (option NoListener), but 'reject/opt/ext/mismatch.proto' is generated with it. Add 'option NoListener;' to 'reject/opt/ext/mismatch.proto', or remove it from 'reject/opt/base/quiet.proto'."),
			reject("ext/mismatch.proto"));
	}

	/** OpenWorld on an intermediate requires OpenWorld on the root (#38). */
	public void testOpenWorldIntermediateOfClosedRoot() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/opt/split/mid.proto: File declares option OpenWorld, but message 'reject.opt.split.Mid' belongs to the hierarchy of 'reject.opt.split.Root' of 'reject/opt/split/root.proto', which does not declare option OpenWorld. Add 'option OpenWorld;' to 'reject/opt/split/root.proto', or remove it from 'reject/opt/split/mid.proto'."),
			reject("split/root.proto", "split/mid.proto"));
	}

	/** OpenWorld cannot be combined with NoInterfaces or SharedGraph (#41). */
	public void testOpenWorldCombinations() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/opt/graph/graph.proto: option OpenWorld cannot be combined with option NoInterfaces. Remove one of the options.",
			"reject/opt/graph/graph.proto: option OpenWorld cannot be combined with option SharedGraph. Remove one of the options."),
			reject("graph.proto"));
	}

	private List<String> reject(String... protos) throws IOException, ParseException {
		File target = new File("target");
		target.mkdirs();
		File out = Files.createTempDirectory(target.toPath(), getName()).toFile();
		Generator generator = new Generator();
		generator.setOut(out);
		for (String proto : protos) {
			generator.load(new File(FIXTURES, proto));
		}
		try {
			generator.generate(new XmlStreamingPlugin());
			fail("Expected rejection of " + Arrays.toString(protos) + ".");
			return null;
		} catch (GeneratorException ex) {
			String[] written = out.list();
			assertTrue("No code must be generated for rejected definitions.", written == null || written.length == 0);
			return ex.getErrors();
		}
	}

}
