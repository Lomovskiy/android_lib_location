object Config {

    object Deps {

        private const val kotlinVersion = "1.4.21"
        private const val materialDesignComponentsVersion = "1.2.1"
        private const val playServicesLocationVersion = "17.1.0"

        const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
        const val materialDesignComponents = "com.google.android.material:material:$materialDesignComponentsVersion"
        const val playServicesLocation = "com.google.android.gms:play-services-location:$playServicesLocationVersion"

    }

    object Modules {

        const val library = ":library"

    }

}
