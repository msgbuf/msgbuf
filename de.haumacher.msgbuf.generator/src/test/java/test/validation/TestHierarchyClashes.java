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
 * Test case for rejecting messages of one hierarchy with clashing type IDs, type kind constants or
 * class names (issue #45).
 */
@SuppressWarnings("javadoc")
public class TestHierarchyClashes extends TestCase {

	private static final File FIXTURES = new File("src/test/resources/reject/hierarchy");

	/** The definition from the issue report. */
	public void testIssue() throws IOException, ParseException {
		String file = "reject/hierarchy/issue/issue.proto";
		String both = "message 'reject.hierarchy.issue.Msg.Item' of '" + file + "' and message 'reject.hierarchy.issue.Item' of '"
			+ file + "'";
		assertEquals(Arrays.asList(
			file + ": In the hierarchy of 'reject.hierarchy.issue.Msg', " + both + " have the same type ID 'Item' and the"
				+ " same XML element name 'item', so that the readers of 'reject.hierarchy.issue.Msg' cannot distinguish them."
				+ " Give one of the messages a distinct identifier with @Name or @XmlName, or rename it.",
			file + ": In the hierarchy of 'reject.hierarchy.issue.Msg', " + both + " generate the same constant 'ITEM' in the"
				+ " enum 'reject.hierarchy.issue.Msg.TypeKind'. Rename one of the messages, or add 'option NoTypeKind;' to '"
				+ file + "'.",
			file + ": Message 'reject.hierarchy.issue.Item' extends message 'reject.hierarchy.issue.Msg' of '" + file
				+ "', which declares the nested message 'reject.hierarchy.issue.Msg.Item' with the same name. In the generated"
				+ " Java class of 'reject.hierarchy.issue.Item', the name 'Item' would refer to the inherited nested type"
				+ " instead of the class itself. Rename one of them."),
			reject("issue.proto"));
	}

	public void testTypeKind() throws IOException, ParseException {
		String file = "reject/hierarchy/typekind/typekind.proto";
		assertEquals(Arrays.asList(
			file + ": In the hierarchy of 'reject.hierarchy.typekind.Msg', message 'reject.hierarchy.typekind.A.Item' of '"
				+ file + "' and message 'reject.hierarchy.typekind.B.Item' of '" + file + "' generate the same constant"
				+ " 'ITEM' in the enum 'reject.hierarchy.typekind.Msg.TypeKind'. Rename one of the messages, or add"
				+ " 'option NoTypeKind;' to '" + file + "'.",
			file + ": In the hierarchy of 'reject.hierarchy.typekind.Root', message 'reject.hierarchy.typekind.FooBar' of '"
				+ file + "' and message 'reject.hierarchy.typekind.FOO_BAR' of '" + file + "' generate the same constant"
				+ " 'FOO_BAR' in the enum 'reject.hierarchy.typekind.Root.TypeKind'. Rename one of the messages, or add"
				+ " 'option NoTypeKind;' to '" + file + "'."),
			reject("typekind.proto"));
	}

	public void testProtocolNames() throws IOException, ParseException {
		String file = "reject/hierarchy/protocol/protocol.proto";
		String prefix = file + ": In the hierarchy of 'reject.hierarchy.protocol.Shape', ";
		String readers = ", so that the readers of 'reject.hierarchy.protocol.Shape' cannot distinguish them.";
		assertEquals(Arrays.asList(
			prefix + "message 'reject.hierarchy.protocol.Circle' of '" + file + "' and message 'reject.hierarchy.protocol.Square' of '"
				+ file + "' have the same type ID 'shape' and the same XML element name 'shape'" + readers
				+ " Give one of the messages a distinct identifier with @Name or @XmlName, or rename it.",
			prefix + "message 'reject.hierarchy.protocol.Rect' of '" + file + "' and message 'reject.hierarchy.protocol.Box' of '"
				+ file + "' have the same XML element name 'rect'" + readers
				+ " Give one of the messages a distinct identifier with @XmlName, or rename it.",
			prefix + "message 'reject.hierarchy.protocol.Line' of '" + file + "' and message 'reject.hierarchy.protocol.Arc' of '"
				+ file + "' have the same binary type ID '7'" + readers
				+ " Give one of the messages a distinct identifier with @type_id."),
			reject("protocol.proto"));
	}

	public void testShadowedByNestedDefinition() throws IOException, ParseException {
		String file = "reject/hierarchy/shadow/shadow.proto";
		assertEquals(Arrays.asList(
			file + ": Message 'reject.hierarchy.shadow.Kind' extends message 'reject.hierarchy.shadow.Base' of '" + file
				+ "', which declares the nested enum 'reject.hierarchy.shadow.Base.Kind' with the same name. In the generated"
				+ " Java class of 'reject.hierarchy.shadow.Kind', the name 'Kind' would refer to the inherited nested type"
				+ " instead of the class itself. Rename one of them.",
			file + ": Message 'reject.hierarchy.shadow.Outer.Item' extends message 'reject.hierarchy.shadow.Base' of '" + file
				+ "', which declares the nested message 'reject.hierarchy.shadow.Base.Item' with the same name. In the"
				+ " generated Java class of 'reject.hierarchy.shadow.Outer.Item', the name 'Item' would refer to the inherited"
				+ " nested type instead of the class itself. Rename one of them."),
			reject("shadow.proto"));
	}

	/** Extensions of an OpenWorld hierarchy in different files and packages, generated together. */
	public void testOpenWorldExtensions() throws IOException, ParseException {
		assertEquals(Arrays.asList(
			"reject/hierarchy/two/two.proto: In the hierarchy of 'reject.hierarchy.open.Shape', message"
				+ " 'reject.hierarchy.one.Circle' of 'reject/hierarchy/one/one.proto' and message 'reject.hierarchy.two.Circle'"
				+ " of 'reject/hierarchy/two/two.proto' have the same type ID 'Circle' and the same XML element name 'circle',"
				+ " so that the readers of 'reject.hierarchy.open.Shape' cannot distinguish them. Give one of the messages a"
				+ " distinct identifier with @Name or @XmlName, or rename it."),
			reject("open/base.proto", "open/one.proto", "open/two.proto"));
	}

	/** An imported base is checked together with the extensions that are generated. */
	public void testOpenWorldExtensionsOfImportedBase() throws IOException, ParseException {
		assertEquals(1, reject("open/one.proto", "open/two.proto").size());
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
