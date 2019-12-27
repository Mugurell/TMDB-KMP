package extensions

import BuildAndroidConfig
import com.android.build.gradle.AppExtension
import extensions.BuildPlugins.KOTLIN_ANDROID
import extensions.BuildPlugins.KOTLIN_ANDROID_EXTENSIONS
import org.gradle.api.JavaVersion
import org.gradle.api.Project

fun AppExtension.configure(project: Project) {
    println("Configuring $project as an Android application")

    project.plugins.apply(KOTLIN_ANDROID)
    project.plugins.apply(KOTLIN_ANDROID_EXTENSIONS)

    setCompileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        setMinSdkVersion(BuildAndroidConfig.MIN_SDK_VERSION)
        setTargetSdkVersion(BuildAndroidConfig.TARGET_SDK_VERSION)
        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile(BuildAndroidConfig.PROGUARD_ANDROID_OPTIMIZED),
                BuildAndroidConfig.PROGUARD_CUSTOM
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
