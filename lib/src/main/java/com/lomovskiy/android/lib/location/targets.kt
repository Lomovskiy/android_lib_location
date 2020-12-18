package com.lomovskiy.android.lib.location

import android.location.Location

interface LastKnownLocationTarget {

    fun onLastKnownLocationSuccess(location: Location?)

    fun onLastKnownLocationFailure(throwable: Throwable)

}

interface CurrentLocationTarget {

    fun onCurrentLocationTargetSuccess(location: Location?)

    fun onCurrentLocationTargetFailure(throwable: Throwable)

}

interface LocationUpdatesTarget {

    fun onLocationUpdated(location: Location)

}
