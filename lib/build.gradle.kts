plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    `java-library`
    `maven-publish`
}

group = "io.mattmoore.kdb"
version = "0.1.0"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.google.guava:guava:31.0.1-jre")
    api("org.apache.commons:commons-math3:3.6.1")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useKotlinTest()
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.mattmoore.kdb"
            artifactId = "kdb"
            version = "0.1.0"

            from(components["java"])

            pom {
                name.set("KDB")
                description.set("Kotlin functional database library inspired by doobie and based on Arrow and JDBC.")
                url.set("https://github.com/mattmoore/kdb")
                developers {
                    developer {
                        id.set("mattmoore")
                        name.set("Matt Moore")
                        email.set("matt@mattmoore.io")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com:mattmoore/kdb.git")
                    developerConnection.set("scm:git:ssh://github.com:mattmoore/kdb.git")
                    url.set("https://github.com/mattmoore/kdb")
                }
            }
        }
    }
}
