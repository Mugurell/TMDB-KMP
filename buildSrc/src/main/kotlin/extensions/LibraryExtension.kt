package extensions

import BuildAndroidConfig
import com.android.build.gradle.LibraryExtension
import deps.Versions
import org.gradle.api.Project

fun LibraryExtension.configure(project: Project) {
    println("Configuring $project as an Android library")

    setCompileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        setMinSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        setTargetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
        }
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile(BuildAndroidConfig.PROGUARD_ANDROID_OPTIMIZED),
                BuildAndroidConfig.PROGUARD_CUSTOM
            )
            consumerProguardFiles(BuildAndroidConfig.PROGUARD_CONSUMER)
        }
    }
    compileOptions {
        sourceCompatibility = Versions.jvm
        targetCompatibility = Versions.jvm
    }
}
