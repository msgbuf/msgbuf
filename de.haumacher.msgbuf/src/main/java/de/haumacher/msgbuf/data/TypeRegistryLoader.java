package de.haumacher.msgbuf.data;

/**
 * Loads all {@link TypeRegistration} implementations via {@link java.util.ServiceLoader}.
 *
 * <p>On platforms where ServiceLoader is not available (GWT, JS),
 * this silently does nothing. Registration must then happen via explicit
 * {@code init()} calls on the generated registration classes.</p>
 */
public class TypeRegistryLoader {

    private static boolean _loaded = false;

    /**
     * Ensures all {@link TypeRegistration} modules have been loaded.
     * Safe to call multiple times — only executes once.
     */
    public static synchronized void ensureLoaded() {
        if (_loaded) {
            return;
        }
        _loaded = true;
        try {
            for (TypeRegistration reg : java.util.ServiceLoader.load(TypeRegistration.class)) {
                reg.register();
            }
        } catch (NoClassDefFoundError e) {
            // ServiceLoader not available (GWT/JS) — registration via explicit init() calls.
        }
    }
}
