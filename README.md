individual-phases-maven-extension
===

A [Maven extension][1] for executing individual lifecycle phases. It is meant to be used in build pipelines, where build steps could be run individually and in parallel. 

### Getting started
Add `individual-phases-maven-extension` to your project's `pom.xml`:
```xml
<project>
    <profiles>
        <profile>
            <id>individual-phases</id>
            <build>
                <plugins>
                    <plugin>
                        <groupId>ee.originaal.maven.extensions</groupId>
                        <artifactId>individual-phases-maven-extension</artifactId>
                        <version>LATEST</version>
                        <extensions>true</extensions> <!-- This is important -->
                    </plugin>
                </plugins>
            </build>
        </profile>
    </profiles>
</project>
```
#### A typical usage of the extension
1. Build your project once
    ```bash
    mvn clean package -DskipTests
    ```
    
2. Run unit tests without rebuilding your project (with `individual-phases` profile enabled)
    ```bash
    mvn test -P individual-phases
    ```
3. Run integration tests without rebuilding your project (with `individual-phases` profile enabled)
    ```bash
    mvn pre-integration-test integration-test post-integration-test -P individual-phases
    ```
4. See [project-artifact-info-maven-plugin][2] for installing and deploying your artifacts without rebuilding your project

[1]: https://maven.apache.org/guides/mini/guide-using-extensions.html
[2]: https://github.com/raigok/project-artifact-info-maven-plugin
