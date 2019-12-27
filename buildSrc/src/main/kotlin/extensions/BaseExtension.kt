package extensions

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

fun BaseExtension.configureTestOptions(project: Project) {
    println("Configuring $project's test options")

    testOptions.apply {
        reportDir = "${project.rootDir}/reports/${project.displayName}"
    }
}
