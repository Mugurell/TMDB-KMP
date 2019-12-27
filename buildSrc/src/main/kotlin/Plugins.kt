import extensions.androidApplication
import extensions.androidLibrary
import extensions.kotlinAndroid
import extensions.kotlinAndroidExtensions
import extensions.kotlinKapt
import extensions.kotlinMultiplatform
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

// Gradle currently does not allow loading in the "plugins" or "buildscript" blocks
// declarations not in the root module.
// For a better package structure this calls should be in a smaller "ext" package
// but at the moment we need this hack to be able to publicly expose them
//
// See https://github.com/gradle/gradle/issues/9270 for details.

inline val PluginDependenciesSpec.androidApplication: PluginDependencySpec
    get() = androidApplication

inline val PluginDependenciesSpec.androidLibrary: PluginDependencySpec
    get() = androidLibrary

inline val PluginDependenciesSpec.kotlinAndroid: PluginDependencySpec
    get() = kotlinAndroid

inline val PluginDependenciesSpec.kotlinMultiplatform: PluginDependencySpec
    get() = kotlinMultiplatform

inline val PluginDependenciesSpec.kotlinAndroidExtensions: PluginDependencySpec
    get() = kotlinAndroidExtensions

inline val PluginDependenciesSpec.kotlinKapt: PluginDependencySpec
    get() = kotlinKapt
