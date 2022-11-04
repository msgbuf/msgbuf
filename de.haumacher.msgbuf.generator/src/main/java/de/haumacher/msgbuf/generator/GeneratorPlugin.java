/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.List;
import java.util.Map;

import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.util.FileGenerator;

/**
 * Plug-in to the {@link MessageGenerator}.
 */
public interface GeneratorPlugin {

	/**
	 * Initializes the plug-in with file options.
	 * 
	 * @param options The options of the current file to translate.
	 */
	default void init(Map<String, Option> options) {
		// Ignore.
	}
	
	/**
	 * Adds interfaces to the generated type.
	 *
	 * @param options
	 *        The options from the top-level definition file.
	 * @param def
	 *        The {@link MessageDef} that is being translated.
	 * @param generalizations
	 *        The generalization list to extend.
	 */
	default void addInterfaces(Map<String, Option> options, MessageDef def, List<String> generalizations) {
		// No additional interfaces by default.
	}

	/** 
	 * Creates a {@link FileGenerator} that is expanded within the interface class.
	 * 
	 * @param options The options from the top-level definition file.
	 * @param def The {@link MessageDef} that is being translated.
	 */
	default FileGenerator messageInterfaceContents(Map<String, Option> options, MessageDef def) {
		return (out, indent) -> {/*ignore*/};
	}
	
	/** 
	 * Creates a {@link FileGenerator} that is expanded within the implementation class.
	 * 
	 * @param options The options from the top-level definition file.
	 * @param def The {@link MessageDef} that is being translated.
	 */
	default FileGenerator messageImplContents(Map<String, Option> options, MessageDef def) {
		return (out, indent) -> {/*ignore*/};
	}

	/** 
	 * {@link GeneratorPlugin} that does not generate any output.
	 */
	static GeneratorPlugin none() {
		return new GeneratorPlugin() {
			@Override
			public GeneratorPlugin andThen(GeneratorPlugin next) {
				return next;
			}
		};
	}

	/** 
	 * Joins this {@link GeneratorPlugin} with the given one.
	 */
	default GeneratorPlugin andThen(GeneratorPlugin next) {
		GeneratorPlugin self = this;
		
		return new GeneratorPlugin() {
			@Override
			public void init(Map<String, Option> options) {
				self.init(options);
				next.init(options);
			}
			
			@Override
			public void addInterfaces(Map<String, Option> options, MessageDef def, List<String> generalizations) {
				self.addInterfaces(options, def, generalizations);
				next.addInterfaces(options, def, generalizations);
			}
			
			@Override
			public FileGenerator messageImplContents(Map<String, Option> options, MessageDef def) {
				return (out, indent) -> {
					self.messageImplContents(options, def).generate(out, indent);
					next.messageImplContents(options, def).generate(out, indent);
				};
			}
			
			@Override
			public FileGenerator messageInterfaceContents(Map<String, Option> options, MessageDef def) {
				return (out, indent) -> {
					self.messageInterfaceContents(options, def).generate(out, indent);
					next.messageInterfaceContents(options, def).generate(out, indent);
				};
			}
		};
	}

}
