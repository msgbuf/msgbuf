package test.maptype;

public class Project implements de.haumacher.msgbuf.data.DataObject {

	/**
	 * Creates a {@link Project} instance.
	 */
	public static Project project() {
		return new Project();
	}

	/**
	 * Creates a {@link Project} instance.
	 *
	 * @see #project()
	 */
	protected Project() {
		super();
	}

	private String _name = "";

	private double _cost = 0.0d;

	public final String getName() {
		return _name;
	}

	/**
	 * @see #getName()
	 */
	public final Project setName(String value) {
		_name = value;
		return this;
	}

	public final double getCost() {
		return _cost;
	}

	/**
	 * @see #getCost()
	 */
	public final Project setCost(double value) {
		_cost = value;
		return this;
	}

	/** Reads a new instance from the given reader. */
	public static Project readProject(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Project result = new Project();
		result.readFields(in);
		return result;
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		writeContent(out);
	}

	/**
	 * Writes a JSON object containing keys for all fields of this object.
	 *
	 * @param out The writer to write to.
	 */
	protected final void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/**
	 * Reads all fields of this instance from the given input.
	 *
	 * @param in The reader to take the input from.
	 */
	protected final void readFields(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(in, field);
		}
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case "name": return getName();
			case "cost": return getCost();
			default: return null;
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "name": setName((String) value); break;
			case "cost": setCost((double) value); break;
		}
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.name("name");
		out.value(getName());
		out.name("cost");
		out.value(getCost());
	}

	/** Reads the given field from the given input. */
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "name": setName(in.nextString()); break;
			case "cost": setCost(in.nextDouble()); break;
			default: in.skipValue();
		}
	}

}
