package test.onlyxml.data.impl;

/**
 * A circle {@link Shape}.
 */
public class Circle_Impl extends test.onlyxml.data.impl.AtomicShape_Impl implements test.onlyxml.data.Circle {

	private int _radius = 0;

	/**
	 * Creates a {@link Circle_Impl} instance.
	 *
	 * @see test.onlyxml.data.Circle#create()
	 */
	public Circle_Impl() {
		super();
	}

	@Override
	public final int getRadius() {
		return _radius;
	}

	@Override
	public test.onlyxml.data.Circle setRadius(int value) {
		internalSetRadius(value);
		return this;
	}

	/** Internal setter for {@link #getRadius()} without chain call utility. */
	protected final void internalSetRadius(int value) {
		_radius = value;
	}

	@Override
	public test.onlyxml.data.Circle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.onlyxml.data.Circle setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** XML element name representing a {@link test.onlyxml.data.Circle} type. */
	public static final String CIRCLE__XML_ELEMENT = "circle";

	/** XML attribute or element name of a {@link #getRadius} property. */
	private static final String RADIUS__XML_ATTR = "radius";

	@Override
	public String getXmlTagName() {
		return CIRCLE__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(RADIUS__XML_ATTR, Integer.toString(getRadius()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.onlyxml.data.Circle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Circle_Impl readCircle_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Circle_Impl result = new Circle_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case RADIUS__XML_ATTR: {
				setRadius(Integer.parseInt(value));
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
			case RADIUS__XML_ATTR: {
				setRadius(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

}
