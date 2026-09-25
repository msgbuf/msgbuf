# Changelog

## 1.2.3

### New Features
- **TypeScript type definitions**: Generate a types-only TypeScript module per `.proto` file describing its JSON
  format (interfaces for messages, string-literal unions for enums, type-tagged tuple unions for polymorphic values).
  Top-level types are named with the suffix `Json` (e.g. `ShapeJson`, `AnyShapeJson`), since they describe the JSON
  format, not the data itself. Properties the Java writer always emits are required, only nullable fields are optional.
  Enabled for all files with the Maven plugin parameter `typeScriptOutputDirectory` or the `-ts <dir>` CLI argument,
  or per file with `option TypeScript = "path/to/module.ts";`.
- **File documentation comment**: A doc comment before the `syntax` or `package` declaration is kept as the documentation
  of the `.proto` file (`DefinitionFile.comment`) and emitted as TSDoc `@packageDocumentation` of the TypeScript module.

### Bug Fixes
- **Nested polymorphic hierarchies** (#16): An abstract message nested in another message no longer crashes the
  generator with a `NullPointerException`. Nested sub-messages of a top-level abstract message are referenced by
  their qualified names in the generated JSON and XML readers (previously uncompilable). For `option OpenWorld`, the
  "same file" test for local subtypes and the implied `NoBinary` of extension files now also hold for nested
  definitions.
- **Format options for enums** (#20): `option NoBinary` and `option NoJson` (and the implied `NoBinary` of
  `option SharedGraph` and `option OpenWorld`) now also suppress the binary and JSON methods of enums.
  **Source compatibility:** a file that uses an enum of another file in a format the other file disables did compile
  before, because enums always had all methods. It is now rejected with an error naming both files and the option,
  as are references to messages of such files and mixed `option SharedGraph` references, which generated uncompilable
  code before. The generator (CLI and Maven plugin) now stops without writing code when it finds such errors.

## 1.2.1

### Bug Fixes
- **GWT compatibility for `json` field type**: Remove XML serialization (`javax.xml.stream.*`) from `JsonValue` envelope classes in `msgbuf-api`, which broke GWT compilation. JSON fields in XML format are serialized as JSON text strings instead.

## 1.2.0

### New Features
- **`json` field type**: Native JSON value type for carrying opaque JSON data without double-serialization. In JSON format, values are written inline; for binary, a `JsonValue` envelope hierarchy is used. Java API uses `Object` (Map, List, String, Number, Boolean, null).
- **`option OpenWorld`**: Cross-file protocol extension for abstract type hierarchies. Subtypes can be defined in separate `.proto` files and modules using `import` and `extends`. Extension types are discovered at runtime via `ServiceLoader`.
- **Classpath-based import resolution**: Imports are resolved from compile-scope dependency JARs, so no file system paths to base modules are needed.
- **Cross-file message embedding**: Import mechanism supports using messages from one protocol as field types in another (not just `extends`).
- **`-resources` CLI argument**: Configure output directory for generated `META-INF/services` descriptors.
- **`-cp` CLI argument**: Specify JARs to search for imported `.proto` files.
- **Maven plugin `includePaths` parameter**: Configure additional include paths for proto file resolution.

### Bug Fixes
- **Binary map serialization**: Fix missing write implementation for `map<K,V>` fields in binary format.

## 1.1.11

### New Features
- **`option UnorderedMaps`**: Use `HashMap` instead of `LinkedHashMap` for map properties when insertion order is not important.
- **`@Singular("item")` annotation**: Specify singular form for repeated fields, overriding automatic pluralization heuristics.
- **Default field values**: Fields can specify inline default values using `= value` syntax.
- **Backtick-quoted identifiers**: Use backticks to escape identifiers that clash with msgbuf keywords.
- **Primitive type aliases**: `int` for `int32`, `long` for `int64`, `boolean` for `bool`.
- **`@Operations("ClassName")` annotation**: Mix-in interfaces with operations on data classes.
- **Dart code generation**: `option DartLib` generates Dart data classes with JSON serialization.
