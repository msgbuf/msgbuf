package test.nested.note;

/**
 * References to a nested polymorphic hierarchy of another file (issue #16).
 */
public interface Note extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface Inner extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.binary.BinaryDataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {

		/**
		 * Creates a {@link test.nested.note.Note.Inner} instance.
		 */
		static test.nested.note.Note.Inner create() {
			return new test.nested.note.impl.Note_Impl.Inner_Impl();
		}

		/** Identifier for the {@link test.nested.note.Note.Inner} type in JSON format. */
		String INNER__TYPE = "Inner";

		/** @see #getRefs() */
		String REFS__PROP = "refs";

		/** Identifier for the property {@link #getRefs()} in binary format. */
		static final int REFS__ID = 1;

		java.util.List<test.nested.doc.Doc.Sec.Item> getRefs();

		/**
		 * @see #getRefs()
		 */
		test.nested.note.Note.Inner setRefs(java.util.List<? extends test.nested.doc.Doc.Sec.Item> value);

		/**
		 * Adds a value to the {@link #getRefs()} list.
		 */
		test.nested.note.Note.Inner addRef(test.nested.doc.Doc.Sec.Item value);

		/**
		 * Removes a value from the {@link #getRefs()} list.
		 */
		void removeRef(test.nested.doc.Doc.Sec.Item value);

		@Override
		public test.nested.note.Note.Inner registerListener(de.haumacher.msgbuf.observer.Listener l);

		@Override
		public test.nested.note.Note.Inner unregisterListener(de.haumacher.msgbuf.observer.Listener l);

		/** Reads a new instance from the given reader. */
		static test.nested.note.Note.Inner readInner(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.note.impl.Note_Impl.Inner_Impl result = new test.nested.note.impl.Note_Impl.Inner_Impl();
			result.readContent(in);
			return result;
		}

		/** Reads a new instance from the given reader. */
		static test.nested.note.Note.Inner readInner(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
			in.beginObject();
			test.nested.note.Note.Inner result = test.nested.note.impl.Note_Impl.Inner_Impl.readInner_Content(in);
			in.endObject();
			return result;
		}

		/** Creates a new {@link Inner} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static Inner readInner(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.note.impl.Note_Impl.Inner_Impl.readInner_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.nested.note.Note} instance.
	 */
	static test.nested.note.Note create() {
		return new test.nested.note.impl.Note_Impl();
	}

	/** Identifier for the {@link test.nested.note.Note} type in JSON format. */
	String NOTE__TYPE = "Note";

	/** @see #getTarget() */
	String TARGET__PROP = "target";

	/** @see #getInner() */
	String INNER__PROP = "inner";

	/** Identifier for the property {@link #getTarget()} in binary format. */
	static final int TARGET__ID = 1;

	/** Identifier for the property {@link #getInner()} in binary format. */
	static final int INNER__ID = 2;

	test.nested.doc.Doc.Sec.Item getTarget();

	/**
	 * @see #getTarget()
	 */
	test.nested.note.Note setTarget(test.nested.doc.Doc.Sec.Item value);

	/**
	 * Checks, whether {@link #getTarget()} has a value.
	 */
	boolean hasTarget();

	test.nested.note.Note.Inner getInner();

	/**
	 * @see #getInner()
	 */
	test.nested.note.Note setInner(test.nested.note.Note.Inner value);

	/**
	 * Checks, whether {@link #getInner()} has a value.
	 */
	boolean hasInner();

	@Override
	public test.nested.note.Note registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.note.Note unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.note.Note readNote(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.note.impl.Note_Impl result = new test.nested.note.impl.Note_Impl();
		result.readContent(in);
		return result;
	}

	/** Reads a new instance from the given reader. */
	static test.nested.note.Note readNote(de.haumacher.msgbuf.binary.DataReader in) throws java.io.IOException {
		in.beginObject();
		test.nested.note.Note result = test.nested.note.impl.Note_Impl.readNote_Content(in);
		in.endObject();
		return result;
	}

	/** Creates a new {@link Note} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Note readNote(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.note.impl.Note_Impl.readNote_XmlContent(in);
	}

}
