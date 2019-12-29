package plugins

import extensions.configure
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KMPConfigPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.getByType<KotlinMultiplatformExtension>()
        extension.configure(project)
    }
}
