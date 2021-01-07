package com.lomovskiy.android.lib.location

import android.Manifest
import android.content.Context
import android.location.Location
import androidx.annotation.RequiresPermission
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class GoogleLocationSource(
    context: Context,
    private val settingsProvider: SettingsClient = SettingsClient(context),
    private val fusedLocationProvider: FusedLocationProviderClient = FusedLocationProviderClient(context)
) : LocationSource {

    @RequiresPermission(value = Manifest.permission.ACCESS_FINE_LOCATION)
    override suspend fun getLastKnownLocation(): Location? {
        try {
            val locationRequest: LocationRequest = createLocationRequest(0, 0F)
            checkSettings(locationRequest)
            return fusedLocationProvider.lastLocation.await()
        } catch (e: Exception) {
            throw mapToLocationException(e)
        }
    }

    @RequiresPermission(value = Manifest.permission.ACCESS_FINE_LOCATION)
    override suspend fun getCurrentLocation(): Location? {
        try {
            val locationRequest: LocationRequest = createLocationRequest(0, 0F)
            checkSettings(locationRequest)
            return fusedLocationProvider
                .getCurrentLocation(locationRequest.priority, null)
                .await()
        } catch (e: Exception) {
            throw mapToLocationException(e)
        }
    }

    @ExperimentalCoroutinesApi
    @RequiresPermission(value = Manifest.permission.ACCESS_FINE_LOCATION)
    override fun subscribeOnLocationUpdatesStream(
            intervalInMillis: Long,
            distanceInMeters: Float
    ): Flow<Location> {
        return callbackFlow {
            try {
                val locationRequest: LocationRequest = createLocationRequest(intervalInMillis, distanceInMeters)
                checkSettings(locationRequest)
                val locationCallback = object : LocationCallback() {

                    override fun onLocationResult(locationResult: LocationResult) {
                        if (locationResult.lastLocation != null) {
                            offer(locationResult.lastLocation)
                        }
                    }

                }
                fusedLocationProvider.requestLocationUpdates(locationRequest, locationCallback, null)
                awaitClose {
                    fusedLocationProvider.removeLocationUpdates(locationCallback)
                }
            } catch (e: Exception) {
                throw mapToLocationException(e)
            }
        }
    }

    private suspend fun checkSettings(locationRequest: LocationRequest) {
        settingsProvider.checkLocationSettings(
                createLocationSettingsRequest(locationRequest)
        ).await()
    }

    private fun mapToLocationException(e: Exception): Throwable {
        when (e) {
            is ResolvableApiException -> {
                if (e.status.hasResolution()) {
                    return LocationException.ResolvableLocationException(e.status)
                } else {
                    return LocationException.UnresolvableLocationException(e.status)
                }
            }
            is ApiException -> {
                return LocationException.UnresolvableLocationException(e.status)
            }
            is SecurityException -> {
                return LocationException.SecurityLocationException
            }
            else -> {
                return LocationException.CommonLocationException
            }
        }
    }

    private fun createLocationRequest(intervalInMillis: Long,
                                      distanceInMeters: Float): LocationRequest {
        return LocationRequest.create()
                .setInterval(intervalInMillis)
                .setSmallestDisplacement(distanceInMeters)
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
    }

    private fun createLocationSettingsRequest(locationRequest: LocationRequest): LocationSettingsRequest {
        return LocationSettingsRequest.Builder()
                .setAlwaysShow(true)
                .addLocationRequest(locationRequest)
                .setNeedBle(false)
                .build()
    }

}
