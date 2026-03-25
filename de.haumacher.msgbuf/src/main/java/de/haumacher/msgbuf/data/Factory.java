package de.haumacher.msgbuf.data;

/**
 * GWT-compatible factory interface for creating instances of a type.
 *
 * @param <T> The type of objects created by this factory.
 */
public interface Factory<T> {
    /**
     * Creates a new instance.
     */
    T create();
}
