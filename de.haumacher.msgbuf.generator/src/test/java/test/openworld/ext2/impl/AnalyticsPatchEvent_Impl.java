package test.openworld.ext2.impl;

/**
 * Implementation of {@link test.openworld.ext2.AnalyticsPatchEvent}.
 */
public class AnalyticsPatchEvent_Impl extends test.openworld.base.impl.SSEEvent_Impl implements test.openworld.ext2.AnalyticsPatchEvent {

	private String _metricName = "";

	private double _metricValue = 0.0d;

	/**
	 * Creates a {@link AnalyticsPatchEvent_Impl} instance.
	 *
	 * @see test.openworld.ext2.AnalyticsPatchEvent#create()
	 */
	public AnalyticsPatchEvent_Impl() {
		super();
	}

	@Override
	public TypeKind kind() {
		return null;
	}

	@Override
	public final String getMetricName() {
		return _metricName;
	}

	@Override
	public test.openworld.ext2.AnalyticsPatchEvent setMetricName(String value) {
		internalSetMetricName(value);
		return this;
	}

	/** Internal setter for {@link #getMetricName()} without chain call utility. */
	protected final void internalSetMetricName(String value) {
		_listener.beforeSet(this, METRIC_NAME__PROP, value);
		_metricName = value;
		_listener.afterChanged(this, METRIC_NAME__PROP);
	}

	@Override
	public final double getMetricValue() {
		return _metricValue;
	}

	@Override
	public test.openworld.ext2.AnalyticsPatchEvent setMetricValue(double value) {
		internalSetMetricValue(value);
		return this;
	}

	/** Internal setter for {@link #getMetricValue()} without chain call utility. */
	protected final void internalSetMetricValue(double value) {
		_listener.beforeSet(this, METRIC_VALUE__PROP, value);
		_metricValue = value;
		_listener.afterChanged(this, METRIC_VALUE__PROP);
	}

	@Override
	public test.openworld.ext2.AnalyticsPatchEvent setTimestamp(long value) {
		internalSetTimestamp(value);
		return this;
	}

	@Override
	public String jsonType() {
		return ANALYTICS_PATCH_EVENT__TYPE;
	}

	@SuppressWarnings("hiding")
	protected static final java.util.List<String> PROPERTIES;
	static {
		java.util.List<String> local = java.util.Arrays.asList(
			METRIC_NAME__PROP, 
			METRIC_VALUE__PROP);
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
			case METRIC_NAME__PROP: return getMetricName();
			case METRIC_VALUE__PROP: return getMetricValue();
			default: return super.get(field);
		}
	}

	@Override
	public void set(String field, Object value) {
		switch (field) {
			case METRIC_NAME__PROP: internalSetMetricName((String) value); break;
			case METRIC_VALUE__PROP: internalSetMetricValue((double) value); break;
			default: super.set(field, value); break;
		}
	}

	@Override
	protected void writeFields(de.haumacher.msgbuf.json.JsonWriter out) throws java.io.IOException {
		super.writeFields(out);
		out.name(METRIC_NAME__PROP);
		out.value(getMetricName());
		out.name(METRIC_VALUE__PROP);
		out.value(getMetricValue());
	}

	@Override
	protected void readField(de.haumacher.msgbuf.json.JsonReader in, String field) throws java.io.IOException {
		switch (field) {
			case METRIC_NAME__PROP: setMetricName(de.haumacher.msgbuf.json.JsonUtil.nextStringOptional(in)); break;
			case METRIC_VALUE__PROP: setMetricValue(in.nextDouble()); break;
			default: super.readField(in, field);
		}
	}

	/** XML element name representing a {@link test.openworld.ext2.AnalyticsPatchEvent} type. */
	public static final String ANALYTICS_PATCH_EVENT__XML_ELEMENT = "analytics-patch-event";

	/** XML attribute or element name of a {@link #getMetricName} property. */
	private static final String METRIC_NAME__XML_ATTR = "metric-name";

	/** XML attribute or element name of a {@link #getMetricValue} property. */
	private static final String METRIC_VALUE__XML_ATTR = "metric-value";

	@Override
	public String getXmlTagName() {
		return ANALYTICS_PATCH_EVENT__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(METRIC_NAME__XML_ATTR, getMetricName());
		out.writeAttribute(METRIC_VALUE__XML_ATTR, Double.toString(getMetricValue()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.openworld.ext2.AnalyticsPatchEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AnalyticsPatchEvent_Impl readAnalyticsPatchEvent_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		AnalyticsPatchEvent_Impl result = new AnalyticsPatchEvent_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case METRIC_NAME__XML_ATTR: {
				setMetricName(value);
				break;
			}
			case METRIC_VALUE__XML_ATTR: {
				setMetricValue(Double.parseDouble(value));
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
			case METRIC_NAME__XML_ATTR: {
				setMetricName(in.getElementText());
				break;
			}
			case METRIC_VALUE__XML_ATTR: {
				setMetricValue(Double.parseDouble(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

	@Override
	public <R,A,E extends Throwable> R visit(test.openworld.base.SSEEvent.Visitor<R,A,E> v, A arg) throws E {
		if (v instanceof test.openworld.ext2.AnalyticsPatchEvent.Visitor) {
			return ((test.openworld.ext2.AnalyticsPatchEvent.Visitor<R,A,E>) v).visit(this, arg);
		}
		return v.visitDefault(this, arg);
	}

}
