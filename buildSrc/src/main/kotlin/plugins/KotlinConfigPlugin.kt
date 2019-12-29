package plugins

import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.crash.afterEvaluate
import extensions.BuildPlugins.KOTLIN_KAPT
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.getPlugin
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class KotlinConfigPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply(KOTLIN_KAPT)

        project.convention.getPlugin<JavaPluginConvention>().apply {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        project.extensions.getByType<AppExtension>().apply {
            // Add Kotlin source directory to all source sets
            sourceSets.forEach {
                it.java.srcDir("src/${it.name}/kotlin")
            }
        }

        project.tasks.withType<KotlinCompile>().all {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}
