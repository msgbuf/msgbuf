package test.maptype.data;

public class Project extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

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
	public Object get(String field) {
		switch (field) {
			case "name": return getName();
			case "cost": return getCost();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "name": setName((String) value); break;
			case "cost": setCost((double) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("name");
		out.value(getName());
		out.name("cost");
		out.value(getCost());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case "name": setName(in.nextString()); break;
			case "cost": setCost(in.nextDouble()); break;
			default: super.readField(in, field);
		}
	}

	@Override
	public final void writeTo(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.beginObject();
		writeFields(out);
		out.endObject();
	}

	/** Serializes all fields of this instance to the given binary output. */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(1);
		out.value(getName());
		out.name(2);
		out.value(getCost());
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 1: setName(in.nextString()); break;
			case 2: setCost(in.nextDouble()); break;
			default: in.skipValue(); 
		}
	}

	/** Reads a new instance from the given reader. */
	public static Project readProject(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		Project result = new Project();
		while (in.hasNext()) {
			int field = in.nextName();
			result.readField(in, field);
		}
		in.endObject();
		return result;
	}

}
