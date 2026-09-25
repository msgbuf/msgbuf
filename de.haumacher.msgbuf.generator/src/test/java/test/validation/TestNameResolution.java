/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package test.validation;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import de.haumacher.msgbuf.generator.Generator;
import de.haumacher.msgbuf.generator.GeneratorException;
import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.common.Util;
import de.haumacher.msgbuf.generator.parser.ParseException;
import de.haumacher.msgbuf.generator.plugins.XmlStreamingPlugin;
import junit.framework.TestCase;

/**
 * Test case for resolving unqualified names in the package of the file using them, and for
 * rejecting ambiguous names and duplicate definitions (issue #46).
 */
@SuppressWarnings("javadoc")
public class TestNameResolution extends TestCase {

	private static final File FIXTURES = new File("src/test/resources/reject/names");

	public void testOwnPackageFirst() throws IOException, ParseException {
		checkOwnPackage("a/a.proto", "b/b.proto");
		checkOwnPackage("b/b.proto", "a/a.proto");
	}

	private void checkOwnPackage(String... protos) throws IOException, ParseException {
		File out = newOutputDir();
		Generator generator = new Generator();
		generator.setOut(out);
		File ts = new File(out, "ts");
		generator.setTypeScriptOut(ts);
		DefinitionFile a = null;
		for (String proto : protos) {
			DefinitionFile file = generator.load(new File(FIXTURES, proto));
			if (proto.startsWith("a/")) {
				a = file;
			}
		}
		generator.generate(new XmlStreamingPlugin());

		MessageDef user = (MessageDef) a.getDefinitions().get(0);
		assertEquals("reject.names.a.Node", Util.protoName(((CustomType) user.getFields().get(0).getType()).getDefinition()));
		MessageDef inner = (MessageDef) user.getDefinitions().get(0);
		assertEquals("reject.names.a.Node", Util.protoName(((CustomType) inner.getFields().get(0).getType()).getDefinition()));
		MessageDef special = (MessageDef) a.getDefinitions().get(3);
		assertEquals("reject.names.a.Node", Util.protoName(special.getExtendedDef()));

		String userJava = read(new File(out, "reject/names/a/User.java"));
		assertTrue(userJava, userJava.contains("reject.names.a.Node getNode()"));
		assertFalse(userJava, userJava.contains("reject.names.b.Node"));

		// A documentation link in a top-level enum.
		String aTs = read(new File(ts, "reject/names/a/a.ts"));
		assertTrue(aTs, aTs.contains("See {@link NodeJson}."));
	}

	public void testAmbiguous() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/names/c/c.proto: The name 'Node' in 'reject.names.c.Use' is ambiguous, it could refer to"
				+ " 'reject.names.a.Node' of 'reject/names/a/a.proto' and 'reject.names.b.Node' of 'reject/names/b/b.proto'."
				+ " Neither package 'reject.names.c' nor the files imported by 'reject/names/c/c.proto' define this name, and"
				+ " the candidates are defined in files that are not imported, but generated together. Use a qualified name,"
				+ " e.g. 'reject.names.a.Node'."),
			reject("a/a.proto", "b/b.proto", "c/c.proto"));
	}

	/**
	 * A name defined in an imported file resolves to its definition, independently of unrelated
	 * files generated in the same run.
	 */
	public void testImportedFirst() throws IOException, ParseException {
		assertEquals("reject.names.imports.a.Node", resolvedType("imports/c/c.proto", "imports/a/a.proto", "imports/b/b.proto", "imports/c/c.proto"));
		assertEquals("reject.names.imports.a.Node", resolvedType("imports/c/c.proto", "imports/c/c.proto", "imports/b/b.proto", "imports/a/a.proto"));
		assertEquals("reject.names.imports.a.Node", resolvedType("imports/c/c.proto", "imports/c/c.proto"));
	}

	/** Definitions of indirectly imported files are found, if no directly imported file defines the name. */
	public void testTransitivelyImported() throws IOException, ParseException {
		assertEquals("reject.names.imports.a.Node", resolvedType("imports/d/d.proto", "imports/b/b.proto", "imports/d/d.proto"));
		assertEquals("reject.names.imports.a.Node", resolvedType("imports/d/d.proto", "imports/d/d.proto", "imports/b/b.proto"));
	}

	public void testAmbiguousImports() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/names/imports/e/e.proto: The name 'Node' in 'reject.names.imports.e.UseE' is ambiguous, it could refer to"
				+ " 'reject.names.imports.a.Node' of 'reject/names/imports/a/a.proto' and 'reject.names.imports.b.Node' of"
				+ " 'reject/names/imports/b/b.proto', which are defined in files imported by 'reject/names/imports/e/e.proto',"
				+ " and package 'reject.names.imports.e' does not define this name. Use a qualified name, e.g."
				+ " 'reject.names.imports.a.Node'."),
			reject("imports/e/e.proto"));
	}

	/**
	 * Generates the given files and returns the name of the type of the first field of the first
	 * message of the given file.
	 */
	private String resolvedType(String use, String... protos) throws IOException, ParseException {
		Generator generator = new Generator();
		generator.setOut(newOutputDir());
		DefinitionFile file = null;
		for (String proto : protos) {
			DefinitionFile loaded = generator.load(new File(FIXTURES, proto));
			if (proto.equals(use)) {
				file = loaded;
			}
		}
		generator.generate(new XmlStreamingPlugin());
		MessageDef message = (MessageDef) file.getDefinitions().get(0);
		return Util.protoName(((CustomType) message.getFields().get(0).getType()).getDefinition());
	}

	public void testDuplicate() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/names/dup/two.proto: Duplicate definition of 'reject.names.dup.Thing', it is also defined in"
				+ " 'reject/names/dup/one.proto'. Rename one of the definitions, or do not pass both files to the generator."),
			reject("dup/one.proto", "dup/two.proto"));
	}

	public void testDuplicateInFile() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/names/twice/twice.proto: Duplicate definition of 'reject.names.twice.Thing'. Rename or remove one of the"
				+ " definitions."),
			reject("dup/twice.proto"));
	}

	/** A file given twice, or given after it was imported, is entered only once. */
	public void testReentry() throws IOException, ParseException {
		File out = newOutputDir();
		Generator generator = new Generator();
		generator.setOut(out);
		DefinitionFile main = generator.load(new File(FIXTURES, "imp/main.proto"));
		generator.load(new File(FIXTURES, "imp/lib.proto"));
		assertSame(main, generator.load(new File(FIXTURES, "imp/main.proto")));
		generator.generate(new XmlStreamingPlugin());

		assertTrue(new File(out, "reject/names/imp/Main.java").isFile());
		// Generated, since given explicitly after being imported.
		assertTrue(new File(out, "reject/names/imp/Lib.java").isFile());
	}

	private List<String> reject(String... protos) throws IOException, ParseException {
		File out = newOutputDir();
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

	private File newOutputDir() throws IOException {
		File target = new File("target");
		target.mkdirs();
		return Files.createTempDirectory(target.toPath(), getName()).toFile();
	}

	private static String read(File file) throws IOException {
		return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
	}

}
