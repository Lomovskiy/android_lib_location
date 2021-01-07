package com.lomovskiy.android.lib.location

import com.google.android.gms.common.api.Status

sealed class LocationException : RuntimeException() {
    object CommonLocationException : LocationException()
    class ResolvableLocationException(val resolution: Status) : LocationException()
    class UnresolvableLocationException(val resolution: Status) : LocationException()
    object SecurityLocationException : LocationException()
}