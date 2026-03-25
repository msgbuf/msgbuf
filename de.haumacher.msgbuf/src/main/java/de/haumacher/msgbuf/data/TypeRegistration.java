package de.haumacher.msgbuf.data;

/**
 * Interface for type registration modules that register extension types
 * with their base type's deserialization registry.
 *
 * <p>Implementations are discovered via {@link java.util.ServiceLoader} on
 * standard Java. On GWT or JS, call the generated {@code init()} method explicitly.</p>
 */
public interface TypeRegistration {
    /**
     * Registers all types provided by this module.
     */
    void register();
}
