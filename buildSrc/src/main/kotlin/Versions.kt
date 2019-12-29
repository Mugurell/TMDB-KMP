import org.gradle.api.JavaVersion

object Versions {

    val jvm = JavaVersion.VERSION_1_8

    // Plugins
    const val androidBuildTools = "3.3.2"
    const val androidJetifierProcessor = "1.0.0-beta04"

    // Kotlin
    const val kotlin = "1.3.60"

    // Kotlin coroutines
    const val kotlinxCoroutines = "1.1.0"

    // Google Material design
    const val googleAndroidMaterial = "1.0.0"

    // Support libraries
    const val androidxCoreKtx = "1.0.1"
    const val androidxAppCompat = "1.0.2"
    const val androidxConstraintLayout = "1.1.3"
    const val androidxRecyclerView = "1.0.0"
    const val androidxCardView = "1.0.0"
    const val androidxAnnotation = "1.0.1"
    const val androidxExifInterface = "1.0.0"
    const val androidxCollectionKtx = "1.0.0"

    // Architecture components
    const val androidxLifecycle = "2.0.0"
    const val androidxArchCoreTesting = "2.0.0"

    // Logging
    const val timber = "4.7.1"

    // Testing
    const val jUnit = "5.3.2"
    const val androidxTestRunner = "1.1.1"
    const val androidxTestExtJUnit = "1.1.0"
    const val androidxTestEspressoCore = "3.1.1"
    const val spoon = "2.0.0-SNAPSHOT"
    const val spoonPlugin = "1.5.0"
    const val jacocoAndroidPlugin = "0.1.4"
    const val kluent = "1.46"
}
