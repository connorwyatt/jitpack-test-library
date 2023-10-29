plugins {
    id("com.diffplug.spotless")
    id("org.jetbrains.kotlin.jvm") apply false
}

tasks {
    create("installLocalGitHook") {
        delete {
            delete(File(rootDir, ".git/hooks/pre-commit"))
        }
        copy {
            from(File(rootDir, "scripts/pre-commit"))
            into(File(rootDir, ".git/hooks"))
            fileMode = 0b111101101
        }
    }

    build {
        dependsOn("installLocalGitHook")
    }
}

allprojects {
    version = "1.0.0"
    group = "io.connorwyatt.jitpack-test-library"
}

subprojects {
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "maven-publish")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    spotless {
        kotlin {
            target("**/*.kt", "**/*.kts")
            ktfmt(project.properties["ktfmtVersion"] as String).kotlinlangStyle()
        }
    }

    tasks.withType(Test::class) {
        useJUnitPlatform()
    }
}
