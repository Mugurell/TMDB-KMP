package extensions

import deps.Versions
import extensions.BuildPlugins.ANDROID_APPLICATION
import extensions.BuildPlugins.ANDROID_LIBRARY
import extensions.BuildPlugins.KOTLIN_ANDROID
import extensions.BuildPlugins.KOTLIN_ANDROID_EXTENSIONS
import extensions.BuildPlugins.KOTLIN_KAPT
import extensions.BuildPlugins.KOTLIN_MULTIPLATFORM
import extensions.BuildPlugins.SPOON
import extensions.BuildPlugins.DETEKT
import extensions.BuildPlugins.KOTLINTER
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

inline val PluginDependenciesSpec.androidApplication: PluginDependencySpec
    get() = id(ANDROID_APPLICATION)

inline val PluginDependenciesSpec.androidLibrary: PluginDependencySpec
    get() = id(ANDROID_LIBRARY)

inline val PluginDependenciesSpec.kotlinAndroid: PluginDependencySpec
    get() = id(KOTLIN_ANDROID)

inline val PluginDependenciesSpec.kotlinMultiplatform: PluginDependencySpec
    get() = id(KOTLIN_MULTIPLATFORM)

inline val PluginDependenciesSpec.kotlinAndroidExtensions: PluginDependencySpec
    get() = id(KOTLIN_ANDROID_EXTENSIONS)

inline val PluginDependenciesSpec.kotlinKapt: PluginDependencySpec
    get() = id(KOTLIN_KAPT)

inline val PluginDependenciesSpec.spoon: PluginDependencySpec
    get() = id(SPOON).version(Versions.spoonPlugin)

inline val PluginDependenciesSpec.detekt: PluginDependencySpec
    get() = id(DETEKT).version(Versions.detekt)

inline val PluginDependenciesSpec.kotlinter: PluginDependencySpec
    get() = id(KOTLINTER).version(Versions.kotlinter)

object BuildPlugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val KOTLIN = "kotlin"
    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val KOTLIN_MULTIPLATFORM = "kotlin-multiplatform"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val KOTLIN_ALLOPEN = "kotlin-allopen"
    const val SPOON = "com.jaredsburrows.extensions.getSpoon"
    const val DETEKT = "io.gitlab.arturbosch.detekt"
    const val KOTLINTER = "org.jmailen.kotlinter"
}
