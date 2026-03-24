package test.openworld.ext2;

/**
 * An analytics event extending the base SSE protocol.
 */
public interface AnalyticsPatchEvent extends test.openworld.base.SSEEvent {

	/** Extended visitor that can handle {@link AnalyticsPatchEvent}. */
	public interface Visitor<R,A,E extends Throwable> extends test.openworld.base.SSEEvent.Visitor<R,A,E> {

		/** Visit case for {@link AnalyticsPatchEvent}. */
		R visit(test.openworld.ext2.AnalyticsPatchEvent self, A arg) throws E;

	}

	/**
	 * Creates a {@link test.openworld.ext2.AnalyticsPatchEvent} instance.
	 */
	static test.openworld.ext2.AnalyticsPatchEvent create() {
		return new test.openworld.ext2.impl.AnalyticsPatchEvent_Impl();
	}

	/** Identifier for the {@link test.openworld.ext2.AnalyticsPatchEvent} type in JSON format. */
	String ANALYTICS_PATCH_EVENT__TYPE = "AnalyticsPatchEvent";

	/** @see #getMetricName() */
	String METRIC_NAME__PROP = "metricName";

	/** @see #getMetricValue() */
	String METRIC_VALUE__PROP = "metricValue";

	/**
	 * Name of the metric.
	 */
	String getMetricName();

	/**
	 * @see #getMetricName()
	 */
	test.openworld.ext2.AnalyticsPatchEvent setMetricName(String value);

	/**
	 * Value of the metric.
	 */
	double getMetricValue();

	/**
	 * @see #getMetricValue()
	 */
	test.openworld.ext2.AnalyticsPatchEvent setMetricValue(double value);

	@Override
	test.openworld.ext2.AnalyticsPatchEvent setTimestamp(long value);

	/** Reads a new instance from the given reader. */
	static test.openworld.ext2.AnalyticsPatchEvent readAnalyticsPatchEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.ext2.impl.AnalyticsPatchEvent_Impl result = new test.openworld.ext2.impl.AnalyticsPatchEvent_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link AnalyticsPatchEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AnalyticsPatchEvent readAnalyticsPatchEvent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.ext2.impl.AnalyticsPatchEvent_Impl.readAnalyticsPatchEvent_XmlContent(in);
	}

}
