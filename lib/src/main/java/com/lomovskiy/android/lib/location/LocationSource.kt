package com.lomovskiy.android.lib.location

import android.content.Context
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.SettingsClient
import kotlin.coroutines.Continuation
import kotlin.coroutines.suspendCoroutine

interface LocationSource {

    suspend fun getLastKnownLocation(): Location?

}

class GoogleLocationSource(
    private val context: Context
) : LocationSource {

    private val settingsProvider: SettingsClient = SettingsClient(context)
    private val fusedLocationProvider: FusedLocationProviderClient = FusedLocationProviderClient(context)

    private val locationSettingsRequest: LocationSettingsRequest = LocationSettingsRequest.Builder()
        .setAlwaysShow(true)
        .addLocationRequest()
        .build()

    override suspend fun getLastKnownLocation(): Location? {
        return suspendCoroutine { continuation: Continuation<Location?> ->
            settingsProvider.checkLocationSettings()
        }
    }

}