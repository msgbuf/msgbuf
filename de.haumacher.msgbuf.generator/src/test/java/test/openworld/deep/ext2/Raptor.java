package test.openworld.deep.ext2;

/**
 * Abstract intermediate at depth three, below the intermediate of the base file.
 */
public interface Raptor extends test.openworld.deep.base.Bird {

	/** Visitor interface for the {@link test.openworld.deep.ext2.Raptor} hierarchy.*/
	public interface Visitor<R,A,E extends Throwable> {

		/** Visit case for {@link test.openworld.deep.ext2.Eagle}.*/
		R visit(test.openworld.deep.ext2.Eagle self, A arg) throws E;

	}

	/** @see #getSpeed() */
	String SPEED__PROP = "speed";

	double getSpeed();

	/**
	 * @see #getSpeed()
	 */
	test.openworld.deep.ext2.Raptor setSpeed(double value);

	@Override
	test.openworld.deep.ext2.Raptor setWingspan(double value);

	@Override
	test.openworld.deep.ext2.Raptor setName(String value);

	/** Reads a new instance from the given reader. */
	static test.openworld.deep.ext2.Raptor readRaptor(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.openworld.deep.ext2.Raptor result;
		in.beginArray();
		String type = in.nextString();
		switch (type) {
			case Eagle.EAGLE__TYPE: result = test.openworld.deep.ext2.Eagle.readEagle(in); break;
			default: in.skipValue(); result = null; break;
		}
		in.endArray();
		return result;
	}

	/** Creates a new {@link Raptor} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Raptor readRaptor(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.openworld.deep.ext2.impl.Raptor_Impl.readRaptor_XmlContent(in);
	}

	/** Accepts the given visitor. */
	public abstract <R,A,E extends Throwable> R visit(Visitor<R,A,E> v, A arg) throws E;

}
