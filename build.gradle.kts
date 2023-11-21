import org.jetbrains.gradle.ext.Gradle
import org.jetbrains.gradle.ext.RunConfigurationContainer
import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
	id("org.jetbrains.gradle.plugin.idea-ext") version "1.1.7"
	id("com.gtnewhorizons.retrofuturagradle") version "1.3.24"
}

group = "hummel"
version = "v" + LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

dependencies {
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
}

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(8))
	}
}

minecraft {
	mcVersion.set("1.7.10")
	username.set("Hummel009")
}

idea {
	project {
		this.withGroovyBuilder {
			"settings" {
				"runConfigurations" {
					val self = this.delegate as RunConfigurationContainer
					self.add(
						Gradle("1. Run Client").apply {
							setProperty("taskNames", listOf("runClient"))
						},
					)
					self.add(
						Gradle("2. Run Server").apply {
							setProperty("taskNames", listOf("runServer"))
						},
					)
				}
			}
		}
	}
}

tasks {
	withType<JavaCompile>().configureEach {
		options.encoding = "UTF-8"
	}
}