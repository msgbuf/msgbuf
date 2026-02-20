# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

MsgBuf is a code generator for GWT-compatible Java data classes suitable for typed client-server messaging. It generates Java classes from `.proto` definition files (using `syntax = "msgbuf";`, not `proto3`) with features beyond standard protobuf: inheritance, abstract classes, polymorphic data composition, and visitor pattern generation.

Supports multiple serialization formats: JSON (primary), Binary, and XML.

## Project Structure

Multi-module Maven project. Build order matters — modules depend on each other sequentially:

1. **de.haumacher.msgbuf** (`msgbuf-api`) — Runtime library with base classes, serialization support, GWT-compatible I/O abstractions. Apache-2.0.
2. **de.haumacher.msgbuf.generator** (`msgbuf-generator`) — Code generator using JavaCC parser. GPL-3.0-or-later. **Self-bootstrapping**: the generator's own AST (`generator/ast/proto.proto`) is defined in msgbuf syntax and generates the Java classes the generator uses internally.
3. **msgbuf-generator-maven-plugin** — Maven plugin wrapper for the generator.
4. **de.haumacher.msgbuf.eclipse** — Eclipse plugin (separate build, not in reactor).

## Building and Testing

```bash
# Full build (must be done in order: api → generator → plugin)
mvn clean install

# Build individual module
mvn clean install -pl de.haumacher.msgbuf
mvn clean install -pl de.haumacher.msgbuf.generator

# Run all tests
mvn test

# Single module tests
mvn test -pl de.haumacher.msgbuf.generator

# Single test class
mvn test -pl de.haumacher.msgbuf.generator -Dtest=test.hierarchy.TestHierarchy

# Run generator standalone (after building)
java -jar de.haumacher.msgbuf.generator/target/msgbuf-generator-*-full.jar <proto-files>
```

## Generator Pipeline

The code generation follows a 4-stage pipeline in `Generator.main()`:

1. **Parsing** — JavaCC grammar (`protobuf.jj`) parses `.proto` files into AST nodes (`DefinitionFile` → `MessageDef`/`EnumDef` → `Field`)
2. **Specialization building** — Resolves type references, links inheritance hierarchies (`extends`), populates `specializations` lists for polymorphism
3. **ID synthesis** — `TypeIdSynthesizer` assigns type IDs for binary serialization; `FieldIDSynthesizer` auto-assigns field indices where not explicit
4. **Code generation** — `PackageGenerator` visitor dispatches to `MessageGenerator` (concrete classes), `EnumGenerator` (enums). Uses `GeneratorPlugin` SPI for extensibility.

Key source locations:
- Generator entry point: `de.haumacher.msgbuf.generator.Generator`
- Code generators: `de.haumacher.msgbuf.generator.MessageGenerator`, `EnumGenerator`
- JavaCC grammar: `de.haumacher.msgbuf.generator/src/main/javacc/protobuf.jj`
- AST proto definition: `de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/ast/proto.proto`

## Runtime API Architecture

Core class hierarchy in `msgbuf-api`:

- `DataObject` (interface) — `writeTo(JsonWriter)`, `writeContent()`, `readContent()`
- `AbstractDataObject` — Base impl with `writeFields()`/`readField()` hooks
- `ReflectiveDataObject` — Adds reflective property access (`get(field)`, `set(field, value)`)
- `Observable` — Change tracking with listener registration

GWT compatibility: no `java.io.Reader/Writer` — uses custom `StringR`/`StringW` and reimplemented `JsonReader`/`JsonWriter` based on Gson.

Generated classes have two property access patterns:
- **Public API**: `setField(value)` returns `this` for fluent chaining
- **Internal API**: `internalSetField(value)` triggers listeners, no chaining

## Proto File Syntax

Extensions beyond standard protobuf:
- `abstract message Foo { ... }` — Abstract base classes
- `message Bar extends Foo { ... }` — Inheritance
- `transient` fields — Not serialized
- Annotations: `@Name("x")`, `@Nullable`, `@Embedded`, `@Container`, `@Ref`, `@Reverse("prop")`, `@Operations("ClassName")`, `@Singular("item")`
- File-level options: `option NoInterfaces;`, `option NoBinary;`, `option NoJson;`, `option NoXml;`, `option NoReflection;`, `option NoListener;`, `option NoVisitor;`, `option SharedGraph;`, `option UnorderedMaps;`
- Backtick identifiers for reserved words: `` QName `package`; ``

## Key Gotchas

- **Self-bootstrapping**: Changes to `generator/ast/proto.proto` require regenerating the AST Java classes with an existing generator, then rebuilding. Maven reactor handles this automatically.
- **NoInterfaces mode**: When set, generates single classes instead of interface + impl. Changes package structure (no `impl` subpackage). Many conditionals in `MessageGenerator` depend on this flag.
- **Polymorphic JSON**: Abstract types serialize as `[type, ...fields]` arrays. Concrete types in hierarchies use same format. Monomorphic references use `writeContent()` without type info.
- **Field IDs**: Auto-synthesis starts at 1, skips manually assigned IDs, is inheritance-aware (child fields can't clash with parent IDs). Field ID 0 is reserved.
- **Tests use JUnit 3 style** (`extends TestCase`) despite JUnit 4 dependency. Tests exercise generated code, not the generator itself directly.
- **GWT constraint**: No Java I/O classes in `msgbuf-api`. No Java 8+ features in generated code.

## Testing

Test proto files and their tests are in `de.haumacher.msgbuf.generator/src/test/java/test/`:
- `test.hierarchy` — Polymorphism, visitor pattern
- `test.container` / `test.references` — Bidirectional references, containment
- `test.graph` — Shared graph synchronization
- `test.nullable`, `test.embedded`, `test.operations`, `test.defaultvalue`, `test.transientprops`, `test.onlyxml`
- Various option combinations (NoInterfaces, NoJson, etc.)

Maven plugin integration tests: `msgbuf-generator-maven-plugin/src/it/`

## Important Constraints

- Java 11+ required (`maven.compiler.source/target = 11`)
- Generated code must be GWT-compatible (no `java.io` usage in `msgbuf-api`)
- Generator uses JavaCC — regenerate parser after grammar changes to `protobuf.jj`
- Proto files must use `syntax = "msgbuf";`
- Different licenses: API is Apache-2.0, Generator is GPL-3.0-or-later (generated code is not GPL-encumbered)
