plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {

    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(30)
        compileSdkVersion(30)
        buildToolsVersion("30.0.3")
        versionCode(1)
        versionName("1.0")

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
    }

//    buildTypes {
//        release {
//            minifyEnabled false
//        }
//    }

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
    implementation(Config.Deps.materialDesignComponents)
}