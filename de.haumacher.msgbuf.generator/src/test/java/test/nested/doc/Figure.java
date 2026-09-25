package test.nested.doc;

/**
 * A top-level specialization of a nested abstract intermediate.
 */
public interface Figure extends test.nested.doc.Doc.Sec.Block {

	/**
	 * Creates a {@link test.nested.doc.Figure} instance.
	 */
	static test.nested.doc.Figure create() {
		return new test.nested.doc.impl.Figure_Impl();
	}

	/** Identifier for the {@link test.nested.doc.Figure} type in JSON format. */
	String FIGURE__TYPE = "Figure";

	/** @see #getSrc() */
	String SRC__PROP = "src";

	/** Identifier for the {@link test.nested.doc.Figure} type in binary format. */
	static final int FIGURE__TYPE_ID = 3;

	/** Identifier for the property {@link #getSrc()} in binary format. */
	static final int SRC__ID = 4;

	String getSrc();

	/**
	 * @see #getSrc()
	 */
	test.nested.doc.Figure setSrc(String value);

	@Override
	test.nested.doc.Figure setWeight(int value);

	@Override
	test.nested.doc.Figure setKind(test.nested.doc.Doc.Sec.Item.Kind value);

	@Override
	test.nested.doc.Figure setPackage(String value);

	/** Reads a new instance from the given reader. */
	static test.nested.doc.Figure readFigure(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.doc.impl.Figure_Impl result = new test.nested.doc.impl.Figure_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.doc.Figure readFigure(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.doc.Figure result = test.nested.doc.impl.Figure_Impl.readFigure_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Figure} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Figure readFigure(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.doc.impl.Figure_Impl.readFigure_XmlContent(in);
	}

}
