package test.onlyxml.data;

/**
 * A {@link Shape} that has no sub-shapes.
 */
public interface AtomicShape extends Shape {

	@Override
	AtomicShape setXCoordinate(int value);

	@Override
	AtomicShape setYCoordinate(int value);

	/** Creates a new {@link AtomicShape} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static AtomicShape readAtomicShape(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.onlyxml.data.AtomicShape_Impl.readAtomicShape_XmlContent(in);
	}

}
