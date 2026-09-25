package test.openworld.novisitor.ext;

/**
 * Registration of extension types for the OpenWorld protocol.
 */
public class ExtTypes implements de.haumacher.msgbuf.data.TypeRegistration {

	@Override
	public void register() {
		test.openworld.novisitor.base.Shape.register(test.openworld.novisitor.ext.Square.SQUARE__TYPE, test.openworld.novisitor.ext.Square::create);
		test.openworld.novisitor.base.Shape.registerXml(test.openworld.novisitor.ext.impl.Square_Impl.SQUARE__XML_ELEMENT, test.openworld.novisitor.ext.Square::create);
	}

	/**
	 * Explicit initialization for GWT or manual use.
	 */
	public static void init() {
		new ExtTypes().register();
	}
}
