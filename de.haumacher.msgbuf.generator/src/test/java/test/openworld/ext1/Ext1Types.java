package test.openworld.ext1;

/**
 * Registration of extension types for the OpenWorld protocol.
 */
public class Ext1Types implements de.haumacher.msgbuf.data.TypeRegistration {

	@Override
	public void register() {
		test.openworld.base.SSEEvent.register(test.openworld.ext1.GraphPatchEvent.GRAPH_PATCH_EVENT__TYPE, test.openworld.ext1.GraphPatchEvent::create);
	}

	/**
	 * Explicit initialization for GWT or manual use.
	 */
	public static void init() {
		new Ext1Types().register();
	}
}
