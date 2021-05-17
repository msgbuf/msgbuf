/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.parser.ParseException;
import de.haumacher.msgbuf.io.StringW;
import de.haumacher.msgbuf.json.JsonWriter;

/**
 * Converts a <code>.proto</code> definition file into JSON representation.
 */
public class Proto2Json {
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		try (FileInputStream in = new FileInputStream(new File(args[0]))) {
			DefinitionFile definitionFile = Generator.parse(in);
			StringW buffer = new StringW();
			definitionFile.writeTo(new JsonWriter(buffer));
			System.out.println(buffer);
		}
	}
}
