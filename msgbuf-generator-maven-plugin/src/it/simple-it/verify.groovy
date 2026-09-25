// Generated to the configured directories (outputDirectory, resourceOutputDirectory, typeScriptOutputDirectory).
File java = new File(basedir, "target/generated-sources/msgbuf/it/ext/Ping.java")
assert java.isFile() : "Missing " + java

File services = new File(basedir, "target/generated-resources/msgbuf/META-INF/services/de.haumacher.msgbuf.data.TypeRegistration")
assert services.isFile() : "Missing " + services
assert services.text.contains("it.ext.ExtTypes")

File ts = new File(basedir, "target/generated-ts/it/ext/ext.ts")
assert ts.isFile() : "Missing " + ts

// Nothing generated to the default locations.
assert !new File(basedir, "src/main/java").exists()
assert !new File(basedir, "src/main/resources").exists()

// The generated sources were compiled.
assert new File(basedir, "target/classes/it/ext/impl/Ping_Impl.class").isFile()
