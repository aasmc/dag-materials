package com.raywenderlich.android.busso.di

import android.annotation.SuppressLint
import android.content.Context
import com.raywenderlich.android.busso.permission.GeoLocationPermissionCheckerImpl

const val LOCATION_MANAGER = "LocationManager"
const val GEO_PERMISSION_CHECKER = "GeoPermissionChecker"

class ServiceLocatorImpl(
    val context: Context
) : ServiceLocator {

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("ServiceCast")
    override fun <A : Any> lookUp(name: String): A = when (name) {
        LOCATION_MANAGER -> context.getSystemService(Context.LOCATION_SERVICE)
        GEO_PERMISSION_CHECKER -> GeoLocationPermissionCheckerImpl(context)
        else -> throw IllegalArgumentException("No component lookup for the key: $name")
    } as A
}