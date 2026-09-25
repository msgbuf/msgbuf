package test.openworld.deep.ext1;

/**
 * Registration of extension types for the OpenWorld protocol.
 */
public class Ext1Types implements de.haumacher.msgbuf.data.TypeRegistration {

	@Override
	public void register() {
		test.openworld.deep.base.Animal.register(test.openworld.deep.ext1.Parrot.PARROT__TYPE, test.openworld.deep.ext1.Parrot::create);
		test.openworld.deep.base.Animal.registerXml(test.openworld.deep.ext1.impl.Parrot_Impl.PARROT__XML_ELEMENT, test.openworld.deep.ext1.Parrot::create);
		test.openworld.deep.base.Animal.register(test.openworld.deep.ext1.Trout.TROUT__TYPE, test.openworld.deep.ext1.Trout::create);
		test.openworld.deep.base.Animal.registerXml(test.openworld.deep.ext1.impl.Trout_Impl.TROUT__XML_ELEMENT, test.openworld.deep.ext1.Trout::create);
		test.openworld.deep.base.Habitat.Plant.register(test.openworld.deep.ext1.Forest.Oak.OAK__TYPE, test.openworld.deep.ext1.Forest.Oak::create);
		test.openworld.deep.base.Habitat.Plant.registerXml(test.openworld.deep.ext1.impl.Forest_Impl.Oak_Impl.OAK__XML_ELEMENT, test.openworld.deep.ext1.Forest.Oak::create);
	}

	/**
	 * Explicit initialization for GWT or manual use.
	 */
	public static void init() {
		new Ext1Types().register();
	}
}
