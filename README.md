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

## Usage
 
The `msgbuf` definition language is an extension of the [proto format](https://developers.google.com/protocol-buffers/docs/proto3) from `protobuf`. A defined message can `extend` another message type, or it can be marked `abstract`. 

Assume, you want to describe shapes in a graphics application, you could define the data types as follows. You may start with an `abstract` shape class, defining coordinates of the origin of its coordinate system:
```protobuf
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

Passing these definitions to the `msgbuf` compiler gives you a class hierarchy with classes `Shape`, `Circle`, `Rectangle`, and `Group`. You can inspect the generation result in the test package [test.hierarchy](de.haumacher.msgbuf.generator/test/test/hierarchy/data) of the compiler. The source of the example data class definitions can be seen in the [hierarchy.proto](de.haumacher.msgbuf.generator/test/test/hierarchy/hierarchy.proto) file.

## Installation in Eclipse

There is an Eclipse plugin providing a project builder that automatically generates corresponding Java files whenever you create or modify a `*.proto` definition file. To install and enable the plugin with the following steps:

### Add update site

 * Open the dialog `Help > Install new Software`.
 * Enter `msgbuf - https://msgbuf.github.io/msgbuf/update-site/` in the `Work with` field, click the `Add...` button, and acknowledge the addition. 
 * Select the `MsgBuf Project Builder` checkbox and click `Finish`. 
 * Accept the license and the installation of unsigned content.

### Enable the MsgBuf builder in your Project

 * Select your project in the `Package Explorer`.
 * In the context menu, select `Configure > Enable MsgBuf Builder`.

### Add project dependency to the MsgBuf runtime libary

```
<dependency>
    <groupId>de.haumacher.msgbuf</groupId>
    <artifactId>msgbuf-api</artifactId>
    <version>1.0.0</version>
</dependency>
```

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

