plugins {
    `java-library`
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = project.name
            groupId = "org.ammonium.ammonialib"
            pom {
                name.set(project.name)
                description.set(project.description)
                url.set("https://github.com/AmmoniumStudios/${project.name}")
                licenses {
                    license {
                        name.set("GNU Affero General Public License v3.0")
                        url.set("https://www.gnu.org/licenses/agpl-3.0.en.html")
                    }
                }
                developers {
                    developer {
                        id.set("AmmoniumStudios")
                        name.set("Ammonium Studios")
                    }
                }
            }
        }
    }
}

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

java {
    java {
        // This is the default value, but we want to be explicit.
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
        withJavadocJar()
        withSourcesJar()
    }
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    withType<Javadoc> {
        options.encoding = "UTF-8"
    }
}