package test.openworld.ext2;

/**
 * Registration of extension types for the OpenWorld protocol.
 */
public class Ext2Types implements de.haumacher.msgbuf.data.TypeRegistration {

	@Override
	public void register() {
		test.openworld.base.SSEEvent.register(test.openworld.ext2.AnalyticsPatchEvent.ANALYTICS_PATCH_EVENT__TYPE, test.openworld.ext2.AnalyticsPatchEvent::create);
	}

	/**
	 * Explicit initialization for GWT or manual use.
	 */
	public static void init() {
		new Ext2Types().register();
	}
}
