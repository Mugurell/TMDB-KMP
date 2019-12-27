package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project
import kotlin.system.measureTimeMillis

object PluginsHelper {
    fun applyPlugins(project: Project, vararg plugins: Plugin<Project>) {
        plugins.forEach { plugin ->
            println("Applying $plugin to $project ...")
            plugin.apply(project)
        }
    }

    fun applyPluginsTimed(project: Project, vararg plugins: Plugin<Project>) {
        plugins.forEach { plugin ->
            println("Applying $plugin to $project ...")
            println(".. Done in ${measureTimeMillis { plugin.apply(project) }} ms.")
        }
    }
}
