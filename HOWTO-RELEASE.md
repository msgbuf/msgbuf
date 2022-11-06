# How to release to Maven Central

## Set stable version number

```
mvn release:clean release:prepare
```

## Create staging repository

```
mvn release:perform
```

## Release to Maven Central

```
cd target/checkout/
mvn nexus-staging:release
```
