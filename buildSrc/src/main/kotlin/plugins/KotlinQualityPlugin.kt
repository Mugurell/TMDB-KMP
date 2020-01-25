package plugins

import com.android.build.gradle.internal.tasks.factory.dependsOn
//import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import extensions.BuildPlugins.DETEKT
import extensions.BuildPlugins.KOTLINTER
//import org.jmailen.gradle.kotlinter.KotlinterExtension

class KotlinQualityPlugin : Plugin<Project> {

    override fun apply(project: Project) = with(project) {
        tasks.register(QUALITY_TASK_NAME)
        tasks.named(GRADLE_ALL_CHECKS_TASK).dependsOn(QUALITY_TASK_NAME)

        project.afterEvaluate {
            addDetekt()
            addKtlint()
        }
    }

    private fun Project.addDetekt() {
        plugins.apply(DETEKT)
        this.detekt {

        }
//        io.gitlab.arturbosch.detekt
//        extensions.getByType(DetektExtension::class.java).apply {
//            input = files("src")
//            filters = ".*/resources/.*,.*/build/.*"
//            reports.html { enabled = false }
//            reports.xml { enabled = false }
//        }

        tasks.named(QUALITY_TASK_NAME).dependsOn("detekt")
    }

    private fun Project.addKtlint() {
//        plugins.apply(KOTLINTER)
//        extensions.configure(KotlinterExtension::class.java) {
//            it.indentSize = INDENTATION_SIZE
//            it.continuationIndentSize = INDENTATION_SIZE
//            it.experimentalRules = true
//            it.reporters = arrayOf("plain")
//        }
        tasks.named(QUALITY_TASK_NAME).dependsOn("lintKotlin")
    }

    private companion object {
        const val GRADLE_ALL_CHECKS_TASK = "check"
        private const val QUALITY_TASK_NAME = "checkQuality"
        const val INDENTATION_SIZE = 4
    }
}