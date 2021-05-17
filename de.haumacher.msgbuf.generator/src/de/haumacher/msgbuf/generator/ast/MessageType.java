package de.haumacher.msgbuf.generator.ast;

public class MessageType extends Type {

	/**
	 * Creates a {@link MessageType} instance.
	 */
	public static MessageType messageType() {
		return new MessageType();
	}

	/**
	 * Creates a {@link MessageType} instance.
	 *
	 * @see #messageType()
	 */
	protected MessageType() {
		super();
	}

	private QName _name;

	public final QName getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final MessageType setName(QName value) {
		_name = value;
		return this;
	}

	/**
	 * Checks, whether {@link #getName()} has a value.
	 */
	public final boolean hasName() {
		return _name != null;
	}

	private static final int[] FIELDS = {0, };

	/** Reads a new instance from the given reader. */
	public static MessageType readMessageType(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		MessageType result = new MessageType();
		result.readContent(in);
		return result;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "name": return getName();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "name": setName((QName) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeContent(out);
		if (hasName()) {
			out.name("name");
			getName().writeTo(out);
		}
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "name": setName(QName.readQName(in)); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public <R,A> R visit(Type.Visitor<R,A> v, A arg) {
		return v.visit(this, arg);
	}

}
