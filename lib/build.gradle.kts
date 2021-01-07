plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {

    defaultConfig {
        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)
        compileSdkVersion(Config.compileSdkVersion)
        buildToolsVersion(Config.buildToolsVersion)
        versionCode(1)
        versionName("1.0")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

}

dependencies {
    api(Config.Deps.playServicesLocation)
    implementation(Config.Deps.kotlinStdLib)
    implementation(Config.Deps.kotlinCoroutines)
    implementation(Config.Deps.kotlinCoroutinesPlayServices)
}