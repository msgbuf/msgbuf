package test.maptype.data;

public class MyMessage extends de.haumacher.msgbuf.data.AbstractReflectiveDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/**
	 * Creates a {@link MyMessage} instance.
	 */
	public static MyMessage create() {
		return new MyMessage();
	}

	/** Identifier for the {@link MyMessage} type in JSON format. */
	public static final String MY_MESSAGE__TYPE = "MyMessage";

	/** @see #getProjects() */
	public static final String PROJECTS = "projects";

	/** @see #getRating() */
	public static final String RATING = "rating";

	/** Identifier for the property {@link #getProjects()} in binary format. */
	public static final int PROJECTS__ID = 3;

	/** Identifier for the property {@link #getRating()} in binary format. */
	public static final int RATING__ID = 4;

	private java.util.Map<String, Project> _projects = new java.util.HashMap<>();

	private java.util.Map<Integer, String> _rating = new java.util.HashMap<>();

	/**
	 * Creates a {@link MyMessage} instance.
	 *
	 * @see #create()
	 */
	protected MyMessage() {
		super();
	}

	public final java.util.Map<String, Project> getProjects() {
		return _projects;
	}

	/**
	 * @see #getProjects()
	 */
	public final MyMessage setProjects(java.util.Map<String, Project> value) {
		_projects.clear();
		_projects.putAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getProjects()} map.
	 */
	public final void addProject(String key, Project value) {
		if (_projects.containsKey(key)) {
			throw new IllegalArgumentException("Property 'projects' already contains a value for key '" + key + "'.");
		}
		_projects.put(key, value);
	}

	public final java.util.Map<Integer, String> getRating() {
		return _rating;
	}

	/**
	 * @see #getRating()
	 */
	public final MyMessage setRating(java.util.Map<Integer, String> value) {
		_rating.clear();
		_rating.putAll(value);
		return this;
	}

	/**
	 * Adds a value to the {@link #getRating()} map.
	 */
	public final void addRating(int key, String value) {
		if (_rating.containsKey(key)) {
			throw new IllegalArgumentException("Property 'rating' already contains a value for key '" + key + "'.");
		}
		_rating.put(key, value);
	}

	private static java.util.List<String> PROPERTIES = java.util.Collections.unmodifiableList(
		java.util.Arrays.asList(
			PROJECTS, 
			RATING));

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case PROJECTS: return getProjects();
			case RATING: return getRating();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case PROJECTS: setProjects((java.util.Map<String, Project>) value); break;
			case RATING: setRating((java.util.Map<Integer, String>) value); break;
		}
	}

	/** Reads a new instance from the given reader. */
	public static MyMessage readMyMessage(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		MyMessage result = new MyMessage();
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
		out.name(PROJECTS);
		out.beginObject();
		for (java.util.Map.Entry<String,Project> entry : getProjects().entrySet()) {
			out.name(entry.getKey());
			entry.getValue().writeTo(out);
		}
		out.endObject();
		out.name(RATING);
		out.beginArray();
		for (java.util.Map.Entry<Integer,String> entry : getRating().entrySet()) {
			out.beginObject();
			out.name("key");
			out.value(entry.getKey());
			out.name("value");
			out.value(entry.getValue());
			out.endObject();
		}
		out.endArray();
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case PROJECTS: {
				in.beginObject();
				while (in.hasNext()) {
					addProject(in.nextName(), Project.readProject(in));
				}
				in.endObject();
				break;
			}
			case RATING: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					int key = 0;
					String value = "";
					while (in.hasNext()) {
						switch (in.nextName()) {
							case "key": key = in.nextInt(); break;
							case "value": value = de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in); break;
							default: in.skipValue(); break;
						}
					}
					addRating(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
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
		out.name(PROJECTS__ID);
		out.name(RATING__ID);
	}

	/** Reads a new instance from the given reader. */
	public static MyMessage readMyMessage(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		MyMessage result = new MyMessage();
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
			case PROJECTS__ID: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					String key = "";
					Project value = null;
					while (in.hasNext()) {
						switch (in.nextName()) {
							case 1: key = in.nextString(); break;
							case 2: value = Project.readProject(in); break;
							default: in.skipValue(); break;
						}
					}
					addProject(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
			case RATING__ID: {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					int key = 0;
					String value = "";
					while (in.hasNext()) {
						switch (in.nextName()) {
							case 1: key = in.nextInt(); break;
							case 2: value = in.nextString(); break;
							default: in.skipValue(); break;
						}
					}
					addRating(key, value);
					in.endObject();
				}
				in.endArray();
				break;
			}
			default: in.skipValue(); 
		}
	}

}
