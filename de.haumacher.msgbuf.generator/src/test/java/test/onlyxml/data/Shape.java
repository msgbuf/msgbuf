package test.onlyxml.data;

/**
 * An abstract base class for all shapes
 */
public interface Shape extends de.haumacher.msgbuf.xml.XmlSerializable {

	/**
	 * X coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getXCoordinate();

	/**
	 * @see #getXCoordinate()
	 */
	test.onlyxml.data.Shape setXCoordinate(int value);

	/**
	 * Y coordinate of the origin of the coordinate system of this {@link Shape}.
	 */
	int getYCoordinate();

	/**
	 * @see #getYCoordinate()
	 */
	test.onlyxml.data.Shape setYCoordinate(int value);

	/** Creates a new {@link Shape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Shape readShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.impl.Shape_Impl.readShape_XmlContent(in);
	}

}
