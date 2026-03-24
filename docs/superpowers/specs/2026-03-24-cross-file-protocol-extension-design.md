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
- Implies `option NoBinary;` — only JSON serialization is supported (avoids integer type-ID conflicts between independent modules)
- Visitor gets a `visitDefault()` fallback method

Without `option OpenWorld;`, behavior is unchanged (closed-world, static dispatch).

### 2. Import Statement

The parser is extended with an `import` statement:

```protobuf
import "path/to/base.proto";
```

The generator loads imported files into the NameTable so that `extends` references can be resolved across files. The generator receives both files but only generates code for the extension file (the base module's code is already generated).

### 3. Dynamic Type Registry

Each abstract type with OpenWorld gets a static registry in the generated base class:

```java
// Generated in SSEEvent (base module)
private static final Map<String, java.util.function.Supplier<SSEEvent>> REGISTRY = new java.util.concurrent.ConcurrentHashMap<>();

public static void register(String typeId, Supplier<SSEEvent> factory) {
    REGISTRY.put(typeId, factory);
}

static SSEEvent readSSEEvent(JsonReader in) {
    in.beginArray();
    String type = in.nextString();
    // First check registry, then fall back to locally known types
    Supplier<SSEEvent> factory = REGISTRY.get(type);
    SSEEvent result;
    if (factory != null) {
        result = factory.get();
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

### 4. Platform-Specific Registration Activation

Each extension module gets a generated registration class (e.g., `GraphSseTypes`) that registers all its subtypes with the base type's registry.

| Platform | Activation Mechanism |
|----------|---------------------|
| Java (Standard) | `ServiceLoader<TypeRegistration>` discovers and invokes registration classes automatically |
| GWT | User calls `GraphSseTypes.init()` in the GWT EntryPoint |
| JS/ESM (future) | Side-effect import: `import './graph-sse-types.js'` triggers registration |

The `TypeRegistration` interface lives in `msgbuf-api`:

```java
public interface TypeRegistration {
    void register();
}
```

Generated registration class:

```java
// In extension module, auto-discovered via ServiceLoader
public class GraphSseTypes implements TypeRegistration {
    @Override
    public void register() {
        SSEEvent.register(GraphPatchEvent.GRAPH_PATCH_EVENT__TYPE, GraphPatchEvent::new);
    }

    /** Explicit init for GWT or manual use. */
    public static void init() {
        new GraphSseTypes().register();
    }
}
```

The base type triggers ServiceLoader discovery lazily on first deserialization call.

### 5. Visitor Pattern

**Base module generates:**

```java
// In SSEEvent
public interface Visitor<R, A, E extends Throwable> {
    R visit(PatchEvent self, A arg) throws E;
    R visit(StateEvent self, A arg) throws E;

    /** Fallback for subtypes not known at compile time. */
    default R visitDefault(SSEEvent self, A arg) throws E {
        throw new UnsupportedOperationException("Unknown SSEEvent type: " + self);
    }
}
```

**Extension module generates:**

```java
// In graph-sse module
public interface GraphSSEVisitor<R, A, E extends Throwable> extends SSEEvent.Visitor<R, A, E> {
    R visit(GraphPatchEvent self, A arg) throws E;
}
```

**Behavior:**
- `GraphPatchEvent.visit(SSEEvent.Visitor v, A arg)` calls `visitDefault()` if the visitor doesn't know the type
- `GraphPatchEvent.visit(GraphSSEVisitor v, A arg)` calls `v.visit(this, arg)` for type-specific handling
- An application module that knows all extensions can implement a visitor combining all extended interfaces

### 6. Codegen Pipeline Changes

The existing 4-stage pipeline is adapted:

1. **Parsing** — Extended to support `import` statements. Imported files are parsed and their definitions loaded into the NameTable.
2. **Specialization building** — Cross-file `extends` references are resolved. The imported base type's `specializations` list is extended (in-memory only, not re-generated).
3. **ID synthesis** — Skipped for OpenWorld hierarchies (NoBinary implied). For non-OpenWorld types in the same file, behavior is unchanged.
4. **Code generation** — Only the extension file's types are generated. The registry-based reader and registration class are generated for OpenWorld hierarchies.

### 7. NameTable Changes

The NameTable must support lookups across imported files:

- Imported definitions are added to the NameTable with their fully qualified names
- Package-qualified lookups work across file boundaries
- Ambiguity (same name in two imports) is a compile error

## Test Plan

Tests in `de.haumacher.msgbuf.generator/src/test/java/test/openworld/`:

### Package Structure

```
test/openworld/
  base/          # Base protocol with option OpenWorld;
    base.proto   # abstract SSEEvent, PatchEvent, StateEvent
  ext1/          # Extension 1
    ext1.proto   # GraphPatchEvent extends SSEEvent
  ext2/          # Extension 2
    ext2.proto   # AnalyticsPatchEvent extends SSEEvent
```

### Test Cases (in `test/openworld/TestOpenWorld.java`)

1. **JSON round-trip within base module** — PatchEvent serializes/deserializes without extensions loaded
2. **Registration** — After loading ext1, GraphPatchEvent is deserializable via `SSEEvent.readSSEEvent()`
3. **Multiple extensions** — Both ext1 and ext2 loaded, both types deserializable
4. **Visitor with visitDefault** — Base visitor receives unknown extension type, `visitDefault()` is called
5. **Extended visitor** — GraphSSEVisitor handles GraphPatchEvent type-specifically
6. **Unknown type handling** — Deserialization of completely unknown type returns null gracefully

## Out of Scope

- Binary serialization for OpenWorld types (explicitly excluded via NoBinary)
- XML serialization for OpenWorld types (can be added later)
- Circular imports (not needed for the extends use case)
- JS/ESM code generation (future work, Issue #11+)
- Re-generation of base module code when extensions are added
