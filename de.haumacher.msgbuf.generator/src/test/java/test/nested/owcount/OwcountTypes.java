package test.nested.owcount;

/**
 * Registration of extension types for the OpenWorld protocol.
 */
public class OwcountTypes implements de.haumacher.msgbuf.data.TypeRegistration {

	@Override
	public void register() {
		test.nested.owbase.Events.Event.register(test.nested.owcount.CountEvent.COUNT_EVENT__TYPE, test.nested.owcount.CountEvent::create);
		test.nested.owbase.Events.Event.registerXml(test.nested.owcount.impl.CountEvent_Impl.COUNT_EVENT__XML_ELEMENT, test.nested.owcount.CountEvent::create);
	}

	/**
	 * Explicit initialization for GWT or manual use.
	 */
	public static void init() {
		new OwcountTypes().register();
	}
}
