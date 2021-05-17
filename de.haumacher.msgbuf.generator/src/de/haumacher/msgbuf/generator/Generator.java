/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.Definition.Visitor;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.parser.ParseException;
import de.haumacher.msgbuf.generator.parser.ProtobufParser;
import de.haumacher.msgbuf.generator.parser.ProtobufParserConstants;
import de.haumacher.msgbuf.generator.parser.Token;

/**
 * Main entry point to the <code>msgbuf</code> generator.
 */
public class Generator {
	
	private NameTable _table = new NameTable();
	private File _out = new File(".");
	private List<DefinitionFile> _files = new ArrayList<>();
	
	public void setOut(File out) {
		_out = out;
	}

	public void load(String fileName) throws IOException, ParseException {
		load(new File(fileName));
	}

	public void load(File file)
			throws ParseException, IOException, FileNotFoundException {
		try (InputStream in = new FileInputStream(file)) {
			load(in);
		}
	}

	public void load(InputStream in) throws ParseException {
		load(parse(in));
	}

	public static DefinitionFile parse(InputStream in) throws ParseException {
		ProtobufParser parser = new ProtobufParser(in, "utf-8");
		DefinitionFile definition = parser.file();
		Token nextToken = parser.getNextToken();
		if (nextToken.kind != ProtobufParserConstants.EOF) {
			throw new ParseException("Unexpected token '" + nextToken
					+ "' at line " + nextToken.beginLine + " column "
					+ nextToken.beginColumn + " .");
		}
		return definition;
	}

	public void load(DefinitionFile file) {
		_files.add(file);
		_table.enter(file);
	}
	
	public void generate() {
		for (DefinitionFile file : _files) {
			buildSpecializations(file);
		}
		for (DefinitionFile file : _files) {
			File dir = mkdir(file.getPackage());
			
			PackageGenerator packageGenerator = new PackageGenerator(dir);
			for (Definition def : file.getDefinitions()) {
				def.visit(packageGenerator, null);
			}
		}
	}
	
	private void buildSpecializations(DefinitionFile file) {
		Visitor<Void, Void> indexer = new Visitor<Void, Void>() {
			@Override
			public Void visit(MessageDef def, Void arg) {
				QName generalizationName = def.getExtends();
				if (generalizationName != null) {
					MessageDef ref = (MessageDef) _table.lookup(def, generalizationName);
					def.setExtendedDef(ref);
					ref.addSpecialization(def);
				}
				
				for (Definition inner : def.getDefinitions()) {
					inner.visit(this, arg);
				}
				return null;
			}

			@Override
			public Void visit(EnumDef def, Void arg) {
				return null;
			}
		};
		for (Definition def : file.getDefinitions()) {
			def.visit(indexer, null);
		}
	}
	
	class PackageGenerator implements Definition.Visitor<Void, Void> {
		private File _dir;

		public PackageGenerator(File dir) {
			_dir = dir;
		}

		@Override
		public Void visit(EnumDef def, Void arg) {
			return generateJava(def.getName(), new EnumGenerator(def));
		}
		
		@Override
		public Void visit(MessageDef def, Void arg) {
			return generateJava(def.getName(), new MessageGenerator(def));
		}
		
		private <D extends Definition> Void generateJava(String name, FileGenerator generator) {
			File out = new File(_dir, name + ".java");
			try (FileOutputStream os = new FileOutputStream(out)) {
				try (PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "utf-8"))) {
					generator.generate(w);
				}
			} catch (IOException ex) {
				error("Error writing file '" + out + "'.", ex);
			}
			return null;
		}

	}

	private File mkdir(QName pkgName) {
		File result = _out;
		if (pkgName != null) {
			for (String name : pkgName.getNames()) {
				result = new File(result, name);
			}
		}
		result.mkdirs();
		return result;
	}

	/** 
	 * TODO
	 */
	public void error(String string, IOException ex) {
		//  TODO: Automatically created
		
	}
	
	public static void main(String[] args) throws ParseException, IOException {
		Generator generator = new Generator();
		for (int n = 0, cnt = args.length; n < cnt; ) {
			String arg = args[n++];
			if (arg.equals("-out")) {
				generator.setOut(new File(args[n++]));
			} else {
				generator.load(arg);
			}
		}
		generator.generate();
	}

}
