# How to perform a release to Maven Central

```
mvn release:clean release:prepare
mvn release:perform
cd target/checkout/de.haumacher.msgbuf
mvn nexus-staging:release
mvn release:clean
```

