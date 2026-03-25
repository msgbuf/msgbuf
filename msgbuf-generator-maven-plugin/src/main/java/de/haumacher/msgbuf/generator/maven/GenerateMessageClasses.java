package de.haumacher.msgbuf.generator.maven;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;

import de.haumacher.msgbuf.generator.Generator;

/**
 * Goal that invokes the MsgBuf compiler.
 */
@Mojo(name = GenerateMessageClasses.NAME, defaultPhase = LifecyclePhase.GENERATE_SOURCES, requiresDependencyResolution = ResolutionScope.COMPILE)
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

	/**
	 * Additional directories to search for imported .proto files.
	 */
	@Parameter(property = "includePaths")
	private List<File> _includePaths;

	/**
	 * Directory where to generate resource files (e.g. META-INF/services).
	 */
	@Parameter(defaultValue = "${project.basedir}/src/main/resources", property = "resourceOutputDir")
	private File _resourceOutputDirectory;

	@Parameter(defaultValue = "${project}", readonly = true, required = true)
	private MavenProject _project;

	@Override
	public void execute() throws MojoExecutionException {
		File outputDirectory = _outputDirectory;
		if (!outputDirectory.exists()) {
			outputDirectory.mkdirs();
		}
		
		try {
			List<File> protoFiles;
			if (_input.isDirectory()) {
				protoFiles = Files.walk(_input.toPath())
					.map(p -> p.toFile())
					.filter(File::isFile)
					.filter(p -> p.getName().endsWith(".proto"))
					.collect(Collectors.toList());
			} else {
				protoFiles = Collections.singletonList(_input);
			}
			if (protoFiles.isEmpty()) {
				getLog().info("No protocol files found, skipping.");
				return;
			}

			Generator generator = new Generator();
			generator.setOut(outputDirectory);
			if (_resourceOutputDirectory != null) {
				generator.setResourceOut(_resourceOutputDirectory);
			}
			if (_includePaths != null) {
				for (File includePath : _includePaths) {
					generator.addIncludePath(includePath);
				}
			}

			// Build classpath from compile dependencies for resolving imports from JARs
			List<String> classpathElements = _project.getCompileClasspathElements();
			if (classpathElements != null && !classpathElements.isEmpty()) {
				URL[] urls = new URL[classpathElements.size()];
				for (int i = 0; i < classpathElements.size(); i++) {
					urls[i] = new File(classpathElements.get(i)).toURI().toURL();
				}
				generator.setImportClassLoader(new URLClassLoader(urls, null));
			}

			for (File protoFile : protoFiles) {
				generator.load(protoFile);
			}

			generator.generate(Generator.loadPlugins());
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
