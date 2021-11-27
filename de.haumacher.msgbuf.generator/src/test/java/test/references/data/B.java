package test.references.data;

public class B extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable {

	/**
	 * Creates a {@link B} instance.
	 */
	public static B create() {
		return new B();
	}

	/** Identifier for the {@link B} type in JSON format. */
	public static final String B__TYPE = "B";

	/** @see #getName() */
	public static final String NAME = "name";

	/** @see #getInBs() */
	public static final String IN_BS = "inBs";

	/** @see #getInB() */
	public static final String IN_B = "inB";

	/** Identifier for the property {@link #getName()} in binary format. */
	public static final int NAME__ID = 1;

	private String _name = "";

	private final java.util.List<A> _inBs = new de.haumacher.msgbuf.util.ReferenceList<A>() {
		@Override
		protected void beforeAdd(int index, A element) {
			_listener.beforeAdd(test.references.data.B.this, IN_BS, index, element);
		}

		@Override
		protected void afterRemove(int index, A element) {
			_listener.afterRemove(test.references.data.B.this, IN_BS, index, element);
		}
	};

	private final java.util.List<A> _inB = new de.haumacher.msgbuf.util.ReferenceList<A>() {
		@Override
		protected void beforeAdd(int index, A element) {
			_listener.beforeAdd(test.references.data.B.this, IN_B, index, element);
		}

		@Override
		protected void afterRemove(int index, A element) {
			_listener.afterRemove(test.references.data.B.this, IN_B, index, element);
		}
	};

	/**
	 * Creates a {@link B} instance.
	 *
	 * @see #create()
	 */
	protected B() {
		super();
	}

	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final B setName(String value) {
		_listener.beforeSet(this, NAME, value);
		_name = value;
		return this;
	}

	public final java.util.List<A> getInBs() {
		return _inBs;
	}

	/**
	 * @see #getInBs()
	 */
	final B setInBs(java.util.List<A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inBs' cannot be null.");
		_inBs.clear();
		_inBs.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getInBs()} list.
	 */
	final B addInBs(A value) {
		_inBs.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getInBs()} list.
	 */
	final B removeInBs(A value) {
		_inBs.remove(value);
		return this;
	}

	public final java.util.List<A> getInB() {
		return _inB;
	}

	/**
	 * @see #getInB()
	 */
	final B setInB(java.util.List<A> value) {
		if (value == null) throw new IllegalArgumentException("Property 'inB' cannot be null.");
		_inB.clear();
		_inB.addAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getInB()} list.
	 */
	final B addInB(A value) {
		_inB.add(value);
		return this;
	}

	/**
	 * Removes a value from the {@link #getInB()} list.
	 */
	final B removeInB(A value) {
		_inB.remove(value);
		return this;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public B registerListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
		return this;
	}

	@Override
	public B unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
		return this;
	}

	@Override
	public String jsonType() {
		return B__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME, 
			IN_BS, 
			IN_B));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME: return getName();
			case IN_BS: return getInBs();
			case IN_B: return getInB();
			default: return de.haumacher.msgbuf.observer.Observable.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME: setName((String) value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static B readB(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		B result = new B();
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
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
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
	}

	/** Reads a new instance from the given reader. */
	public static B readB(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		B result = new B();
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
			default: in.skipValue(); 
		}
	}

}
