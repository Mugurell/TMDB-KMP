import com.android.build.gradle.AppPlugin
import com.android.build.gradle.LibraryPlugin
import extensions.BuildPlugins.ANDROID_LIBRARY
import org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper
import plugins.AndroidConfigPlugin
import plugins.KotlinConfigPlugin
import plugins.PluginsHelper.applyPluginsTimed

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()

    }

    // Show all compile time errors
    // See: https://movieos.org/2017/android-room-data-binding-compile-time-errors/
    gradle.projectsEvaluated {
        tasks.withType<JavaCompile> {
            options.compilerArgs.addAll(
                arrayOf("-Xmaxerrs", "4000", "-Xmaxwarns", "4000")
            )
        }
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }

    configurations.all {
        resolutionStrategy.eachDependency {
            // Force all of the Kotlin libraries to use the same version
            if (requested.group == "org.jetbrains.kotlin") {
                useVersion(Versions.kotlin)
            }
        }
    }
}

subprojects {
    // Whenever a subproject adds the following plugins we come in and add the others
    // Which may do / add other stuff...
    plugins.withType(AppPlugin::class.java) {
        applyPluginsTimed(project, AndroidConfigPlugin(), KotlinConfigPlugin())
    }
    plugins.withType(LibraryPlugin::class.java) {
        applyPluginsTimed(project, AndroidConfigPlugin())
    }
    plugins.withType(KotlinMultiplatformPluginWrapper::class.java) {
        if (project.pluginManager.hasPlugin(ANDROID_LIBRARY)) {
            println("This KMP project is a library. Let's configure it accordingly ...")
        } else {
            println("This KMP project is NOT a library. Skipping configuring it.")
        }
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}
