package test.maptype;

public class MyMessage {

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

	private static final int[] FIELDS = {3, 4, };

	/** Reads a new instance from the given reader. */
	public static MyMessage readMyMessage(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		MyMessage result = new MyMessage();
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
			case "projects": return getProjects();
			case "rating": return getRating();
			default: return null;
		}
	}

	/** Sets the value of the field with the given index. */
	public void set(String field, Object value) {
		switch (field) {
			case "projects": setProjects((java.util.Map<String, Project>) value); break;
			case "rating": setRating((java.util.Map<Integer, String>) value); break;
		}
	}

	/** Writes all fields of this instance to the given output. */
	protected void writeContent(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
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

	/** Reads the given field from the given input. */
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
			default: in.skipValue();
		}
	}

}
