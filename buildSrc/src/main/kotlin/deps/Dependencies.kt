import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

object Dependencies {
    inline val android: DependencyHandlerScope.() -> Unit
        get() = {
            // Common code. Domain + data layers
            commonModule

            // Kotlin
            kotlinStandardLibraryJdk8

            // AppCompat support
            androidxAppCompat
            androidxCoreKtx
            androidxConstraintLayout

            // Local unit test libraries
            jUnit
            androidxEspressoCore
            androidxTestExtJUnit
        }

    inline val commonMain: KotlinDependencyHandler.() -> Unit
        get() = {
            kotlinStandardLibraryCommon
        }

    inline val commonAndroid: KotlinDependencyHandler.() -> Unit
        get() = {
            kotlinStandardLibraryJdk8
        }

    inline val commonIos: KotlinDependencyHandler.() -> Unit
        get() = {
            // tbd
        }

    inline val commonMainTest: KotlinDependencyHandler.() -> Unit
        get() = {
            // tbd
        }
}
