# Changelog

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
