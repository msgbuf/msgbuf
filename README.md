# msgbuf
Code generator for GWT-compatible Java data classes suitable for typed client-server messaging.

Inspired by Google's [protocol buffers](https://developers.google.com/protocol-buffers), `msgbuf` provides a code generator that produces data classes out of a concise protocol definition file. 

In contrast to `protobuf`, `msgbuf` supports:
 * Code generation compatible with the [GWT Java-to-Javascript compiler](http://www.gwtproject.org/).
 * Inheritance of data classes.
 * Abstract data classes defining the root of a hierarchy of exchangable data fragments.
 * Polymorphic data compositions.
 * [Visitor pattern](https://en.wikipedia.org/wiki/Visitor_pattern) for processing polomorphic data structures.
 
`msgbuf` currently serializes messages in JSON format. For GWT-compatibility it uses a modified `JsonReader`/`JsonWriter` from the [gson library](https://github.com/google/gson) that was abstracted from the unsupported `Reader`/`Writer` Java API.

## Setup with Maven

### Add the MsgBuf runtime libary dependency to your project

```xml
<dependency>
    <groupId>de.haumacher.msgbuf</groupId>
    <artifactId>msgbuf-api</artifactId>
    <version>1.1.5</version>
</dependency>
```

### Add the MsgBuf generator to your pom.xml

To the `build/plugins` section add:

```xml
<plugin>
    <groupId>de.haumacher.msgbuf</groupId>
    <artifactId>msgbuf-generator-maven-plugin</artifactId>
    <version>1.1.5</version>
    
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

## Usage
 
The `msgbuf` definition language is an extension of the [proto format](https://developers.google.com/protocol-buffers/docs/proto3) from `protobuf`. A defined message can `extend` another message type, or it can be marked `abstract`. 

Assume, you want to describe shapes in a graphics application, you could define the data types as follows. You may start with an `abstract` shape class, defining coordinates of the origin of its coordinate system:

Add `src/main/java/my/app/model/shape.proto` with the following contents:
```protobuf
package my.app.model;

syntax = "msgbuf";

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

## Global protocol options

### `@NoJson`
Disables generation of read and write methods for the JSON format.

### `@NoBinary`
Disables generation of read and write methods for binary format.

### `@NoXml`
Disables generation of read and write methods for XML format.

### `@NoXmlNames`
Disables generation of constants for the XML format.

### `@NoInterfaces`
Disables generation interfaces for data classes. Normally, data classes are represented by a Java interface. This 
enables multiple inheritance for data classes. To reduce the amout of generated code, this can be disabled for simple 
cases, where no multiple inheritance is required. 

### `@NoListener`
Disables generation of listener interfaces and corresponding registration methods. Add this options, if observing 
data classes for changes is not required.

### `@NoReflection`
Disables generation of reflective access methods that allow access to properties through their property names.

### `@NoVisitor`
Disables generation of visitor interfaces and visit methods. 

### `@NoVisitorExceptions`
Produces visitor interfaces that cannot throw declared exceptions.

### `@NoTypeKind`
Suppresses the type kind enumeration for a data class hierarchy.

### `@SharedGraph`
Allows to handle multiple synchronized instances of a data class graph. Each graph can be observed for changes. Changes
generate synchronization messages to keep other instances of the same shared graph up to date. With this option, 
a shared graph can be instantiated on a server, transfered to a client while keeping the state in sync when changes 
occur on each side.

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

### `@Name("myProp")`
Sets a custom property name. This name is used in JSON serialization.

### `@XmlName("myProp")`
Sets a custom tag name for XML serialization.

### `@Reverse("otherProp")`
Marks a reference to be the reverse end of the reference with the given name in the target type.

### `@Container`
Marks a reference point to the container of the current object.

### `@type_id(4711)`
Sets a custom ID for binary serialization.


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
`@DartLib("../lib/protocol.dart")`

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

### Test the installtion

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

In polymorphic hierarchy of classes as defined above, it is not enough for a class to just write its own properties. Consider a `Group` instance from the example above. Its `shapes` list may contain multiple instances of either circles, rectangles, or even nested groups. Therefore, a class in a polymorphic hierarchy not only serializes its properties, but also its type. Reading back such polymorphic instance instantiates the correct class and fills it with its properties.

### Visitor pattern

For processing polymorphic messages, generated classes provide support for the [visitor pattern](https://en.wikipedia.org/wiki/Visitor_pattern) to allow writing custom code for each possible sub-type. Since the generated code should not be modified, you cannot add custom code directly to the data class. If you want to process (e.g. render) a received shape instance from the example above, you could of cause use an `instanceof` test to handle circles differently from rectangles and groups. But this leads to fragile code, where one of the possible choices is missed.

A better alternative is the visitor pattern. This allows to separate processing code from the data class hierarchy without `instanceof` tests. An `abstract` base class provides a `Visitor` interface and a `visit(...)` method accepting such a visitor:

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

Each of the concrete sub-classes implement the `abstract` visit-method by delegating to the correspoinding case-method from the `Visitor` interface:

```java
public class Rectangle extends Shape {

   ...

   @Override
   public <R,A> R visit(Shape.Visitor<R,A> v, A arg) {
      return v.visit(this, arg);
   }
}
```

This allow to creating e.g. a renderer implementation that is able to process all concrete types from the shape hierarchy by applying the appropriate code to them:

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

