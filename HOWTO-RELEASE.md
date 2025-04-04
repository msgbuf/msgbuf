# How to release to Maven Central

## Set stable version number and tag version

```
mvn release:clean release:prepare
```

## Release to Maven Central

```
mvn release:perform
```
