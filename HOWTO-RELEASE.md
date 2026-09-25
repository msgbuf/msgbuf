# How to release to Maven Central

## Set stable version number and tag version

```
mvn release:clean release:prepare
```

This sets the release version, commits, creates the tag `msgbuf-api-<version>`, sets the next
snapshot version, commits again and pushes both commits and the tag.

## Release to Maven Central

Pushing the tag starts the GitHub workflow `.github/workflows/release.yml` ("Release to Maven
Central"). It checks that the tag matches the project version, builds the tagged sources, signs the
artifacts and publishes them through the Central Portal. It waits until the deployment is
published. Follow it in the repository's Actions tab.

Do **not** run `mvn release:perform` in addition: the version would be deployed twice, and the
second deployment is rejected by Maven Central.

The workflow needs these repository secrets (Settings → Secrets and variables → Actions):

| Secret             | Content                                                                 |
|--------------------|-------------------------------------------------------------------------|
| `CENTRAL_USERNAME` | User name of a Central Portal user token (central.sonatype.com → Account → Generate User Token) |
| `CENTRAL_PASSWORD` | Password of that user token                                             |
| `GPG_PRIVATE_KEY`  | ASCII-armored signing key: `gpg --armor --export-secret-keys <key-id>`  |
| `GPG_PASSPHRASE`   | Passphrase of that key                                                  |

To check the build and the signing secrets without releasing, run the workflow manually (Actions →
Release to Maven Central → Run workflow): it builds and signs the selected branch but does not
deploy.

A failed deployment can be repeated by re-running the workflow for the tag, as long as nothing was
published yet.

## Signing

Artifacts are GPG signed only in the `ossrh` profile. The release workflow and `release:perform`
activate it, so a regular `mvn install` does not require a GPG key. The key passphrase is read from
the environment variable `MAVEN_GPG_PASSPHRASE` if set, otherwise the gpg-agent is asked.

For a manual deployment to Maven Central (e.g. if GitHub Actions is unavailable), check out the
tag and activate the profile explicitly. This needs the `central` server credentials in
`~/.m2/settings.xml`:

```
mvn deploy -Possrh
```
