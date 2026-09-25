package test.openworld.deep;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLClassLoader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import de.haumacher.msgbuf.data.TypeRegistryLoader;
import de.haumacher.msgbuf.io.StringR;
import de.haumacher.msgbuf.json.JsonReader;
import de.haumacher.msgbuf.xml.XmlSerializable;
import junit.framework.TestCase;
import test.openworld.deep.base.Animal;
import test.openworld.deep.base.Bird;
import test.openworld.deep.base.Dog;
import test.openworld.deep.base.Habitat;
import test.openworld.deep.base.Sparrow;
import test.openworld.deep.base.Zoo;
import test.openworld.deep.ext1.Fish;
import test.openworld.deep.ext1.Forest;
import test.openworld.deep.ext1.Parrot;
import test.openworld.deep.ext1.Pond;
import test.openworld.deep.ext1.Trout;
import test.openworld.deep.ext2.Eagle;
import test.openworld.deep.ext2.Raptor;
import test.openworld.deep.ext2.Shark;

/**
 * Readers of OpenWorld hierarchies with abstract intermediates resolve the types of all files of
 * the hierarchy in JSON and XML format (issues #26 and #27).
 *
 * <p>
 * The hierarchy {@link Animal} has the abstract intermediate {@link Bird} in the base file, the
 * abstract intermediate {@link Fish} in the extension file <code>ext1</code> and the abstract
 * intermediate {@link Raptor} in the extension file <code>ext2</code>. The extension types are
 * registered through the generated service descriptor in
 * <code>src/test/resources/META-INF/services</code>.
 * </p>
 */
@SuppressWarnings("javadoc")
public class TestOpenWorldDeep extends TestCase {

	private static Parrot parrot() {
		return Parrot.create().setWord("hello").setWingspan(0.5).setName("Polly");
	}

	private static Eagle eagle() {
		return Eagle.create().setBald(true).setSpeed(80.5).setWingspan(2.0).setName("Sam");
	}

	private static Trout trout() {
		return Trout.create().setRainbow(true).setFins(7).setName("Tim");
	}

	private static Shark shark() {
		return Shark.create().setTeeth(300).setFins(8).setName("Bruce");
	}

	public void testExpectedJson() {
		assertEquals("[\"Parrot\",{\"name\":\"Polly\",\"wingspan\":0.5,\"word\":\"hello\"}]", parrot().toString());
		assertEquals("{\"king\":[\"Shark\",{\"name\":\"Bruce\",\"fins\":8,\"teeth\":300}],\"school\":[]}",
			Pond.create().setKing(shark()).toString());
	}

	public void testJsonThroughRootReader() throws IOException {
		for (Animal animal : new Animal[] { parrot(), eagle(), trout(), shark(), Sparrow.create().setFlock(3),
				Dog.create().setGood(true) }) {
			Animal copy = Animal.readAnimal(json(animal.toString()));
			assertEquals(animal.getClass(), copy.getClass());
			assertEquals(animal.toString(), copy.toString());
		}
	}

	public void testJsonThroughIntermediateReader() throws IOException {
		// Intermediate of the base file, types of the base file, the first and the second extension.
		for (Bird bird : new Bird[] { parrot(), eagle(), Sparrow.create().setFlock(3) }) {
			Bird copy = Bird.readBird(json(bird.toString()));
			assertEquals(bird.getClass(), copy.getClass());
			assertEquals(bird.toString(), copy.toString());
		}

		// Intermediate of the first extension file, types of the same and of the second extension.
		for (Fish fish : new Fish[] { trout(), shark() }) {
			Fish copy = Fish.readFish(json(fish.toString()));
			assertEquals(fish.getClass(), copy.getClass());
			assertEquals(fish.toString(), copy.toString());
		}

		// Intermediate at depth three of the second extension file.
		Raptor copy = Raptor.readRaptor(json(eagle().toString()));
		assertEquals(eagle().toString(), copy.toString());
	}

	public void testXmlThroughRootReader() throws XMLStreamException {
		for (Animal animal : new Animal[] { parrot(), eagle(), trout(), shark(), Sparrow.create().setFlock(3),
				Dog.create().setGood(true) }) {
			Animal copy = Animal.readAnimal(xmlReader(xml(animal)));
			assertEquals(animal.getClass(), copy.getClass());
			assertEquals(animal.toString(), copy.toString());
		}
	}

	public void testXmlThroughIntermediateReader() throws XMLStreamException {
		for (Bird bird : new Bird[] { parrot(), eagle(), Sparrow.create().setFlock(3) }) {
			Bird copy = Bird.readBird(xmlReader(xml(bird)));
			assertEquals(bird.getClass(), copy.getClass());
			assertEquals(bird.toString(), copy.toString());
		}

		for (Fish fish : new Fish[] { trout(), shark() }) {
			Fish copy = Fish.readFish(xmlReader(xml(fish)));
			assertEquals(fish.getClass(), copy.getClass());
			assertEquals(fish.toString(), copy.toString());
		}

		Raptor copy = Raptor.readRaptor(xmlReader(xml(eagle())));
		assertEquals(eagle().toString(), copy.toString());
	}

	/**
	 * Single, repeated and nested fields of the root and of an intermediate type.
	 */
	private static Zoo zoo() {
		return Zoo.create()
			.setStar(shark())
			.addAnimal(trout())
			.addAnimal(parrot())
			.addAnimal(Dog.create().setName("Rex"))
			.addAnimal(eagle())
			.setFavorite(eagle())
			.addBird(parrot())
			.addBird(Sparrow.create().setName("Jack"))
			.addBird(eagle())
			.setAviary(Zoo.Aviary.create()
				.setBoss(parrot())
				.addResident(eagle())
				.addResident(parrot()));
	}

	public void testFieldsJson() throws IOException {
		Zoo zoo = zoo();
		String json = zoo.toString();
		Zoo copy = Zoo.readZoo(json(json));
		assertEquals(json, copy.toString());
		assertTrue(copy.getStar() instanceof Shark);
		assertTrue(copy.getFavorite() instanceof Eagle);
		assertTrue(copy.getBirds().get(0) instanceof Parrot);
		assertTrue(copy.getAviary().getBoss() instanceof Parrot);
		assertTrue(copy.getAviary().getResidents().get(0) instanceof Eagle);

		Pond pond = Pond.create().setKing(shark()).addSchool(trout()).addSchool(shark());
		assertEquals(pond.toString(), Pond.readPond(json(pond.toString())).toString());
	}

	public void testFieldsXml() throws XMLStreamException {
		Zoo zoo = zoo();
		Zoo copy = Zoo.readZoo(xmlReader(xml(zoo)));
		assertEquals(zoo.toString(), copy.toString());
		assertTrue(copy.getStar() instanceof Shark);
		assertTrue(copy.getFavorite() instanceof Eagle);
		assertTrue(copy.getAviary().getResidents().get(1) instanceof Parrot);

		Pond pond = Pond.create().setKing(shark()).addSchool(trout()).addSchool(shark());
		assertEquals(pond.toString(), Pond.readPond(xmlReader(xml(pond))).toString());
	}

	/**
	 * A nested OpenWorld hierarchy with a nested intermediate, extended by a nested type of another
	 * file.
	 */
	public void testNestedHierarchy() throws IOException, XMLStreamException {
		Habitat habitat = Habitat.create()
			.setTallest(Forest.Oak.create().setAge(200).setHeight(30).setSpecies("quercus"))
			.addPlant(Habitat.Birch.create().setHeight(10))
			.addPlant(Forest.Oak.create().setAge(5));
		String json = habitat.toString();
		assertEquals(json, Habitat.readHabitat(json(json)).toString());
		assertEquals(json, Habitat.readHabitat(xmlReader(xml(habitat))).toString());

		Forest.Oak oak = Forest.Oak.create().setAge(1);
		assertEquals(oak.toString(), Habitat.Tree.readTree(json(oak.toString())).toString());
		assertEquals(oak.toString(), Habitat.Tree.readTree(xmlReader(xml(oak))).toString());
	}

	/**
	 * A reader of an intermediate treats a registered type of a sibling subtree like an unknown type:
	 * the value is skipped and the reader returns <code>null</code>, as the root reader does for an
	 * unknown type.
	 */
	public void testMismatchedAndUnknownTypeJson() throws IOException {
		assertNull(Bird.readBird(json(trout().toString())));
		assertNull(Bird.readBird(json(shark().toString())));
		assertNull(Bird.readBird(json(Dog.create().toString())));
		assertNull(Fish.readFish(json(parrot().toString())));
		assertNull(Raptor.readRaptor(json(parrot().toString())));
		assertNull(Bird.readBird(json("[\"Unknown\",{\"name\":\"x\"}]")));
		assertNull(Animal.readAnimal(json("[\"Unknown\",{\"name\":\"x\"}]")));

		// The skipped value is consumed completely: the reader continues with the next property.
		Zoo zoo = Zoo.readZoo(json("{\"favorite\":" + trout() + ",\"star\":" + parrot() + "}"));
		assertNull(zoo.getFavorite());
		assertEquals(parrot().toString(), zoo.getStar().toString());
	}

	public void testMismatchedAndUnknownTypeXml() throws XMLStreamException {
		assertNull(Bird.readBird(xmlReader(xml(trout()))));
		assertNull(Bird.readBird(xmlReader(xml(shark()))));
		assertNull(Fish.readFish(xmlReader(xml(parrot()))));
		assertNull(Raptor.readRaptor(xmlReader(xml(parrot()))));
		assertNull(Bird.readBird(xmlReader("<unknown name=\"x\"><a/></unknown>")));
		assertNull(Animal.readAnimal(xmlReader("<unknown name=\"x\"><a/></unknown>")));

		// The skipped element is consumed completely: the reader continues with the next element.
		String xml = xml(Zoo.create().setFavorite(eagle()).setStar(parrot()))
			.replace("<eagle ", "<trout rainbow=\"true\" ").replace("</eagle>", "</trout>");
		assertTrue(xml, xml.contains("<trout "));
		Zoo zoo = Zoo.readZoo(xmlReader(xml));
		assertNull(zoo.getFavorite());
		assertEquals(parrot().toString(), zoo.getStar().toString());
	}

	public void testVisitor() {
		Animal.Visitor<String, Void, RuntimeException> animals = new Animal.Visitor<>() {
			@Override
			public String visit(Sparrow self, Void arg) {
				return "sparrow";
			}

			@Override
			public String visit(Dog self, Void arg) {
				return "dog";
			}

			@Override
			public String visitDefault(Bird self, Void arg) {
				return "bird:" + self.getName();
			}

			@Override
			public String visitDefault(Animal self, Void arg) {
				return "animal:" + self.getName();
			}
		};
		assertEquals("sparrow", Sparrow.create().visit(animals, null));
		assertEquals("dog", Dog.create().visit(animals, null));
		assertEquals("bird:Polly", parrot().visit(animals, null));
		assertEquals("bird:Sam", eagle().visit(animals, null));
		assertEquals("animal:Tim", trout().visit(animals, null));
		assertEquals("animal:Bruce", shark().visit(animals, null));

		// A visitor of the intermediate of an extension file handles its types.
		class FishVisitor implements Animal.Visitor<String, Void, RuntimeException>, Fish.Visitor<String, Void, RuntimeException> {
			@Override
			public String visit(Sparrow self, Void arg) {
				return "sparrow";
			}

			@Override
			public String visit(Dog self, Void arg) {
				return "dog";
			}

			@Override
			public String visitDefault(Bird self, Void arg) {
				return "bird";
			}

			@Override
			public String visitDefault(Animal self, Void arg) {
				return "animal";
			}

			@Override
			public String visit(Trout self, Void arg) {
				return "trout";
			}

			@Override
			public String visitDefault(Fish self, Void arg) {
				return "fish:" + self.getName();
			}
		}
		// Dispatched through the visitor of the root, which does not know the types of the extensions.
		Animal.Visitor<String, Void, RuntimeException> fishes = new FishVisitor();
		assertEquals("trout", trout().visit(fishes, null));
		assertEquals("fish:Bruce", shark().visit(fishes, null));
		assertEquals("bird", parrot().visit(fishes, null));
		assertEquals("dog", Dog.create().visit(fishes, null));

		Animal.Visitor<String, Void, RuntimeException> sharks = new FishVisitor() {
			@Override
			public String visitDefault(Fish self, Void arg) {
				return self instanceof Shark ? "shark" : "other";
			}
		};
		assertEquals("shark", shark().visit(sharks, null));

		Bird.Visitor<String, Void, RuntimeException> parrots = new Parrot.Visitor<>() {
			@Override
			public String visit(Sparrow self, Void arg) {
				return "sparrow";
			}

			@Override
			public String visit(Parrot self, Void arg) {
				return "parrot:" + self.getWord();
			}

			@Override
			public String visitDefault(Bird self, Void arg) {
				return "bird";
			}
		};
		assertEquals("parrot:hello", parrot().visit(parrots, null));
		assertEquals("bird", eagle().visit(parrots, null));
		assertEquals("sparrow", Sparrow.create().visit(parrots, null));
	}

	/**
	 * The JSON readers, static methods of interfaces, load the registrations of the extension types
	 * even if no implementation class of the hierarchy has been initialized before.
	 */
	public void testFreshReaderLoadsRegistrations() throws Exception {
		assertEquals(Parrot.class.getName(), readInFreshClassLoader(Animal.class, "readAnimal", parrot().toString()));
		assertEquals(Shark.class.getName(), readInFreshClassLoader(Fish.class, "readFish", shark().toString()));
	}

	/**
	 * Reads the given JSON with the given reader method in a class loader that has not yet loaded
	 * any class of the tested hierarchy, and returns the name of the data interface of the result.
	 */
	private static String readInFreshClassLoader(Class<?> type, String readMethod, String json) throws Exception {
		URL testClasses = TestOpenWorldDeep.class.getProtectionDomain().getCodeSource().getLocation();
		URL apiClasses = TypeRegistryLoader.class.getProtectionDomain().getCodeSource().getLocation();
		Thread thread = Thread.currentThread();
		ClassLoader before = thread.getContextClassLoader();
		try (URLClassLoader loader = new URLClassLoader(new URL[] { testClasses, apiClasses },
				ClassLoader.getPlatformClassLoader())) {
			// The service loader of the registrations uses the context class loader.
			thread.setContextClassLoader(loader);
			Class<?> reader = loader.loadClass(JsonReader.class.getName());
			Object in = reader.getConstructor(loader.loadClass("de.haumacher.msgbuf.io.Reader"))
				.newInstance(loader.loadClass(StringR.class.getName()).getConstructor(String.class).newInstance(json));
			Object result = loader.loadClass(type.getName()).getMethod(readMethod, reader).invoke(null, in);
			assertNotNull(result);
			assertNotSame(type, result.getClass().getInterfaces()[0]);
			return result.getClass().getInterfaces()[0].getName();
		} finally {
			thread.setContextClassLoader(before);
		}
	}

	private static JsonReader json(String data) {
		return new JsonReader(new StringR(data));
	}

	private static String xml(XmlSerializable value) throws XMLStreamException {
		StringWriter buffer = new StringWriter();
		value.writeTo(XMLOutputFactory.newDefaultFactory().createXMLStreamWriter(buffer));
		return buffer.toString();
	}

	private static XMLStreamReader xmlReader(String xml) throws XMLStreamException {
		return XMLInputFactory.newFactory().createXMLStreamReader(new StringReader(xml));
	}

}
