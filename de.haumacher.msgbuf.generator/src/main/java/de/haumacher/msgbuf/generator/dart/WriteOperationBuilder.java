/*
 * Copyright (c) 2022 Bernhard Haumacher et al. All Rights Reserved.
 */
package de.haumacher.msgbuf.generator.dart;

import de.haumacher.msgbuf.generator.ast.CustomType;
import de.haumacher.msgbuf.generator.ast.Definition;
import de.haumacher.msgbuf.generator.ast.EnumDef;
import de.haumacher.msgbuf.generator.ast.MapType;
import de.haumacher.msgbuf.generator.ast.MessageDef;
import de.haumacher.msgbuf.generator.ast.PrimitiveType;
import de.haumacher.msgbuf.generator.ast.Type;
import de.haumacher.msgbuf.generator.util.AbstractDartGenerator;

/**
 * Generator of a read operation for reading a field value from a JSON stream.
 */
public class WriteOperationBuilder extends AbstractDartGenerator implements Type.Visitor<Void, String>, Definition.Visitor<Void, String> {
	
	private final boolean _repeated;
	private final Type _type;
	private final String _value;

	/** 
	 * Creates a {@link WriteOperationBuilder}.
	 */
	public WriteOperationBuilder(boolean repeated, Type type, String value) {
		_repeated = repeated;
		_type = type;
		_value = value;
	}
	
	@Override
	protected void generate() {
		if (_repeated) {
			line("json.startArray();");
			line("for (var _element in " + _value + ") {");
			{
				_type.visit(this, "_element");
			}
			line("}");
			line("json.endArray();");
		} else {
			_type.visit(this, _value);
		}
	}

	@Override
	public Void visit(CustomType self, String var) {
		return self.getDefinition().visit(this, var);
	}

	@Override
	public Void visit(PrimitiveType self, String var) {
		switch (self.getKind()) {
		case BOOL: 
			line("json.addBool(" + var + ");");
			return null;
			
		case FLOAT:
		case DOUBLE:
			
		case FIXED_32:
		case FIXED_64:
		case INT_32:
		case INT_64:
		case SFIXED_32:
		case SFIXED_64:
		case SINT_32:
		case SINT_64:
		case UINT_32:
		case UINT_64:
			line("json.addNumber(" + var + ");");
			return null;
			
		case BYTES: 
		case STRING:
			line("json.addString(" + var + ");");
			return null;
		}
		throw new IllegalArgumentException("No such type: " + self);
	}

	@Override
	public Void visit(MapType self, String var) {
		line("json.startObject();");
		line("for (var x in " + var + ".entries) {");
		{
			line("json.addKey(x.key);");
			self.getValueType().visit(this, "x.value");
		}
		line("}");
		line("json.endObject();");
		return null;
	}

	@Override
	public Void visit(EnumDef self, String var) {
		line(DartCoding.writeEnumMethod(self) + "(json, " + var + ");");
		return null;
	}

	@Override
	public Void visit(MessageDef self, String var) {
		if (self.isAbstract()) {
			line(var + ".writeTo(json);");
		} else {
			line(var + ".writeContent(json);");
		}
		return null;
	}
}
