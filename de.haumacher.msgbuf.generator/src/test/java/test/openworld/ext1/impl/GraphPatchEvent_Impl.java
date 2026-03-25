package test.openworld.ext1.impl;

/**
 * Implementation of {@link test.openworld.ext1.GraphPatchEvent}.
 */
public class GraphPatchEvent_Impl extends test.openworld.base.impl.SSEEvent_Impl implements test.openworld.ext1.GraphPatchEvent {

	private String _controlId = "";

	private String _patch = "";

	/**
	 * Creates a {@link GraphPatchEvent_Impl} instance.
	 *
	 * @see test.openworld.ext1.GraphPatchEvent#create()
	 */
	public GraphPatchEvent_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return null;
	}

	@Override
	public final String getControlId() {
		return _controlId;
	}

	@Override
	public test.openworld.ext1.GraphPatchEvent setControlId(String value) {
		internalSetControlId(value);
		return this;
	}

	/** Internal setter for {@link #getControlId()} without chain call utility. */
	protected final void internalSetControlId(String value) {
		_listener.beforeSet(this, CONTROL_ID__PROP, value);
		_controlId = value;
		_listener.afterChanged(this, CONTROL_ID__PROP);
	}

	@Override
	public final String getPatch() {
		return _patch;
	}

	@Override
	public test.openworld.ext1.GraphPatchEvent setPatch(String value) {
		internalSetPatch(value);
		return this;
	}

	/** Internal setter for {@link #getPatch()} without chain call utility. */
	protected final void internalSetPatch(String value) {
		_listener.beforeSet(this, PATCH__PROP, value);
		_patch = value;
		_listener.afterChanged(this, PATCH__PROP);
	}

	@Override
	public test.openworld.ext1.GraphPatchEvent setTimestamp(long value) {
		internalSetTimestamp(value);
		return this;
	}

	@Override
	public String jsonType() {
		return GRAPH_PATCH_EVENT__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			CONTROL_ID__PROP, 
			PATCH__PROP);
		java.util.List<String> tmp = new java.util.ArrayList<>();
		tmp.addAll(test.openworld.base.impl.SSEEvent_Impl.PROPERTIES);
		tmp.addAll(local);
		PROPERTIES = java.util.Collections.unmodifiableList(tmp);
	}

	@SuppressWarnings("hiding")
	protected static final java.util.Set<String> TRANSIENT_PROPERTIES;
	static {
		java.util.HashSet<String> tmp = new java.util.HashSet<>();
		tmp.addAll(test.openworld.base.impl.SSEEvent_Impl.TRANSIENT_PROPERTIES);
		tmp.addAll(java.util.Arrays.asList(
				));
		TRANSIENT_PROPERTIES = java.util.Collections.unmodifiableSet(tmp);
	}

	@Override
	public java.util.List<String> properties() {
		return PROPERTIES;
	}

	@Override
	public java.util.Set<String> transientProperties() {
		return TRANSIENT_PROPERTIES;
	}

	@Override
	public Object get(String field) {
		switch (field) {
			case CONTROL_ID__PROP: return getControlId();
			case PATCH__PROP: return getPatch();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case CONTROL_ID__PROP: internalSetControlId((String) value); break;
			case PATCH__PROP: internalSetPatch((String) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(CONTROL_ID__PROP);
		out.value(getControlId());
		out.name(PATCH__PROP);
		out.value(getPatch());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case CONTROL_ID__PROP: setControlId(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case PATCH__PROP: setPatch(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.ext1.GraphPatchEvent} type. */
	public static final String GRAPH_PATCH_EVENT__XML_ELEMENT = "graph-patch-event";

	/** XML attribute or element name of a {@link #getControlId} property. */
	private static final String CONTROL_ID__XML_ATTR = "control-id";

	/** XML attribute or element name of a {@link #getPatch} property. */
	private static final String PATCH__XML_ATTR = "patch";

	@Override
	public String getXmlTagName() {
		return GRAPH_PATCH_EVENT__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(CONTROL_ID__XML_ATTR, getControlId());
		out.writeAttribute(PATCH__XML_ATTR, getPatch());
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.ext1.GraphPatchEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static GraphPatchEvent_Impl readGraphPatchEvent_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		GraphPatchEvent_Impl result = new GraphPatchEvent_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case CONTROL_ID__XML_ATTR: {
				setControlId(value);
				break;
			}
			case PATCH__XML_ATTR: {
				setPatch(value);
				break;
			}
			default: {
				super.readFieldXmlAttribute(name, value);
			}
		}
	}

	@Override
	protected void readFieldXmlElement(javax.xml.stream.XMLStreamReader in, String localName) throws javax.xml.stream.XMLStreamException {
		switch (localName) {
			case CONTROL_ID__XML_ATTR: {
				setControlId(in.getElementText());
				break;
			}
			case PATCH__XML_ATTR: {
				setPatch(in.getElementText());
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.openworld.base.SSEEvent.Visitor<R,A,E> v, A arg) throws E {
		if (v instanceof test.openworld.ext1.GraphPatchEvent.Visitor) {
			return ((test.openworld.ext1.GraphPatchEvent.Visitor<R,A,E>) v).visit(this, arg);
		}
		return v.visitDefault(this, arg);
	}

}
