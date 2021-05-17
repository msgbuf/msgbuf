/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import java.util.ArrayList;
import java.util.List;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.Field;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.ast.Type;

/**
 * TODO
 */
public class MessageGenerator extends AbstractFileGenerator implements Type.Visitor<String, Void>, Definition.Visitor<Void, Void> {

	private MessageDef _def;

	/** 
	 * Creates a {@link MessageGenerator}.
	 *
	 * @param def
	 */
	public MessageGenerator(MessageDef def) {
		_def = def;
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
		line("public" + modifier + getAbstract() + " class " + camelCase(_def.getName()) + getExtends() + " {");
		generateContents();
		nl();
		line("}");
	}

	private String getAbstract() {
		return _def.isAbstract() ? " abstract" : "";
	}

	private String getExtends() {
		return _def.getExtends() == null ? "" : " extends " + Util.qName(_def.getExtends());
	}

	private void generateContents() {
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
			line("public static " + _def.getName() + " " + firstLowerCase(_def.getName()) + "() {");
			{
				line("return new " + _def.getName() + "();");
			}
			line("}");
		}
		
		nl();
		line("/**");
		line(" * Creates a {@link " + _def.getName() + "} instance.");
		line(" *");
		line(" * @see #" + firstLowerCase(_def.getName()) + "()");
		line(" */");
		line("protected " + _def.getName() + "() {");
		{
			line("super();");
		}
		line("}");

		for (Field field : _def.getFields()) {
			generateFieldDef(field);
		}
		
		for (Field field : _def.getFields()) {
			generateFieldAccessor(field);
		}
		
		generateReflectionAccess();
		
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
		
		nl();
		lineStart("private static final int[] FIELDS = {");
		List<Field> fields = _def.getFields();
		for (Field field : fields) {
			append(field.getIndex() + ", ");
		}
		append("};");
		nl();
		
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
				line("result.readContent(in);");
			}
			line("return result;");
		}
		line("}");
		
		if (baseClass) {
			nl();
			line("/** Writes this instance to the given output. */");
			line("public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {");
			{
				line("out.beginObject();");
				line("writeContent(out);");
				line("out.endObject();");
			}
			line("}");
			
			nl();
			line("/** Reads all fields of this instance from the given input. */");
			line("protected final void readContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {");
			{
				line("while (in.hasNext()) {");
				{
					line("String field = in.nextName();");
					line("readField(in, field);");
				}
				line("}");
			}
			line("}");
		}
		
		if (!fields.isEmpty() || baseClass) {
			nl();
			if (baseClass) {
				line("/** Retrieves value of the field with the given index. */");
			} else {
				line("@Override");
			}
			line("public Object get(String field) {");
			{
				line("switch (field) {");
				for (Field field : fields) {
					line("case " + fieldNameString(field) + ": return " + getterName(field) + "()" + ";");
				}
				if (baseClass) {
					line("default: return null;");
				} else {
					line("default: return super.get(field);");
				}
				line("}");
			}
			line("}");
			
			nl();
			if (baseClass) {
				line("/** Sets the value of the field with the given index. */");
			} else {
				line("@Override");
			}
			line("public void set(String field, Object value) {");
			{
				if (fields.isEmpty()) {
					line("// No fields.");
				} else {
					line("switch (field) {");
					for (Field field : fields) {
						line("case " + fieldNameString(field) + ": " + setterName(field) + "(" + cast(field, "value") + ")" + "; break;");
					}
					if (!baseClass) {
						line("default: super.set(field, value); break;");
					}
					line("}");
				}
			}
			line("}");
			
			nl();
			if (baseClass) {
				line("/** Writes all fields of this instance to the given output. */");
			} else {
				line("@Override");
			}
			line("protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {");
			{
				if (!baseClass) {
					line("super.writeContent(out);");
				}
				if (fields.isEmpty()) {
					line("// No fields.");
				} else {
					for (Field field : fields) {
						if (field.isTransient()) {
							continue;
						}
						boolean nullable = isNullable(field);
						if (nullable) {
							line("if (" + hasName(field) + "()" + ") {");
						}
						line("out.name(" + fieldNameString(field) + ");");
						if (field.isRepeated()) {
							line("out.beginArray();");
							line("for (" + getType(field.getType()) +" x : " + getterName(field) + "()" + ") {");
							{
								line(jsonOut(field.getType(), "x") + ";");
							}
							line("}");
							line("out.endArray();");
						} else {
							line(jsonOut(field.getType(), getterName(field) + "()") + ";");
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
				line("/** Reads the given field from the given input. */");
			} else {
				line("@Override");
			}
			line("protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {");
			{
				line("switch (field) {");
				for (Field field : fields) {
					if (field.isTransient()) {
						continue;
					}
					if (field.isRepeated()) {
						line("case " + fieldNameString(field) + ": {");
						{
							line("in.beginArray();");
							line("while (in.hasNext()) {");
							{
								line(adderName(field) + "(" + jsonType(field) + ");");
							}
							line("}");
							line("in.endArray();");
						}
						line("}");
						line("break;");
					} else {
						line("case " + fieldNameString(field) + ": " + setterName(field) + "(" + jsonType(field) + "); break;");
					}
				}
				if (baseClass) {
					line("default: in.skipValue();");
				} else {
					line("default: super.readField(in, field);");
				}
				line("}");
			}
			line("}");
		}
	}

	/** 
	 * TODO
	 */
	private List<MessageDef> transitiveSpecializations(MessageDef def) {
		ArrayList<MessageDef> result = new ArrayList<MessageDef>(def.getSpecializations());
		int n = 0;
		while (n < result.size()) {
			result.addAll(result.get(n++).getSpecializations());
		}
		return result;
	}

	private String fieldNameString(Field field) {
		return "\"" + field.getName() + "\"";
	}

	private String jsonOut(Type type, String x) {
		if (type instanceof PrimitiveType) {
			return "out.value(" + x + ")";
		} else if (type instanceof CustomType) {
			return x + ".writeTo(out)";
		} else {
			throw new RuntimeException("Unsupported: " + type);
		}
	}

	static String readerName(Definition def) {
		return readerName(def.getName());
	}

	static String readerName(String name) {
		return "read" + name;
	}

	private String jsonType(Field field) {
		Type type = field.getType();
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
			return "in.nextString()";
			
		case BYTES:
			return "java.util.Base64.getDecoder().decode(in.nextString())";
		}			
		
		throw new RuntimeException("No such type: " + primitive);
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
		new MessageGenerator(def).generateInner(this);
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
		if (field.isRepeated()) {
			return " = new java.util.ArrayList<>()";
		}
		Type type = field.getType();
		if (type instanceof CustomType) {
			Definition definition = ((CustomType) type).getDefinition();
			if (definition instanceof EnumDef) {
				return " = " + definition.getName() + "." + ((EnumDef) definition).getConstants().get(0).getName();
			}
		}
		
		return "";
	}

	private String getType(Field field) {
		return field.isRepeated() ? "java.util.List<" + getType(field.getType()) + ">" : getType(field.getType());
	}

	private String getType(Type type) {
		return type.visit(this, null);
	}
	
	@Override
	public String visit(MapType type, Void arg) {
		return "java.util.Map<" + type.getKeyType().visit(this, null) + ", " + type.getValueType().visit(this, null) + ">";
	}
	
	@Override
	public String visit(CustomType type, Void arg) {
		return Util.qName(type.getName());
	}
	
	@Override
	public String visit(PrimitiveType type, Void arg) {
		switch (type.getKind()) {
		case BOOL:
			return "boolean";
		case BYTES:
			return "byte[]";
		case FLOAT:
			return "float";
		case DOUBLE:
			return "double";
		case INT32:
		case UINT32:
		case FIXED32:
		case SINT32:
		case SFIXED32:
			return "int";
		case INT64:
		case UINT64:
		case FIXED64:
		case SINT64:
		case SFIXED64:
			return "long";
		case STRING:
			return "String";
		}
		throw new RuntimeException("No such type: " + type.getKind());
	}

	private void generateFieldAccessor(Field field) {
		nl();
		line("public final " + getType(field) + " " + getterName(field) + "()" + " {");
		line("return " + "_" + name(field) + ";");
		line("}");
		
		nl();
		line("/**");
		line(" * @see #" + getterName(field) + "()");
		line(" */");
		line("public final " + _def.getName() + " " + setterName(field) + "(" + getType(field) + " " + "value" + ")" + " {");
		{
			if (field.isRepeated()) {
				line("_" + name(field) + ".clear();");
				line("_" + name(field) + ".addAll(value);");
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
			line("public final " + "void" + " " + adderName(field) + "(" + getType(field.getType()) + " " + "value" + ")" + " {");
			line("_" + name(field) + ".add(value);");
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

	private String camelCase(String name) {
		StringBuilder result = new StringBuilder();
		for (String part : name.split("_+")) {
			result.append(firstUpperCase(part));
		}
		return result.toString();
	}

	private String suffix(Field field) {
		return camelCase(field.getName());
	}

	private String firstUpperCase(String name) {
		return Character.toUpperCase(name.charAt(0)) + name.substring(1);
	}
	
	private String firstLowerCase(String name) {
		return Character.toLowerCase(name.charAt(0)) + name.substring(1);
	}
	

}
