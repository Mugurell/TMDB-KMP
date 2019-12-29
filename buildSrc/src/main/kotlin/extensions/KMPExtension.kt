package extensions

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.getting
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.tasks.FatFrameworkTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun KotlinMultiplatformExtension.configure(project: Project) {
    val ideaActive = System.getProperty("idea.active") == "true"

    android()

    val iosArm32 = iosArm32("iosArm32")
    val iosArm64 = iosArm64("iosArm64")
    val iosX64 = iosX64("iosX64")

    if (ideaActive) {
        iosX64("ios")
    }

    sourceSets {
        // By default MPP names the Android module "main"
        // Let's rename that to "androidMain" to respect the convention.
        val android = project.extensions.getByType<BaseExtension>()
        with (android.sourceSets) {
            val main by getting {
                setRoot("src/androidMain")
                manifest.srcFile("src/androidMain/resources/manifest/AndroidManifest.xml")
                resources.srcDirs(listOf("src/androidMain/resources/res"))
                res.srcDirs(listOf("src/androidMain/resources/res"))
            }
        }

        val commonMain by getting {
            dependencies {
                // add here common KMP dependencies
                implementation(Libs.kotlin_sdlib_common)
            }
        }

        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation(Libs.kotlin_stdlib_jdk8)
                // add here Android dependencies custom to use on the KMP project
            }
        }

        val iosMain = if (ideaActive) {
            getByName("iosMain")
        } else {
            create("iosMain")
        }

        iosMain.apply {
            dependsOn(commonMain)
            dependencies {
                // add here iOS dependencies custom to use on the KMP project
            }
        }
        val iosArm32Main by getting
        val iosArm64Main by getting
        val iosX64Main by getting
        project.configure(listOf(iosArm32Main, iosArm64Main, iosX64Main)) {
            dependsOn(iosMain)
        }

        val commonTest by getting {
            dependencies {
                // add here KMP dependencies custom to use when testing a KMP project
            }
        }
    }

    val frameworkName = "TMDB-KMP-Framework"

    project.configure(listOf(iosArm32, iosArm64, iosX64)) {
        compilations {
            val main by getting {
                extraOpts("-Xobjc-generics")
            }
            binaries.framework {
                baseName = frameworkName
            }
        }
    }

    project.tasks.register<FatFrameworkTask>("debugFatFramework") {
        baseName = frameworkName
        group = "Universal framework"
        description = "Builds a universal (fat) debug framework"

        from(iosX64.binaries.getFramework("DEBUG"))
    }

    project.tasks.register<FatFrameworkTask>("releaseFatFramework") {
        baseName = frameworkName
        group = "Universal framework"
        description = "Builds a universal (release) debug framework"

        from(iosArm64.binaries.getFramework("RELEASE"), iosArm32.binaries.getFramework("RELEASE"))
    }

    project.tasks.withType<KotlinCompile>().all {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
