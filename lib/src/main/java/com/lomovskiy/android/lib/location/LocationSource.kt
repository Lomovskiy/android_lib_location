package com.lomovskiy.android.lib.location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import kotlinx.coroutines.flow.Flow

interface LocationSource {

    @RequiresPermission(value = Manifest.permission.ACCESS_FINE_LOCATION)
    suspend fun getLastKnownLocation(): Location?

    @RequiresPermission(value = Manifest.permission.ACCESS_FINE_LOCATION)
    suspend fun getCurrentLocation(): Location?

    @RequiresPermission(value = Manifest.permission.ACCESS_FINE_LOCATION)
    fun subscribeOnLocationUpdatesStream(
        intervalInMillis: Long,
        distanceInMeters: Float
    ): Flow<Location>

}
