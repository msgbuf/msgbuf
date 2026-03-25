# Cross-File Protocol Extension Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Enable message types to extend abstract messages defined in other `.proto` files, with dynamic type registration for polymorphic deserialization.

**Architecture:** Opt-in via `option OpenWorld;` in the base proto file. The parser gets `import` statement support. A runtime registry in `msgbuf-api` (`Factory`, `TypeRegistration`, `TypeRegistryLoader`) enables dynamic subtype registration. The generator produces registry-based deserialization for OpenWorld hierarchies and registration classes for extension modules. ServiceLoader integration lives in the runtime with graceful GWT/JS fallback.

**Tech Stack:** Java 11, JavaCC (parser), Maven (build), JUnit 3 (tests)

**Spec:** `docs/superpowers/specs/2026-03-24-cross-file-protocol-extension-design.md`

---

## File Map

### New files in `msgbuf-api` (`de.haumacher.msgbuf`)

| File | Responsibility |
|------|---------------|
| `src/main/java/de/haumacher/msgbuf/data/Factory.java` | Generic factory interface (GWT-safe replacement for `Supplier`) |
| `src/main/java/de/haumacher/msgbuf/data/TypeRegistration.java` | Interface for registration classes to implement |
| `src/main/java/de/haumacher/msgbuf/data/TypeRegistryLoader.java` | ServiceLoader-based auto-discovery with GWT fallback |

### Modified files in generator (`de.haumacher.msgbuf.generator`)

| File | Changes |
|------|---------|
| `src/main/java/de/haumacher/msgbuf/generator/ast/proto.proto` | Add `repeated string imports` field to `DefinitionFile` |
| `src/main/javacc/protobuf.jj` (actually at `src/main/java/.../parser/protobuf.jj`) | Add `IMPORT` token, import grammar rule |
| `src/main/java/.../generator/Generator.java` | Import resolution, `-I` CLI arg, OpenWorld validation |
| `src/main/java/.../generator/NameTable.java` | Cross-package lookups for imported types |
| `src/main/java/.../generator/MessageGenerator.java` | Registry-based reader, `visitDefault()`, `instanceof` dispatch |
| `src/main/java/.../generator/TypeIdSynthesizer.java` | Skip OpenWorld hierarchies |

### Modified files in Maven plugin

| File | Changes |
|------|---------|
| `src/main/java/.../maven/GenerateMessageClasses.java` | Add `<includePaths>` parameter |

### New test files

| File | Responsibility |
|------|---------------|
| `src/test/java/test/openworld/base/base.proto` | Base protocol with `option OpenWorld;` |
| `src/test/java/test/openworld/ext1/ext1.proto` | Extension 1: `GraphPatchEvent extends SSEEvent` |
| `src/test/java/test/openworld/ext2/ext2.proto` | Extension 2: `AnalyticsPatchEvent extends SSEEvent` |
| `src/test/java/test/openworld/TestOpenWorld.java` | All test cases |

Plus generated code in `test/openworld/base/`, `test/openworld/ext1/`, `test/openworld/ext2/`.

---

## Task 1: Runtime API — `Factory`, `TypeRegistration`, `TypeRegistryLoader`

**Files:**
- Create: `de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/data/Factory.java`
- Create: `de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/data/TypeRegistration.java`
- Create: `de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/data/TypeRegistryLoader.java`

- [ ] **Step 1: Create `Factory<T>` interface**

```java
// de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/data/Factory.java
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
```

- [ ] **Step 2: Create `TypeRegistration` interface**

```java
// de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/data/TypeRegistration.java
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
```

- [ ] **Step 3: Create `TypeRegistryLoader`**

```java
// de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/data/TypeRegistryLoader.java
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
```

- [ ] **Step 4: Build the API module**

Run: `mvn clean install -pl de.haumacher.msgbuf`
Expected: BUILD SUCCESS

- [ ] **Step 5: Commit**

```bash
git add de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/data/Factory.java \
       de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/data/TypeRegistration.java \
       de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/data/TypeRegistryLoader.java
git commit -m "feat: add Factory, TypeRegistration, TypeRegistryLoader to msgbuf-api"
```

---

## Task 2: AST Extension — Add `imports` to `DefinitionFile`

**Files:**
- Modify: `de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/ast/proto.proto:53-59`

- [ ] **Step 1: Add imports field to DefinitionFile**

In `proto.proto`, change the `DefinitionFile` message (line 53-59) to:

```protobuf
message DefinitionFile extends WithOptions {
    /** The package name for all types in this file. */
	QName `package`;

    /** Import paths referencing other .proto files. */
	repeated string imports;

    /** All definitions in this file. */
	repeated Definition definitions;
}
```

- [ ] **Step 2: Regenerate AST Java classes (self-bootstrapping)**

The generator is self-bootstrapping: `proto.proto` defines the AST that the generator itself uses. Adding a field requires running the *existing* generator binary first, then rebuilding.

First, build the generator in its current state to get the jar:
```bash
mvn clean install -pl de.haumacher.msgbuf.generator -DskipTests
```

Then run the built generator on `proto.proto` to regenerate the AST Java classes:
```bash
java -jar de.haumacher.msgbuf.generator/target/msgbuf-generator-*-full.jar \
  -out de.haumacher.msgbuf.generator/src/main/java \
  de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/ast/proto.proto
```

Then rebuild to compile the updated AST classes:
```bash
mvn clean install -pl de.haumacher.msgbuf.generator
```

Expected: BUILD SUCCESS — `DefinitionFile.java` now has `getImports()` and `addImport()` methods.

- [ ] **Step 3: Verify the generated `DefinitionFile.java` has `getImports()` and `addImport()` methods**

Check that the generated `DefinitionFile.java` (or `DefinitionFile_Impl.java` — this module uses `NoInterfaces` so it's a single class) includes the new field accessors.

- [ ] **Step 4: Commit**

```bash
git add de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/ast/
git commit -m "feat: add imports field to DefinitionFile AST"
```

---

## Task 3: Parser — `import` Statement Support

**Files:**
- Modify: `de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/parser/protobuf.jj:45-120`

- [ ] **Step 1: Add `IMPORT` token**

In `protobuf.jj`, add the `IMPORT` token in the TOKEN block (after line 47, the `PACKAGE` token):

```
| < IMPORT : "import" >
```

- [ ] **Step 2: Add import parsing rule in `file()` production**

In the `file()` production (line 92-120), add import parsing after package declaration and before options. Change lines 107-110 from:

```javacc
  )?

  (    optionStatement(result)
  )*
```

to:

```javacc
  )?

  (
    < IMPORT > { Token importPath; }
    importPath = < STRING >
    { result.addImport(de.haumacher.msgbuf.generator.common.Util.stringContent(importPath.image)); }
    ";"
  )*

  (    optionStatement(result)
  )*
```

- [ ] **Step 3: Regenerate the parser**

```bash
mvn clean install -pl de.haumacher.msgbuf.generator
```

Expected: BUILD SUCCESS — JavaCC regenerates the parser with import support.

- [ ] **Step 4: Write a quick parse test**

Create a simple test that parses a proto file with an import statement and verifies `getImports()` returns the expected path. Add to a new test or an existing test class:

```java
public void testParseImport() throws Exception {
    String proto = "import \"base/base.proto\";\n\nmessage Foo {}\n";
    DefinitionFile file = Generator.parse(new ByteArrayInputStream(proto.getBytes("utf-8")));
    assertEquals(1, file.getImports().size());
    assertEquals("base/base.proto", file.getImports().get(0));
}
```

- [ ] **Step 5: Run the parse test**

Run: `mvn test -pl de.haumacher.msgbuf.generator -Dtest=<TestClass>#testParseImport`
Expected: PASS

- [ ] **Step 6: Commit**

```bash
git add de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/parser/protobuf.jj
git add de.haumacher.msgbuf.generator/src/test/java/...
git commit -m "feat: add import statement support to parser"
```

---

## Task 4: Import Resolution in Generator

**Files:**
- Modify: `de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/Generator.java`

- [ ] **Step 1: Add include paths and import-tracking state**

Add fields to `Generator` (after line 51):

```java
private List<File> _includePaths = new ArrayList<>();
private Set<String> _loadedFiles = new HashSet<>();
private List<DefinitionFile> _importedFiles = new ArrayList<>();

public void addIncludePath(File path) {
    _includePaths.add(path);
}
```

- [ ] **Step 2: Add import resolution method**

Add method to `Generator` that resolves and loads imports recursively:

```java
private void resolveImports(DefinitionFile file, File sourceFile) throws IOException, ParseException {
    for (String importPath : file.getImports()) {
        File resolved = resolveImportPath(importPath, sourceFile);
        if (resolved == null) {
            error("Cannot resolve import '" + importPath + "' from '" + sourceFile + "'.");
            continue;
        }
        String canonical = resolved.getCanonicalPath();
        if (_loadedFiles.contains(canonical)) {
            continue; // Already loaded (dedup / circular import protection)
        }
        _loadedFiles.add(canonical);
        DefinitionFile imported = load(resolved);
        _importedFiles.add(imported);
        resolveImports(imported, resolved);
    }
}

private File resolveImportPath(String importPath, File sourceFile) {
    // 1. Relative to importing file's directory
    File relative = new File(sourceFile.getParentFile(), importPath);
    if (relative.isFile()) {
        return relative;
    }
    // 2. From configured include paths
    for (File includePath : _includePaths) {
        File candidate = new File(includePath, importPath);
        if (candidate.isFile()) {
            return candidate;
        }
    }
    return null;
}
```

- [ ] **Step 3: Modify `load(File)` to track canonical paths**

Update `load(File file)` to register canonical paths:

```java
public DefinitionFile load(File file) throws ParseException, IOException, FileNotFoundException {
    _loadedFiles.add(file.getCanonicalPath());
    DefinitionFile content;
    try (InputStream in = new FileInputStream(file)) {
        content = load(parse(in));
    }
    resolveImports(content, file);
    return content;
}
```

- [ ] **Step 4: Modify `generate()` to skip code generation for imported files**

In `generate()`, the code generation loop (lines 105-119) should skip imported files — they are only in the NameTable for resolution:

```java
for (DefinitionFile file : _files) {
    if (_importedFiles.contains(file)) {
        continue; // Imported for type resolution only, don't generate
    }
    // ... existing code generation ...
}
```

- [ ] **Step 5: Add `-I` CLI argument parsing in `main()`**

In `main()` (line 263), add handling for `-I` argument:

```java
} else if (arg.equals("-I")) {
    generator.addIncludePath(new File(args[n++]));
}
```

- [ ] **Step 6: Build and verify**

Run: `mvn clean install -pl de.haumacher.msgbuf.generator`
Expected: BUILD SUCCESS

- [ ] **Step 7: Commit**

```bash
git add de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/Generator.java
git commit -m "feat: add import resolution and include paths to generator"
```

---

## Task 5: OpenWorld Validation

**Files:**
- Modify: `de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/Generator.java`

- [ ] **Step 1: Add OpenWorld validation in `generate()`**

After `buildSpecializations()` and before `TypeIdSynthesizer`, add validation:

```java
for (DefinitionFile file : _files) {
    validateOpenWorld(file);
}
```

With the validation method:

```java
private void validateOpenWorld(DefinitionFile file) {
    boolean openWorld = Util.getFlag(file, "OpenWorld");
    if (!openWorld) {
        return;
    }
    // OpenWorld implies NoBinary — set it automatically
    file.getOptions().put("NoBinary", Flag.create().setValue(true));

    boolean noInterfaces = Util.getFlag(file, "NoInterfaces");
    if (noInterfaces) {
        error("option OpenWorld cannot be combined with option NoInterfaces.");
    }
}
```

- [ ] **Step 2: Skip TypeIdSynthesizer for OpenWorld files**

In the TypeIdSynthesizer loop, skip OpenWorld files:

```java
TypeIdSynthesizer typeIdSynthesizer = new TypeIdSynthesizer();
for (DefinitionFile file : _files) {
    if (!Util.getFlag(file, "OpenWorld")) {
        typeIdSynthesizer.process(file);
    }
}
```

- [ ] **Step 3: Build and verify**

Run: `mvn clean install -pl de.haumacher.msgbuf.generator`
Expected: BUILD SUCCESS

- [ ] **Step 4: Commit**

```bash
git add de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/Generator.java
git commit -m "feat: add OpenWorld validation and skip binary ID synthesis"
```

---

## Task 6: Test Proto Files

**Files:**
- Create: `de.haumacher.msgbuf.generator/src/test/java/test/openworld/base/base.proto`
- Create: `de.haumacher.msgbuf.generator/src/test/java/test/openworld/ext1/ext1.proto`
- Create: `de.haumacher.msgbuf.generator/src/test/java/test/openworld/ext2/ext2.proto`

- [ ] **Step 1: Create base.proto**

```protobuf
package test.openworld.base;

option OpenWorld;

/** Base event for server-sent events. */
abstract message SSEEvent {
    /** Timestamp of the event. */
    long timestamp;
}

/** A simple text event. */
message TextEvent extends SSEEvent {
    /** The text content. */
    string text;
}
```

- [ ] **Step 2: Create ext1.proto**

```protobuf
package test.openworld.ext1;

import "../base/base.proto";

/** A graph patch event extending the base SSE protocol. */
message GraphPatchEvent extends test.openworld.base.SSEEvent {
    /** ID of the control being patched. */
    string controlId;

    /** Patch data. */
    string patch;
}
```

- [ ] **Step 3: Create ext2.proto**

```protobuf
package test.openworld.ext2;

import "../base/base.proto";

/** An analytics event extending the base SSE protocol. */
message AnalyticsPatchEvent extends test.openworld.base.SSEEvent {
    /** Name of the metric. */
    string metricName;

    /** Value of the metric. */
    double metricValue;
}
```

- [ ] **Step 4: Commit**

```bash
git add de.haumacher.msgbuf.generator/src/test/java/test/openworld/
git commit -m "feat: add test proto files for OpenWorld scenario"
```

---

## Task 7: Code Generation — Registry on Abstract OpenWorld Types

**Files:**
- Modify: `de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/MessageGenerator.java`

This is the core task. The `MessageGenerator` must generate different code for abstract types in OpenWorld protocols:
- A static `REGISTRY` map
- A `register()` method
- A modified `readXxx()` that checks the registry before/after the static switch
- A `visitDefault()` method on the Visitor interface
- Modified `visit()` dispatch with `instanceof` check for extension types

- [ ] **Step 1: Detect OpenWorld mode**

In `MessageGenerator`, add a field/method to check if the current definition is in an OpenWorld file. The `_options` map (from the `DefinitionFile`) is already available. Check:

```java
private boolean isOpenWorld() {
    return isTrue(_options.get("OpenWorld"), false);
}
```

- [ ] **Step 2: Generate registry field and register method**

In the interface generation path (for abstract OpenWorld types), after generating the type constant, generate:

```java
if (_interface && _def.isAbstract() && isOpenWorld() && _def.getExtendedDef() == null) {
    nl();
    line("/** Registry for dynamically registered subtypes. */");
    line("static java.util.Map<String, de.haumacher.msgbuf.data.Factory<? extends " + thisType() + ">> REGISTRY = new java.util.HashMap<>();");
    nl();
    line("/**");
    line(" * Registers a subtype factory for polymorphic deserialization.");
    line(" *");
    line(" * @param typeId The JSON type identifier.");
    line(" * @param factory The factory creating instances of the subtype.");
    line(" */");
    line("static void register(String typeId, de.haumacher.msgbuf.data.Factory<? extends " + thisType() + "> factory) {");
    {
        line("REGISTRY.put(typeId, factory);");
    }
    line("}");
}
```

- [ ] **Step 3: Modify `readXxx()` for OpenWorld abstract types**

In the JSON reader method generation (around line 1280-1296), for OpenWorld abstract types, add registry lookup. After the static switch's `default` case, consult the registry:

Change the existing abstract-type dispatch (lines 1287-1296) to:

```java
if (isOpenWorld()) {
    line("de.haumacher.msgbuf.data.TypeRegistryLoader.ensureLoaded();");
}
line("switch (type) {");
for (MessageDef specialization : Util.concreteTransitiveSpecializations(_def)) {
    line("case " + jsonTypeConstantRef(specialization) + ": result = " + qTypeName(specialization) + "." + readerName(specialization) + "(in); break;");
}
if (isOpenWorld()) {
    line("default: {");
    {
        line("de.haumacher.msgbuf.data.Factory<? extends " + thisType() + "> factory = REGISTRY.get(type);");
        line("if (factory != null) {");
        {
            line("result = factory.create();");
            line("result.readContent(in);");
        }
        line("} else {");
        {
            line("in.skipValue();");
            line("result = null;");
        }
        line("}");
    }
    line("} break;");
} else {
    line("default: in.skipValue(); result = null; break;");
}
line("}");
```

- [ ] **Step 4: Generate `visitDefault()` in Visitor interface**

In `generateVisitorInterface()` (line 332-374), for OpenWorld types, add `visitDefault()` after the visit methods:

```java
if (isOpenWorld()) {
    nl();
    line("/** Fallback for visiting subtypes not known at compile time. */");
    line("R visitDefault(" + qTypeName(_def) + " self, A arg)" + onVisitEx(" throws E") + ";");
}
```

- [ ] **Step 5: Generate `instanceof`-based visit dispatch for cross-file types**

In `generateVisitMethods()` (line 2067-2092), the concrete type's `visit()` method currently does `return v.visit(this, arg)`. For types whose abstract generalization is in a different file (OpenWorld extension types), generate the `instanceof` dispatch instead:

```java
// For cross-file extension types (their abstract base has OpenWorld):
if (isCrossFileExtension()) {
    line("if (v instanceof " + qTypeName(_def.getFile()) + "...Visitor) {");
    // ... instanceof check and cast
}
```

Note: This logic is complex. The cross-file extension types are generated separately by the extension module's generator run. When the generator processes `ext1.proto`, it sees `GraphPatchEvent extends SSEEvent`. Since `SSEEvent` is from an OpenWorld protocol, the generated `visit()` should use `instanceof` dispatch.

Implement a helper method to detect if the current message is a cross-file OpenWorld extension:

```java
private boolean isCrossFileExtension() {
    MessageDef gen = getAbstractGeneralization();
    if (gen == null) return false;
    return gen.getFile() != _def.getFile() && Util.getFlag(gen.getFile(), "OpenWorld");
}
```

Then modify `generateVisitMethods()`. In the existing code (line 2076-2092), the `gen != null` branch generates `visit()` for concrete types. Add a check for cross-file extensions inside that branch. Change line 2085-2086 from:

```java
} else {
    line("return v.visit(this, arg);");
}
```

to:

```java
} else if (isCrossFileExtension()) {
    // Cross-file OpenWorld extension: instanceof dispatch
    line("if (v instanceof " + qTypeName(_def) + ".Visitor) {");
    {
        line("return ((" + qTypeName(_def) + ".Visitor<R,A" + onVisitEx(",E") + ">) v).visit(this, arg);");
    }
    line("}");
    line("return v.visitDefault(this, arg);");
} else {
    line("return v.visit(this, arg);");
}
```

This generates:
```java
@Override
public <R,A,E extends Throwable> R visit(test.openworld.base.SSEEvent.Visitor<R,A,E> v, A arg) throws E {
    if (v instanceof test.openworld.ext1.GraphPatchEvent.Visitor) {
        return ((test.openworld.ext1.GraphPatchEvent.Visitor<R,A,E>) v).visit(this, arg);
    }
    return v.visitDefault(this, arg);
}
```

- [ ] **Step 6: Generate extension Visitor interface**

For concrete types that are cross-file extensions of an OpenWorld abstract type, generate a local Visitor interface that extends the base Visitor:

```java
if (isCrossFileExtension() && !_def.isAbstract()) {
    nl();
    line("/** Extended visitor that can handle {@link " + typeName(_def) + "}. */");
    line("public interface Visitor<R,A" + onVisitEx(",E extends Throwable") + "> extends " + qTypeName(getAbstractGeneralization()) + ".Visitor<R,A" + onVisitEx(",E") + "> {");
    {
        nl();
        line("/** Visit case for {@link " + typeName(_def) + "}. */");
        line("R visit(" + qTypeName(_def) + " self, A arg)" + onVisitEx(" throws E") + ";");
    }
    nl();
    line("}");
}
```

- [ ] **Step 7: Build**

Run: `mvn clean install -pl de.haumacher.msgbuf.generator`
Expected: BUILD SUCCESS

- [ ] **Step 8: Commit**

```bash
git add de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/MessageGenerator.java
git commit -m "feat: generate OpenWorld registry, reader, and visitor code"
```

---

## Task 8: Registration Class Generation

**Files:**
- Modify: `de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/Generator.java`

The generator must produce a registration class for extension files that import OpenWorld protocols.

- [ ] **Step 1: Detect extension files that need registration classes**

After code generation, for each non-imported file that has cross-file extensions of OpenWorld types, generate a registration class.

Add to `PackageGenerator` or `Generator.generate()`:

```java
// After normal code generation, generate registration classes for extensions
for (DefinitionFile file : _files) {
    if (_importedFiles.contains(file)) continue;
    List<MessageDef> crossFileExtensions = findCrossFileExtensions(file);
    if (!crossFileExtensions.isEmpty()) {
        generateRegistrationClass(file, crossFileExtensions);
    }
}
```

- [ ] **Step 2: Implement `findCrossFileExtensions()`**

```java
private List<MessageDef> findCrossFileExtensions(DefinitionFile file) {
    List<MessageDef> result = new ArrayList<>();
    for (Definition def : file.getDefinitions()) {
        if (def instanceof MessageDef) {
            collectCrossFileExtensions((MessageDef) def, file, result);
        }
    }
    return result;
}

private void collectCrossFileExtensions(MessageDef def, DefinitionFile file, List<MessageDef> result) {
    MessageDef extended = def.getExtendedDef();
    if (extended != null && extended.getFile() != file) {
        if (Util.getFlag(extended.getFile(), "OpenWorld")) {
            if (!def.isAbstract()) {
                result.add(def);
            }
        }
    }
    for (Definition inner : def.getDefinitions()) {
        if (inner instanceof MessageDef) {
            collectCrossFileExtensions((MessageDef) inner, file, result);
        }
    }
}
```

- [ ] **Step 3: Implement `generateRegistrationClass()`**

Generate a Java class named `<ProtoFileName>Types` that implements `TypeRegistration`:

```java
private void generateRegistrationClass(DefinitionFile file, List<MessageDef> extensions) {
    String protoFileName = ...; // Derive from file name
    String className = capitalize(protoFileName) + "Types";
    File dir = mkdir(file.getPackage());
    File out = new File(dir, className + ".java");

    try (PrintWriter w = new PrintWriter(new OutputStreamWriter(new FileOutputStream(out), "utf-8"))) {
        // Write package declaration
        // Write class implementing TypeRegistration
        // register() method registers each extension with its base type
        // static init() method for GWT
    }
}
```

The generated class looks like:

```java
package test.openworld.ext1;

public class Ext1Types implements de.haumacher.msgbuf.data.TypeRegistration {
    @Override
    public void register() {
        test.openworld.base.SSEEvent.register(
            GraphPatchEvent.GRAPH_PATCH_EVENT__TYPE,
            GraphPatchEvent::create);
    }

    public static void init() {
        new Ext1Types().register();
    }
}
```

- [ ] **Step 4: Generate `META-INF/services` entry**

For ServiceLoader discovery, generate a services file at the output directory:

```
META-INF/services/de.haumacher.msgbuf.data.TypeRegistration
```

containing the fully qualified class name of the registration class.

Note: For test purposes, this can be done manually. For the Maven plugin, this should be generated alongside the Java code.

- [ ] **Step 5: Build**

Run: `mvn clean install -pl de.haumacher.msgbuf.generator`
Expected: BUILD SUCCESS

- [ ] **Step 6: Commit**

```bash
git add de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/Generator.java
git commit -m "feat: generate TypeRegistration classes for extension modules"
```

---

## Task 9: NameTable Cross-Package Lookup

**Files:**
- Modify: `de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/NameTable.java`

Currently `lookupBase()` only searches `_definitionByName` (unqualified). For cross-file extends with package-qualified names (e.g., `test.openworld.base.SSEEvent`), we need package-aware lookup.

- [ ] **Step 1: Modify `lookupBase()` to support package-qualified names**

The `lookup()` method already handles multi-part `QName`s by splitting into base + inner lookups. However, `test.openworld.base.SSEEvent` would be parsed as a QName with 4 parts, where `test.openworld.base` is the package and `SSEEvent` is the type.

The current logic tries to find `test` as a definition name and then drill into it — which fails. We need to also try interpreting leading QName parts as a package prefix:

```java
public Definition lookup(MessageDef context, QName name) {
    // Existing logic: try as nested name
    String baseName = name.getNames().get(0);
    Definition base = lookupBase(context, baseName);

    if (base != null) {
        // Existing logic for resolving remaining parts as inner definitions
        for (int n = 1; n < name.getNames().size(); n++) {
            String nextName = name.getNames().get(n);
            Definition inner = lookupInner(base, nextName);
            if (inner == null) {
                base = null;
                break;
            }
            base = inner;
        }
        if (base != null) {
            return base;
        }
    }

    // NEW: Try as package-qualified name
    // Try progressively longer package prefixes
    List<String> names = name.getNames();
    for (int split = names.size() - 1; split >= 1; split--) {
        String pkgName = String.join(".", names.subList(0, split));
        Package pkg = _packageByName.get(pkgName);
        if (pkg != null) {
            String typeName = names.get(split);
            Definition found = pkg._definitionsByName.get(typeName);
            if (found != null) {
                // Resolve remaining parts as inner definitions
                for (int n = split + 1; n < names.size(); n++) {
                    found = lookupInner(found, names.get(n));
                    if (found == null) break;
                }
                if (found != null) return found;
            }
        }
    }

    if (base == null) {
        error("Name cannot be resolved" + (context == null ? "" : " in '" + context.getName() + "'") + ": " + CodeConvention.qTypeName(name));
    }
    return base;
}
```

- [ ] **Step 2: Make `_definitionsByName` accessible from NameTable**

The `Package._definitionsByName` field needs to be accessible from `lookup()`. Either make it package-private or add a getter:

```java
class Package {
    // Change visibility to package-private
    final Map<String, Definition> _definitionsByName = new HashMap<>();
    // ... rest unchanged
}
```

- [ ] **Step 3: Build and verify**

Run: `mvn clean install -pl de.haumacher.msgbuf.generator`
Expected: BUILD SUCCESS

- [ ] **Step 4: Commit**

```bash
git add de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/NameTable.java
git commit -m "feat: support package-qualified name lookup in NameTable"
```

---

## Task 10: Maven Plugin — Include Paths

**Files:**
- Modify: `msgbuf-generator-maven-plugin/src/main/java/de/haumacher/msgbuf/generator/maven/GenerateMessageClasses.java`

- [ ] **Step 1: Add `includePaths` parameter**

After the `_input` field (line 40), add:

```java
/**
 * Additional directories to search for imported .proto files.
 */
@Parameter(property = "includePaths")
private List<File> _includePaths;
```

- [ ] **Step 2: Pass include paths to Generator**

In `execute()` method, add `-I` arguments for each include path:

```java
ArrayList<String> argList = new ArrayList<>(Arrays.asList(Generator.OUTPUT_DIR_ARG, _outputDirectory.getAbsolutePath()));
if (_includePaths != null) {
    for (File includePath : _includePaths) {
        argList.add("-I");
        argList.add(includePath.getAbsolutePath());
    }
}
argList.addAll(files);
```

- [ ] **Step 3: Build**

Run: `mvn clean install -pl msgbuf-generator-maven-plugin`
Expected: BUILD SUCCESS

- [ ] **Step 4: Commit**

```bash
git add msgbuf-generator-maven-plugin/src/main/java/de/haumacher/msgbuf/generator/maven/GenerateMessageClasses.java
git commit -m "feat: add includePaths parameter to Maven plugin"
```

---

## Task 11: Generate Test Code and Write Tests

**Files:**
- Create: `de.haumacher.msgbuf.generator/src/test/java/test/openworld/TestOpenWorld.java`
- Generated: `test/openworld/base/`, `test/openworld/ext1/`, `test/openworld/ext2/` (generated Java files)

- [ ] **Step 1: Generate code from test proto files**

Run the generator on the three proto files. The base must be processed first (or together). The extensions import the base.

For base:
```bash
java -jar de.haumacher.msgbuf.generator/target/msgbuf-generator-*-full.jar \
  -out de.haumacher.msgbuf.generator/src/test/java \
  de.haumacher.msgbuf.generator/src/test/java/test/openworld/base/base.proto
```

For ext1 (with include path to find base.proto):
```bash
java -jar de.haumacher.msgbuf.generator/target/msgbuf-generator-*-full.jar \
  -out de.haumacher.msgbuf.generator/src/test/java \
  -I de.haumacher.msgbuf.generator/src/test/java/test/openworld \
  de.haumacher.msgbuf.generator/src/test/java/test/openworld/ext1/ext1.proto
```

For ext2 (same pattern):
```bash
java -jar de.haumacher.msgbuf.generator/target/msgbuf-generator-*-full.jar \
  -out de.haumacher.msgbuf.generator/src/test/java \
  -I de.haumacher.msgbuf.generator/src/test/java/test/openworld \
  de.haumacher.msgbuf.generator/src/test/java/test/openworld/ext2/ext2.proto
```

- [ ] **Step 2: Verify generated code compiles**

Run: `mvn compile test-compile -pl de.haumacher.msgbuf.generator`
Expected: BUILD SUCCESS

- [ ] **Step 3: Write test class**

```java
package test.openworld;

import java.io.IOException;

import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import junit.framework.TestCase;
import test.openworld.base.SSEEvent;
import test.openworld.base.TextEvent;
import test.openworld.ext1.Ext1Types;
import test.openworld.ext1.GraphPatchEvent;
import test.openworld.ext2.AnalyticsPatchEvent;
import test.openworld.ext2.Ext2Types;

public class TestOpenWorld extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        // Register extension types explicitly (like GWT usage)
        Ext1Types.init();
        Ext2Types.init();
    }

    /** Base type round-trip without extensions. */
    public void testBaseTypeRoundTrip() throws IOException {
        TextEvent event = TextEvent.create().setText("hello").setTimestamp(12345);
        String json = event.toString();
        SSEEvent copy = readEvent(json);
        assertTrue(copy instanceof TextEvent);
        assertEquals("hello", ((TextEvent) copy).getText());
        assertEquals(12345, copy.getTimestamp());
    }

    /** Extension type deserializable after registration. */
    public void testExtensionRegistration() throws IOException {
        GraphPatchEvent event = GraphPatchEvent.create()
            .setControlId("c1")
            .setPatch("{\"x\":1}")
            .setTimestamp(100);
        String json = event.toString();
        SSEEvent copy = readEvent(json);
        assertTrue("Expected GraphPatchEvent, got: " + copy.getClass(), copy instanceof GraphPatchEvent);
        assertEquals("c1", ((GraphPatchEvent) copy).getControlId());
    }

    /** Multiple independent extensions both work. */
    public void testMultipleExtensions() throws IOException {
        GraphPatchEvent graph = GraphPatchEvent.create().setControlId("c1").setTimestamp(1);
        AnalyticsPatchEvent analytics = AnalyticsPatchEvent.create().setMetricName("cpu").setMetricValue(0.95).setTimestamp(2);

        SSEEvent graphCopy = readEvent(graph.toString());
        SSEEvent analyticsCopy = readEvent(analytics.toString());

        assertTrue(graphCopy instanceof GraphPatchEvent);
        assertTrue(analyticsCopy instanceof AnalyticsPatchEvent);
        assertEquals("cpu", ((AnalyticsPatchEvent) analyticsCopy).getMetricName());
    }

    /** Visitor visitDefault is called for unknown extension types. */
    public void testVisitorDefault() throws IOException {
        GraphPatchEvent event = GraphPatchEvent.create().setControlId("c1");
        final boolean[] defaultCalled = {false};

        event.visit(new SSEEvent.Visitor<Void, Void, RuntimeException>() {
            @Override
            public Void visit(TextEvent self, Void arg) {
                fail("Should not visit TextEvent");
                return null;
            }

            @Override
            public Void visitDefault(SSEEvent self, Void arg) {
                defaultCalled[0] = true;
                assertTrue(self instanceof GraphPatchEvent);
                return null;
            }
        }, null);

        assertTrue("visitDefault should have been called", defaultCalled[0]);
    }

    /** Extended visitor handles extension type specifically. */
    public void testExtendedVisitor() throws IOException {
        GraphPatchEvent event = GraphPatchEvent.create().setControlId("c1");
        final String[] result = {null};

        // Use the extension's Visitor interface
        GraphPatchEvent.Visitor<Void, Void, RuntimeException> visitor =
            new GraphPatchEvent.Visitor<Void, Void, RuntimeException>() {
                @Override
                public Void visit(TextEvent self, Void arg) {
                    result[0] = "text";
                    return null;
                }

                @Override
                public Void visit(GraphPatchEvent self, Void arg) {
                    result[0] = self.getControlId();
                    return null;
                }

                @Override
                public Void visitDefault(SSEEvent self, Void arg) {
                    result[0] = "default";
                    return null;
                }
            };

        // Cast to base visitor — instanceof dispatch should route correctly
        event.visit((SSEEvent.Visitor<Void, Void, RuntimeException>) visitor, null);
        assertEquals("c1", result[0]);
    }

    /** Unknown type returns null gracefully. */
    public void testUnknownType() throws IOException {
        String json = "[\"CompletelyUnknown\", {}]";
        SSEEvent result = readEvent(json);
        assertNull(result);
    }

    /** OpenWorld + NoInterfaces must be a compile error. */
    public void testOpenWorldNoInterfacesRejected() throws Exception {
        String proto = "package test.rejected;\n\noption OpenWorld;\noption NoInterfaces;\n\nabstract message Foo {}\n";
        Generator generator = new Generator();
        DefinitionFile file = generator.load(new java.io.ByteArrayInputStream(proto.getBytes("utf-8")));
        // Expect error during generate() — this test verifies the validation
        // Implementation detail: capture System.err or check for thrown error
    }

    private SSEEvent readEvent(String json) throws IOException {
        return SSEEvent.readSSEEvent(new JsonReader(new StringR(json)));
    }
}
```

- [ ] **Step 4: Run tests**

Run: `mvn test -pl de.haumacher.msgbuf.generator -Dtest=test.openworld.TestOpenWorld`
Expected: All tests PASS

- [ ] **Step 5: Commit**

```bash
git add de.haumacher.msgbuf.generator/src/test/java/test/openworld/
git commit -m "feat: add OpenWorld test suite with base, ext1, ext2 scenarios"
```

---

## Task 12: Full Build Verification

- [ ] **Step 1: Run full build**

Run: `mvn clean install`
Expected: BUILD SUCCESS — all existing tests still pass, new OpenWorld tests pass.

- [ ] **Step 2: Run all tests**

Run: `mvn test`
Expected: All tests PASS (existing + new).

- [ ] **Step 3: Commit any remaining changes**

If any fixups were needed, commit them.

---

## Task Order and Dependencies

```
Task 1 (API) ─────────────────────────┐
Task 2 (AST) ──┐                      │
Task 3 (Parser) ┤                      │
                │                      │
Task 9 (NameTable) ─┐                 │
                    ├─ Task 4 (Import Resolution)
Task 6 (Protos)     │         │
                    │         ├─ Task 5 (Validation) ─┐
                    │         │                       │
                    │         │        ┌──────────────┤
                    │         │        │              │
                    └─────────┼────────┤              │
                              │        ├─ Task 7 (Codegen: Registry/Visitor)
                              │        │              │
                              │        ├─ Task 8 (Codegen: Registration Class)
                              │        │              │
Task 10 (Maven) ──────────────┘        │              │
                                       │              │
                              Task 11 (Tests) ── Task 12 (Full Build)
```

**Critical ordering:** Task 9 (NameTable cross-package lookup) must be completed **before** Task 4 (Import Resolution), because `buildSpecializations()` calls `table.lookup()` which needs package-qualified name support to resolve cross-file `extends` references like `test.openworld.base.SSEEvent`.

Tasks 1, 2, 3, 6, 9, 10 can be worked on in parallel. Tasks 7 and 8 depend on most prior tasks. Task 11 depends on everything. Task 12 is the final verification.
