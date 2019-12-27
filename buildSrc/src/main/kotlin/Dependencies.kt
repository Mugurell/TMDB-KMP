object Versionsss {
    val compile_sdk = 29
    val target_sdk = 29
    val min_sdk = 21
}

object GradlePlugins {
    internal data class Versions(
        val gradle: String = "3.6.0-rc01",
        val kotlin: String = "1.3.61"
    )

    internal val versions = Versions()

    val gradle = "com.android.tools.build:gradle:${versions.gradle}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${versions.kotlin}"
}

object Libs {
    private data class Versions(
        val appCompat: String = "1.0.2",
        val constraintLayout: String = "2.0.0-alpha2"
    )

    private val versions = Versions()

    val kotlin_stdlib_jdk8 =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${GradlePlugins.versions.kotlin}"
    val appCompat = "androidx.appcompat:appcompat:${versions.appCompat}"
    val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${versions.constraintLayout}"
}
