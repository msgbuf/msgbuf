package de.haumacher.msgbuf.generator.maven;

import static org.junit.Assert.*;

import java.io.File;

import org.apache.maven.plugin.testing.MojoRule;
import org.junit.Rule;
import org.junit.Test;

public class TestGenerateMessageClasses {
	@Rule
	public MojoRule rule = new MojoRule() {
		@Override
		protected void before() throws Throwable {
		}

		@Override
		protected void after() {
		}
	};

	@Test
	public void testSomething() throws Exception {
		File pom = new File("target/test-classes/project-to-test/");
		assertNotNull(pom);
		assertTrue(pom.exists());

		GenerateMessageClasses generate = 
				(GenerateMessageClasses) rule.lookupConfiguredMojo(pom, GenerateMessageClasses.NAME);
		assertNotNull(generate);
		generate.execute();

		File outputDirectory = generate.getOutputDirectory();
		assertNotNull(outputDirectory);
		assertTrue(outputDirectory.exists());

		File touch = new File(outputDirectory, "my/company/MyMessage.java");
		assertTrue(touch.exists());
	}

}
