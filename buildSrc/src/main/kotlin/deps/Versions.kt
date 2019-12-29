package deps

import org.gradle.api.JavaVersion

object Versions {

    val jvm = JavaVersion.VERSION_1_8

    // Plugins
    const val androidBuildTools = "3.6.0-rc01"

    // Kotlin
    const val kotlin = "1.3.60"

    // Kotlin coroutines
    const val kotlinxCoroutines = "1.3.3"

    // Google Material design
    const val googleAndroidMaterial = "1.1.0-beta02"

    // Support libraries
    const val androidxAnnotation = "1.1.0"
    const val androidxAppCompat = "1.1.0"
    const val androidxCardView = "1.0.0"
    const val androidxCollectionKtx = "1.1.0"
    const val androidxConstraintLayout = "2.0.0-beta4"
    const val androidxCoreKtx = "1.1.0"
    const val androidxRecyclerView = "1.1.0"

    // Architecture components
    const val androidxLifecycle = "2.2.0-rc03"
    const val androidxArchCoreTesting = "2.1.0"

    // User interface
    const val tapTargetView = "1.11.0"
    const val slidingUpPanel = "3.4.0"
    const val expandIcon = "1.2.1"
    const val aboutLibraries = "7.1.0"
    const val circleImageView = "3.0.1"

    // Logging
    const val timber = "4.7.1"

    // Testing
    const val jUnit = "5.5.2"
    const val androidxTestRunner = "1.2.0"
    const val androidxTestExtJUnit = "1.1.1"
    const val androidxTestEspressoCore = "3.2.0"
    const val spoon = "2.0.0-SNAPSHOT"
    const val spoonPlugin = "1.5.0"
    const val kluent = "1.46"
}
