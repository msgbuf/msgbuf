package test.maptype;

public class Project {

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

	private static final int[] FIELDS = {0, 0, };

	/** Reads a new instance from the given reader. */
	public static Project readProject(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		Project result = new Project();
		result.readContent(in);
		return result;
	}

	/** Writes this instance to the given output. */
	public final void writeTo(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		out.beginObject();
		writeContent(out);
		out.endObject();
	}

	/** Reads all fields of this instance from the given input. */
	protected final void readContent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		while (in.hasNext()) {
			String field = in.nextName();
			readField(in, field);
		}
	}

	/** Retrieves value of the field with the given index. */
	public Object get(String field) {
		switch (field) {
			case "name": return getName();
			case "cost": return getCost();
			default: return null;
		}
	}

	/** Sets the value of the field with the given index. */
	public void set(String field, Object value) {
		switch (field) {
			case "name": setName((String) value); break;
			case "cost": setCost((double) value); break;
		}
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
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
