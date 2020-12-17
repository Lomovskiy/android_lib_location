package ru.facilicom

private const val kotlinVersion = "1.4.10"
private const val multidexVersion = "2.0.1"
private const val appCompatVersion = "1.1.0"
private const val retrofitVersion = "2.3.0"
private const val retrofitCoroutinesAdapterVersion = "0.9.2"
private const val stethoVersion = "1.5.0"
private const val gsonVersion = "2.8.5"
private const val jacksonVersion = "1.9.13"
private const val greenDaoVersion = "3.2.2"
private const val ormLiteVersion = "5.0"
private const val roomVersion = "2.2.5"
private const val ciceroneVersion = "5.0.0"
private const val firebaseUiVersion = "4.3.1"
private const val kotlinCoroutinesAndroidVersion = "1.3.0"
private const val kotlinCoroutinesVersion = "1.3.9"
private const val lifecycleVersion = "2.2.0"
private const val rxJavaVersion = "2.2.9"
private const val rxAndroidVersion = "2.1.1"
private const val rxKotlinVersion = "2.3.0"
private const val rxRelayVersion = "2.1.0"
private const val rxBindingVersion = "2.1.1"
private const val materialVersion = "1.1.0"
private const val cardViewVersion = "1.0.0"
private const val androidAsyncHttpVersion = "1.4.9"
private const val okHttpLoggingInterceptorVersion = "3.11.0"
private const val legacySupportVersion = "1.0.0"
private const val googlePlayServicesVersion = "17.0.0"
private const val firebaseCoreVersion = "17.4.3"
private const val firebaseMessagingVersion = "20.2.0"
private const val firebaseCrashlyticsVersion = "17.1.0"
private const val firebaseAuthVersion = "19.3.1"
private const val firebaseAnalyticsVersion = "17.4.2"
private const val zxingVersion = "3.3.0"
private const val zxingAndroidVersion = "3.6.0"
private const val timberVersion = "4.7.1"
private const val eventBusVersion = "3.1.1"
private const val easyImageVersion = "2.1.0"
private const val picassoVersion = "2.71828"
private const val threetenabpVersion = "1.2.1"
private const val compressorVersion = "2.1.0"
private const val rxPermissionsVersion = "0.10.2"
private const val androidTimesSquareVersion = "1.7.3"
private const val rabbitMqClientVersion = "3.6.6"
private const val materialDialogsVersion = "0.9.6.0"
private const val horizontalScrollViewVersion = "1.3.1"
private const val segmentedButtonVersion = "v2.0.2"
private const val workManagerVersion = "2.4.0"
private const val fragmentsVersion = "1.2.5"
private const val constraintLayoutVersion = "1.1.3"
private const val rxLocationVersion = "1.0.3"
private const val rxSensorsVersion = "0.2.0"
private const val preferencesVersion = "1.1.0"
private const val koinVersion = "2.1.6"
private const val cameraViewVersion = "2.6.4"

private const val jUnitVersion = "4.12"
private const val runnerVersion = "1.1.0"
private const val rulesVersion = "1.2.0"
private const val truthVersion = "1.0"
private const val mockitoVersion = "2.19.0"
private const val robolectricVersion = "4.2.1"
private const val testCoreVersion = "1.2.0"
private const val roomTestingVersion = "2.2.5"

object Config {
    const val kotlinGradlePluginVersion = kotlinVersion
    const val androidGradlePluginVersion = "4.1.0"
    const val gmsGradlePluginVersion = "4.3.3"
    const val crashlyticsGradlePluginVersion = "2.2.0"

    const val buildToolsVersion = "29.0.3"
    const val minSdkVersion = 16
    const val targetSdkVersion = 29
    const val compileSdkVersion = 29

    object Manager {
        const val versionCode = 227
        const val versionName = "1.29.0"
    }

    object Worker {
        const val versionCode = 343
        const val versionName = "1.60.1"
    }

    object Libs {

        const val cameraView = "com.otaliastudios:cameraview:$cameraViewVersion"

        val koinGroup = arrayOf(
            "org.koin:koin-core:$koinVersion",
            "org.koin:koin-android:$koinVersion",
            "org.koin:koin-androidx-scope:$koinVersion",
            "org.koin:koin-androidx-viewmodel:$koinVersion",
            "org.koin:koin-androidx-fragment:$koinVersion"
        )

        const val kotlinStd: String = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
        const val kotlinCoroutinesAndroid: String = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlinCoroutinesAndroidVersion"
        const val kotlinCoroutines: String = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion"

        const val multidex: String = "androidx.multidex:multidex:$multidexVersion"

        const val appCompat: String = "androidx.appcompat:appcompat:$appCompatVersion"

        const val retrofit: String = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val retrofitGsonConverter: String = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val retrofitRxJavaAdapter: String = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
        const val retrofitCoroutinesAdapter: String = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$retrofitCoroutinesAdapterVersion"

        const val stetho: String = "com.facebook.stetho:stetho:$stethoVersion"
        const val stethoOkHttp: String = "com.facebook.stetho:stetho-okhttp3:$stethoVersion"

        const val gson: String = "com.google.code.gson:gson:$gsonVersion"

        const val jacksonCore: String = "org.codehaus.jackson:jackson-core-asl:$jacksonVersion"
        const val jacksonMapper: String = "org.codehaus.jackson:jackson-mapper-asl:$jacksonVersion"

        const val greenDao: String = "org.greenrobot:greendao:$greenDaoVersion"

        const val ormLiteCore: String = "com.j256.ormlite:ormlite-core:$ormLiteVersion"
        const val ormLiteAndroid: String = "com.j256.ormlite:ormlite-android:$ormLiteVersion"

        const val roomRuntime: String = "androidx.room:room-runtime:$roomVersion"
        const val roomRxJavaAdapter: String = "androidx.room:room-rxjava2:$roomVersion"
        const val roomCompiler: String = "androidx.room:room-compiler:$roomVersion"

        const val cicerone: String = "ru.terrakok.cicerone:cicerone:$ciceroneVersion"

        const val firebaseUiStorage: String = "com.firebaseui:firebase-ui-storage:$firebaseUiVersion"
        const val firebaseUiDatabase: String = "com.firebaseui:firebase-ui-database:$firebaseUiVersion"

        const val lifecycleViewModel: String = "androidx.lifecycle:lifecycle-viewmodel:$lifecycleVersion"
        const val lifecycleViewModelSavedState: String = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion"
        const val lifecycleLiveData: String  = "androidx.lifecycle:lifecycle-livedata:$lifecycleVersion"
        const val lifecycleCommon: String = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        const val lifecycleService: String = "androidx.lifecycle:lifecycle-service:$lifecycleVersion"
        const val lifecycleProcess: String = "androidx.lifecycle:lifecycle-process:$lifecycleVersion"
        const val lifecycleRuntime: String = "androidx.lifecycle:lifecycle-runtime:$lifecycleVersion"
        const val lifecycleExtensions: String = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
        const val lifecycleReactiveStreams: String = "androidx.lifecycle:lifecycle-reactivestreams:$lifecycleVersion"

        const val rxJava: String = "io.reactivex.rxjava2:rxjava:$rxJavaVersion"
        const val rxAndroid: String = "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion"
        const val rxKotlin: String = "io.reactivex.rxjava2:rxkotlin:$rxKotlinVersion"
        const val rxRelay: String = "com.jakewharton.rxrelay2:rxrelay:$rxRelayVersion"
        const val rxBinding: String = "com.jakewharton.rxbinding2:rxbinding-kotlin:$rxBindingVersion"
        const val rxBindingAppCompatV7: String = "com.jakewharton.rxbinding2:rxbinding-appcompat-v7-kotlin:$rxBindingVersion"

        const val material: String = "com.google.android.material:material:$materialVersion"

        const val cardView: String = "androidx.cardview:cardview:$cardViewVersion"

        const val androidAsyncHttp: String = "com.loopj.android:android-async-http:$androidAsyncHttpVersion"

        const val okHttpLoggingInterceptor: String = "com.squareup.okhttp3:logging-interceptor:$okHttpLoggingInterceptorVersion"

        const val legacySupportV4: String = "androidx.legacy:legacy-support-v4:$legacySupportVersion"
        const val legacySupportV13: String = "androidx.legacy:legacy-support-v13:$legacySupportVersion"

        const val googlePlayServicesLocation: String = "com.google.android.gms:play-services-location:$googlePlayServicesVersion"
        const val googlePlayServicesMaps: String = "com.google.android.gms:play-services-maps:$googlePlayServicesVersion"

        const val firebaseCore: String = "com.google.firebase:firebase-core:$firebaseCoreVersion"
        const val firebaseAuth: String = "com.google.firebase:firebase-auth:$firebaseAuthVersion"
        const val firebaseCrashlytics: String = "com.google.firebase:firebase-crashlytics:$firebaseCrashlyticsVersion"
        const val firebaseMessaging: String = "com.google.firebase:firebase-messaging:$firebaseMessagingVersion"
        const val firebaseAnalytics: String = "com.google.firebase:firebase-analytics:$firebaseAnalyticsVersion"

        const val zxing: String = "com.google.zxing:core:$zxingVersion"
        const val zxingAndroid: String = "com.journeyapps:zxing-android-embedded:$zxingAndroidVersion"

        const val timber: String = "com.jakewharton.timber:timber:$timberVersion"

        const val eventBus: String = "org.greenrobot:eventbus:$eventBusVersion"

        const val easyImage: String = "com.github.jkwiecien:EasyImage:$easyImageVersion"

        const val picasso: String = "com.squareup.picasso:picasso:$picassoVersion"

        const val threetenabp: String = "com.jakewharton.threetenabp:threetenabp:$threetenabpVersion"

        const val compressor: String = "id.zelory:compressor:$compressorVersion"

        const val rxPermissions: String = "com.github.tbruyelle:rxpermissions:$rxPermissionsVersion"

        const val androidTimesSquare: String = "com.squareup:android-times-square:$androidTimesSquareVersion"

        const val rabbitMqClient: String = "com.rabbitmq:amqp-client:$rabbitMqClientVersion"

        const val materialDialogsCore: String = "com.afollestad.material-dialogs:core:$materialDialogsVersion"
        const val materialDialogsCommons: String = "com.afollestad.material-dialogs:commons:$materialDialogsVersion"

        const val horizontalScrollView: String = "it.sephiroth.android.library.horizontallistview:hlistview:$horizontalScrollViewVersion"

        const val segmentedButton: String = "com.github.ceryle:SegmentedButton:$segmentedButtonVersion"

        const val workManager: String = "androidx.work:work-runtime-ktx:$workManagerVersion"

        const val fragments: String = "androidx.fragment:fragment-ktx:$fragmentsVersion"
        const val preferences: String = "androidx.preference:preference:$preferencesVersion"

        const val constraintLayout: String = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

        const val rxLocation: String = "com.patloew.rxlocation:rxlocation:$rxLocationVersion"

        const val rxSensors: String = "com.github.pwittchen:reactivesensors-rx2:$rxSensorsVersion"
    }

    object TestLibs {

        const val jUnit: String = "junit:junit:$jUnitVersion"
        const val runner: String = "androidx.test:runner:$runnerVersion"
        const val rules: String = "androidx.test:rules:$rulesVersion"
        const val truth: String = "com.google.truth:truth:$truthVersion"
        const val mockito: String = "org.mockito:mockito-core:$mockitoVersion"
        const val testCore: String = "androidx.test:core:$testCoreVersion"
        const val robolectric: String = "org.robolectric:robolectric:$robolectricVersion"
        const val roomTesting: String = "androidx.room:room-testing:$roomTestingVersion"
        const val workManager = "androidx.work:work-testing:$workManagerVersion"

    }

}