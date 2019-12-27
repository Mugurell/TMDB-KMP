/**
 * Configuration of android build
 */
object BuildAndroidConfig {
    const val APPLICATION_ID = "com.petru.tbdbkmp"

    const val BUILD_TOOLS_VERSION = "29.0.0"
    const val COMPILE_SDK_VERSION = 29
    const val MIN_SDK_VERSION = 21
    const val TARGET_SDK_VERSION = 29

    const val VERSION_CODE = 1
    const val VERSION_NAME = "1.0"

    const val SUPPORT_LIBRARY_VECTOR_DRAWABLES = true

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    const val PROGUARD_CONSUMER = "consumer-rules.pro"
    const val PROGUARD_ANDROID_BASIC = "proguard-android.txt"
    const val PROGUARD_ANDROID_OPTIMIZED = "proguard-android-optimize.txt"
    const val PROGUARD_CUSTOM = "proguard-rules.pro"
}
