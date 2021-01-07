object Config {

    const val minSdkVersion = 16
    const val targetSdkVersion = 30
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"

    object Deps {

        private const val kotlinVersion = "1.4.21"
        private const val kotlinCoroutinesVersion = "1.4.2"
        private const val materialDesignComponentsVersion = "1.2.1"
        private const val playServicesLocationVersion = "17.1.0"

        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion"
        const val kotlinCoroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:$kotlinCoroutinesVersion"
        const val materialDesignComponents = "com.google.android.material:material:$materialDesignComponentsVersion"
        const val playServicesLocation = "com.google.android.gms:play-services-location:$playServicesLocationVersion"

    }

    object Modules {

        const val lib = ":lib"

    }

}
