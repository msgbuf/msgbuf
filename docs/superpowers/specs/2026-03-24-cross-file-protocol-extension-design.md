# Cross-File Protocol Extension (Issue #9)

## Problem

All message types in a protocol must be defined in a single `.proto` file. It is not possible to define subtypes of an abstract message in a different `.proto` file from a different module. This forces undesirable dependencies from the base module to all domain-specific modules.

## Use Case

A server-sent events protocol defines base event types in module A. Downstream modules B and C each add domain-specific event types. Modules B and C are independent — they don't know about each other. An application that loads both modules should be able to deserialize all event types polymorphically.

```
Module A (base):      abstract SSEEvent, PatchEvent, StateEvent
Module B (ext1):      GraphPatchEvent extends SSEEvent
Module C (ext2):      AnalyticsPatchEvent extends SSEEvent
Application:          loads A + B + C, deserializes all types
```

## Design Decisions

### 1. Opt-in via `option OpenWorld;`

Cross-file extension is not needed for all protocols. The base `.proto` file must explicitly opt in:

```protobuf
option OpenWorld;

abstract message SSEEvent { ... }
```

**Implications of OpenWorld:**
- Enables dynamic type registry on the abstract type
- Implies `option NoBinary;` — JSON and XML serialization are supported (both use string-based type names; only binary serialization has integer type-ID conflict issues)
- Visitor gets a `visitDefault()` fallback method
- `option OpenWorld;` on a non-abstract message is a compile error

Without `option OpenWorld;`, behavior is unchanged (closed-world, static dispatch).

### 2. Import Statement

The parser is extended with an `import` statement:

```protobuf
import "path/to/base.proto";
```

**Grammar change:** `import` becomes a reserved keyword in the JavaCC grammar (`protobuf.jj`). This is technically a breaking change if anyone uses `import` as an identifier, but this is unlikely (backtick syntax exists as a workaround). The parser must be regenerated after the grammar change.

**Path resolution order:**
1. Relative to the importing file's directory
2. From a configurable list of include paths (new `-I <path>` CLI option, new `<includePaths>` Maven plugin configuration element)

**Transitive imports** are supported: if A imports B and B imports C, then A can reference types from C. Circular imports are detected and reported as a compile error.

The generator loads imported files into the NameTable so that `extends` references can be resolved across files. The generator receives both files but only generates code for the extension file (the base module's code is already generated).

### 3. AST Changes

`DefinitionFile` in `generator/ast/proto.proto` needs a new field for import declarations:

```protobuf
message DefinitionFile extends WithOptions {
    QName `package`;
    repeated string imports;       // NEW: import paths
    repeated Definition definitions;
}
```

**Bootstrapping note:** Since the generator is self-bootstrapping, this change requires: (1) add the field to `proto.proto`, (2) regenerate AST Java classes with the existing generator, (3) rebuild the generator. The Maven reactor handles this automatically.

### 4. Dynamic Type Registry

Each abstract type with OpenWorld gets a static registry in the generated base class. The registry uses GWT-compatible types only (no `java.util.concurrent`, no `java.util.function`).

A new `Factory<T>` interface in `msgbuf-api` replaces `Supplier`:

```java
// In msgbuf-api (GWT-compatible)
public interface Factory<T> {
    T create();
}
```

Generated registry code in the base class:

```java
// Generated in SSEEvent (base module)
private static final Map<String, Factory<? extends SSEEvent>> REGISTRY = new HashMap<>();

public static void register(String typeId, Factory<? extends SSEEvent> factory) {
    REGISTRY.put(typeId, factory);
}

static SSEEvent readSSEEvent(JsonReader in) {
    in.beginArray();
    String type = in.nextString();
    // First check registry, then fall back to locally known types
    Factory<? extends SSEEvent> factory = REGISTRY.get(type);
    SSEEvent result;
    if (factory != null) {
        result = factory.create();
        result.readContent(in);
    } else {
        switch (type) {
            case PatchEvent.PATCH_EVENT__TYPE: result = PatchEvent.readPatchEvent(in); break;
            case StateEvent.STATE_EVENT__TYPE: result = StateEvent.readStateEvent(in); break;
            default: in.skipValue(); result = null; break;
        }
    }
    in.endArray();
    return result;
}
```

Locally defined concrete subtypes remain in the static switch for performance. Only cross-file extensions go through the registry.

### 5. Platform-Specific Registration Activation

Each extension module gets a generated registration class. The naming convention is `<ProtoFileName>Types` (e.g., `ext1.proto` generates `Ext1Types`).

| Platform | Activation Mechanism |
|----------|---------------------|
| Java (Standard) | `ServiceLoader<TypeRegistration>` discovers and invokes registration classes automatically |
| GWT | User calls `Ext1Types.init()` in the GWT EntryPoint |
| JS/ESM (future) | Side-effect import: `import './ext1-types.js'` triggers registration |

The `TypeRegistration` interface lives in `msgbuf-api` (GWT-compatible):

```java
public interface TypeRegistration {
    void register();
}
```

Generated registration class:

```java
public class Ext1Types implements TypeRegistration {
    @Override
    public void register() {
        SSEEvent.register(GraphPatchEvent.GRAPH_PATCH_EVENT__TYPE, GraphPatchEvent::new);
    }

    /** Explicit init for GWT or manual use. */
    public static void init() {
        new Ext1Types().register();
    }
}
```

**ServiceLoader bootstrap (standard Java only):** The base type's `readXxx()` method triggers ServiceLoader discovery lazily on first call, using a `volatile boolean` flag for thread-safe initialization:

```java
private static volatile boolean _registryLoaded = false;

private static void ensureRegistryLoaded() {
    if (!_registryLoaded) {
        synchronized (SSEEvent.class) {
            if (!_registryLoaded) {
                for (TypeRegistration reg : ServiceLoader.load(TypeRegistration.class)) {
                    reg.register();
                }
                _registryLoaded = true;
            }
        }
    }
}
```

**GWT builds:** The ServiceLoader bootstrap code is not generated when GWT compatibility is required. Registration depends entirely on explicit `init()` calls. This is controlled by the existing GWT-related generation options.

### 6. Visitor Pattern

**Base module generates:**

```java
// In SSEEvent
public interface Visitor<R, A, E extends Throwable> {
    R visit(PatchEvent self, A arg) throws E;
    R visit(StateEvent self, A arg) throws E;

    /** Fallback for subtypes not known at compile time. */
    R visitDefault(SSEEvent self, A arg) throws E;
}
```

Note: `visitDefault()` is not a `default` method (GWT compatibility — no Java 8 features). Implementations must provide it explicitly.

**Extension module generates:**

```java
// In graph-sse module
public interface GraphSSEVisitor<R, A, E extends Throwable> extends SSEEvent.Visitor<R, A, E> {
    R visit(GraphPatchEvent self, A arg) throws E;
}
```

**Visitor dispatch in extension types uses `instanceof`:**

```java
// Generated in GraphPatchEvent
@Override
public <R, A, E extends Throwable> R visit(SSEEvent.Visitor<R, A, E> v, A arg) throws E {
    if (v instanceof GraphSSEVisitor) {
        return ((GraphSSEVisitor<R, A, E>) v).visit(this, arg);
    }
    return v.visitDefault(this, arg);
}
```

This is the key dispatch mechanism: if the visitor implements the extended interface, the type-specific method is called. Otherwise, `visitDefault()` handles the unknown type.

### 7. Codegen Pipeline Changes

The existing 4-stage pipeline is adapted:

1. **Parsing** — Extended to support `import` statements. Imported files are parsed recursively and their definitions loaded into the NameTable.
2. **Specialization building** — Cross-file `extends` references are resolved. The imported base type's `specializations` list is extended (in-memory only, not re-generated).
3. **ID synthesis** — Skipped for OpenWorld hierarchies (NoBinary implied). For non-OpenWorld types in the same file, behavior is unchanged.
4. **Code generation** — Only the extension file's types are generated. The registry-based reader and registration class are generated for OpenWorld hierarchies.

### 8. NameTable Changes

The NameTable must support lookups across imported files:

- Imported definitions are added to the NameTable under their package-qualified names
- Lookup order: (1) inner definitions of the current context, (2) definitions in the current file's package, (3) definitions from imported files by package-qualified name
- An `extends` clause in an extension file can use either the fully qualified name (`base.pkg.SSEEvent`) or the unqualified name (`SSEEvent`) if unambiguous
- If the same unqualified name exists in multiple imported packages, it must be qualified — otherwise a compile error is reported

## Test Plan

Tests in `de.haumacher.msgbuf.generator/src/test/java/test/openworld/`, following the existing JUnit 3 style (`extends TestCase`).

### Package Structure

```
test/openworld/
  base/                  # Base protocol with option OpenWorld;
    base.proto           # abstract SSEEvent, PatchEvent, StateEvent
  ext1/                  # Extension 1
    ext1.proto           # GraphPatchEvent extends SSEEvent (with additional fields)
  ext2/                  # Extension 2
    ext2.proto           # AnalyticsPatchEvent extends SSEEvent
  TestOpenWorld.java     # Test cases
```

### Test Cases

1. **JSON round-trip within base module** — PatchEvent serializes/deserializes without extensions loaded
2. **Registration** — After calling `Ext1Types.init()`, GraphPatchEvent is deserializable via `SSEEvent.readSSEEvent()`
3. **Multiple extensions** — Both ext1 and ext2 registered, both types deserializable
4. **Extension fields** — GraphPatchEvent with its own fields serializes/deserializes correctly
5. **Visitor with visitDefault** — Base visitor receives unknown extension type, `visitDefault()` is called
6. **Extended visitor** — GraphSSEVisitor handles GraphPatchEvent type-specifically
7. **Unknown type handling** — Deserialization of completely unknown type returns null gracefully
8. **Multi-level extension** — Type in ext1 extends a non-abstract type from base that itself extends the abstract root (if applicable)
9. **NoInterfaces interaction** — Verify OpenWorld works correctly with `option NoInterfaces;` (single class mode, no `impl` subpackage)

## Out of Scope

- Binary serialization for OpenWorld types (explicitly excluded via NoBinary)
- Circular imports (detected and reported as compile error)
- JS/ESM code generation (future work)
- Re-generation of base module code when extensions are added
- Multi-level transitive cross-file hierarchies (A→B→C across three files; can be added later)
