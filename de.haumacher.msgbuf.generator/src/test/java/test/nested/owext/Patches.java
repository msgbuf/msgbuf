package test.nested.owext;

/**
 * Nested extensions of a nested OpenWorld root declared in another file.
 *
 * <p>
 * No top-level definition of this file extends the OpenWorld root: the implied NoBinary must be
 * detected from the nested extension.
 * </p>
 */
public interface Patches extends de.haumacher.msgbuf.data.DataObject, de.haumacher.msgbuf.observer.Observable, de.haumacher.msgbuf.xml.XmlSerializable {
	public interface PatchEvent extends test.nested.owbase.Events.Event {

		/** Extended visitor that can handle {@link PatchEvent}. */
		public interface Visitor<R,A,E extends Throwable> extends test.nested.owbase.Events.Event.Visitor<R,A,E> {

			/** Visit case for {@link PatchEvent}. */
			R visit(test.nested.owext.Patches.PatchEvent self, A arg) throws E;

		}

		/**
		 * Creates a {@link test.nested.owext.Patches.PatchEvent} instance.
		 */
		static test.nested.owext.Patches.PatchEvent create() {
			return new test.nested.owext.impl.Patches_Impl.PatchEvent_Impl();
		}

		/** Identifier for the {@link test.nested.owext.Patches.PatchEvent} type in JSON format. */
		String PATCH_EVENT__TYPE = "PatchEvent";

		/** @see #getPatch() */
		String PATCH__PROP = "patch";

		String getPatch();

		/**
		 * @see #getPatch()
		 */
		test.nested.owext.Patches.PatchEvent setPatch(String value);

		@Override
		test.nested.owext.Patches.PatchEvent setTimestamp(long value);

		/** Reads a new instance from the given reader. */
		static test.nested.owext.Patches.PatchEvent readPatchEvent(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
			test.nested.owext.impl.Patches_Impl.PatchEvent_Impl result = new test.nested.owext.impl.Patches_Impl.PatchEvent_Impl();
			result.readContent(in);
			return result;
		}

		/** Creates a new {@link PatchEvent} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
		public static PatchEvent readPatchEvent(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
			in.nextTag();
			return test.nested.owext.impl.Patches_Impl.PatchEvent_Impl.readPatchEvent_XmlContent(in);
		}

	}

	/**
	 * Creates a {@link test.nested.owext.Patches} instance.
	 */
	static test.nested.owext.Patches create() {
		return new test.nested.owext.impl.Patches_Impl();
	}

	/** Identifier for the {@link test.nested.owext.Patches} type in JSON format. */
	String PATCHES__TYPE = "Patches";

	@Override
	public test.nested.owext.Patches registerListener(de.haumacher.msgbuf.observer.Listener l);

	@Override
	public test.nested.owext.Patches unregisterListener(de.haumacher.msgbuf.observer.Listener l);

	/** Reads a new instance from the given reader. */
	static test.nested.owext.Patches readPatches(de.haumacher.msgbuf.json.JsonReader in) throws java.io.IOException {
		test.nested.owext.impl.Patches_Impl result = new test.nested.owext.impl.Patches_Impl();
		result.readContent(in);
		return result;
	}

	/** Creates a new {@link Patches} and reads properties from the content (attributes and inner tags) of the currently open element in the given {@link javax.xml.stream.XMLStreamReader}. */
	public static Patches readPatches(javax.xml.stream.XMLStreamReader in) throws javax.xml.stream.XMLStreamException {
		in.nextTag();
		return test.nested.owext.impl.Patches_Impl.readPatches_XmlContent(in);
	}

}
