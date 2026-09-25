# Changelog

## 1.2.3

### New Features
- **TypeScript type definitions**: Generate a TypeScript module per `.proto` file describing its JSON
  format (interfaces for messages, string-literal unions for enums, type-tagged tuple unions for polymorphic values).
  Top-level types are named with the suffix `Json` (e.g. `ShapeJson`, `AnyShapeJson`), since they describe the JSON
  format, not the data itself. Properties the Java writer always emits are required, only nullable fields are optional.
  Enabled for all files with the Maven plugin parameter `typeScriptOutputDirectory` or the `-ts <dir>` CLI argument,
  or per file with `option TypeScript = "path/to/module.ts";`.
  For polymorphic values, the modules contain small helpers operating on the plain JSON values (#10): a visitor
  interface and an exhaustive dispatch function (`visitShapeJson(value, visitor)`, with a required `visitDefault` for
  `option OpenWorld`) and a type guard checking the type tag (`isAnyShapeJson(value)`) per `Any...Json` union, and a
  function creating the type-tagged tuple per concrete type (`tagCircle(self)`). No helpers are generated for
  `option SharedGraph`. Helper names that would clash (e.g. of `message A_B` and a nested `A.B`) are rejected.
- **File documentation comment**: A doc comment before the `syntax` or `package` declaration is kept as the documentation
  of the `.proto` file (`DefinitionFile.comment`) and emitted as TSDoc `@packageDocumentation` of the TypeScript module.

### Bug Fixes
- **Nested polymorphic hierarchies** (#16): An abstract message nested in another message no longer crashes the
  generator with a `NullPointerException`. Nested sub-messages of a top-level abstract message are referenced by
  their qualified names in the generated JSON and XML readers (previously uncompilable). For `option OpenWorld`, the
  "same file" test for local subtypes and the implied `NoBinary` of extension files now also hold for nested
  definitions.
- **Maven plugin parameter names** (#17): The parameters `input`, `outputDirectory`, `resourceOutputDirectory` and
  `includePaths` can be set under these names in the plugin `<configuration>`. Before, only the user properties
  (`-DoutputDir=…`) worked, and the README's `<resourceOutputDir>` was silently ignored.
- **Format options for enums** (#20): `option NoBinary` and `option NoJson` (and the implied `NoBinary` of
  `option SharedGraph` and `option OpenWorld`) now also suppress the binary and JSON methods of enums.
  **Source compatibility:** a file that uses an enum of another file in a format the other file disables did compile
  before, because enums always had all methods. It is now rejected with an error naming both files and the option,
  as are references to messages of such files and mixed `option SharedGraph` references, which generated uncompilable
  code before. The generator (CLI and Maven plugin) now stops without writing code when it finds such errors.
- **XML format: transient and derived fields** (#29): `transient` fields are no longer written in XML format, like in
  JSON and binary format. **Wire format change:** XML documents no longer contain these attributes and elements;
  readers ignore them in documents of earlier versions. The same applies to derived references (`@Container`,
  `@Reverse`): writing an object whose container was set to XML recursed endlessly (`StackOverflowError`).
- **Redeclared fields** (#21): A field that redeclares an inherited field (directly or through any generalization,
  also across files), a field declared twice, and fields whose names generate the same Java names (e.g. `foo_bar` and
  `fooBar`) are rejected with an error. Before, the generator silently produced Java code that did not compile.
- **Extensions across files require OpenWorld** (#25): A message that extends a message of another file is rejected
  unless that file declares `option OpenWorld`. Extending from another package produced Java that did not compile.
  **Source compatibility:** extending a message of an only imported (not generated together) file of the same package
  compiled before, but the readers of the base did not know the subtype. It is now rejected as well. A closed
  hierarchy split into files of the same package that are generated together is still accepted. Inheritance cycles
  are rejected with an error instead of crashing the generator.
- **Nested specializations of the outer message** (#32): A message nested in its own generalization (e.g.
  `abstract message Expr { message Sum extends Expr {…} }`) crashed the generator with a `StackOverflowError`.
- **Consistent options across `extends`** (#37, #38, #39, #40, #41): A message that extends a message of another
  file is rejected if the files disagree on the serialization formats, `NoVisitor`, `NoVisitorExceptions`,
  `NoTypeKind` or `NoInterfaces`, or if it adds listener or reflection support its generalization lacks. These
  combinations generated uncompilable code. The exception is `NoJson` (or `NoXml`) only on an OpenWorld extension
  file: it compiled, but the extension type was written without its own fields and could not be read. It is rejected
  now as well. `option OpenWorld` on a file whose hierarchy root is in a file without it, and `OpenWorld` combined
  with `SharedGraph` or `NoInterfaces` (before only a message on the console), are rejected. `option NoVisitor` now
  also suppresses the visitor of OpenWorld extension types.
- **OpenWorld readers of abstract intermediates** (#26): The JSON reader of an abstract message below the root of an
  `option OpenWorld` hierarchy (e.g. `Bird` in `Animal > Bird > Parrot`, top-level or nested) no longer fails to
  compile. It reads the types of other files registered with the root, if they are specializations of the message; a
  registered type of another subtree is skipped like an unknown type (the reader returns `null`). This also works for
  abstract intermediates declared in extension files (which need `option OpenWorld` to be extended themselves), at any
  depth. All concrete messages of an extension file below an OpenWorld message of another file are now registered,
  also those extending a message of their own file. Visiting a type of an extension-file intermediate with a visitor
  that does not know it calls `visitDefault()`, and such types return `null` from `kind()`. The JSON readers load the
  type registrations themselves (before, reading an extension type returned `null` unless some implementation class
  of the hierarchy had been initialized before).
- **OpenWorld XML readers** (#27): The XML readers of an `option OpenWorld` hierarchy (root and abstract intermediates)
  now read the types of other files. The generated registration class (e.g. `Ext1Types`) additionally registers the
  XML element name of each extension type with the root (`registerXml()`, `XML_REGISTRY`), if the files generate XML.
  The wire formats are unchanged.

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
