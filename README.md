# msgbuf
Code generator for GWT-compatible Java data classes suitable for typed client-server messaging.

Inspired by Google's [protocol buffers](https://developers.google.com/protocol-buffers), `msgbuf` provides a code generator that produces data classes out of a concise protocol definition file. 

In contrast to `protobuf`, `msgbuf` supports:
 * Code generation compatible with the [GWT Java-to-Javascript compiler](http://www.gwtproject.org/).
 * Inheritance of data classes.
 * Abstract data classes defining the root of a hierarchy of exchangeable data fragments.
 * Polymorphic data compositions.
 * [Visitor pattern](https://en.wikipedia.org/wiki/Visitor_pattern) for processing polymorphic data structures.
 
`msgbuf` serializes messages in JSON, Binary, and XML formats. For GWT-compatibility it uses a modified `JsonReader`/`JsonWriter` from the [gson library](https://github.com/google/gson) that was abstracted from the unsupported `Reader`/`Writer` Java API.

## Setup with Maven

### Add the MsgBuf runtime library dependency to your project

```xml
<dependency>
    <groupId>de.haumacher.msgbuf</groupId>
    <artifactId>msgbuf-api</artifactId>
    <version>1.2.1</version>
</dependency>
```

### Add the MsgBuf generator to your pom.xml

To the `build/plugins` section add:

```xml
<plugin>
    <groupId>de.haumacher.msgbuf</groupId>
    <artifactId>msgbuf-generator-maven-plugin</artifactId>
    <version>1.2.1</version>
    
    <executions>
        <execution>
            <id>generate-protocols</id>
            <goals>
                <goal>generate</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

Now you are ready to create `*.proto` files in your source folder and build them with `mvn compile`.

### Where to place proto files

Proto files are placed in your Java source folder (`src/main/java/`) inside the directory matching their `package` declaration. The generated Java files are written next to the proto file. For example, a proto file with `package my.app.model;` should be placed at `src/main/java/my/app/model/shape.proto`, and the generated classes will appear in `src/main/java/my/app/model/`.

### Plugin parameters

All parameters are optional. Set them in the `<configuration>` of the plugin (or its execution), or with the user
property on the command line (`-D<property>=...`):

| Parameter | User property | Default | Description |
|---|---|---|---|
| `input` | `input` | `${project.build.sourceDirectory}` | Directory searched for `.proto` files (or a single `.proto` file). |
| `outputDirectory` | `outputDir` | `${project.build.sourceDirectory}` | Directory the Java sources are generated to. |
| `resourceOutputDirectory` | `resourceOutputDir` | `${project.basedir}/src/main/resources` | Directory resource files (`META-INF/services`) are generated to. |
| `typeScriptOutputDirectory` | `typeScriptOutputDir` | none | Directory TypeScript types are generated to (see [TypeScript](#typescript-type-definitions)). |
| `includePaths` | `includePaths` | none | Additional directories searched for imported `.proto` files. |

If `outputDirectory` is not a source folder of the project, add it as one (e.g. with the `build-helper-maven-plugin`).

## Usage
 
The `msgbuf` definition language is an extension of the [proto format](https://developers.google.com/protocol-buffers/docs/proto3) from `protobuf`. A defined message can `extend` another message type, or it can be marked `abstract`. 

Assume, you want to describe shapes in a graphics application, you could define the data types as follows. You may start with an `abstract` shape class, defining coordinates of the origin of its coordinate system:

Add `src/main/java/my/app/model/shape.proto` with the following contents:
```protobuf
package my.app.model;

abstract message Shape {
  int32 xCoordinate;
  int32 yCoordinate;
}
```

Based on that, you create concrete classes for circles and rectangles:

```protobuf
message Circle extends Shape {
  int32 radius;
}

message Rectangle extends Shape {
  int32 width;
  int32 height;
}
```

Finally, you could create a group class that allows combining arbitrary shapes by placing them into a new coordinate system:

```protobuf
message Group extends Shape {
  repeated Shape shapes;
}
```

Passing these definitions to the `msgbuf` compiler gives you a class hierarchy with classes `Shape`, `Circle`, `Rectangle`, and `Group`. You can inspect the generation result in the test package [test.hierarchy](https://github.com/msgbuf/msgbuf/tree/main/de.haumacher.msgbuf.generator/src/test/java/test/hierarchy/data) of the compiler. The source of the example data class definitions can be seen in the [hierarchy.proto](https://github.com/msgbuf/msgbuf/tree/main/de.haumacher.msgbuf.generator/src/test/java/test/hierarchy/data/hierarchy.proto) file.

A sub-message inherits all fields of its generalizations and cannot redeclare them, not even to narrow the type. The
names of all fields of a message, including the inherited ones, must also generate distinct Java names: `foo_bar`
and `fooBar` both generate `getFooBar()`. The generator rejects such definitions with an error naming the field and
the message declaring the other one.

### Enum types

Enums define a fixed set of named constants. Each constant is terminated with a semicolon. Constants can optionally
have explicit numeric IDs assigned:

```protobuf
enum Corpus {
    UNIVERSAL = 0;
    WEB = 1;
    IMAGES = 2;
}
```

Enums can also be nested inside messages:

```protobuf
message SearchRequest {
    enum Corpus {
        UNIVERSAL = 0;
        WEB = 1;
    }
    Corpus corpus;
}
```

### Nested messages

Messages can be nested inside other messages:

```protobuf
message SearchResponse {
    message Result {
        string url;
        string title;
        repeated string snippets;
    }
    repeated Result results;
}
```

### Type names and imports

Messages and enums of other `.proto` files are made available with `import "path/to/other.proto";` (resolved relative
to the importing file, then in the include paths, then on the classpath). A type can always be referenced by its
qualified name (`package.Type`, `package.Outer.Inner`). An unqualified name `Type` (or `Type.Inner`) is resolved in
the following order; the first step that finds a definition wins:

1. A nested definition of the message using the name, or of one of its outer messages (innermost first).
2. A top-level definition of the package of the file using the name (in any file of that package generated in the same
   run).
3. A top-level definition of a file imported by that file. If none of the imported files defines the name, the files
   they import are searched, and so on. Two definitions found in the same step are an error: use a qualified name.
4. For compatibility, a top-level definition of any other file generated in the same run, if exactly one file defines
   the name. Otherwise, the name is rejected as ambiguous.

Because of step 3, adding an unrelated file to the files generated together (e.g. a new `.proto` file in a Maven
project) does not change how the names of a file resolve, as long as the definitions it uses come from its own package
or its imports. A package must not define a top-level name twice, not even in different files.

### Transient fields

Fields marked with `transient` are not serialized in any format (JSON, binary, XML). They exist only in the in-memory
representation. Readers ignore values of transient fields, e.g. in XML documents written by versions before 1.2.3:

```protobuf
message A {
    string name;
    transient string cachedValue;
}
```

### Backtick-quoted identifiers

Backticks can be used to escape identifiers that clash with msgbuf keywords:

```protobuf
message NullableValues {
    @Nullable
    int `int`;
    @Nullable
    boolean `boolean`;
}
```

### Primitive type aliases

In addition to the protobuf type names, `msgbuf` supports shorter aliases:
- `int` for `int32`
- `long` for `int64`
- `boolean` for `bool`

### Native JSON value type (`json`)

The `json` type represents an opaque JSON value — any valid JSON structure (object, array, string, number, boolean, or null). This avoids double-serialization when a message needs to carry dynamically-typed data:

```protobuf
message PatchEvent {
    string controlId;
    json patch;
}
```

In JSON format, the value is written natively without string-wrapping:

```json
{"controlId":"c1","patch":{"nodes":{"n1":{"x":100}}}}
```

The generated Java API uses `Object` as the field type. Supported value types are `Map<String, Object>`, `List<Object>`, `String`, `Long`, `Double`, `Boolean`, and `null`:

```java
Map<String, Object> patch = new LinkedHashMap<>();
patch.put("nodes", ...);
PatchEvent event = PatchEvent.create()
    .setControlId("c1")
    .setPatch(patch);

// Reading back:
Object value = event.getPatch(); // Map, List, String, Number, Boolean, or null
```

For binary serialization, json values are wrapped in a `JsonValue` message envelope (defined in `de.haumacher.msgbuf.json.value`). For XML, json values are encoded as JSON strings in element text.

## Global protocol options

### `option NoJson`
Disables generation of read and write methods for the JSON format (for messages and enums).

### `option NoBinary`
Disables generation of read and write methods for binary format (for messages and enums).

### `option NoXml`
Disables generation of read and write methods for XML format.

The format options apply to all messages and enums of a file. A message that references a message or enum of another
file (as field type or with `extends`) needs the read and write methods of each format it generates itself in that
other file. The generator rejects a reference to a definition generated without such a format, and generates no code
in that case. Either disable the format in the referencing file as well, or enable it in the referenced one. The same
holds for `option SharedGraph`, which has its own JSON methods for messages: a message can reference messages of
another file only if both files use `option SharedGraph`, or neither does. Enums are not affected by
`option SharedGraph`. `transient` fields and derived references (`@Container`, `@Reverse`) are not serialized, so they
don't need these formats.

A message that extends a message of another file implements and overrides its generated methods. So both files must
agree on the serialization formats, `option NoVisitor`, `option NoVisitorExceptions`, `option NoTypeKind` and
`option NoInterfaces`. A specialization may be generated without the listener (`option NoListener`) or reflection
(`option NoReflection`) support of its generalization, but not with support its generalization lacks. The generator
rejects other combinations with an error naming both files.

### `option NoXmlNames`
Disables generation of constants for the XML format.

### `option NoInterfaces`
Disables generation interfaces for data classes. Normally, data classes are represented by a Java interface. This
enables multiple inheritance for data classes. To reduce the amount of generated code, this can be disabled for simple
cases, where no multiple inheritance is required.

### `option NoListener`
Disables generation of listener interfaces and corresponding registration methods. Add this options, if observing 
data classes for changes is not required.

### `option NoReflection`
Disables generation of reflective access methods that allow access to properties through their property names.

### `option NoVisitor`
Disables generation of visitor interfaces and visit methods. 

### `option NoVisitorExceptions`
Produces visitor interfaces that cannot throw declared exceptions.

### `option NoTypeKind`
Suppresses the type kind enumeration for a data class hierarchy.

### `option SharedGraph`
Allows to handle multiple synchronized instances of a data class graph. Each graph can be observed for changes. Changes
generate synchronization messages to keep other instances of the same shared graph up to date. With this option,
a shared graph can be instantiated on a server, transferred to a client while keeping the state in sync when changes
occur on each side.

### `option UnorderedMaps`
Uses `HashMap` instead of `LinkedHashMap` for map-type properties. By default, map properties use `LinkedHashMap` to
preserve insertion order. This option switches to `HashMap` for better performance when insertion order is not important.

Example:
```protobuf
option UnorderedMaps;  // Use HashMap for better performance

message Config {
    map<string, string> settings;  // Will use HashMap instead of LinkedHashMap
}
```

### `option OpenWorld`
Enables cross-file protocol extension for abstract type hierarchies. With this option, subtypes can be defined in
separate `.proto` files (and separate modules) using `import` and `extends`.

A message can extend a message of another file only if that file declares `option OpenWorld`, so that the readers of
the hierarchy resolve types of other files. This also holds for an intermediate: to extend a message of an extension
file, the extension file must declare `option OpenWorld` as well. The only exception is a hierarchy without
`OpenWorld` that is split into several files of the same package, which are generated together. The generator rejects
other extensions across files with an error.

```protobuf
// base-module: events.proto
option OpenWorld;

abstract message Event {
    long timestamp;
}

message TextEvent extends Event {
    string text;
}
```

```protobuf
// extension-module: graph-events.proto
import "../base-module/events.proto";

message GraphPatchEvent extends base.pkg.Event {
    string controlId;
    string patch;
}
```

Extension types are discovered at runtime via `ServiceLoader`. The generator produces a registration class
(e.g. `GraphEventsTypes`) and a `META-INF/services` descriptor automatically when the `-resources` output
directory is configured. On platforms without `ServiceLoader` (e.g. GWT), call `GraphEventsTypes.init()` explicitly.

The base module's `.proto` files should be packaged as resources in its JAR (e.g. in `src/main/resources`).
The Maven plugin automatically resolves imports from compile-scope dependency JARs, so no file system paths
to the base module are needed.

Readers of the hierarchy (of the root and of abstract intermediates) resolve the types of all registered
extension modules in JSON and XML format. The registration class registers the JSON type ID and, if XML is
generated, the XML element name of each extension type with the root of the hierarchy. A reader of an abstract
intermediate only accepts registered types that specialize the intermediate. An unknown type (or a registered
type of another subtree) is skipped, and the reader returns `null`. An abstract message of an extension file can
itself be extended in further files, if the extension file declares `option OpenWorld`, too.

Implications:
- Implies `option NoBinary` (only JSON and XML serialization are supported)
- Cannot be combined with `option NoInterfaces` or `option SharedGraph`
- The root's file must declare `option OpenWorld` if any file of the hierarchy does
- The generated `Visitor` interface includes a `visitDefault()` fallback method for unknown extension types
- Extension types generate their own `Visitor` sub-interface with an `instanceof`-based dispatch

Maven plugin configuration (extension module):
```xml
<configuration>
    <resourceOutputDirectory>${project.basedir}/src/main/resources</resourceOutputDirectory>
</configuration>
```

Imports are resolved automatically from the compile classpath. If the base module packages its `.proto` files
as resources, no additional configuration is needed beyond declaring the dependency.

CLI usage (standalone, without Maven):
```
java -jar msgbuf-generator.jar -out src/main/java -resources src/main/resources -cp base-module.jar extension.proto
```

The `-cp` option specifies JARs to search for imported `.proto` files. The `-I` option can still be used
for file system include paths.

## Message options

### Mix-in interfaces (`@Operations(...)`)

The data classes can extends mix-in interfaces with operations.

```protobuf
/** The data class */
@Operations("test.operations.DataOperations")
message Data {
  int x;
}
```
```java
/** The mix-in interface with operations on data. */
public interface DataOperations {
    /** Access to the data. */
    Data self();
    
    /** Operation added to data class. */
    default void inc() {
        self().setX(self().getX() + 1);
    }
}

/** Testing the mix-in operation. */
public void testOperations() {
    Data data = Data.create();
    data.inc();
    data.inc();
    assertEquals(2, data.getX());
}
```

## Property options

### `@Nullable`
A property of a primitive type that does not allow `null` values (e.g. `int` and `string`) can be explicitly marked to
allow `null` values.

### `@Singular("item")`
Specifies the singular form for a repeated field, used when generating `addXxx()` and `removeXxx()` methods. This annotation
takes precedence over the automatic pluralization heuristics. Useful for irregular plurals or when the heuristics produce
incorrect results.

Example:
```protobuf
message Container {
    @Singular("person")
    repeated string people;      // Generates addPerson() instead of addPeople()

    @Singular("child")
    repeated string children;    // Generates addChild() instead of addChildren()

    @Singular("datum")
    repeated string data;        // Generates addDatum() instead of addData()
}
```

### `@Name("myProp")`
Sets a custom property name. This name is used in JSON serialization.

### `@XmlName("myProp")`
Sets a custom tag name for XML serialization.

### `@Reverse("otherProp")`
Marks a reference to be the reverse end of the reference with the given name in the target type.

### `@Container`
Marks a reference point to the container of the current object. The container reference is derived from the
containment and not serialized.

### `@Ref`
Marks a reference as cross reference (non-composition). When setting values to fields marked as cross reference, container properties are not updated.

### `@type_id(4711)`
Sets a custom type discriminator ID for binary serialization of polymorphic hierarchies.

### Default values
Fields can specify default values inline using `= value` syntax:

```protobuf
message Config {
    string name = "default";
    int count = 42;
    double ratio = 3.14;
    bool enabled = true;
}
```

### `map<K,V>` fields
Map-type fields are supported using the `map<KeyType, ValueType>` syntax:

```protobuf
message Config {
    map<string, string> settings;
    map<string, int32> counts;
}
```

### XML reference embedding (`@Embedded`)
When serializing data classes to XML, all data fields and references are normally represented by XML tags with the same 
name as the field or reference. By adding the `@Embedded` annotation to a reference, the tag for the reference can be 
omitted. The contents of the reference is placed directly within the tag for the containing element. Care must be taken 
that the tag names for referenced elements do not clash with tag names of other attributes and references of the 
container.

In the following example, a container with contents A and B can be written `<container><a/><b/></container>` instead of 
wrapping the contents into an extra element as in `<container><contents><a/><b/></contents></container>`. 
 
```protobuf
message Container {
    @Embedded
    repeated Base contents;
}

abstract message Base {}
message A extends Base {}
message B extends Base {}
```

However, even with the `@Embedded` annotation, the verbose serialization with the wrapping reference element is also 
understood.

## Plugin options

### `option DartLib = "path/to/output.dart";`
Generates a Dart library file containing Dart data classes with JSON serialization support for all messages and enums
defined in the proto file. The path is relative to the generator output directory.

```protobuf
option DartLib = "../lib/protocol.dart";

message MyMessage {
    string name;
    int count;
}
```

### TypeScript type definitions

The generator can create a TypeScript module with type definitions for the JSON format of each `.proto` file. The
modules let a TypeScript client share the protocol contract with the Java side. Besides the types, they only contain
small helper functions for type-tagged polymorphic values (visitor dispatch, tagging, tag guards, see below) that
operate on the plain values of `JSON.parse()`: no classes, no readers or writers, no runtime library.

Since the types describe the JSON format and not the data itself, a top-level type is named after its definition with
the suffix `Json`, e.g. `ShapeJson` for `message Shape`. This keeps the plain names free for types representing the
data in the TypeScript application.

TypeScript output is enabled in one of the following ways:

* **Output directory for all files**: Set the Maven plugin parameter `typeScriptOutputDirectory` (user property
  `typeScriptOutputDir`), or pass `-ts <dir>` on the command line. A module is generated for each `.proto` file.
  The module for a file `name.proto` with `package a.b.c;` is written to `a/b/c/name.ts` within that directory.
* **Per file**: `option TypeScript = "path/to/module.ts";` in a `.proto` file. The path is relative to the generator
  output directory (like `option DartLib`) and takes precedence over the output directory.

```xml
<plugin>
    <groupId>de.haumacher.msgbuf</groupId>
    <artifactId>msgbuf-generator-maven-plugin</artifactId>
    <version>...</version>
    <configuration>
        <typeScriptOutputDirectory>${project.basedir}/src/main/ts/protocol</typeScriptOutputDirectory>
    </configuration>
    ...
</plugin>
```

Mapping of protocol definitions:

| Protocol definition | TypeScript |
|---|---|
| `message M { ... }` | `export interface MJson { ... }` with the JSON property names of the fields (`@Name` is honored) |
| `message M extends B` | `export interface MJson extends BJson` |
| `abstract message A` | `export interface AJson`, plus `export type AnyAJson = ['TypeIdOfC1', C1Json] \| ...` if the hierarchy root is abstract (see below) |
| `enum E { ... }` | `export type EJson = 'A' \| 'B';` with the protocol names of the constants (`@Name` is honored) |
| `string` | `string` |
| `bytes` | `string \| null` (Base64 encoded, see below) |
| `bool` | `boolean` |
| `int32`, `int64`, `float`, `double`, ... | `number` |
| `json` | `unknown` |
| `repeated T` | `T[]` |
| `map<string, V>` | `Record<string, V>` |
| `map<K, V>` (other key types) | `Array<{ key: K; value: V }>` |
| Nested definitions | Declarations in a namespace named after the outer message, keeping their names, e.g. `OuterJson.Inner` |
| Types from imported `.proto` files | `import type { ... } from '<relative module path>';` |
| `abstract message A` with `AnyAJson` | Visitor interface `AJsonVisitor<R>`, dispatch function `visitAJson(value, visitor)`, type guard `isAnyAJson(value)` |
| `message C extends A` (in a hierarchy with abstract root) | Function `tagC(self: CJson): ['TypeIdOfC', CJson]` creating the type-tagged tuple |

Details:

* **Required and optional properties**: The types describe the JSON the Java side writes. A property is required
  (`name: T`), if it is always written. Fields that are nullable (`@Nullable`, non-repeated references to messages,
  `json`) are omitted from the JSON output when unset instead of being written as `null`, their properties are
  optional (`name?: T`). A non-nullable `bytes` field has no value by default and is written as `null` then, it is
  typed `string | null`. Note that the JSON reader is more lenient: it accepts any subset of properties and uses the
  field's default value for a missing one. Explicit default values of fields are documented with a `@defaultValue`
  tag.
* **Enum values**: An enum constant is written as its name exactly as spelled in the `.proto` file (e.g. `ICON_ONLY`),
  unless a custom name is given with `@Name`:

  ```protobuf
  enum DisplayMode {
      @Name("icon-only")
      ICON_ONLY;
      @Name("label-only")
      LABEL_ONLY;
  }
  ```

  generates `export type DisplayModeJson = | 'icon-only' | 'label-only';`.
* **Polymorphism**: A value of an abstract message type in a hierarchy with an abstract root is written as a tuple
  of its type ID and its properties, `["Circle", {"r": 5}]` (see [Polymorphic JSON serialization](#polymorphic-json-serialization)).
  For each such abstract message `A`, a union type `AnyAJson` of the tuples of all known concrete specializations is
  generated and used as type of fields referencing `A`. For `option OpenWorld` hierarchies, the union additionally
  contains `[string, AJson]` for extension types from other modules. References to concrete messages (and all messages
  in a hierarchy with a concrete root) are written without type information and use the interface directly.
* **Helpers for polymorphic values**: For each union `AnyAJson`, a visitor interface with one method per concrete
  type of the union, a dispatch function and a type guard are generated, and a tag function for each concrete type
  of such a hierarchy:

  ```ts
  export interface SSEEventJsonVisitor<R> {
      visitPatchEvent(self: PatchEventJson): R;
      visitStateEvent(self: StateEventJson): R;
  }
  export function visitSSEEventJson<R>(value: AnySSEEventJson, visitor: SSEEventJsonVisitor<R>): R;
  export function isAnySSEEventJson(value: unknown): value is AnySSEEventJson;
  export function tagPatchEvent(self: PatchEventJson): ['PatchEvent', PatchEventJson];
  ```

  Usage:

  ```ts
  const event: unknown = JSON.parse(data);
  if (isAnySSEEventJson(event)) {
      visitSSEEventJson(event, {
          visitPatchEvent: patch => applyPatch(patch),
          visitStateEvent: state => replaceState(state),
      });
  }
  socket.send(JSON.stringify(tagPatchEvent({ timestamp: Date.now(), patch: '...' })));
  ```

  * The name part of a helper (`SSEEvent`, `PatchEvent`) is the message name qualified with the names of its outer
    messages, joined with `_`, first letter in upper case, e.g. `visitGroup_Info` and `tagGroup_Info` for message
    `Info` nested in `Group`. The package is not part of the name. All helpers are declared at the top level of the
    module, also for nested messages (a namespace containing functions is not erasable TypeScript syntax). The
    generator rejects a `.proto` file whose helper names clash, i.e. two concrete types of one hierarchy (also from
    different files) or two messages of one file with the same name part, e.g. `message A_B` and `A.B`.
  * A visitor method has the same name in the visitors of all abstract types of a hierarchy, so a visitor of the root
    can also be passed to the dispatch function of an abstract intermediate type.
  * The dispatch function of a closed hierarchy is checked for exhaustiveness by the compiler and throws an `Error`
    for an unknown type ID. For `option OpenWorld` hierarchies, the visitor has an additional required method
    `visitDefault(self: AJson, typeId: string)` that receives values of types not known to the module (like the
    `visitDefault()` of the Java visitor).
  * The type guard checks the type tag only: an array of two elements, the first a known type ID (any string for
    `option OpenWorld`), the second an object. The properties of the object are not validated.
  * Tag functions return the exact tuple type, which is assignable to each `Any...Json` union containing the type.
* **Documentation**: Doc comments become TSDoc comments. JavaDoc inline tags are translated: `{@code x}` becomes
  `` `x` ``, `{@link Type}`, `{@link #field}` and `{@link Type#field label}` become links to the TypeScript type or
  property (`{@link Type.prop label}`, using the JSON property name), a link to an enum constant becomes its protocol
  name in back ticks, and an unresolvable link becomes its label or the target in back ticks. The doc comment
  (`/** ... */`) before the `syntax` or `package` declaration of a `.proto` file becomes the module's
  `@packageDocumentation` comment.
* **Module paths**: Imports use relative module specifiers without file extension (e.g. `'../common/common'`), as
  resolved by bundlers and `moduleResolution: "bundler"`. An imported `.proto` file is expected to have its module
  at the location the same generator configuration would produce for it (its `option TypeScript`, or its package
  path within the TypeScript output directory).
* **Limitations**: The JSON format of `option SharedGraph` protocols (objects as `[type, id, {...}]`, references as
  IDs, incremental updates) is not described by the generated types, no helper functions are generated for them. A generated `AnyAJson` union type may clash with
  a message named `AnyA`.

## Installation in Eclipse

There is an Eclipse plugin providing a project builder that automatically generates corresponding Java files whenever you create or modify a `*.proto` definition file. To install and enable the plugin with the following steps:

### Add update site

 * Open the dialog `Help > Install new Software`.
 * Enter `msgbuf - https://msgbuf.github.io/msgbuf/update-site/` in the `Work with` field, click the `Add...` button, and acknowledge the addition. 
 * Select the `MsgBuf Project Builder` checkbox and click `Finish`. 
 * Accept the license and the installation of unsigned content.

### Enable the MsgBuf Builder in your project

 * Select your project in the `Package Explorer`.
 * In the context menu, select `Configure > Enable MsgBuf Builder`.

### Test the installation

 * Create a `MyMessage.proto` file in one of your packages in the source folder.
 * Add the package definition and a message declaration.
 * Immediately, when you save your changes, a corresponding `MyMessage` class should appear that can be directly used in your code.

## Features

### Polymorphic JSON serialization

All of the generated data classes have get- and set-methods for their properties. Additionally, each class has methods for writing its contents to JSON format and reading it back:

```java
/** Reads a new instance from the given reader. */
public static Rectangle readRectangle(JsonReader in) throws IOException {
   ...
}

/** Writes this instance to the given output. */
public final void writeTo(JsonWriter out) throws IOException {
   ...
}
```

Note that `JsonReader` and `JsonWriter` use `de.haumacher.msgbuf.io.Reader` and `de.haumacher.msgbuf.io.Writer` instead of `java.io.Reader` and `java.io.Writer`. This is required for GWT compatibility, since `java.io` is not available in GWT. For in-memory string-based serialization, use `StringR` and `StringW`:

```java
// Writing to a JSON string:
StringW out = new StringW();
rectangle.writeTo(new JsonWriter(out));
String json = out.toString();

// Reading from a JSON string:
Rectangle copy = Rectangle.readRectangle(new JsonReader(new StringR(json)));
```

On the server side (where GWT compatibility is not needed), you can use `ReaderAdapter` and `WriterAdapter` from `de.haumacher.msgbuf.server.io` to wrap standard `java.io.Reader`/`java.io.Writer` instances:

```java
// Reading from a java.io.Reader:
Rectangle r = Rectangle.readRectangle(new JsonReader(new ReaderAdapter(javaIoReader)));

// Writing to a java.io.Writer:
rectangle.writeTo(new JsonWriter(new WriterAdapter(javaIoWriter)));
```

In polymorphic hierarchy of classes as defined above, it is not enough for a class to just write its own properties. Consider a `Group` instance from the example above. Its `shapes` list may contain multiple instances of either circles, rectangles, or even nested groups. Therefore, a class in a polymorphic hierarchy not only serializes its properties, but also its type. Reading back such polymorphic instance instantiates the correct class and fills it with its properties.

### Visitor pattern

In a client-server messaging scenario, the server (or client) receives polymorphic messages and must dispatch each one to the appropriate handler. Consider a protocol with different request types:

```protobuf
abstract message Request {
    string sessionId;
}

message LoginRequest extends Request {
    string username;
    string password;
}

message QueryRequest extends Request {
    string query;
    int32 limit;
}

message LogoutRequest extends Request {
}
```

You could use `instanceof` checks to handle each request type, but this is fragile — if a new request type is added to the protocol, the compiler won't warn you about the missing case, leading to silent failures at runtime.

The generated visitor pattern solves this. Each abstract message hierarchy generates a `Visitor` interface with a case for every concrete subtype. When a new message type is added, every visitor implementation fails to compile until the new case is handled, guaranteeing completeness at compile time.

```java
public class RequestHandler implements Request.Visitor<Response, Session> {
    @Override
    public Response visit(LoginRequest self, Session session) {
        return authenticate(self.getUsername(), self.getPassword());
    }

    @Override
    public Response visit(QueryRequest self, Session session) {
        return executeQuery(self.getQuery(), self.getLimit());
    }

    @Override
    public Response visit(LogoutRequest self, Session session) {
        session.invalidate();
        return Response.ok();
    }
}

// Dispatching a received message:
Request request = Request.readRequest(new JsonReader(input));
Response response = request.visit(handler, session);
```

The visitor pattern also works for non-messaging use cases. For the shape hierarchy defined above, a renderer could be implemented as follows.

An `abstract` base class provides a `Visitor` interface and a `visit(...)` method accepting such a visitor:

```java
public abstract class Shape {

   /** Visitor interface for the {@link Shape} hierarchy.*/
   public interface Visitor<R,A> {

      /** Visit case for {@link Circle}.*/
      R visit(Circle self, A arg);

     /** Visit case for {@link Rectangle}.*/
     R visit(Rectangle self, A arg);

     /** Visit case for {@link Group}.*/
     R visit(Group self, A arg);

   }
  
   ...

   /** Accepts the given visitor. */
   public abstract <R,A> R visit(Visitor<R,A> v, A arg);
}
```

Each of the concrete sub-classes implement the `abstract` visit-method by delegating to the corresponding case-method from the `Visitor` interface:

```java
public class Rectangle extends Shape {

   ...

   @Override
   public <R,A> R visit(Shape.Visitor<R,A> v, A arg) {
      return v.visit(this, arg);
   }
}
```

This allows creating e.g. a renderer implementation that handles all concrete types from the shape hierarchy:

```java
public class ShapeRenderer implements Shape.Visitor<Void, Graphics2D> {
   @Override
   public Void visit(Rectangle self, Graphics2D g2d) {
      g2d.drawRect(self.getXCoordinate(), self.getYCoordinate(), self.getWidth(), self.getHeight());
      return null;
   }

   @Override
   public Void visit(Circle self, Graphics2D g2d) {
      ...
   }

   @Override
   public Void visit(Group self, Graphics2D g2d) {
      for (Shape shape : self.getShapes()) {
         shape.visit(this, g2d);
      }
      return null;
   }
}
```

Having an arbitrary `Shape` instance and a renderer from above, you can render the shape to a `Graphics2D` with the following code:

```java
Shape shape = ...;
ShapeRenderer renderer = ...;
Graphics2D g2d = ...;

shape.visit(renderer, g2d);
```

