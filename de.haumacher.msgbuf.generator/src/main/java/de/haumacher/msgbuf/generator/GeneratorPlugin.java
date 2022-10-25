/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.Map;

import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.util.FileGenerator;

/**
 * Plug-in to the {@link MessageGenerator}.
 */
public interface GeneratorPlugin {

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
