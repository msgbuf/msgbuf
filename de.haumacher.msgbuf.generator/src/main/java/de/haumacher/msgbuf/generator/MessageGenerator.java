/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.haumacher.msgbuf.binary.DataType;
import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.Option;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.PrimitiveType.Kind;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.ast.StringOption;
import de.haumacher.msgbuf.generator.ast.Type;

/**
 * {@link Generator} for message data classes.
 */
public class MessageGenerator extends AbstractFileGenerator implements Type.Visitor<String, Boolean>, Definition.Visitor<Void, Void> {

	private static final Pattern NAME_PART_PATTERN = Pattern.compile(
		"(?<=\\p{javaLowerCase})(?=\\p{javaUpperCase})" + "|" + 
		"(?<=\\p{javaLetter})(?=\\p{javaDigit})" + "|" + 
		"(?<=\\p{javaDigit})(?=\\p{javaLetter})" + "|" + 
		"_+");
	
	private final NameTable _table;
	private final MessageDef _def;
	private boolean _binary = true;
	private boolean _reflection = true;

	/** 
	 * Creates a {@link MessageGenerator}.
	 * @param table 
	 *
	 * @param def
	 */
	public MessageGenerator(NameTable table, MessageDef def) {
		_table = table;
		_def = def;
	}
	
	/**
	 * Whether binary IO should be generated.
	 */
	public boolean isBinary() {
		return _binary;
	}
	
	/**
	 * @see #isBinary()
	 */
	public void setBinary(boolean binary) {
		_binary = binary;
	}
	
	/**
	 * Whether reflective access should be generated.
	 */
	public boolean isReflection() {
		return _reflection;
	}
	
	/**
	 * @see #isReflection()
	 */
	public void setReflection(boolean reflection) {
		_reflection = reflection;
	}

	@Override
	protected void generate() {
		String modifier;
		if (_def.getFile() != null) {
			QName packageName = _def.getFile().getPackage();
			if (packageName != null) {
				line("package " + Util.qName(packageName) + ";");
				nl();
			}
			modifier = "";
		} else {
			modifier = " static";
		}
		docComment(_def.getComment());
		line("public" + modifier + getAbstract() + " class " + camelCase(_def.getName()) + getExtends() + " {");
		generateClassContents();
		nl();
		line("}");
	}
	
	@Override
	protected void docComment(String comment) {
		Pattern ref = Pattern.compile("([a-zA-Z_][a-zA-Z_0-9]*)?#([a-zA-Z_][a-zA-Z_0-9]*)");
		Matcher matcher = ref.matcher(comment);
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			String type = matcher.group(1);
			String name = matcher.group(2);
			Definition def = _def;
			if (type != null) {
				def = _table.lookup(_def, qName(type));
			}
			Field field = def instanceof MessageDef ? getField((MessageDef) def, name) : null;
			String replacement = (type == null ? "" : type) + "#";
			if (field == null) {
				replacement += name;
			} else {
				replacement += getter(field);
			}
			
			matcher.appendReplacement(buffer, replacement);
		}
		matcher.appendTail(buffer);
		
		super.docComment(buffer.toString());
	}

	private String getter(Field field) {
		return getterName(field) + "()";
	}

	private QName qName(String name) {
		QName result = QName.create();
		for (String part : name.split("\\.")) {
			result.addName(part);
		}
		return result;
	}

	private Field getField(MessageDef def, String name) {
		Field result = localField(def, name);
		if (result != null) {
			return result;
		}
		MessageDef extendedDef = def.getExtendedDef();
		if (extendedDef != null) {
			return getField(extendedDef, name);
		}
		return null;
	}

	private Field localField(MessageDef def, String name) {
		return def.getFields().stream().filter(f -> name.equals(f.getName())).findFirst().orElse(null);
	}

	private String getAbstract() {
		return _def.isAbstract() ? " abstract" : "";
	}

	private String getExtends() {
		if (_def.getExtends() == null) {
			return " extends " + (_reflection ? "de.haumacher.msgbuf.data.AbstractReflectiveDataObject" : "de.haumacher.msgbuf.data.AbstractDataObject") + 
					(_binary ? " implements " : "") + 
					(_binary ? "de.haumacher.msgbuf.binary.BinaryDataObject" : "")
				;
		} else {
			return " extends " + Util.qName(_def.getExtends());
		}
	}

	private void generateClassContents() {
		if (_def.isAbstract()) {
			nl();
			line("/** Visitor interface for the {@link " + _def.getName() + "} hierarchy.*/");
			lineStart("public interface Visitor<R,A>");
			boolean first = true;
			for (MessageDef specialization : _def.getSpecializations()) {
				if (!specialization.isAbstract()) {
					continue;
				}
				if (first) {
					first = false;
					append(" extends ");
				} else {
					append(", ");
				}
				append(specialization.getName() + ".Visitor<R,A>");
			}
			append(" {");
			nl();
			{
				for (MessageDef specialization : _def.getSpecializations()) {
					if (specialization.isAbstract()) {
						continue;
					}

					nl();
					line("/** Visit case for {@link " + specialization.getName() + "}.*/");
					line("R visit(" + specialization.getName() + " self, A arg);");
				}
			}
			nl();
			line("}");
		}
		
		for (Definition def : _def.getDefinitions()) {
			def.visit(this, null);
		}
		
		if (!_def.isAbstract()) {
			nl();
			line("/**");
			line(" * Creates a {@link " + _def.getName() + "} instance.");
			line(" */");
			line("public static " + _def.getName() + " " + factoryName(_def) + "() {");
			{
				line("return new " + _def.getName() + "();");
			}
			line("}");
		}
		
		nl();
		line("/**");
		line(" * Creates a {@link " + _def.getName() + "} instance.");
		if (!_def.isAbstract()) {
			line(" *");
			line(" * @see #" + factoryName(_def) + "()");
		}
		line(" */");
		line("protected " + _def.getName() + "() {");
		{
			line("super();");
		}
		line("}");
		
		List<Field> fields = _def.getFields();
		
		generateConstants(fields);

		for (Field field : fields) {
			generateFieldDef(field);
		}
		
		for (Field field : fields) {
			generateFieldAccessor(field);
		}
		
		generateReflectionAccess();
		
		binaryIO();
		
		if (_def.isAbstract()) {
			nl();
			line("/** Accepts the given visitor. */");
			line("public abstract <R,A> R visit(Visitor<R,A> v, A arg);");
			nl();
		}
		
		MessageDef gen = abstractGeneralizations(_def);
		if (gen != null) {
			nl();
			line("@Override");
			line("public" + (_def.isAbstract() ? " final" : "") + " <R,A> R visit(" + gen.getName() + ".Visitor<R,A> v, A arg) {");
			{
				if (_def.isAbstract()) {
					line("return visit((Visitor<R,A>) v, arg);");
				} else {
					line("return v.visit(this, arg);");
				}
			}
			line("}");
		}
	}

	/**
	 * Name of the factory method for the given {@link MessageDef}.
	 * 
	 * @param def
	 *        The {@link MessageDef} to produce a factory name for.
	 */
	private String factoryName(MessageDef def) {
		return "create";
	}
	
	private MessageDef abstractGeneralizations(MessageDef def) {
		while (true) {
			MessageDef extendsDef = def.getExtendedDef();
			if (extendsDef == null) {
				break;
			}
			if (extendsDef.isAbstract()) {
				return extendsDef;
			}
			def = extendsDef;
		}
		return null;
	}

	private void generateReflectionAccess() {
		boolean baseClass = _def.getExtends() == null;
		List<Field> fields = _def.getFields();
		
		nl();
		line("/** Reads a new instance from the given reader. */");
		line("public static " + _def.getName() + " " + readerName(_def) + "(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {");
		{
			if (_def.isAbstract()) {
				line(_def.getName() + " result;");
				line("in.beginArray();");
				line("String type = in.nextString();");
				line("switch (type) {");
				for (MessageDef specialization : transitiveSpecializations(_def)) {
					if (specialization.isAbstract()) {
						continue;
					}
					line("case \"" + specialization.getName() + "\": result = " + specialization.getName() + "." + readerName(specialization) + "(in); break;");
				}
				line("default: in.skipValue(); result = null; break;");
				line("}");
				line("in.endArray();");
			} else {
				line(_def.getName() + " result = new " + _def.getName() + "();");
				line("in.beginObject();");
				line("result.readFields(in);");
				line("in.endObject();");
			}
			line("return result;");
		}
		line("}");
		
		if (baseClass) {
			nl();
			line("@Override");
			line("public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {");
			if (_def.isAbstract()) {
				line("out.beginArray();");
				line("out.value(jsonType());");
				line("writeContent(out);");
				line("out.endArray();");
			} else {
				line("writeContent(out);");
			}
			line("}");
			
			if (_def.isAbstract()) {
				nl();
				line("/** The type identifier for this concrete subtype. */");
				line("public abstract String jsonType();");
			}
		}
		
		if (_def.getExtendedDef() != null && !_def.isAbstract()) {
			nl();
			line("@Override");
			line("public String jsonType() {");
			{
				line("return \"" + _def.getName() + "\";");
			}
			line("}");
		}
		
		if (!fields.isEmpty()) {
			nl();
			line("private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(");
			{
				line("java.util.Arrays.asList(");
				{
					boolean first = true;
					for (Field field : fields) {
						if (first) {
							first = false;
						} else {
							append(", ");
							nl();
						}
						lineStart(constant(field));
					}
					append("));");
					nl();
				}
			}
			
			nl();
			line("@Override");
			line("public java.util.List<String> properties() {");
			{
				line("return PROPERTIES;");
			}
			line("}");
			
			nl();
			line("@Override");
			line("public Object get(String field) {");
			{
				line("switch (field) {");
				for (Field field : fields) {
					line("case " + constant(field) + ": return " + getterName(field) + "()" + ";");
				}
				line("default: return super.get(field);");
				line("}");
			}
			line("}");
			
			nl();
			line("@Override");
			line("public void set(String field, Object value) {");
			{
				{
					line("switch (field) {");
					for (Field field : fields) {
						line("case " + constant(field) + ": " + setterName(field) + "(" + cast(field, "value") + ")" + "; break;");
					}
					if (!baseClass) {
						line("default: super.set(field, value); break;");
					}
					line("}");
				}
			}
			line("}");
		
			nl();
			line("@Override");
			line("protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {");
			{
				line("super.writeFields(out);");
				for (Field field : fields) {
					if (field.isTransient()) {
						continue;
					}
					boolean nullable = isNullable(field);
					if (nullable) {
						line("if (" + hasName(field) + "()" + ") {");
					}
					line("out.name(" + constant(field) + ");");
					if (field.isRepeated()) {
						line("out.beginArray();");
						line("for (" + getType(field.getType()) +" x : " + getterName(field) + "()" + ") {");
						{
							jsonOutValue(field.getType(), "x");
						}
						line("}");
						line("out.endArray();");
					} else {
						jsonOutValue(field.getType(), getter(field));
					}
					if (nullable) {
						line("}");
					}
				}
			}
			line("}");
		
			nl();
			line("@Override");
			line("protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {");
			{
				line("switch (field) {");
				for (Field field : fields) {
					if (field.isTransient()) {
						continue;
					}
					jsonReadField(field);
				}
				line("default: super.readField(in, field);");
				line("}");
			}
			line("}");
		}
	}

	private void generateConstants(List<Field> fields) {
		for (Field field : fields) {
			nl();
			line("/** @see #" + getter(field) + " */");
			line("public static final String " + constant(field) + " = " + fieldNameString(field) + ";");
		}
	}

	private void jsonReadField(Field field) {
		Type type = field.getType();
		if (field.isRepeated()) {
			line("case " + constant(field) + ": {");
			{
				line("in.beginArray();");
				line("while (in.hasNext()) {");
				{
					line(adderName(field) + "(" + jsonReadEntry(type) + ");");
				}
				line("}");
				line("in.endArray();");
			}
			line("}");
			line("break;");
		} else if (type instanceof MapType) {
			MapType mapType = (MapType) type;
			line("case " + constant(field) + ": {");
			{
				Type keyType = mapType.getKeyType();
				Type valueType = mapType.getValueType();
				if (keyType instanceof PrimitiveType && ((PrimitiveType) keyType).getKind() == Kind.STRING) {
					line("in.beginObject();");
					line("while (in.hasNext()) {");
					{
						line(adderName(field) + "(in.nextName(), " + jsonReadEntry(valueType) + ");");
					}
					line("}");
					line("in.endObject();");
				} else {
					line("in.beginArray();");
					line("while (in.hasNext()) {");
					{
						line("in.beginObject();");
						line(getType(keyType) + " key = " + defaultValue(keyType) + ";");
						line(getType(valueType) + " value = " + defaultValue(valueType) + ";");
						line("while (in.hasNext()) {");
						{
							line("switch (in.nextName()) {");
							line("case \"key\": key = " + jsonReadEntry(keyType) + "; break;");
							line("case \"value\": value = " + jsonReadEntry(valueType) + "; break;");
							line("default: in.skipValue(); break;");
							line("}");
						}
						line("}");
						line(adderName(field) + "(key, value);");
						line("in.endObject();");
					}
					line("}");
					line("in.endArray();");
				}
			}
			line("break;");
			line("}");
		} else {
			line("case " + constant(field) + ": " + setterName(field) + "(" + jsonReadEntry(type) + "); break;");
		}
	}

	private String jsonReadEntry(Type type) {
		if (type instanceof PrimitiveType) {
			return jsonType(((PrimitiveType) type).getKind());
		}
		else if (type instanceof CustomType) {
			CustomType messageType = (CustomType) type;
			QName name = messageType.getName();
			return Util.qName(name) + "." + readerName(Util.last(name)) +  "(in)";
		}
		throw new RuntimeException("Unsupported: " + type);
	}
	
	private String jsonType(PrimitiveType.Kind primitive) {
		switch (primitive) {
		case BOOL: 
			return "in.nextBoolean()";

		case FLOAT:
			return "(float) in.nextDouble()";
		case DOUBLE: 
			return "in.nextDouble()";
		
		case INT32:
		case SINT32:
		case UINT32:
		case FIXED32: 
		case SFIXED32:
			return "in.nextInt()";
		
		case INT64:
		case SINT64:
		case UINT64:
		case FIXED64: 
		case SFIXED64: 
			return "in.nextLong()";
		
		case STRING:
			return "de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)";
			
		case BYTES:
			return "de.haumacher.msgbuf.json.JsonUtil.nextBinaryOptional(in)";
		}			
		
		throw new RuntimeException("No such type: " + primitive);
	}

	private void binaryIO() {
		if (!_binary) {
			return;
		}
		
		boolean baseClass = _def.getExtends() == null;
		List<Field> fields = _def.getFields();
		
		if (baseClass) {
			nl();
			line("@Override");
			line("public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {");
			{
				line("out.beginObject();");
				if (_def.isAbstract()) {
					line("out.name(0);");
					line("out.value(typeId());");
				}
				line("writeFields(out);");
				line("out.endObject();");
			}
			line("}");
		}
		
		if (baseClass) {
			if (_def.isAbstract()) {
				nl();
				line("/** The binary identifier for this concrete type in the polymorphic {@link " + _def.getName() + "} hierarchy. */");
				line("public abstract int typeId();");
			}
		} else {
			if (!_def.isAbstract() && root(_def).isAbstract()) {
				nl();
				line("@Override");
				line("public int typeId() {");
				{
					line("return " + _def.getId() + ";");				
				}
				line("}");
			}
		}
		
		if (baseClass || !fields.isEmpty()) {
			nl();
			if (baseClass) {
				line("/**");
				line(" * Serializes all fields of this instance to the given binary output.");
				line(" *");
				line(" * @param out");
				line(" *        The binary output to write to.");
				line(" * @throws java.io.IOException If writing fails.");
				line(" */");
			} else {
				line("@Override");
			}
			line("protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {");
			{
				if (!baseClass) {
					line("super.writeFields(out);");
				}
				if (fields.isEmpty()) {
					line("// No fields to write, hook for subclasses.");
				} else {
					for (Field field : fields) {
						if (field.isTransient()) {
							continue;
						}
						boolean nullable = isNullable(field);
						if (nullable) {
							line("if (" + hasName(field) + "()" + ") {");
						}
						{
							line("out.name(" + field.getIndex() + ");");
							if (field.isRepeated()) {
								line("{");
								{
									line(getType(field) + " values = " + getterName(field) + "();");
									line("out.beginArray(" + "de.haumacher.msgbuf.binary.DataType." + binaryType(field.getType()) + ", values.size());");
									line("for (" + getType(field.getType()) +" x : values) {");
									{
										binaryOutValue(field.getType(), "x");
									}
									line("}");
									line("out.endArray();");
								}
								line("}");
							} else {
								binaryOutValue(field.getType(), getter(field));
							}
						}
						if (nullable) {
							line("}");
						}
					}
				}
			}
			line("}");
			
			nl();
			if (baseClass) {
				line("/** Consumes the value for the field with the given ID and assigns its value. */");
			} else {
				line("@Override");
			}
			line("protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {");
			{
				line("switch (field) {");
				for (Field field : fields) {
					if (field.isTransient()) {
						continue;
					}
					binaryReadField(field);
				}
				if (baseClass) {
					line("default: in.skipValue(); ");
				} else {
					line("default: super.readField(in, field);");
				}
				line("}");
			}
			line("}");
		}
		
		nl();
		line("/** Reads a new instance from the given reader. */");
		line("public static " + _def.getName() + " " + readerName(_def) + "(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {");
		{
			line("in.beginObject();");
			if (_def.isAbstract()) {
				line(_def.getName() + " result;");
				line("int typeField = in.nextName();");
				line("assert typeField == 0;");
				line("int type = in.nextInt();");
				line("switch (type) {");
				for (MessageDef specialization : transitiveSpecializations(_def)) {
					if (specialization.isAbstract()) {
						continue;
					}
					line("case " + specialization.getId() + ": result = " + specialization.getName() + "." + factoryName(specialization) + "(); break;");
				}
				line("default: while (in.hasNext()) {in.skipValue(); } in.endObject(); return null;");
				line("}");
			} else {
				line(_def.getName() + " result = new " + _def.getName() + "();");
			}
			
			line("while (in.hasNext()) {");
			{
				line("int field = in.nextName();");
				line("result.readField(in, field);");
			}
			line("}");

			line("in.endObject();");
			line("return result;");
		}
		line("}");
	}

	private void binaryReadField(Field field) {
		Type type = field.getType();
		if (field.isRepeated()) {
			line("case " + field.getIndex() + ": {");
			{
				line("in.beginArray();");
				line("while (in.hasNext()) {");
				{
					line(adderName(field) + "(" + binaryReadEntry(type) + ");");
				}
				line("}");
				line("in.endArray();");
			}
			line("}");
			line("break;");
		} else if (type instanceof MapType) {
			MapType mapType = (MapType) type;
			line("case " + field.getIndex() + ": {");
			{
				Type keyType = mapType.getKeyType();
				Type valueType = mapType.getValueType();
				
				line("in.beginArray();");
				line("while (in.hasNext()) {");
				{
					line("in.beginObject();");
					line(getType(keyType) + " key = " + defaultValue(keyType) + ";");
					line(getType(valueType) + " value = " + defaultValue(valueType) + ";");
					line("while (in.hasNext()) {");
					{
						line("switch (in.nextName()) {");
						line("case 1: key = " + binaryReadEntry(keyType) + "; break;");
						line("case 2: value = " + binaryReadEntry(valueType) + "; break;");
						line("default: in.skipValue(); break;");
						line("}");
					}
					line("}");
					line(adderName(field) + "(key, value);");
					line("in.endObject();");
				}
				line("}");
				line("in.endArray();");
			}
			line("break;");
			line("}");
		} else {
			line("case " + field.getIndex() + ": " + setterName(field) + "(" + binaryReadEntry(type) + "); break;");
		}
	}

	private String binaryReadEntry(Type type) {
		if (type instanceof PrimitiveType) {
			return binaryReadValue(((PrimitiveType) type).getKind());
		}
		else if (type instanceof CustomType) {
			CustomType messageType = (CustomType) type;
			QName name = messageType.getName();
			return Util.qName(name) + "." + readerName(Util.last(name)) +  "(in)";
		}
		throw new RuntimeException("Unsupported: " + type);
	}

	private String binaryReadValue(Kind kind) {
		switch (kind) {
		case BOOL: 
			return "in.nextBoolean()";
		case FLOAT:
			return "in.nextFloat()";
		case DOUBLE: 
			return "in.nextDouble()";
		case INT32:
		case UINT32:
			return "in.nextInt()";
		case SINT32:
			return "in.nextIntSigned()";
		case FIXED32: 
		case SFIXED32:
			return "in.nextIntFixed()";
		
		case INT64:
		case UINT64:
			return "in.nextLong()";
			
		case SINT64:
			return "in.nextLongSigned()";

		case FIXED64: 
		case SFIXED64: 
			return "in.nextLongFixed()";
		
		case STRING:
			return "in.nextString()";
			
		case BYTES:
			return "in.nextBinary()";
		}			
		
		throw new RuntimeException("No such type: " + kind);
	}

	private static MessageDef root(MessageDef def) {
		MessageDef extendedDef = def.getExtendedDef();
		if (extendedDef == null) {
			return def;
		} else {
			return root(extendedDef);
		}
	}

	private List<MessageDef> transitiveSpecializations(MessageDef def) {
		ArrayList<MessageDef> result = new ArrayList<MessageDef>(def.getSpecializations());
		int n = 0;
		while (n < result.size()) {
			result.addAll(result.get(n++).getSpecializations());
		}
		return result;
	}

	private String fieldNameString(Field field) {
		Optional<Option> fieldName = field.getOptions().stream().filter(opt -> opt.getName().equals("Name")).findFirst();
		String name = fieldName.isPresent() ? ((StringOption) fieldName.get()).getValue() : field.getName();
		return "\"" + name + "\"";
	}

	private DataType binaryType(Type type) {
		if (type instanceof PrimitiveType) {
			return binaryType(((PrimitiveType) type).getKind());
		} else if (type instanceof CustomType) {
			Definition definition = ((CustomType) type).getDefinition();
			if (definition instanceof EnumDef) {
				return DataType.INT; 
			} else {
				return DataType.OBJECT;
			}
		} else {
			return DataType.OBJECT;
		}
	}
	
	private DataType binaryType(PrimitiveType.Kind primitive) {
		switch (primitive) {
		case BOOL: 
			return DataType.INT;

		case FLOAT:
			return DataType.FLOAT;
		case DOUBLE: 
			return DataType.DOUBLE;
		
		case INT32:
		case UINT32:
			return DataType.INT;
		case SINT32:
			return DataType.SINT;
		case FIXED32: 
		case SFIXED32:
			return DataType.FINT;
		
		case INT64:
		case UINT64:
			return DataType.LONG;
		case SINT64:
			return DataType.SLONG;
		case FIXED64: 
		case SFIXED64: 
			return DataType.FLONG;
		
		case STRING:
			return DataType.STRING;
			
		case BYTES:
			return DataType.BINARY;
		}			
		
		throw new RuntimeException("No such type: " + primitive);
	}

	private void binaryOutValue(Type type, String x) {
		if (type instanceof PrimitiveType) {
			line("out.value(" + x + ");");
		} else if (type instanceof CustomType) {
			line(x + ".writeTo(out);");
		} else {
			// TODO
		}
	}
	
	private void jsonOutValue(Type type, String x) {
		jsonOutValue(type, x, 0);
	}
	
	private void jsonOutValue(Type type, String x, int depth) {
		if (type instanceof PrimitiveType) {
			switch (((PrimitiveType) type).getKind()) {
			case BYTES: {
				line("de.haumacher.msgbuf.json.JsonUtil.writeBinaryOptional(out, " + x + ");");
				break;
			}
			default: {
				line("out.value(" + x + ");");
				break;
			}
			}
		} else if (type instanceof CustomType) {
			CustomType customType = (CustomType) type;
			if (isMonomorphicReferenceToTypeInPolymorphicHierarchy(customType)) { 
				line(x + ".writeContent(out);");
			} else {
				line(x + ".writeTo(out);");
			}
		} else if (type instanceof MapType) {
			MapType mapType = (MapType) type;
			
			Type keyType = mapType.getKeyType();
			Type valueType = mapType.getValueType();
			if (keyType instanceof PrimitiveType && ((PrimitiveType) keyType).getKind() == Kind.STRING) {
				line("out.beginObject();");
				String entry = "entry";
				if (depth > 0) {
					entry += depth;
				}
				line("for (" + entryType(mapType) + " " + entry + " : " + x + ".entrySet()) {");
				{
					line("out.name(" + entry + ".getKey()" + ");");
					jsonOutValue(valueType, entry + ".getValue()", depth + 1);
				}
				line("}");
				line("out.endObject();");
			} else {
				line("out.beginArray();");
				String entry = "entry";
				if (depth > 0) {
					entry += depth;
				}
				line("for (" + entryType(mapType) + " " + entry + " : " + x + ".entrySet()) {");
				{
					line("out.beginObject();");
					line("out.name(\"key\");");
					jsonOutValue(keyType, entry + ".getKey()", depth + 1);
					line("out.name(\"value\");");
					jsonOutValue(valueType, entry + ".getValue()", depth + 1);
					line("out.endObject();");
				}
				line("}");
				line("out.endArray();");
			}
		} else {
			throw new RuntimeException("Unsupported: " + type);
		}
	}

	private boolean isMonomorphicReferenceToTypeInPolymorphicHierarchy(CustomType customType) {
		Definition definition = customType.getDefinition();
		if (definition instanceof MessageDef) {
			MessageDef messageDef = (MessageDef) definition;
			
			if (messageDef.getExtendedDef() != null && !messageDef.isAbstract()) {
				return true;
			}
		}
		return false;
	}

	private String entryType(MapType mapType) {
		return "java.util.Map.Entry" + "<" + getTypeWrapped(mapType.getKeyType()) + "," + getTypeWrapped(mapType.getValueType()) + ">";
	}

	static String readerName(Definition def) {
		return readerName(def.getName());
	}

	static String readerName(String name) {
		return "read" + name;
	}


	private String cast(Field field, String var) {
		return "(" + getType(field) + ") " + var;
	}

	@Override
	public Void visit(EnumDef def, Void arg) {
		new EnumGenerator(def).generateInner(this);
		return null;
	}
	
	@Override
	public Void visit(MessageDef def, Void arg) {
		new MessageGenerator(_table, def).generateInner(this);
		return null;
	}

	private void generateFieldDef(Field field) {
		nl();
		line("private" + getTransient(field) + getFinal(field) +  " " + getType(field) + " " + "_" + name(field) + getInitializer(field) + ";");
	}

	private String getTransient(Field field) {
		return field.isTransient() ? " transient" : "";
	}

	private String getFinal(Field field) {
		return field.isRepeated() ? " final" : "";
	}
	
	private String getInitializer(Field field) {
		return " = " + defaultValue(field);
	}
	
	private String defaultValue(Field field) {
		if (field.isRepeated()) {
			return "new java.util.ArrayList<>()";
		} else {
			return defaultValue(field.getType());
		}
	}
	
	static final Type.Visitor<String, Void> DEFAULT_VALUE = new Type.Visitor<String, Void>() {

		@Override
		public String visit(CustomType self, Void arg) {
			Definition definition = self.getDefinition();
			if (definition instanceof EnumDef) {
				return definition.getName() + "." + ((EnumDef) definition).getConstants().get(0).getName();
			} else {
				return "null";
			}
		}

		@Override
		public String visit(PrimitiveType self, Void arg) {
			switch (self.getKind()) {
			case BOOL: return "false";
			case BYTES: return "null";
			case DOUBLE: return "0.0d";
			case FLOAT: return "0.0f";
			case STRING: return "\"\"";
			case INT32:
			case SINT32:
			case UINT32:
			case FIXED32: 
			case SFIXED32:
				return "0";
			case INT64:
			case SINT64:
			case UINT64:
			case FIXED64:
			case SFIXED64:
				return "0L";
			}
			throw new UnsupportedOperationException("Unsupported type: " + self.getKind());
		}

		@Override
		public String visit(MapType self, Void arg) {
			return "new java.util.HashMap<>()";
		}
	};
	
	private String defaultValue(Type type) {
		return type.visit(DEFAULT_VALUE, null);
	}

	private String getType(Field field) {
		return field.isRepeated() ? "java.util.List<" + getTypeWrapped(field.getType()) + ">" : getType(field.getType());
	}

	private String getType(Type type) {
		return type.visit(this, Boolean.FALSE);
	}
	
	private String getTypeWrapped(Type type) {
		return type.visit(this, Boolean.TRUE);
	}
	
	@Override
	public String visit(MapType type, Boolean wrapped) {
		return "java.util.Map<" + getTypeWrapped(type.getKeyType()) + ", " + getTypeWrapped(type.getValueType()) + ">";
	}
	
	@Override
	public String visit(CustomType type, Boolean wrapped) {
		return Util.qName(type.getName());
	}
	
	@Override
	public String visit(PrimitiveType type, Boolean wrapped) {
		switch (type.getKind()) {
		case BOOL:
			return wrapped ? "Boolean" : "boolean";
		case BYTES:
			return "byte[]";
		case FLOAT:
			return wrapped ? "Float" : "float";
		case DOUBLE:
			return wrapped ? "Double" : "double";
		case INT32:
		case UINT32:
		case FIXED32:
		case SINT32:
		case SFIXED32:
			return wrapped ? "Integer" : "int";
		case INT64:
		case UINT64:
		case FIXED64:
		case SINT64:
		case SFIXED64:
			return wrapped ? "Long" : "long";
		case STRING:
			return "String";
		}
		throw new RuntimeException("No such type: " + type.getKind());
	}

	private void generateFieldAccessor(Field field) {
		nl();
		docComment(field.getComment());
		line("public final " + getType(field) + " " + getterName(field) + "()" + " {");
		line("return " + "_" + name(field) + ";");
		line("}");
		
		nl();
		line("/**");
		line(" * @see #" + getterName(field) + "()");
		line(" */");
		line("public final " + _def.getName() + " " + setterName(field) + "(" + getType(field) + " " + "value" + ")" + " {");
		Type type = field.getType();
		{
			if (field.isRepeated()) {
				line("_" + name(field) + ".clear();");
				line("_" + name(field) + ".addAll(value);");
			} else if (type instanceof MapType) {
				line("_" + name(field) + ".clear();");
				line("_" + name(field) + ".putAll(value);");
			} else {
				line("_" + name(field) + " = " + "value" + ";");
			}
			line("return this;");
		}
		line("}");
		
		if (field.isRepeated()) {
			nl();
			line("/**");
			line(" * Adds a value to the {@link #" + getterName(field) + "()"+ "} list.");
			line(" */");
			line("public final " + _def.getName() + " " + adderName(field) + "(" + getType(type) + " " + "value" + ")" + " {");
			{
				line("_" + name(field) + ".add(value);");
				line("return this;");
			}
			line("}");
		}
		else if (type instanceof MapType) {
			MapType mapType = (MapType) type;
			nl();
			line("/**");
			line(" * Adds a value to the {@link #" + getterName(field) + "()"+ "} map.");
			line(" */");
			line("public final " + "void" + " " + adderName(field) + "(" + getType(mapType.getKeyType()) + " key" + ", " + getType(mapType.getValueType()) + " value" + ")" + " {");
			{
				line("if (" + "_" + name(field) + ".containsKey(key)) {");
				{
					line("throw new IllegalArgumentException(\"Property '" + field.getName() + "' already contains a value for key '\" + key + \"'.\");");
				}
				line("}");
				line("_" + name(field) + ".put(key, value);");
			}
			line("}");
		}
		
		if (isNullable(field)) {
			nl();
			line("/**");
			line(" * Checks, whether {@link #" + getterName(field) + "()"+ "} has a value.");
			line(" */");
			line("public final " + "boolean" + " " + hasName(field) + "()" + " {");
			{
				line("return _" + name(field) + " != null;");
			}
			line("}");
		}
	}

	private boolean isNullable(Field field) {
		return field.getType() instanceof CustomType && !field.isRepeated();
	}

	private String setterName(Field field) {
		return "set" + suffix(field);
	}

	private String hasName(Field field) {
		return "has" + suffix(field);
	}
	
	private String adderName(Field field) {
		String suffix = suffix(field);
		if (suffix.endsWith("s")) {
			suffix = suffix.substring(0, suffix.length() - 1);
		}
		return "add" + suffix;
	}
	
	private String getterName(Field field) {
		Type type = field.getType();
		if (type instanceof PrimitiveType && ((PrimitiveType) type).getKind() == PrimitiveType.Kind.BOOL) {
			return "is" + suffix(field);
		} else {
			return "get" + suffix(field);
		}
	}

	private String name(Field field) {
		return firstLowerCase(camelCase(field.getName()));
	}

	private static String camelCase(String name) {
		StringBuilder result = new StringBuilder();
		for (String part : name.split("_+")) {
			result.append(firstUpperCase(part));
		}
		return result.toString();
	}

	private static String allUpperCase(String name) {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (String part : NAME_PART_PATTERN.split(name)) {
			if (first) {
				first = false;
			} else {
				result.append('_');
			}
			result.append(part.toUpperCase());
		}
		return result.toString();
	}
	
	private String constant(Field field) {
		return allUpperCase(field.getName());
	}
	
	private String suffix(Field field) {
		return camelCase(field.getName());
	}

	private static String firstUpperCase(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}
	
	private String firstLowerCase(String name) {
		return Character.toLowerCase(name.charAt(0)) + name.substring(1);
	}
	

}
