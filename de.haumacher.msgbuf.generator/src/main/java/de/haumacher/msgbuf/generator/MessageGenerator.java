/*
 * Copyright (c) 2021 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator;

import static de.haumacher.msgbuf.generator.CodeConvention.*;
import static de.haumacher.msgbuf.generator.DefaultValueGenerator.*;
import static de.haumacher.msgbuf.generator.TypeGenerator.*;
import static de.haumacher.msgbuf.generator.util.CodeUtil.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
import de.haumacher.msgbuf.generator.ast.WithOptions.TypeKind;
import de.haumacher.msgbuf.generator.common.MsgBufJsonProtocol;
import de.haumacher.msgbuf.generator.common.Util;
import de.haumacher.msgbuf.generator.util.CodeUtil;

/**
 * {@link Generator} for message data classes.
 */
public class MessageGenerator extends AbstractMessageGenerator implements Definition.Visitor<Void, Void> {

	private final NameTable _table;
	private final MessageDef _def;
	private final GeneratorPlugin _plugin;
	
	private boolean _graph;
	private boolean _json;
	private boolean _binary;
	private boolean _reflection;
	private boolean _visitor;
	private boolean _visitEx;
	private boolean _typeKind;

	private Map<String, Option> _options;
	private boolean _listener;
	private boolean _interface;

	/** 
	 * Creates a {@link MessageGenerator}.
	 */
	public MessageGenerator(NameTable table, Map<String, Option> options, boolean isInterface, MessageDef def, GeneratorPlugin plugin) {
		super(options);
		_table = table;
		_options = options;
		_interface = isInterface;
		_def = def;
		_plugin = plugin;
		_graph = isTrue(options.get("SharedGraph"), false);
		_json = _graph || !isTrue(options.get("NoJson"), false);
		_binary = !_graph && !isTrue(options.get("NoBinary"), false);
		_listener = _graph || !isTrue(options.get("NoListener"), false);
		_reflection = _listener || !isTrue(options.get("NoReflection"), false);
		_visitor = !isTrue(options.get("NoVisitor"), false);
		_visitEx= !isTrue(options.get("NoVisitorExceptions"), false);
		_typeKind = !isTrue(options.get("NoTypeKind"), false);
	}
	
	/**
	 * Whether to generate JSON serialization code.
	 */
	public boolean isJson() {
		return _json;
	}
	
	/**
	 * @see #isJson()
	 */
	public void setJson(boolean json) {
		_json = json;
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
				line("package " + packageName(packageName) + ";");
				nl();
			}
			modifier = "";
		} else {
			modifier = _interface ? "" : "static";
		}
		docComment(_def.getComment());
		line((_interface || _noInterfaces ? "public" : ""), modifier, mkAbstract(), (_interface ? "interface" : "class"), (_interface || _noInterfaces ? typeName(_def) : implName(_def)), getExtends(), getImplements(), "{");
		generateClassContents();
		nl();
		line("}");
	}
	
	private String mkAbstract() {
		return !_interface && _def.isAbstract() ? "abstract" : "";
	}

	private String getExtends() {
		List<String> generalizations = new ArrayList<>();
		if (isBaseClass()) {
			if (_graph) {
				generalizations.add(_interface ? 
						"de.haumacher.msgbuf.graph.SharedGraphNode" :
						"de.haumacher.msgbuf.graph.AbstractSharedGraphNode");
			} else {
				if (_json) {
					generalizations.add(_interface ?
							"de.haumacher.msgbuf.data.DataObject" :
							"de.haumacher.msgbuf.data.AbstractDataObject");
				}
			}
		} else {
			generalizations.add(_interface || _noInterfaces ? qTypeName(_def.getExtends()) : implName(_def.getExtendedDef()));
		}
		
		if (_interface) {
			if (isBaseClass()) {
				addImplements(generalizations);
			}
			addMixins(generalizations);
		}

		return generalizationList("extends", generalizations);
	}
	
	private String getImplements() {
		if (_interface) {
			return "";
		}
		
		List<String> generalizations = new ArrayList<>();
		if (_noInterfaces) {
			if (isBaseClass()) {
				addImplements(generalizations);
			}
			addMixins(generalizations);
		} else {
			generalizations.add(typeName(_def));
		}
		
		return generalizationList("implements", generalizations);
	}
	
	private void addImplements(List<String> generalizations) {
		if (_binary) {
			generalizations.add("de.haumacher.msgbuf.binary.BinaryDataObject");
		}
		if (!_graph) {
			if (_listener) {
				generalizations.add("de.haumacher.msgbuf.observer.Observable");
			} else if (_reflection) {
				generalizations.add("de.haumacher.msgbuf.data.ReflectiveDataObject");
			}
		}
	}

	private void addMixins(List<String> generalizations) {
		_plugin.addInterfaces(_options, _def, generalizations);

		Option operations = _def.getOptions().get("Operations");
		if (operations != null) {
			if (operations instanceof StringOption) {
				StringOption singleOperation = (StringOption) operations;
				generalizations.add(singleOperation.getValue());
			} else {
				System.err.println("String option '" + "Operations" + "' expected, got: " + operations);
			}
		}
	}
	
	private String generalizationList(String keyword, List<String> generalizations) {
		if (generalizations.isEmpty()) {
			return "";
		}
		return keyword + " " + generalizations.stream().collect(Collectors.joining(", "));
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
			Field field = def instanceof MessageDef ? CodeConvention.getField((MessageDef) def, name) : null;
			String replacement = (type == null ? "" : type) + "#";
			if (field == null) {
				replacement += name;
			} else {
				replacement += getterCall(field);
			}
			
			matcher.appendReplacement(buffer, replacement);
		}
		matcher.appendTail(buffer);
		
		super.docComment(buffer.toString());
	}

	private void generateClassContents() {
		if (_interface || _noInterfaces) {
			if (_typeKind) {
				generateTypeCodeEnum();
			}
			if (_visitor) {
				generateVisitorInterface();
			}
		}
		generateInnerDefinitions();
		if (_interface || _noInterfaces) {
			generateFactoryMethod();
		}
		generateConstants();
		
		if (!_interface) {
			generateFieldMembers();
			generateConstructor();
		}
		if (_typeKind) {
			generateKindLookup();
		}
		generateAccessors();
		generatedSetterOverrides();
		
		if (_listener) {
			generateListener();
		}
		if (_reflection || _json) {
			reflectionType();
		}
		if (_reflection) {
			if (!_interface) {
				generateReflection();
			}
		}
		
		if (_json) {
			generateJson();
		}
		
		if (_binary) {
			generateBinaryIO();
		}
		
		if (!_interface) {
			include(_plugin.messageImplContents(getOptions(), _def));
		}

		if (_interface || _noInterfaces) {
			include(_plugin.messageInterfaceContents(getOptions(), _def));
		}
		
		if (_visitor) {
			generateVisitMethods();
		}
	}

	private void generateTypeCodeEnum() {
		if (!_def.getSpecializations().isEmpty() && _def == getRoot(_def)) {
			nl();
			line("/** Type codes for the {@link " + typeName(_def) + "} hierarchy. */");
			line("public enum " + TYPE_KIND_NAME + " {");
			for (MessageDef caseDef : concreteSpecializations(_def)) {
				nl();
				line("/** Type literal for {@link " + typeName(caseDef) + "}. */");
				line(typeKindConstant(caseDef) + ",");
			}
			line(";");
			nl();
			line("}");
		}
	}

	private void generateVisitorInterface() {
		if (_def.isAbstract()) {
			nl();
			line("/** Visitor interface for the {@link " + typeName(_def) + "} hierarchy.*/");
			lineStart("public interface Visitor<R,A" + onVisitEx(",E extends Throwable") + ">");
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
				append(typeName(specialization) + ".Visitor<R,A" + onVisitEx(",E") + ">");
			}
			append(" {");
			nl();
			{
				boolean hasCase = false;
				for (MessageDef specialization : _def.getSpecializations()) {
					if (specialization.isAbstract()) {
						continue;
					}
	
					nl();
					line("/** Visit case for {@link " + typeName(specialization) + "}.*/");
					line("R visit(" + typeName(specialization) + " self, A arg)" + onVisitEx(" throws E") + ";");
					
					hasCase = true;
				}
				
				if (!hasCase) {
					nl();
					line("// Pure sum interface.");
				}
			}
			nl();
			line("}");
		}
	}

	private void generateInnerDefinitions() {
		for (Definition def : _def.getDefinitions()) {
			def.visit(this, null);
		}
	}

	@Override
	public Void visit(EnumDef def, Void arg) {
		if (_interface || _noInterfaces) {
			include(new EnumGenerator(def));
		}
		return null;
	}

	@Override
	public Void visit(MessageDef def, Void arg) {
		include(new MessageGenerator(_table, _options, _interface, def, _plugin));
		return null;
	}

	private void generateFactoryMethod() {
		if (!_def.isAbstract()) {
			nl();
			line("/**");
			line(" * Creates a {@link " + typeName(_def) + "} instance.");
			line(" */");
			line((_noInterfaces ? "public " : "") + "static " + typeName(_def) + " " + factoryName(_def) + "() {");
			{
				line("return new " + qImplName(_def) + "();");
			}
			line("}");
		}
	}

	private void generateConstants() {
		if (_interface || _noInterfaces) {
			if ((_json || _reflection) && !_def.isAbstract()) {
				nl();
				line("/** Identifier for the {@link " + typeName(_def) + "} type in JSON format. */");
				line((_noInterfaces ? "public " : "") + "static final String " + jsonTypeConstant(_def) + " = " + jsonTypeID(_def) + ";");
			}
		}
		
		if (_json || _reflection) {
			if (_interface || _noInterfaces) {
				String modifier = _reflection ? (_noInterfaces ? "public " : "") : "private ";
				
				for (Field field : getFields()) {
					if (!_reflection && field.isTransient()) {
						continue;
					}
					nl();
					line("/** @see #" + getterCall(field) + " */");
					line(modifier + "static final String " + constant(field) + " = " + getFieldNameString(field) + ";");
				}
			}
		}
		
		if (_binary && (_interface || _noInterfaces)) {
			if (!_def.isAbstract() && getRoot(_def).isAbstract()) {
				nl();
				line("/** Identifier for the {@link " + typeName(_def) + "} type in binary format. */");
				line("static final int " + mkBinaryTypeConstant(_def) + " = " + _def.getId() + ";");
			}
			
			for (Field field : getFields()) {
				if (field.isTransient() || field.isDerived()) {
					continue;
				}
				
				nl();
				line("/** Identifier for the property {@link #" + getterCall(field) + "} in binary format. */");
				line("static final int " + binaryConstant(field) + " = " + field.getIndex() + ";");
			}
		}
	}

	private String getFieldNameString(Field field) {
		return CodeUtil.stringLiteral(MsgBufJsonProtocol.fieldId(field));
	}

	private void generateConstructor() {
		nl();
		line("/**");
		line(" * Creates a {@link " + implName(_def) + "} instance.");
		if (!_def.isAbstract()) {
			line(" *");
			line(" * @see " + typeName(_def) + "#" + factoryName(_def) + "()");
		}
		line(" */");
		line("protected " + implName(_def) + "() {");
		{
			line("super();");
		}
		line("}");
	}

	private void generateFieldMembers() {
		for (Field field : getFields()) {
			nl();
			
			if (field.isRepeated()) {
				Field reverseEnd = reverseEnd(field);
				boolean hasReverseEnd = reverseEnd != null;
				if (_listener || hasReverseEnd) {
					String qFieldTypeName = mkTypeWrapped(field.getType());
					line("private" + mkTransient(field) + mkFinal(field) +  " " + mkType(field) + " " + fieldMemberName(field) + " = " + "new de.haumacher.msgbuf.util.ReferenceList<" + qFieldTypeName + ">() {");
					{
						line("@Override");
						line("protected void beforeAdd(int index, " + qFieldTypeName + " element) {");
						{
							if (_listener) {
								line("_listener.beforeAdd(" + implName(_def) + ".this, " + constant(field) + ", index, element);");
							}
							if (hasReverseEnd) {
								line("((" + mkTypeWrappedImpl(field.getType()) + ") element)." + adderName(reverseEnd) + "(" + implName(_def) + ".this);");
							}
						}
						line("}");
						nl();
						
						line("@Override");
						line("protected void afterRemove(int index, " + qFieldTypeName + " element) {");
						{
							if (hasReverseEnd) {
								line("((" + mkTypeWrappedImpl(field.getType()) + ") element)." + removerName(reverseEnd) + "(" + implName(_def) + ".this);");
							}
							if (_listener) {
								line("_listener.afterRemove(" + implName(_def) + ".this, " + constant(field) + ", index, element);");
							}
						}
						line("}");
					}
					line("};");
					continue;
				}
			}
			
			line("private" + mkTransient(field) + mkFinal(field) +  " " + mkType(field) + " " + fieldMemberName(field) + mkInitializer(field) + ";");
		}
	}

	private void generateKindLookup() {
		boolean hasSpecializations = !_def.getSpecializations().isEmpty();
		boolean hasTypeLookup = !isBaseClass() || hasSpecializations;
		
		if (hasTypeLookup) {
			if (_interface) {
				if (isBaseClass()) {
					nl();
					kindLookupComment();
					line(TYPE_KIND_NAME + " kind();");
				}
			} else {
				if (_def.isAbstract()) {
					if (isBaseClass()) {
						nl();
						kindLookupComment();
						line("public abstract " + TYPE_KIND_NAME + " kind();");
					}
				} else {
					nl();
					line("@Override");
					line("public " + TYPE_KIND_NAME + " kind() {");
					{
						line("return " + TYPE_KIND_NAME + "." + typeKindConstant(_def) + ";");
					}
					line("}");
				}
			}
		}
	}

	private void kindLookupComment() {
		line("/** The type code of this instance. */");
	}
	
	private void generateAccessors() {
		for (Field field : getFields()) {
			generateAccessors(field);
		}
	}

	private void generateAccessors(Field field) {
		accessorGetter(field);
		accessorSetter(field, false);
		if (!_interface) {
			accessorSetterImpl(field);
		}
		accessorAdder(field, false);
		accessorAdderImpl(field);
		accessorHasValue(field);
	}

	private void generatedSetterOverrides() {
		MessageDef anchestor = _def.getExtendedDef();
		while (anchestor != null) {
			for (Field field : anchestor.getFields()) {
				accessorSetter(field, true);
				accessorAdder(field, true);
			}
			
			anchestor = anchestor.getExtendedDef();
		}
	}

	private void accessorGetter(Field field) {
		nl();
		if (_interface) {
			docComment(field.getComment());
			line(mkType(field) + " " + getterName(field) + "();");
		} else {
			if (_noInterfaces) {
				docComment(field.getComment());
			} else {
				line("@Override");
			}
			line("public final " + mkType(field) + " " + getterName(field) + "()" + " {");
			line("return " + fieldMemberName(field) + ";");
			line("}");
		}
	}

	private void accessorSetter(Field field, boolean override) {
		if (_interface) {
			if (!field.isDerived()) {
				nl();
				if (override) {
					line("@Override");
				} else {
					setterDoc(field);
				}
				line(myType() + " " + setterName(field) + "(" + mkTypeReadOnly(field) + " " + "value" + ");");
			}
		} else {
			nl();
			if (!field.isDerived()) {
				if (!override && _noInterfaces) {
					setterDoc(field);
				} else {
					line("@Override");
				}
			}
			line(setterModifier(field) + myType() + " " + setterName(field) + "(" + mkTypeReadOnly(field) + " " + "value" + ")" + " {");
			{
				line(internalSetterName(field) + "(value);");
				generateChain();
			}
			line("}");
		}
	}

	private void setterDoc(Field field) {
		line("/**");
		line(" * @see #" + getterName(field) + "()");
		line(" */");
	}
	
	private void accessorSetterImpl(Field field) {
		nl();
		line("/** Internal setter for {@link #" + getterName(field) + "()} without chain call utility. */");
		line("protected final void " + internalSetterName(field) + "(" + mkTypeReadOnly(field) + " " + "value" + ")" + " {");
		Type type = field.getType();
		{
			if (!Util.isNullable(field) && !(type instanceof PrimitiveType)) {
				line("if (value == null) throw new IllegalArgumentException(" +
					stringLiteral("Property '" + field.getName() + "' cannot be null.") + ");");
			}
			
			if (field.isRepeated()) {
				setterReset(field);
				line(fieldMemberName(field) + ".addAll(value);");
			} else if (type instanceof MapType) {
				setterReset(field);
				line(fieldMemberName(field) + ".putAll(value);");
			} else {
				Field reverseEnd = reverseEnd(field);
				boolean hasReverseEnd = reverseEnd != null;
				
				if (_listener) {
					line("_listener.beforeSet(this, " + constant(field) + ", value);");
				}
				
				if (hasReverseEnd) {
					line("if (" + fieldMemberName(field) + " != null) {");
					{
						line("((" + mkTypeWrappedImpl(type) + ") " + fieldMemberName(field) + ")." + removerName(reverseEnd) + "(this);");
					}
					line("}");
				}

				line(fieldMemberName(field) + " = " + "value" + ";");

				if (hasReverseEnd) {
					line("if (value != null) {");
					{
						line("((" + mkTypeWrappedImpl(type) + ") value)." + adderName(reverseEnd) + "(this);");
					}
					line("}");
				}
			}
		}
		line("}");
	}

	private Field reverseEnd(Field field) {
		Type type = field.getType();
		if (type instanceof CustomType) {
			Definition typeDef = ((CustomType) type).getDefinition();
			if (typeDef instanceof MessageDef) {
				MessageDef messageType = (MessageDef) typeDef;
				
				return getReverseField(messageType, field.getName());
			}
		}
		return null;
	}

	private void setterReset(Field field) {
		if (Util.isNullable(field)) {
			adderInitNullable(field);
		}
		line(fieldMemberName(field) + ".clear();");
	}

	private void accessorAdder(Field field, boolean override) {
		Type type = field.getType();
		if (field.isRepeated()) {
			if (_interface) {
				if (!field.isDerived()) {
					nl();
					if (override) {
						line("@Override");
					} else {
						adderDoc(field);
					}
					line(myType() + " " + adderName(field) + "(" + mkType(type) + " " + "value" + ");");
				}
			} else {
				nl();
				if (!field.isDerived()) {
					if (!override && _noInterfaces) {
						adderDoc(field);
					} else {
						line("@Override");
					}
				}
				line(setterModifier(field) + myType() + " " + adderName(field) + "(" + mkType(type) + " " + "value" + ")" + " {");
				{
					line(internalAdderName(field) + "(value);");
					generateChain();
				}
				line("}");
			}
		}
		else if (type instanceof MapType) {
			MapType mapType = (MapType) type;
			if (_interface) {
				if (!field.isDerived()) {
					nl();
					if (override) {
						line("@Override");
					} else {
						putDoc(field);
					}
					line(myType() + " " + adderName(field) + "(" + mkType(mapType.getKeyType()) + " key" + ", " + mkType(mapType.getValueType()) + " value" + ");");
				}
			} else {
				nl();
				if (!field.isDerived()) {
					if (!override && _noInterfaces) {
						putDoc(field);
					} else {
						line("@Override");
					}
				}
				line(setterModifier(field) + myType() + " " + adderName(field) + "(" + mkType(mapType.getKeyType()) + " key" + ", " + mkType(mapType.getValueType()) + " value" + ")" + " {");
				{
					line(internalAdderName(field) + "(key, value);");
					generateChain();
				}
				line("}");
			}
		}
	}

	private void putDoc(Field field) {
		line("/**");
		line(" * Adds a key value pair to the {@link #" + getterName(field) + "()"+ "} map.");
		line(" */");
	}

	private void adderDoc(Field field) {
		line("/**");
		line(" * Adds a value to the {@link #" + getterName(field) + "()"+ "} list.");
		line(" */");
	}
	
	private void accessorAdderImpl(Field field) {
		Type type = field.getType();
		if (field.isRepeated()) {
			if (!_interface) {
				nl();
				line("/** Implementation of {@link #" + adderName(field) + "(" + mkType(type) + ")} without chain call utility. */");
				line("protected final void " + internalAdderName(field) + "(" + mkType(type) + " " + "value" + ")" + " {");
				{
					adderInitNullable(field);
					line(fieldMemberName(field) + ".add(value);");
				}
				line("}");
			}
			
			if (_interface) {
				if (!field.isDerived()) {
					nl();
					removerDoc(field);
					line("void " + removerName(field) + "(" + mkType(type) + " " + "value" + ");");
				}
			} else {
				nl();
				if (!field.isDerived()) {
					if (_noInterfaces) {
						removerDoc(field);
					} else {
						line("@Override");
					}
				}
				line(setterModifier(field) + "final void " + removerName(field) + "(" + mkType(type) + " " + "value" + ")" + " {");
				{
					adderInitNullable(field);
					line(fieldMemberName(field) + ".remove(value);");
				}
				line("}");
			}
		}
		else if (type instanceof MapType) {
			MapType mapType = (MapType) type;
			if (!_interface) {
				nl();
				line("/** Implementation of {@link #" + adderName(field) + "(" + mkType(mapType.getKeyType()) + ", " + mkType(mapType.getValueType()) + ")} without chain call utility. */");
				line("protected final void  " + internalAdderName(field) + "(" + mkType(mapType.getKeyType()) + " key" + ", " + mkType(mapType.getValueType()) + " value" + ")" + " {");
				{
					adderInitNullable(field);
					line("if (" + fieldMemberName(field) + ".containsKey(key)) {");
					{
						line("throw new IllegalArgumentException(" + stringLiteral("Property '" + field.getName() + "' already contains a value for key '") + 
								" + key + " + stringLiteral("'.") + ");");
					}
					line("}");
					line(fieldMemberName(field) + ".put(key, value);");
				}
				line("}");
			}
			
			if (_interface) {
				if (!field.isDerived()) {
					nl();
					removeKeyDoc(field);
					line("void " + removerName(field) + "(" + mkType(mapType.getKeyType()) + " key" + ");");
				}
			} else {
				nl();
				if (!field.isDerived()) {
					if (_noInterfaces) {
						removeKeyDoc(field);
					} else {
						line("@Override");
					}
				}
				line(setterModifier(field) + "final void " + removerName(field) + "(" + mkType(mapType.getKeyType()) + " key" + ")" + " {");
				{
					adderInitNullable(field);
					line(fieldMemberName(field) + ".remove(key);");
				}
				line("}");
			}
		}
	}

	private void removeKeyDoc(Field field) {
		line("/**");
		line(" * Removes a key from the {@link #" + getterName(field) + "()"+ "} map.");
		line(" */");
	}

	private void removerDoc(Field field) {
		line("/**");
		line(" * Removes a value from the {@link #" + getterName(field) + "()"+ "} list.");
		line(" */");
	}

	private String setterModifier(Field field) {
		String modifier;
		if (field.isDerived()) {
			modifier = "";
		} else {
			modifier = "public ";
		}
		return modifier;
	}

	private void adderInitNullable(Field field) {
		if (Util.isNullable(field)) {
			line("if (" + fieldMemberName(field) + " == null) " + fieldMemberName(field) + " = " + mkDefaultValueNonNullable(field) + ";");
		}
	}

	private void accessorHasValue(Field field) {
		if (Util.isNullable(field)) {
			nl();
			if (_interface) {
				hasValueDoc(field);
				line("boolean" + " " + hasName(field) + "();");
			} else {
				if (_noInterfaces) {
					hasValueDoc(field);
				} else {
					line("@Override");
				}
				line("public final " + "boolean" + " " + hasName(field) + "()" + " {");
				{
					line("return _" + name(field) + " != null;");
				}
				line("}");
			}
		}
	}

	private void hasValueDoc(Field field) {
		line("/**");
		line(" * Checks, whether {@link #" + getterName(field) + "()"+ "} has a value.");
		line(" */");
	}

	private void generateListener() {
		if (!_graph && isBaseClass()) {
			if (!_interface) {
				nl();
				line("protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;");
			}

			nl();
			if (_interface) {
				line("@Override");
				line("public " + myType() + " registerListener(de.haumacher.msgbuf.observer.Listener l);");
			} else {
				line("@Override");
				line("public " + myType() + " registerListener(de.haumacher.msgbuf.observer.Listener l) {");
				{
					line("internalRegisterListener(l);");
					generateChain();
				}
				line("}");
			}
			
			if (!_interface) {
				nl();
				line("protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {");
				{
					line("_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);");
				}
				line("}");
			}
			
			nl();
			if (_interface) {
				line("@Override");
				line("public " + myType() + " unregisterListener(de.haumacher.msgbuf.observer.Listener l);");
			} else {
				line("@Override");
				line("public " + myType() + " unregisterListener(de.haumacher.msgbuf.observer.Listener l) {");
				{
					line("internalUnregisterListener(l);");
					generateChain();
				}
				line("}");
			}
			
			if (!_interface) {
				nl();
				line("protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {");
				{
					line("_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);");
				}
				line("}");
			}
		}
	}

	private void generateReflection() {
		if (hasFields()) {
			reflectionPropertiesConstant();
			reflectionProperties();
			reflectionGet();
			reflectionSet();
		}
	}

	private void reflectionType() {
		if (_def.isAbstract()) {
			if (!_reflection) {
				// Otherwise, the interface is inherited from ReflectiveDataObject.
				if (_interface || _noInterfaces) {
					nl();
					jsonTypeDoc();
					line((_noInterfaces ? "public abstract " : "") + "String jsonType();");
				}
			}
		} else {
			if (!_interface) {
				nl();
				if (_reflection || _def.getExtendedDef() != null) {
					line("@Override");
				}
				line("public String jsonType() {");
				{
					line("return " + jsonTypeConstant(_def) + ";");
				}
				line("}");
			}
		}
	}

	private void jsonTypeDoc() {
		line("/** The type identifier for this concrete subtype. */");
	}

	private void reflectionPropertiesConstant() {
		nl();
		line("private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(");
		{
			line("java.util.Arrays.asList(");
			{
				boolean first = true;
				for (Field field : getFields()) {
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
	}

	private void reflectionProperties() {
		nl();
		line("@Override");
		line("public java.util.List<String> properties() {");
		{
			line("return PROPERTIES;");
		}
		line("}");
	}

	private void reflectionGet() {
		nl();
		line("@Override");
		line("public Object get(String field) {");
		{
			line("switch (field) {");
			for (Field field : getFields()) {
				line("case " + constant(field) + ": return " + getterName(field) + "()" + ";");
			}
			if (!_graph && isBaseClass()) {
				if (_noInterfaces) {
					// To complicated to select the correct super type.
					line("default: return null;");
				} else {
					line("default: return " + typeName(_def) + ".super.get(field);");
				}
			} else {
				line("default: return super.get(field);");
			}
			line("}");
		}
		line("}");
	}

	private void reflectionSet() {
		nl();
		line("@Override");
		line("public void set(String field, Object value) {");
		{
			{
				line("switch (field) {");
				for (Field field : getFields()) {
					if (field.isDerived()) {
						continue;
					}
					line("case " + constant(field) + ": " + internalSetterName(field) + "(" + mkCast(field, "value") + ")" + "; break;");
				}
				if (!isBaseClass()) {
					line("default: super.set(field, value); break;");
				}
				line("}");
			}
		}
		line("}");
	}

	private void generateJson() {
		if (_interface || _noInterfaces) {
			nl();
			line("/** Reads a new instance from the given reader. */");
			line((_noInterfaces ? "public " : "") + "static " + thisType() + " " + readerName(_def) + "(" + scopeParam() + "de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {");
			{
				if (_graph) {
					line("if (in.peek() == de.haumacher.msgbuf.json.JsonToken.NUMBER) {");
					{
						line("return (" + thisType() + ") scope.resolveOrFail(in.nextInt());");
					}
					line("}");
				}
				
				if (_def.isAbstract()) {
					line(thisType() + " result;");
					line("in.beginArray();");
					line("String type = in.nextString();");
					if (_graph) {
						line("int id = in.nextInt();");
					}
					line("switch (type) {");
					for (MessageDef specialization : Util.concreteTransitiveSpecializations(_def)) {
						if (_graph) {
							line("case " + jsonTypeConstantRef(specialization) + ": result = " + typeName(specialization) + ".create(); break;");
						} else {
							line("case " + jsonTypeConstantRef(specialization) + ": result = " + qTypeName(specialization) + "." + readerName(specialization) + "(in); break;");
						}
					}
					line("default: in.skipValue(); result = null; break;");
					line("}");
					if (_graph) {
						line("if (result != null) {");
						{
							line("scope.readData(result, id, in);");
						}
						line("}");
					}
					line("in.endArray();");
				} else {
					if (_graph) {
						line("in.beginArray();");
						line("String type = in.nextString();");
						line("assert " + jsonTypeConstant(_def) + ".equals(type);");
						line("int id = in.nextInt();");
					}
					line(qImplName(_def) + " result = " + "new " + qImplName(_def) + "();");
					if (_graph) {
						line("scope.readData(result, id, in);");
						line("in.endArray();");
					} else {
						line("result.readContent(" + scopeArg() + "in);");
					}
				}
				line("return result;");
			}
			line("}");
		}
		
		if (!_interface) {
			if (!_graph) {
				if (isBaseClass()) {
					nl();
					line("@Override");
					line("public final void writeTo(" + scopeParam() + "de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {");
					if (_def.isAbstract()) {
						line("out.beginArray();");
						line("out.value(jsonType());");
						line("writeContent(" + scopeArg() + "out);");
						line("out.endArray();");
					} else {
						line("writeContent(out);");
					}
					line("}");
				}
			}
	
			if (hasFields()) {
				nl();
				line("@Override");
				line("protected void writeFields(" + scopeParam() + "de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {");
				{
					line("super.writeFields(" + scopeArg() + "out);");
					for (Field field : getFields()) {
						if (field.isTransient() || field.isDerived()) {
							continue;
						}
						boolean nullable = Util.isNullable(field);
						if (nullable) {
							line("if (" + hasName(field) + "()" + ") {");
						}
						line("out.name(" + constant(field) + ");");
						writeFieldValue(field);
						if (nullable) {
							line("}");
						}
					}
				}
				line("}");
				
				if (_graph) {
					nl();
					line("@Override");
					line("public void writeFieldValue(" + scopeParam() + "de.haumacher.msgbuf.json.JsonWriter out, String field) throws java.io.IOException {");
					{
						line("switch (field) {");
						for (Field field : getFields()) {
							line("case " + constant(field) + ": {");
							{
								boolean nullable = Util.isNullable(field);
								if (nullable) {
									line("if (" + hasName(field) + "()" + ") {");
								}
								writeFieldValue(field);
								if (nullable) {
									line("} else {");
									{
										line("out.nullValue();");
									}
									line("}");
								}
								line("break;");
							}
							line("}");
						}
						line("default: " + "super.writeFieldValue(" + scopeArg() + "out, field);");
						line("}");
					}
					line("}");
				}
				
				nl();
				line("@Override");
				line((_graph ? "public" : "protected") + " void readField(" + scopeParam() + "de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {");
				{
					line("switch (field) {");
					for (Field field : getFields()) {
						jsonReadField(field);
					}
					line("default: super.readField(" + scopeArg() + "in, field);");
					line("}");
				}
				line("}");
	
				if (_graph) {
					List<Field> fieldsWithElements = getFields().stream().filter(field -> !field.isTransient() && !field.isDerived() && field.isRepeated()).collect(Collectors.toList());
					if (!fieldsWithElements.isEmpty()) {
						nl();
						line("@Override");
						line("public void writeElement(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonWriter out, String field, Object element) throws java.io.IOException {");
						{
							line("switch (field) {");
							{
								for (Field field : fieldsWithElements) {
									line("case " + constant(field) + ": {");
									{
										jsonOutValue(field.getType(), "((" + mkType(field.getType()) + ") element)");
										line("break;");
									}
									line("}");
								}
								line("default: super.writeElement(scope, out, field, element);");
							}
							line("}");
						}
						line("}");
						
						nl();
						line("@Override");
						line("public Object readElement(de.haumacher.msgbuf.graph.Scope scope, de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {");
						{
							line("switch (field) {");
							{
								for (Field field : fieldsWithElements) {
									line("case " + constant(field) + ": {");
									{
										line("return " + jsonReadEntry(field.getType()) + ";");
									}
									line("}");
								}
								line("default: return super.readElement(scope, in, field);");
							}
							line("}");
						}
						line("}");
					}
				}
			}
		}
	}

	private void writeFieldValue(Field field) {
		if (field.isRepeated()) {
			line("out.beginArray();");
			line("for (" + mkType(field.getType()) +" x : " + getterName(field) + "()" + ") {");
			{
				jsonOutValue(field.getType(), "x");
			}
			line("}");
			line("out.endArray();");
		} else {
			jsonOutValue(field.getType(), getterCall(field));
		}
	}

	private String scopeParam() {
		return _graph ? "de.haumacher.msgbuf.graph.Scope scope, " : "";
	}
	
	private String scopeArg() {
		return _graph ? "scope, " : "";
	}

	private void jsonReadField(Field field) {
		if (field.isTransient()) {
			return;
		}
		if (field.isDerived()) {
			return;
		}
		
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
						line(mkType(keyType) + " key = " + mkDefaultValue(keyType) + ";");
						line(mkType(valueType) + " value = " + mkDefaultValue(valueType) + ";");
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
			if (messageType.getDefinition() == null) {
				System.err.println("ERROR: No definition found for type '" + type + "'.");
				return "ERROR";
			} else  if (messageType.getDefinition().kind() == TypeKind.ENUM_DEF) {
				return qTypeName(messageType) + "." + readerName(Util.last(name)) +  "(in)";
			} else {
				return qTypeName(messageType) + "." + readerName(Util.last(name)) +  "(" + scopeArg() + "in)";
			}
		}
		throw new RuntimeException("Unsupported: " + type);
	}

	private String jsonTypeID(MessageDef def) {
		return CodeUtil.stringLiteral(MsgBufJsonProtocol.typeId(def));
	}

	private String jsonType(PrimitiveType.Kind primitive) {
		switch (primitive) {
		case BOOL: 
			return "in.nextBoolean()";
	
		case FLOAT:
			return "(float) in.nextDouble()";
		case DOUBLE: 
			return "in.nextDouble()";
		
		case INT_32:
		case SINT_32:
		case UINT_32:
		case FIXED_32: 
		case SFIXED_32:
			return "in.nextInt()";
		
		case INT_64:
		case SINT_64:
		case UINT_64:
		case FIXED_64: 
		case SFIXED_64: 
			return "in.nextLong()";
		
		case STRING:
			return "de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)";
			
		case BYTES:
			return "de.haumacher.msgbuf.json.JsonUtil.nextBinaryOptional(in)";
		}			
		
		throw new RuntimeException("No such type: " + primitive);
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
			if (!_graph && isMonomorphicReferenceToTypeInPolymorphicHierarchy(customType)) { 
				line(x + ".writeContent(" + scopeArg() + "out);");
			} else if (customType.getDefinition() == null) {
				System.err.println("ERROR: No definition found for type '" + type + "'.");
			} else if (customType.getDefinition().kind() == TypeKind.ENUM_DEF) {
				line(x + ".writeTo(out);");
			} else {
				line(x + ".writeTo(" + scopeArg() + "out);");
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
				line("for (" + mkEntryType(mapType) + " " + entry + " : " + x + ".entrySet()) {");
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
				line("for (" + mkEntryType(mapType) + " " + entry + " : " + x + ".entrySet()) {");
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

	private String mkEntryType(MapType mapType) {
		return "java.util.Map.Entry" + "<" + mkTypeWrapped(mapType.getKeyType()) + "," + mkTypeWrapped(mapType.getValueType()) + ">";
	}

	private void generateBinaryIO() {
		binaryTypeId();
		if (!_interface) {
			binaryWrite();
		}
		binaryRead();
	}

	private void binaryTypeId() {
		if (isBaseClass()) {
			if (_def.isAbstract() && (_interface || _noInterfaces)) {
				nl();
				typeIdDoc();
				line("abstract int typeId();");
			}
		} else {
			if (!_def.isAbstract() && getRoot(_def).isAbstract() && !_interface) {
				nl();
				if (_noInterfaces) {
					typeIdDoc();
				} else {
					line("@Override");
				}
				line("public int typeId() {");
				{
					line("return " + mkBinaryTypeConstant(_def) + ";");				
				}
				line("}");
			}
		}
	}

	private void typeIdDoc() {
		line("/** The binary identifier for this concrete type in the polymorphic {@link " + typeName(_def) + "} hierarchy. */");
	}

	private void binaryWrite() {
		if (isBaseClass()) {
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

		if (isBaseClass() || hasFields()) {
			nl();
			if (isBaseClass()) {
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
				if (!isBaseClass()) {
					line("super.writeFields(out);");
				}
				if (getFields().isEmpty()) {
					line("// No fields to write, hook for subclasses.");
				} else {
					for (Field field : getFields()) {
						if (field.isTransient() || field.isDerived()) {
							continue;
						}
						boolean nullable = Util.isNullable(field);
						if (nullable) {
							line("if (" + hasName(field) + "()" + ") {");
						}
						{
							line("out.name(" + binaryConstant(field) + ");");
							if (field.isRepeated()) {
								line("{");
								{
									line(mkType(field) + " values = " + getterName(field) + "();");
									line("out.beginArray(" + "de.haumacher.msgbuf.binary.DataType." + mkBinaryType(field.getType()) + ", values.size());");
									line("for (" + mkType(field.getType()) +" x : values) {");
									{
										binaryWriteValue(field.getType(), "x");
									}
									line("}");
									line("out.endArray();");
								}
								line("}");
							} else {
								binaryWriteValue(field.getType(), getterCall(field));
							}
						}
						if (nullable) {
							line("}");
						}
					}
				}
			}
			line("}");
		}
	}

	private void binaryWriteValue(Type type, String x) {
		if (type instanceof PrimitiveType) {
			line("out.value(" + x + ");");
		} else if (type instanceof CustomType) {
			line(x + ".writeTo(out);");
		} else {
			// TODO
		}
	}

	private void binaryRead() {
		if (_interface || _noInterfaces) {
			nl();
			line("/** Reads a new instance from the given reader. */");
			line((_noInterfaces ? "public " : "") + "static " + thisType() + " " + readerName(_def) + "(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {");
			{
				line("in.beginObject();");
				if (_def.isAbstract()) {
					line("int typeField = in.nextName();");
					line("assert typeField == 0;");
					line("int type = in.nextInt();");
					line(thisType() + " result;");
					line("switch (type) {");
					for (MessageDef specialization : Util.concreteTransitiveSpecializations(_def)) {
						line("case " + mkBinaryTypeConstantRef(specialization) + ": result = " + qImplName(specialization) + "." + readerNameContent(specialization) + "(in); break;");
					}
					line("default: result = null; while (in.hasNext()) {in.skipValue(); }");
					line("}");
				} else {
					line(thisType() + " result = " + qImplName(_def) + "." + readerNameContent(_def) + "(in);");
				}
				line("in.endObject();");
				line("return result;");
			}
			line("}");
		}
		
		if (!_interface) {
			if (!_def.isAbstract()) {
				nl();
				line("/** Helper for creating an object of type {@link " + thisType() + "} from a polymorphic composition. */");
				line("public static " + thisType() + " " + readerNameContent(_def) + "(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {");
				{
					line(qImplName(_def) + " result = new " + implName(_def) + "();");
					line("result.readContent(in);");
					line("return result;");
				}
				line("}");
			}
			
			if (isBaseClass()) {
				nl();
				line("/** Helper for reading all fields of this instance. */");
				line("protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {");
				{
					line("while (in.hasNext()) {");
					{
						line("int field = in.nextName();");
						line("readField(in, field);");
					}
					line("}");
				}
				line("}");
			}
			
			if (isBaseClass() || hasFields()) {
				nl();
				if (isBaseClass()) {
					line("/** Consumes the value for the field with the given ID and assigns its value. */");
				} else {
					line("@Override");
				}
				line("protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {");
				{
					line("switch (field) {");
					for (Field field : getFields()) {
						binaryReadField(field);
					}
					if (isBaseClass()) {
						line("default: in.skipValue(); ");
					} else {
						line("default: super.readField(in, field);");
					}
					line("}");
				}
				line("}");
			}
		}
	}

	private String thisType() {
		return typeName(_def);
	}

	private String myType() {
		return typeName(_def);
	}

	private void generateChain() {
		line("return this;");
	}

	private void binaryReadField(Field field) {
		if (field.isTransient()) {
			return;
		}
		if (field.isDerived()) {
			return;
		}

		Type type = field.getType();
		if (field.isRepeated()) {
			line("case " + binaryConstant(field) + ": {");
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
			line("case " + binaryConstant(field) + ": {");
			{
				Type keyType = mapType.getKeyType();
				Type valueType = mapType.getValueType();
				
				line("in.beginArray();");
				line("while (in.hasNext()) {");
				{
					line("in.beginObject();");
					line(mkType(keyType) + " key = " + mkDefaultValue(keyType) + ";");
					line(mkType(valueType) + " value = " + mkDefaultValue(valueType) + ";");
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
			line("case " + binaryConstant(field) + ": " + setterName(field) + "(" + binaryReadEntry(type) + "); break;");
		}
	}

	private String binaryReadEntry(Type type) {
		if (type instanceof PrimitiveType) {
			return mkBinaryReadValue(((PrimitiveType) type).getKind());
		}
		else if (type instanceof CustomType) {
			CustomType messageType = (CustomType) type;
			QName messageTypeName = messageType.getName();
			return qTypeName(messageType) + "." + readerName(Util.last(messageTypeName)) +  "(in)";
		}
		throw new RuntimeException("Unsupported: " + type);
	}

	private String mkBinaryTypeConstantRef(MessageDef def) {
		return typeName(def) + "." + mkBinaryTypeConstant(def);
	}

	private String mkBinaryReadValue(Kind kind) {
		switch (kind) {
		case BOOL: 
			return "in.nextBoolean()";
		case FLOAT:
			return "in.nextFloat()";
		case DOUBLE: 
			return "in.nextDouble()";
		case INT_32:
		case UINT_32:
			return "in.nextInt()";
		case SINT_32:
			return "in.nextIntSigned()";
		case FIXED_32: 
		case SFIXED_32:
			return "in.nextIntFixed()";
		
		case INT_64:
		case UINT_64:
			return "in.nextLong()";
			
		case SINT_64:
			return "in.nextLongSigned()";
	
		case FIXED_64: 
		case SFIXED_64: 
			return "in.nextLongFixed()";
		
		case STRING:
			return "in.nextString()";
			
		case BYTES:
			return "in.nextBinary()";
		}			
		
		throw new RuntimeException("No such type: " + kind);
	}

	private DataType mkBinaryType(Type type) {
		if (type instanceof PrimitiveType) {
			return mkBinaryType(((PrimitiveType) type).getKind());
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

	private DataType mkBinaryType(PrimitiveType.Kind primitive) {
		switch (primitive) {
		case BOOL: 
			return DataType.INT;
	
		case FLOAT:
			return DataType.FLOAT;
		case DOUBLE: 
			return DataType.DOUBLE;
		
		case INT_32:
		case UINT_32:
			return DataType.INT;
		case SINT_32:
			return DataType.SINT;
		case FIXED_32: 
		case SFIXED_32:
			return DataType.FINT;
		
		case INT_64:
		case UINT_64:
			return DataType.LONG;
		case SINT_64:
			return DataType.SLONG;
		case FIXED_64: 
		case SFIXED_64: 
			return DataType.FLONG;
		
		case STRING:
			return DataType.STRING;
			
		case BYTES:
			return DataType.BINARY;
		}			
		
		throw new RuntimeException("No such type: " + primitive);
	}

	private void generateVisitMethods() {
		if (_def.isAbstract()) {
			if (_interface || _noInterfaces) {
				nl();
				visitDoc();
				line("public abstract <R,A" + onVisitEx(",E extends Throwable") + "> R visit(Visitor<R,A" + onVisitEx(",E") + "> v, A arg)" + onVisitEx(" throws E") + ";");
			}
		}

		MessageDef gen = getAbstractGeneralization();
		if (gen != null) {
			if (!_interface) {
				nl();
				line("@Override");
				line("public" + (_def.isAbstract() ? " final" : "") + " <R,A" + onVisitEx(",E extends Throwable") + "> R visit(" + typeName(gen) + ".Visitor<R,A" + onVisitEx(",E") + "> v, A arg) " + onVisitEx("throws E ") + "{");
				{
					if (_def.isAbstract()) {
						line("return visit((" + typeName(_def) + ".Visitor<R,A" + onVisitEx(",E") + ">) v, arg);");
					} else {
						line("return v.visit(this, arg);");
					}
				}
				line("}");
			}
		}
	}

	private void visitDoc() {
		line("/** Accepts the given visitor. */");
	}

	private String onVisitEx(String code) {
		return _visitEx ? code : "";
	}

	private MessageDef getAbstractGeneralization() {
		MessageDef current = _def;
		while (true) {
			MessageDef extendsDef = current.getExtendedDef();
			if (extendsDef == null) {
				return null;
			}
			if (extendsDef.isAbstract()) {
				return extendsDef;
			}
			current = extendsDef;
		}
	}

	private boolean hasFields() {
		return hasFields(_def);
	}
	
	static boolean hasFields(MessageDef def) {
		return !def.getFields().isEmpty();
	}

	private List<Field> getFields() {
		return _def.getFields();
	}

	private boolean isBaseClass() {
		return _def.getExtends() == null;
	}

	private static MessageDef getRoot(MessageDef def) {
		MessageDef extendedDef = def.getExtendedDef();
		if (extendedDef == null) {
			return def;
		} else {
			return getRoot(extendedDef);
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

	private String mkCast(Field field, String var) {
		if (field.isRepeated()) {
			String elementType = mkTypeWrapped(field.getType());
			return "de.haumacher.msgbuf.util.Conversions.asList(" + elementType + ".class, " + var + ")";
		} else {
			return "(" + mkType(field.getType(), Util.isNullable(field)) + ") " + var;
		}
	}

	private String mkTransient(Field field) {
		return field.isTransient() ? " transient" : "";
	}

	private String mkFinal(Field field) {
		boolean isCollection = field.isRepeated() || field.getType() instanceof MapType;
		return isCollection && !Util.isNullable(field) ? " final" : "";
	}
	
	private String mkInitializer(Field field) {
		return " = " + mkDefaultValue(field);
	}
	
	static QName qName(String name) {
		QName result = QName.create();
		for (String part : name.split("\\.")) {
			result.addName(part);
		}
		return result;
	}

	static String getterCall(Field field) {
		return getterName(field) + "()";
	}

	static Field getLocalField(MessageDef def, String name) {
		return def.getFields().stream().filter(f -> name.equals(f.getName())).findFirst().orElse(null);
	}
	
	private static Field getReverseField(MessageDef def, String name) {
		Field result = getLocalReverseField(def, name);
		if (result != null) {
			return result;
		}
		MessageDef extendedDef = def.getExtendedDef();
		if (extendedDef != null) {
			return getReverseField(extendedDef, name);
		}
		return null;
	}
	
	static Field getLocalReverseField(MessageDef def, String name) {
		return def.getFields().stream().filter(f -> hasReverseName(f, name)).findFirst().orElse(null);
	}

	private static boolean hasReverseName(Field f, String name) {
		StringOption reverseOption = (StringOption) f.getOptions().get("Reverse");
		if (reverseOption == null) {
			return false;
		}
		return reverseOption.getValue().equals(name);
	}

}
