/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ts;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.haumacher.msgbuf.generator.Generator;
import de.haumacher.msgbuf.generator.GeneratorException;
import de.haumacher.msgbuf.generator.GeneratorPlugin;
import de.haumacher.msgbuf.generator.parser.ParseException;
import junit.framework.TestCase;

/**
 * Golden-file test for {@link TypeScriptGenerator}.
 *
 * <p>
 * Generates the <code>.proto</code> files in <code>src/test/resources/ts/proto</code> and compares
 * the TypeScript output with the files in <code>src/test/resources/ts/expected</code>. Run with
 * <code>-Dmsgbuf.ts.update=true</code> to replace the expected files with the current output.
 * </p>
 */
@SuppressWarnings("javadoc")
public class TestTypeScriptGenerator extends TestCase {

	private static final File BASE = new File("src/test/resources/ts");

	private static final File PROTO_DIR = new File(BASE, "proto");

	private static final File EXPECTED_DIR = new File(BASE, "expected");

	private static final File REJECT_DIR = new File("src/test/resources/reject/ts");

	public void testGolden() throws Exception {
		File outDir = new File("target/ts-test");
		deleteRecursively(outDir.toPath());

		File javaOut = new File(outDir, "java");
		File tsOut = new File(outDir, "ts");

		Generator generator = new Generator();
		generator.setOut(javaOut);
		generator.setTypeScriptOut(tsOut);
		for (File proto : protoFiles()) {
			generator.load(proto);
		}
		generator.generate(GeneratorPlugin.none());

		Set<String> actual = tsFiles(tsOut.toPath());
		assertFalse("No TypeScript files generated.", actual.isEmpty());

		if (Boolean.getBoolean("msgbuf.ts.update")) {
			deleteRecursively(EXPECTED_DIR.toPath());
			for (String name : actual) {
				Path target = EXPECTED_DIR.toPath().resolve(name);
				Files.createDirectories(target.getParent());
				Files.copy(tsOut.toPath().resolve(name), target);
			}
			return;
		}

		Set<String> expected = tsFiles(EXPECTED_DIR.toPath());
		assertEquals("Generated TypeScript modules.", expected, actual);
		for (String name : expected) {
			assertEquals("Content of '" + name + "'.",
				read(EXPECTED_DIR.toPath().resolve(name)),
				read(tsOut.toPath().resolve(name)));
		}
	}

	/** Helper names generated for different messages of a module or hierarchy must not clash. */
	public void testHelperNameClash() throws Exception {
		String hint = " Rename one of the messages (TypeScript helper names are derived from the message name qualified with"
			+ " the names of its outer messages, joined with '_', without the package).";
		assertEquals(Arrays.asList(
			"reject/ts/collide/names.proto: The TypeScript visitor 'RootJsonVisitor' of message 'reject.ts.collide.Root' requires a method 'visitA_B' for message 'reject.ts.collide.A_B' of 'reject/ts/collide/names.proto' and for message 'reject.ts.collide.A.B' of 'reject/ts/collide/names.proto'." + hint,
			"reject/ts/collide/names.proto: The TypeScript declaration 'tagA_B' is generated for message 'reject.ts.collide.A_B' and for message 'reject.ts.collide.A.B'." + hint),
			reject("collide/names.proto"));
	}

	/** Visitor method names must be unique in a hierarchy across files. */
	public void testVisitorMethodClashAcrossFiles() throws Exception {
		assertEquals(Arrays.asList(
			"reject/ts/open/base.proto: The TypeScript visitor 'ShapeJsonVisitor' of message 'reject.ts.open.Shape' requires a method 'visitCircle' for message 'reject.ts.one.Circle' of 'reject/ts/one/one.proto' and for message 'reject.ts.two.Circle' of 'reject/ts/two/two.proto'. Rename one of the messages (TypeScript helper names are derived from the message name qualified with the names of its outer messages, joined with '_', without the package)."),
			reject("open/base.proto", "open/one.proto", "open/two.proto"));
	}

	private List<String> reject(String... protos) throws IOException, ParseException {
		File target = new File("target");
		target.mkdirs();
		File out = Files.createTempDirectory(target.toPath(), getName()).toFile();
		Generator generator = new Generator();
		generator.setOut(new File(out, "java"));
		generator.setTypeScriptOut(new File(out, "ts"));
		for (String proto : protos) {
			generator.load(new File(REJECT_DIR, proto));
		}
		try {
			generator.generate(GeneratorPlugin.none());
			fail("Expected rejection of " + Arrays.toString(protos) + ".");
			return null;
		} catch (GeneratorException ex) {
			String[] written = out.list();
			assertTrue("No code must be generated for rejected definitions.", written == null || written.length == 0);
			return ex.getErrors();
		}
	}

	private static List<File> protoFiles() throws IOException {
		try (Stream<Path> files = Files.walk(PROTO_DIR.toPath())) {
			return files
				.filter(p -> p.toString().endsWith(".proto"))
				.sorted()
				.map(Path::toFile)
				.collect(Collectors.toList());
		}
	}

	private static Set<String> tsFiles(Path dir) throws IOException {
		if (!Files.isDirectory(dir)) {
			return new TreeSet<>();
		}
		try (Stream<Path> files = Files.walk(dir)) {
			return files
				.filter(p -> p.toString().endsWith(".ts"))
				.map(p -> dir.relativize(p).toString().replace(File.separatorChar, '/'))
				.collect(Collectors.toCollection(TreeSet::new));
		}
	}

	private static String read(Path file) throws IOException {
		return new String(Files.readAllBytes(file), StandardCharsets.UTF_8).replace("\r\n", "\n");
	}

	private static void deleteRecursively(Path dir) throws IOException {
		if (!Files.exists(dir)) {
			return;
		}
		try (Stream<Path> files = Files.walk(dir)) {
			for (Path p : files.sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList())) {
				Files.delete(p);
			}
		}
	}

}
