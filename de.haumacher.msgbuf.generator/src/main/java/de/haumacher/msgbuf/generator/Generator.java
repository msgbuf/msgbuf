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
import java.util.Map;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.Definition.Visitor;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.ast.Type;
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

	public DefinitionFile load(String fileName) throws IOException, ParseException {
		return load(new File(fileName));
	}

	public DefinitionFile load(File file)
			throws ParseException, IOException, FileNotFoundException {
		try (InputStream in = new FileInputStream(file)) {
			return load(in);
		}
	}

	public DefinitionFile load(InputStream in) throws ParseException {
		return load(parse(in));
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

	public DefinitionFile load(DefinitionFile file) {
		_files.add(file);
		_table.enter(file);
		return file;
	}
	
	public void generate() {
		for (DefinitionFile file : _files) {
			buildSpecializations(file);
		}
		
		TypeIdSynthesizer typeIdSynthesizer = new TypeIdSynthesizer();
		for (DefinitionFile file : _files) {
			typeIdSynthesizer.process(file);
		}
		
		FieldIDSynthesizer synthesizer = new FieldIDSynthesizer();
		for (DefinitionFile file : _files) {
			synthesizer.process(file);
		}
		
		for (DefinitionFile file : _files) {
			File dir = mkdir(file.getPackage());
			
			PackageGenerator packageGenerator = new PackageGenerator(dir, file.getOptions());
			for (Definition def : file.getDefinitions()) {
				def.visit(packageGenerator, null);
			}
		}
	}
	
	private void buildSpecializations(DefinitionFile file) {
		NameTable table = _table;
		
		Type.Visitor<Void, MessageDef> typeResolver = new Type.Visitor<Void, MessageDef>() {

			@Override
			public Void visit(CustomType self, MessageDef context) {
				self.setDefinition(table.lookup(context, self.getName()));
				return null;
			}

			@Override
			public Void visit(PrimitiveType self, MessageDef context) {
				return null;
			}

			@Override
			public Void visit(MapType self, MessageDef context) {
				self.getKeyType().visit(this, context);
				self.getValueType().visit(this, context);
				return null;
			}
			
		};
		
		Visitor<Void, Void> indexer = new Visitor<Void, Void>() {
			@Override
			public Void visit(MessageDef def, Void arg) {
				QName generalizationName = def.getExtends();
				if (generalizationName != null) {
					MessageDef ref = (MessageDef) table.lookup(def, generalizationName);
					if (ref ==  null) {
						error("Referenced type '" + Util.qTypeName(generalizationName) + "' not found.");
					} else {
						def.setExtendedDef(ref);
						ref.addSpecialization(def);
					}
				}
				
				for (Definition inner : def.getDefinitions()) {
					inner.visit(this, arg);
				}
				
				for (Field field : def.getFields()) {
					field.getType().visit(typeResolver, def);
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
		private Map<String, Option> _options;

		public PackageGenerator(File dir, Map<String, Option> options) {
			_dir = dir;
			_options = options;
		}

		@Override
		public Void visit(EnumDef def, Void arg) {
			return generateJava(Util.typeName(def), new EnumGenerator(def));
		}
		
		@Override
		public Void visit(MessageDef def, Void arg) {
			return generateJava(Util.typeName(def), new MessageGenerator(_table, _options, def));
		}
		
		private <D extends Definition> Void generateJava(String name, FileGenerator generator) {
			File out = new File(_dir, name + ".java");
			try (FileOutputStream os = new FileOutputStream(out)) {
				try (PrintWriter w = new PrintWriter(new OutputStreamWriter(os, "utf-8"))) {
					System.out.println("Generating '" + out + "'.");
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

	protected void error(String message) {
		error(message, null);
	}
	
	protected void error(String message, IOException ex) {
		System.out.println(message);
		if (ex != null) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ParseException, IOException {
		if (args.length == 0) {
			printHelp();
			return;
		}
		File out = null;
		Generator generator = new Generator();
		for (int n = 0, cnt = args.length; n < cnt; ) {
			String arg = args[n++];
			if (arg.equals("-out")) {
				out = new File(args[n++]);
			} else if (arg.equals("-h")) {
				printHelp();
				return;
			} else {
				File file = new File(arg);
				DefinitionFile content = generator.load(file);
				if (out == null) {
					out = findBase(file, content);
				}
			}
		}
		if (out != null) {
			generator.setOut(out);
		}
		generator.generate();
	}

	private static void printHelp() {
		System.err.println("Usage: java -jar " + Generator.class.getName() + " -out <java-output-dir> <protocol-definition.proto>*");
	}

	private static File findBase(File protoFile, DefinitionFile content) {
		File result = protoFile.getParentFile();
		if (content.getPackage() != null) {
			for (int n = 0, cnt = content.getPackage().getNames().size(); n < cnt; n++) {
				result = result.getParentFile();
			}
		}
		return result;
	}

}
