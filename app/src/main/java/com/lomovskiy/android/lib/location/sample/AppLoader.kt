package com.lomovskiy.android.lib.location.sample

import android.app.Application
import com.lomovskiy.android.lib.location.GoogleLocationSource
import com.lomovskiy.android.lib.location.LocationSource

class AppLoader : Application() {

    companion object {

        lateinit var locationSource: LocationSource

    }

    override fun onCreate() {
        super.onCreate()
        locationSource = GoogleLocationSource(this)
    }

}