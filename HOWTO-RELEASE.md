# How to release to Maven Central

## Set stable version number and tag version

```
mvn release:clean release:prepare
```

## Release to Maven Central

```
mvn release:perform
```


## Signing

Artifacts are GPG signed only in the `ossrh` profile. `release:perform` activates it automatically (see
`releaseProfiles` of the `maven-release-plugin`), so a regular `mvn install` does not require a GPG key.
For a manual deployment to Maven Central, activate the profile explicitly:

```
mvn deploy -Possrh
```
