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
 * Test case for rejecting fields that redeclare inherited fields or whose generated names clash
 * (issue #21).
 */
@SuppressWarnings("javadoc")
public class TestFieldNames extends TestCase {

	private static final File FIXTURES = new File("src/test/resources/reject/fields");

	/** The definition from the issue report. */
	public void testRedeclare() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"test/redeclare/redeclare.proto: Field 'test.redeclare.B.value' redeclares the field inherited from"
				+ " 'test.redeclare.A' of 'test/redeclare/redeclare.proto'. A sub-message cannot redeclare an inherited"
				+ " field (not even to narrow its type). Remove the declaration or rename the field."),
			reject("redeclare.proto"));
	}

	public void testHierarchy() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/fields/hierarchy.proto: Field 'reject.fields.Outer.label' is declared twice. Rename or remove one of"
				+ " the declarations.",
			"reject/fields/hierarchy.proto: Field 'reject.fields.Outer.Leaf.name' redeclares the field inherited from"
				+ " 'reject.fields.Root' of 'reject/fields/hierarchy.proto'. A sub-message cannot redeclare an inherited"
				+ " field (not even to narrow its type). Remove the declaration or rename the field.",
			"reject/fields/hierarchy.proto: Field 'reject.fields.Outer.Other.foo_bar' clashes with field 'fooBar'"
				+ " inherited from 'reject.fields.Root' of 'reject/fields/hierarchy.proto': both generate the same Java"
				+ " names ('getFooBar()', 'FOO_BAR__PROP'). Rename the field."),
			reject("hierarchy.proto"));
	}

	public void testCrossFile() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/fields/ext/extension.proto: Field 'reject.fields.ext.Ping.source' redeclares the field inherited"
				+ " from 'reject.fields.Event' of 'reject/fields/base.proto'. A sub-message cannot redeclare an"
				+ " inherited field (not even to narrow its type). Remove the declaration or rename the field."),
			reject("extension.proto"));
	}

	private List<String> reject(String proto) throws IOException, ParseException {
		File target = new File("target");
		target.mkdirs();
		File out = Files.createTempDirectory(target.toPath(), getName()).toFile();
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

}
