plugins {
    `kotlin-dsl`
    id("java-gradle-plugin")
}

configure<GradlePluginDevelopmentExtension> {
    plugins.apply {
        create("android-config") {
            id = "android-config"
            implementationClass = "AndroidConfigPlugin"
        }
        create("kotlin-config") {
            id = "kotlin-config"
            implementationClass = "KotlinConfigPlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("com.android.tools.build:gradle:3.6.0-rc01")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
    implementation("org.eclipse.jgit:org.eclipse.jgit.pgm:5.3.1.201904271842-r")
}

// dependencies graph generator
//apply(from = "https://raw.githubusercontent.com/JakeWharton/SdkSearch/master/gradle/projectDependencyGraph.gradle")
