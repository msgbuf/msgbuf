package test.references.data;

public class A extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.data.ReflectiveDataObject {

	/**
	 * Creates a {@link A} instance.
	 */
	public static A create() {
		return new A();
	}

	/** Identifier for the {@link A} type in JSON format. */
	public static final String A__TYPE = "A";

	/** @see #getName() */
	public static final String NAME = "name";

	/** @see #getContents() */
	public static final String CONTENTS = "contents";

	/** @see #getChildren() */
	public static final String CHILDREN = "children";

	/** @see #getBs() */
	public static final String BS = "bs";

	/** @see #getB() */
	public static final String B = "b";

	/** @see #getOther() */
	public static final String OTHER = "other";

	/** @see #getOthers() */
	public static final String OTHERS = "others";

	/** @see #getInOther() */
	public static final String IN_OTHER = "inOther";

	/** @see #getInOthers() */
	public static final String IN_OTHERS = "inOthers";

	/** Identifier for the property {@link #getName()} in binary format. */
	public static final int NAME__ID = 1;

	/** Identifier for the property {@link #getContents()} in binary format. */
	public static final int CONTENTS__ID = 2;

	/** Identifier for the property {@link #getChildren()} in binary format. */
	public static final int CHILDREN__ID = 3;

	/** Identifier for the property {@link #getBs()} in binary format. */
	public static final int BS__ID = 4;

	/** Identifier for the property {@link #getB()} in binary format. */
	public static final int B__ID = 5;

	/** Identifier for the property {@link #getOther()} in binary format. */
	public static final int OTHER__ID = 6;

	/** Identifier for the property {@link #getOthers()} in binary format. */
	public static final int OTHERS__ID = 7;

	private String _name = "";

	private A _contents = null;

	private final java.util.List<A> _children = new java.util.ArrayList<>();

	private final java.util.List<B> _bs = new de.haumacher.msgbuf.util.ReferenceList<test.references.data.B>() {
		@Override
		protected void onAdd(test.references.data.B element) {
			element.addInBs(test.references.data.A.this);
		}

		@Override
		protected void onRemove(test.references.data.B element) {
			element.removeInBs(test.references.data.A.this);
		}
	};

	private B _b = null;

	private A _other = null;

	private final java.util.List<A> _others = new de.haumacher.msgbuf.util.ReferenceList<test.references.data.A>() {
		@Override
		protected void onAdd(test.references.data.A element) {
			element.addInOthers(test.references.data.A.this);
		}

		@Override
		protected void onRemove(test.references.data.A element) {
			element.removeInOthers(test.references.data.A.this);
		}
	};

	private final java.util.List<A> _inOther = new java.util.ArrayList<>();

	private final java.util.List<A> _inOthers = new java.util.ArrayList<>();

	/**
	 * Creates a {@link A} instance.
	 *
	 * @see #create()
	 */
	protected A() {
		super();
	}

	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final A setName(String value) {
		_name = value;
		return this;
	}

	public final A getContents() {
		return _contents;
	}

	/**
	 * @see #getContents()
	 */
	public final A setContents(A value) {
		_contents = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getContents()} has a value.
	 */
	public final boolean hasContents() {
		return _contents != null;
	}

	public final java.util.List<A> getChildren() {
		return _children;
	}

	/**
	 * @see #getChildren()
	 */
	public final A setChildren(java.util.List<A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'children' cannot be null.");
		_children.clear();
		_children.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getChildren()} list.
	 */
	public final A addChildren(A value) {
		_children.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getChildren()} list.
	 */
	public final A removeChildren(A value) {
		_children.remove(value);
		return this;
	}

	public final java.util.List<B> getBs() {
		return _bs;
	}

	/**
	 * @see #getBs()
	 */
	public final A setBs(java.util.List<B> value) {
		if (value == null) throw new IllegalArgumentException("Property 'bs' cannot be null.");
		_bs.clear();
		_bs.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getBs()} list.
	 */
	public final A addBs(B value) {
		_bs.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getBs()} list.
	 */
	public final A removeBs(B value) {
		_bs.remove(value);
		return this;
	}

	public final B getB() {
		return _b;
	}

	/**
	 * @see #getB()
	 */
	public final A setB(B value) {
		if (_b != null) {
			_b.removeInB(this);
		}
		_b = value;
		if (value != null) {
			value.addInB(this);
		}
		return this;
	}

	/**
	 * Checks, whether {@link #getB()} has a value.
	 */
	public final boolean hasB() {
		return _b != null;
	}

	public final A getOther() {
		return _other;
	}

	/**
	 * @see #getOther()
	 */
	public final A setOther(A value) {
		if (_other != null) {
			_other.removeInOther(this);
		}
		_other = value;
		if (value != null) {
			value.addInOther(this);
		}
		return this;
	}

	/**
	 * Checks, whether {@link #getOther()} has a value.
	 */
	public final boolean hasOther() {
		return _other != null;
	}

	public final java.util.List<A> getOthers() {
		return _others;
	}

	/**
	 * @see #getOthers()
	 */
	public final A setOthers(java.util.List<A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'others' cannot be null.");
		_others.clear();
		_others.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getOthers()} list.
	 */
	public final A addOthers(A value) {
		_others.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getOthers()} list.
	 */
	public final A removeOthers(A value) {
		_others.remove(value);
		return this;
	}

	public final java.util.List<A> getInOther() {
		return _inOther;
	}

	/**
	 * @see #getInOther()
	 */
	final A setInOther(java.util.List<A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inOther' cannot be null.");
		_inOther.clear();
		_inOther.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getInOther()} list.
	 */
	final A addInOther(A value) {
		_inOther.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getInOther()} list.
	 */
	final A removeInOther(A value) {
		_inOther.remove(value);
		return this;
	}

	public final java.util.List<A> getInOthers() {
		return _inOthers;
	}

	/**
	 * @see #getInOthers()
	 */
	final A setInOthers(java.util.List<A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inOthers' cannot be null.");
		_inOthers.clear();
		_inOthers.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getInOthers()} list.
	 */
	final A addInOthers(A value) {
		_inOthers.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getInOthers()} list.
	 */
	final A removeInOthers(A value) {
		_inOthers.remove(value);
		return this;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME, 
			CONTENTS, 
			CHILDREN, 
			BS, 
			B, 
			OTHER, 
			OTHERS, 
			IN_OTHER, 
			IN_OTHERS));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME: return getName();
			case CONTENTS: return getContents();
			case CHILDREN: return getChildren();
			case BS: return getBs();
			case B: return getB();
			case OTHER: return getOther();
			case OTHERS: return getOthers();
			case IN_OTHER: return getInOther();
			case IN_OTHERS: return getInOthers();
			default: return de.haumacher.msgbuf.data.ReflectiveDataObject.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME: setName((String) value); break;
			case CONTENTS: setContents((A) value); break;
			case CHILDREN: setChildren((java.util.List<A>) value); break;
			case BS: setBs((java.util.List<B>) value); break;
			case B: setB((B) value); break;
			case OTHER: setOther((A) value); break;
			case OTHERS: setOthers((java.util.List<A>) value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static A readA(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		A result = new A();
		in.beginObject();
		result.readFields(in);
		in.endObject();
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(NAME);
		out.value(getName());
		if (hasContents()) {
			out.name(CONTENTS);
			getContents().writeTo(out);
		}
		out.name(CHILDREN);
		out.beginArray();
		for (A x : getChildren()) {
			x.writeTo(out);
		}
		out.endArray();
		out.name(BS);
		out.beginArray();
		for (B x : getBs()) {
			x.writeTo(out);
		}
		out.endArray();
		if (hasB()) {
			out.name(B);
			getB().writeTo(out);
		}
		if (hasOther()) {
			out.name(OTHER);
			getOther().writeTo(out);
		}
		out.name(OTHERS);
		out.beginArray();
		for (A x : getOthers()) {
			x.writeTo(out);
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case CONTENTS: setContents(test.references.data.A.readA(in)); break;
			case CHILDREN: {
				in.beginArray();
				while (in.hasNext()) {
					addChildren(test.references.data.A.readA(in));
				}
				in.endArray();
			}
			break;
			case BS: {
				in.beginArray();
				while (in.hasNext()) {
					addBs(test.references.data.B.readB(in));
				}
				in.endArray();
			}
			break;
			case B: setB(test.references.data.B.readB(in)); break;
			case OTHER: setOther(test.references.data.A.readA(in)); break;
			case OTHERS: {
				in.beginArray();
				while (in.hasNext()) {
					addOthers(test.references.data.A.readA(in));
				}
				in.endArray();
			}
			break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Serializes all fields of this instance to the given binary output.
	 *
	 * @param out
	 *        The binary output to write to.
	 * @throws java.io.IOException If writing fails.
	 */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(NAME__ID);
		out.value(getName());
		if (hasContents()) {
			out.name(CONTENTS__ID);
			getContents().writeTo(out);
		}
		out.name(CHILDREN__ID);
		{
			java.util.List<A> values = getChildren();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (A x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
		out.name(BS__ID);
		{
			java.util.List<B> values = getBs();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (B x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
		if (hasB()) {
			out.name(B__ID);
			getB().writeTo(out);
		}
		if (hasOther()) {
			out.name(OTHER__ID);
			getOther().writeTo(out);
		}
		out.name(OTHERS__ID);
		{
			java.util.List<A> values = getOthers();
			out.beginArray(de.haumacher.msgbuf.binary.DataType.OBJECT, values.size());
			for (A x : values) {
				x.writeTo(out);
			}
			out.endArray();
		}
	}

	/** Reads a new instance from the given reader. */
	public static A readA(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		A result = new A();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case NAME__ID: setName(in.nextString()); break;
			case CONTENTS__ID: setContents(test.references.data.A.readA(in)); break;
			case CHILDREN__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addChildren(test.references.data.A.readA(in));
				}
				in.endArray();
			}
			break;
			case BS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addBs(test.references.data.B.readB(in));
				}
				in.endArray();
			}
			break;
			case B__ID: setB(test.references.data.B.readB(in)); break;
			case OTHER__ID: setOther(test.references.data.A.readA(in)); break;
			case OTHERS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					addOthers(test.references.data.A.readA(in));
				}
				in.endArray();
			}
			break;
			default: in.skipValue(); 
		}
	}

}
