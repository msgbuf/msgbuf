package test.maptype.data;

public class MyMessage extends de.haumacher.msgbuf.data.AbstractDataObject implements de.haumacher.msgbuf.binary.BinaryDataObject {

	/**
	 * Creates a {@link MyMessage} instance.
	 */
	public static MyMessage myMessage() {
		return new MyMessage();
	}

	/**
	 * Creates a {@link MyMessage} instance.
	 *
	 * @see #myMessage()
	 */
	protected MyMessage() {
		super();
	}

	private java.util.Map<String, Project> _projects = new java.util.HashMap<>();

	private java.util.Map<Integer, String> _rating = new java.util.HashMap<>();

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
	public Object get(String field) {
		switch (field) {
			case "projects": return getProjects();
			case "rating": return getRating();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case "projects": setProjects((java.util.Map<String, Project>) value); break;
			case "rating": setRating((java.util.Map<Integer, String>) value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name("projects");
		out.beginObject();
		for (java.util.Map.Entry<String,Project> entry : getProjects().entrySet()) {
			out.name(entry.getKey());
			entry.getValue().writeTo(out);
		}
		out.endObject();
		out.name("rating");
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
			case "projects": {
				in.beginObject();
				while (in.hasNext()) {
					addProject(in.nextName(), Project.readProject(in));
				}
				in.endObject();
				break;
			}
			case "rating": {
				in.beginArray();
				while (in.hasNext()) {
					in.beginObject();
					int key = 0;
					String value = "";
					while (in.hasNext()) {
						switch (in.nextName()) {
							case "key": key = in.nextInt(); break;
							case "value": value = in.nextString(); break;
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

	/** Serializes all fields of this instance to the given binary output. */
	protected void writeFields(de.haumacher.msgbuf.binary.DataWriter out) throws java.io.IOException {
		out.name(3);
		out.name(4);
	}

	/** Consumes the value for the field with the given ID and assigns its value. */
	protected void readField(de.haumacher.msgbuf.binary.DataReader in, int field) throws java.io.IOException {
		switch (field) {
			case 3: {
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
			case 4: {
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

}
