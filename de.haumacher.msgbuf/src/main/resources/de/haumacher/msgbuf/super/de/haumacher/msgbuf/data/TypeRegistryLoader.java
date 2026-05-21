package de.haumacher.msgbuf.data;

/**
 * GWT super-source replacement for {@code TypeRegistryLoader}.
 *
 * <p>
 * The original uses {@link java.util.ServiceLoader} which is not available in GWT.
 * In GWT, registration happens via explicit {@code init()} calls on generated
 * registration classes.
 * </p>
 */
public class TypeRegistryLoader {

	/**
	 * No-op in GWT. Registration must happen via explicit init() calls.
	 */
	public static void ensureLoaded() {
		// No ServiceLoader available in GWT.
	}

}
