package test.nested.owext;

/**
 * Registration of extension types for the OpenWorld protocol.
 */
public class OwextTypes implements de.haumacher.msgbuf.data.TypeRegistration {

	@Override
	public void register() {
		test.nested.owbase.Events.Event.register(test.nested.owext.Patches.PatchEvent.PATCH_EVENT__TYPE, test.nested.owext.Patches.PatchEvent::create);
		test.nested.owbase.Events.Event.registerXml(test.nested.owext.impl.Patches_Impl.PatchEvent_Impl.PATCH_EVENT__XML_ELEMENT, test.nested.owext.Patches.PatchEvent::create);
	}

	/**
	 * Explicit initialization for GWT or manual use.
	 */
	public static void init() {
		new OwextTypes().register();
	}
}
