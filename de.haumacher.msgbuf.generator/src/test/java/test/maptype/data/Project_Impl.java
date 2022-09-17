package test.maptype.data;

class Project_Impl extends de.haumacher.msgbuf.data.AbstractDataObject implements Project {

	private String _name = "";

	private double _cost = 0.0d;

	/**
	 * Creates a {@link Project_Impl} instance.
	 *
	 * @see Project#create()
	 */
	protected Project_Impl() {
		super();
	}

	@Override
	public final String getName() {
		return _name;
	}

	@Override
	public Project setName(String value) {
		internalSetName(value);
		return this;
	}

	/** Internal setter for {@link #getName()} without chain call utility. */
	protected final void internalSetName(String value) {
		_listener.beforeSet(this, NAME, value);
		_name = value;
	}

	@Override
	public final double getCost() {
		return _cost;
	}

	@Override
	public Project setCost(double value) {
		internalSetCost(value);
		return this;
	}

	/** Internal setter for {@link #getCost()} without chain call utility. */
	protected final void internalSetCost(double value) {
		_listener.beforeSet(this, COST, value);
		_cost = value;
	}

	protected de.haumacher.msgbuf.observer.Listener _listener = de.haumacher.msgbuf.observer.Listener.NONE;

	@Override
	public Project registerListener(de.haumacher.msgbuf.observer.Listener l) {
		internalRegisterListener(l);
		return this;
	}

	protected final void internalRegisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.register(_listener, l);
	}

	@Override
	public Project unregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		internalUnregisterListener(l);
		return this;
	}

	protected final void internalUnregisterListener(de.haumacher.msgbuf.observer.Listener l) {
		_listener = de.haumacher.msgbuf.observer.Listener.unregister(_listener, l);
	}

	@Override
	public String jsonType() {
		return PROJECT__TYPE;
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			NAME, 
			COST));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case NAME: return getName();
			case COST: return getCost();
			default: return Project.super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case NAME: internalSetName((String) value); break;
			case COST: internalSetCost((double) value); break;
		}
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
		out.name(COST);
		out.value(getCost());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case NAME: setName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case COST: setCost(in.nextDouble()); break;
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
		out.name(COST__ID);
		out.value(getCost());
	}

	/** Helper for creating an object of type {@link Project} from a polymorphic composition. */
	public static Project readProject_Content(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		test.maptype.data.Project_Impl result = new Project_Impl();
		result.readContent(in);
		return result;
	}

	/** Helper for reading all fields of this instance. */
	protected final void readContent(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		while (in.hasNext()) {
			int field = in.nextName();
			readField(in, field);
		}
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case NAME__ID: setName(in.nextString()); break;
			case COST__ID: setCost(in.nextDouble()); break;
			default: in.skipValue(); 
		}
	}

}
