/*
 * Copyright (c) 2026 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.ts;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.haumacher.msgbuf.generator.Generator;
import de.haumacher.msgbuf.generator.GeneratorPlugin;
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
