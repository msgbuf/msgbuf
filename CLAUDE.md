# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

MsgBuf is a code generator for GWT-compatible Java data classes suitable for typed client-server messaging. Inspired by Google's Protocol Buffers, it generates Java classes from `.proto` definition files with additional features like inheritance, abstract classes, and polymorphic data composition.

The project supports multiple serialization formats: JSON (primary), Binary, and XML.

## Project Structure

This is a multi-module Maven project with three core modules:

- **de.haumacher.msgbuf** (`msgbuf-api`) - Runtime library containing base classes for generated code, serialization support (JSON/Binary/XML), and GWT-compatible I/O abstractions. Licensed under Apache-2.0.

- **de.haumacher.msgbuf.generator** (`msgbuf-generator`) - Code generator that reads `.proto` files and generates Java classes. Uses JavaCC for parsing. Can be run standalone via shaded JAR. Licensed under GPL-3.0-or-later.

- **msgbuf-generator-maven-plugin** - Maven plugin wrapper for the generator, allowing proto compilation during Maven build.

- **de.haumacher.msgbuf.eclipse** - Eclipse plugin providing automatic proto file compilation (separate from Maven build).

## Building and Testing

### Full Build
```bash
mvn clean install
```

### Build Individual Module
```bash
# Build runtime library only
mvn clean install -pl de.haumacher.msgbuf

# Build generator only
mvn clean install -pl de.haumacher.msgbuf.generator

# Build Maven plugin only
mvn clean install -pl msgbuf-generator-maven-plugin
```

### Run Tests
```bash
# All tests
mvn test

# Single module tests
mvn test -pl de.haumacher.msgbuf.generator
```

### Check for Vulnerabilities
```bash
mvn dependency-check:check
```

### Update Dependencies
```bash
mvn versions:use-latest-releases
```

## Development Workflow

### Working with Proto Files

Proto definition files use the `syntax = "msgbuf";` declaration (not `proto3`). Test proto files in `de.haumacher.msgbuf.generator/src/test/java/test/**/` demonstrate various features.

Key proto file locations:
- Test examples: `de.haumacher.msgbuf.generator/src/test/java/test/*/`
- Generator's own AST model: `de.haumacher.msgbuf.generator/src/main/java/de/haumacher/msgbuf/generator/ast/proto.proto`
- Shared graph commands: `de.haumacher.msgbuf/src/main/java/de/haumacher/msgbuf/graph/cmd/update.proto`

### Generator Architecture

The code generator pipeline:
1. **Parser** (JavaCC) - Parses `.proto` files into AST (see `generator/ast/proto.proto`)
2. **Synthesizers** - Add field IDs and type IDs if not explicitly defined
3. **Code Generators** - Generate Java source code:
   - `MessageGenerator` - Concrete message classes
   - `AbstractMessageGenerator` - Abstract base classes with visitor pattern
   - `EnumGenerator` - Enum types
   - `TypeGenerator` - Orchestrates generation

Main entry point: `de.haumacher.msgbuf.generator.Generator.main()`

### Running Generator Standalone

The shaded JAR allows standalone execution:
```bash
java -jar de.haumacher.msgbuf.generator/target/msgbuf-generator-*-full.jar <proto-files>
```

### Generated Code Structure

Each message definition generates:
- Interface (if `NoInterfaces` option not set)
- Implementation class with:
  - Getters/setters for properties
  - JSON read/write methods (`readX()`, `writeTo()`)
  - Binary read/write methods (if `NoBinary` not set)
  - XML read/write methods (if `NoXml` not set)
  - Visitor pattern support (if abstract/polymorphic)
  - Property listeners (if `NoListener` not set)
  - Reflective property access (if `NoReflection` not set)

## Key Concepts

### Inheritance and Polymorphism

MsgBuf extends protobuf syntax with:
- `abstract message` - Creates abstract base classes
- `extends` keyword - Message inheritance
- Visitor pattern generation for polymorphic hierarchies
- Type discrimination in serialization

### Serialization Formats

**JSON** - Primary format, uses modified Gson reader/writer abstracted for GWT compatibility
**Binary** - Compact format using DataReader/DataWriter
**XML** - Document format with XmlSerializable interface

### GWT Compatibility

The runtime library (`msgbuf-api`) avoids Java I/O classes (java.io.Reader/Writer) to work with GWT. Custom abstractions in `de.haumacher.msgbuf.io` package provide compatible interfaces.

### Shared Graph Support

The `SharedGraph` option enables synchronized object graphs across client/server with change tracking and update commands (see `de.haumacher.msgbuf.graph.cmd`).

## Release Process

Follow the documented release process:
```bash
# Set version and create tag
mvn release:clean release:prepare

# Deploy to Maven Central
mvn release:perform
```

Release configuration in parent POM includes GPG signing and automatic publishing to Maven Central via the central-publishing-maven-plugin.

## Important Constraints

- Java 11+ required (maven.compiler.source/target = 11)
- Generated code must be GWT-compatible (no java.io usage in msgbuf-api)
- Generator uses JavaCC for parsing - regenerate parser after grammar changes
- Proto files must use `syntax = "msgbuf";` not `proto3`
- Different licenses: API is Apache-2.0, Generator is GPL-3.0-or-later

## Testing Strategy

Test proto files in `de.haumacher.msgbuf.generator/src/test/java/test/` cover:
- Hierarchy and inheritance (`test.hierarchy`)
- Various options (NoJson, NoInterfaces, NoVisitor, etc.)
- Container/reference handling (`test.container`, `test.references`)
- Shared graphs (`test.graph`)
- Edge cases (reserved names, lowercase messages, etc.)

The Maven plugin has integration tests in `msgbuf-generator-maven-plugin/src/it/`.
