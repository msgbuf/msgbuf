package de.haumacher.msgbuf.generator.maven;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import de.haumacher.msgbuf.generator.Generator;

/**
 * Goal that invokes the MsgBuf compiler.
 */
@Mojo(name = GenerateMessageClasses.NAME, defaultPhase = LifecyclePhase.PROCESS_SOURCES)
public class GenerateMessageClasses extends AbstractMojo {
	
	/**
	 * Name of the target.
	 */
	public static final String NAME = "generate";
	
	/**
	 * Directory where to generate source code to.
	 */
	@Parameter(defaultValue = "${project.build.sourceDirectory}", property = "outputDir", required = true)
	private File _outputDirectory;
	
	/**
	 * Input where to search for <code>*.proto</code> files.
	 */
	@Parameter(defaultValue = "${project.build.sourceDirectory}", property = "input", required = true)
	private File _input;

	@Override
	public void execute() throws MojoExecutionException {
		File outputDirectory = _outputDirectory;
		if (!outputDirectory.exists()) {
			outputDirectory.mkdirs();
		}
		
		try {
			List<String> files;
			if (_input.isDirectory()) {
				files = Files.walk(_input.toPath())
					.filter(p -> p.toFile().isFile())
					.filter(p -> p.getFileName().toString().endsWith(".proto"))
					.map(p -> p.toAbsolutePath().toString())
					.collect(Collectors.toList());
			} else {
				files = Collections.singletonList(_input.getAbsolutePath());
			}
			if (files.isEmpty()) {
				getLog().info("No protocol files found, skipping.");
				return;
			}
		
			ArrayList<String> argList = new ArrayList<>(Arrays.asList(Generator.OUTPUT_DIR_ARG, _outputDirectory.getAbsolutePath()));
			argList.addAll(files);
			String[] args = argList.toArray(new String[0]);
			Generator.main(args);
		} catch (Throwable ex) {
			throw new MojoExecutionException("Failed to invoke the generator: " + ex.getMessage(), ex);
		}
	}

	/** 
	 * The directory where source files are generated to.
	 */
	public File getOutputDirectory() {
		return _outputDirectory;
	}
}
