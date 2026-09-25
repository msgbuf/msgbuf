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
 * Test case for rejecting references to definitions of other files that are generated without a
 * serialization format the referencing file needs (issue #20).
 */
@SuppressWarnings("javadoc")
public class TestFormatReferences extends TestCase {

	private static final File FIXTURES = new File("src/test/resources/reject/formats");

	public void testRejectMissingBinary() throws IOException, ParseException {
		List<String> errors = reject("paint/paint.proto");
		assertEquals(Arrays.asList(
			"reject/formats/paint/paint.proto: Field 'reject.formats.paint.Paint.color' references enum"
				+ " 'reject.formats.colors.Color' of 'reject/formats/colors/colors.proto', which is generated without"
				+ " binary serialization (option NoBinary). Add 'option NoBinary;' to"
				+ " 'reject/formats/paint/paint.proto', or enable binary serialization in"
				+ " 'reject/formats/colors/colors.proto'.",
			"reject/formats/paint/paint.proto: Field 'reject.formats.paint.Paint.shades' references message"
				+ " 'reject.formats.colors.Shade' of 'reject/formats/colors/colors.proto', which is generated without"
				+ " binary serialization (option NoBinary). Add 'option NoBinary;' to"
				+ " 'reject/formats/paint/paint.proto', or enable binary serialization in"
				+ " 'reject/formats/colors/colors.proto'.",
			"reject/formats/paint/paint.proto: Field 'reject.formats.paint.Paint.Layer.colors' references enum"
				+ " 'reject.formats.colors.Color' of 'reject/formats/colors/colors.proto', which is generated without"
				+ " binary serialization (option NoBinary). Add 'option NoBinary;' to"
				+ " 'reject/formats/paint/paint.proto', or enable binary serialization in"
				+ " 'reject/formats/colors/colors.proto'."),
			errors);
	}

	public void testRejectSharedGraphMismatch() throws IOException, ParseException {
		List<String> errors = reject("graph/graph.proto");
		assertEquals(Arrays.asList(
			"reject/formats/graph/graph.proto: Field 'reject.formats.graph.Node.shade' references message"
				+ " 'reject.formats.colors.Shade' of 'reject/formats/colors/colors.proto', but only one of the files"
				+ " uses option SharedGraph. Use option SharedGraph in both files or in neither."),
			errors);
	}

	public void testAcceptMatchingFormats() throws IOException, ParseException {
		File out = newOutputDir();
		generator(out, "paint/paint-nobinary.proto").generate(new XmlStreamingPlugin());
		assertTrue(new File(out, "reject/formats/paint/PaintNoBinary.java").isFile());
	}

	private List<String> reject(String proto) throws IOException, ParseException {
		File out = newOutputDir();
		try {
			generator(out, proto).generate(new XmlStreamingPlugin());
			fail("Expected rejection of '" + proto + "'.");
			return null;
		} catch (GeneratorException ex) {
			String[] written = out.list();
			assertTrue("No code must be generated for rejected definitions.", written == null || written.length == 0);
			return ex.getErrors();
		}
	}

	private static Generator generator(File out, String proto) throws IOException, ParseException {
		Generator generator = new Generator();
		generator.setOut(out);
		generator.load(new File(FIXTURES, proto));
		return generator;
	}

	private File newOutputDir() throws IOException {
		File target = new File("target");
		target.mkdirs();
		return Files.createTempDirectory(target.toPath(), getName()).toFile();
	}

}
