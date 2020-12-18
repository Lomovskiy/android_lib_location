package com.lomovskiy.android.lib.location

import android.Manifest
import android.content.Context
import android.location.Location
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task

interface LocationSource {

    @RequiresPermission(anyOf = [
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ])
    fun getLastKnownLocation(target: LastKnownLocationTarget)

    @RequiresPermission(anyOf = [
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ])
    fun getCurrentLocation(target: CurrentLocationTarget)

    @RequiresPermission(anyOf = [
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ])
    fun getLocationUpdates(target: LocationUpdatesTarget)

    @RequiresPermission(anyOf = [
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ])
    fun removeLocationUpdates(target: LocationUpdatesTarget)

}

class GoogleLocationSource(
    context: Context,
    intervalInMillis: Long = 3 * 1000,
    distanceInMeters: Float = 3.0F
) : LocationSource {

    private val settingsProvider: SettingsClient = SettingsClient(context)
    private val fusedLocationProvider: FusedLocationProviderClient = FusedLocationProviderClient(context)

    private val targets: ArrayList<LocationUpdatesTarget> = ArrayList()

    private val locationRequest: LocationRequest = LocationRequest.create()
            .setInterval(intervalInMillis)
            .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
            .setSmallestDisplacement(distanceInMeters)

    private val locationSettingsRequest: LocationSettingsRequest = LocationSettingsRequest.Builder()
            .setAlwaysShow(true)
            .addLocationRequest(locationRequest)
            .setNeedBle(false)
            .build()

    private val locationCallback = object : LocationCallback() {

        override fun onLocationResult(locationResult: LocationResult) {
            super.onLocationResult(locationResult)
            if (locationResult.lastLocation != null) {
                targets.forEach { target: LocationUpdatesTarget ->
                    target.onLocationUpdated(locationResult.lastLocation)
                }
            }
        }

    }

    @RequiresPermission(anyOf = [
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ])
    override fun getLastKnownLocation(target: LastKnownLocationTarget) {
        settingsProvider.checkLocationSettings(locationSettingsRequest)
                .addOnCompleteListener { settingsTask: Task<LocationSettingsResponse> ->
                    if (settingsTask.isSuccessful) {
                        fusedLocationProvider.lastLocation.addOnCompleteListener { locationTask: Task<Location?> ->
                            if (locationTask.isSuccessful) {
                                target.onLastKnownLocationSuccess(locationTask.result)
                            } else {
                                target.onLastKnownLocationFailure(settingsTask.exception!!)
                            }
                        }
                    } else {
                        target.onLastKnownLocationFailure(settingsTask.exception!!)
                    }
                }
    }

    @RequiresPermission(anyOf = [
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ])
    override fun getCurrentLocation(target: CurrentLocationTarget) {
        settingsProvider.checkLocationSettings(locationSettingsRequest)
                .addOnCompleteListener { settingsTask: Task<LocationSettingsResponse> ->
                    if (settingsTask.isSuccessful) {
                        fusedLocationProvider.getCurrentLocation(LocationRequest.PRIORITY_HIGH_ACCURACY, null)
                                .addOnCompleteListener { locationTask: Task<Location?> ->
                                    if (locationTask.isSuccessful) {
                                        target.onCurrentLocationTargetSuccess(locationTask.result)
                                    } else {
                                        target.onCurrentLocationTargetFailure(settingsTask.exception!!)
                                    }
                                }
                    } else {
                        target.onCurrentLocationTargetFailure(settingsTask.exception!!)
                    }
                }
    }

    @RequiresPermission(anyOf = [
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ])
    override fun getLocationUpdates(target: LocationUpdatesTarget) {
        if (targets.isEmpty()) {
            fusedLocationProvider.requestLocationUpdates(locationRequest, locationCallback, null)
        }
        targets.add(target)
    }

    @RequiresPermission(anyOf = [
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ])
    override fun removeLocationUpdates(target: LocationUpdatesTarget) {
        targets.remove(target)
        if (targets.isEmpty()) {
            fusedLocationProvider.removeLocationUpdates(locationCallback)
        }
    }

}