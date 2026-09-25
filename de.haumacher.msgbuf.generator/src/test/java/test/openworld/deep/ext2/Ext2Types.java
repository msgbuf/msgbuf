package test.openworld.deep.ext2;

/**
 * Registration of extension types for the OpenWorld protocol.
 */
public class Ext2Types implements de.haumacher.msgbuf.data.TypeRegistration {

	@Override
	public void register() {
		test.openworld.deep.base.Animal.register(test.openworld.deep.ext2.Shark.SHARK__TYPE, test.openworld.deep.ext2.Shark::create);
		test.openworld.deep.base.Animal.registerXml(test.openworld.deep.ext2.impl.Shark_Impl.SHARK__XML_ELEMENT, test.openworld.deep.ext2.Shark::create);
		test.openworld.deep.base.Animal.register(test.openworld.deep.ext2.Eagle.EAGLE__TYPE, test.openworld.deep.ext2.Eagle::create);
		test.openworld.deep.base.Animal.registerXml(test.openworld.deep.ext2.impl.Eagle_Impl.EAGLE__XML_ELEMENT, test.openworld.deep.ext2.Eagle::create);
	}

	/**
	 * Explicit initialization for GWT or manual use.
	 */
	public static void init() {
		new Ext2Types().register();
	}
}
