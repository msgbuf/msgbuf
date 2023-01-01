package test.onlyxml.data.impl;

/**
 * A rectangle.
 */
public class Rectangle_Impl extends test.onlyxml.data.impl.AtomicShape_Impl implements test.onlyxml.data.Rectangle {

	private int _width = 0;

	private int _height = 0;

	/**
	 * Creates a {@link Rectangle_Impl} instance.
	 *
	 * @see test.onlyxml.data.Rectangle#create()
	 */
	public Rectangle_Impl() {
		super();
	}

	@Override
	public final int getWidth() {
		return _width;
	}

	@Override
	public test.onlyxml.data.Rectangle setWidth(int value) {
		internalSetWidth(value);
		return this;
	}

	/** Internal setter for {@link #getWidth()} without chain call utility. */
	protected final void internalSetWidth(int value) {
		_width = value;
	}

	@Override
	public final int getHeight() {
		return _height;
	}

	@Override
	public test.onlyxml.data.Rectangle setHeight(int value) {
		internalSetHeight(value);
		return this;
	}

	/** Internal setter for {@link #getHeight()} without chain call utility. */
	protected final void internalSetHeight(int value) {
		_height = value;
	}

	@Override
	public test.onlyxml.data.Rectangle setXCoordinate(int value) {
		internalSetXCoordinate(value);
		return this;
	}

	@Override
	public test.onlyxml.data.Rectangle setYCoordinate(int value) {
		internalSetYCoordinate(value);
		return this;
	}

	/** XML element name representing a {@link test.onlyxml.data.Rectangle} type. */
	public static final String RECTANGLE__XML_ELEMENT = "rectangle";

	/** XML attribute or element name of a {@link #getWidth} property. */
	private static final String WIDTH__XML_ATTR = "w";

	/** XML attribute or element name of a {@link #getHeight} property. */
	private static final String HEIGHT__XML_ATTR = "h";

	@Override
	public String getXmlTagName() {
		return RECTANGLE__XML_ELEMENT;
	}

	/** Serializes all fields that are written as XML attributes. */
	@Override
	protected void writeAttributes(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeAttributes(out);
		out.writeAttribute(WIDTH__XML_ATTR, Integer.toString(getWidth()));
		out.writeAttribute(HEIGHT__XML_ATTR, Integer.toString(getHeight()));
	}

	/** Serializes all fields that are written as XML elements. */
	@Override
	protected void writeElements(javax.xml.stream.XMLStreamWriter out) throws javax.xml.stream.XMLStreamException {
		super.writeElements(out);
		// No element fields.
	}

	/** Creates a new {@link test.onlyxml.data.Rectangle} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Rectangle_Impl readRectangle_XmlContent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		Rectangle_Impl result = new Rectangle_Impl();
		result.readContentXml(in);
		return result;
	}

	@Override
	protected void readFieldXmlAttribute(String name, String value) {
		switch (name) {
			case WIDTH__XML_ATTR: {
				setWidth(Integer.parseInt(value));
				break;
			}
			case HEIGHT__XML_ATTR: {
				setHeight(Integer.parseInt(value));
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
			case WIDTH__XML_ATTR: {
				setWidth(Integer.parseInt(in.getElementText()));
				break;
			}
			case HEIGHT__XML_ATTR: {
				setHeight(Integer.parseInt(in.getElementText()));
				break;
			}
			default: {
				super.readFieldXmlElement(in, localName);
			}
		}
	}

}
