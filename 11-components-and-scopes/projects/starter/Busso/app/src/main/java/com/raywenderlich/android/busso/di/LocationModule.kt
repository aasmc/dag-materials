package com.raywenderlich.android.busso.di

import android.app.Application
import android.content.Context
import android.location.LocationManager
import com.raywenderlich.android.busso.permission.GeoLocationPermissionCheckerImpl
import com.raywenderlich.android.location.api.model.LocationEvent
import com.raywenderlich.android.location.api.permissions.GeoLocationPermissionChecker
import com.raywenderlich.android.location.rx.provideRxLocationObservable
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import javax.inject.Singleton

@Module
class LocationModule {

    @Singleton
    @Provides
    fun provideLocationManager(application: Application): LocationManager =
        application.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @Singleton
    @Provides
    fun providePermissionChecker(application: Application): GeoLocationPermissionChecker =
        GeoLocationPermissionCheckerImpl(application)

    @Provides
    fun provideLocationObservable(
        locationManager: LocationManager,
        permissionChecker: GeoLocationPermissionChecker
    ): Observable<LocationEvent> = provideRxLocationObservable(locationManager, permissionChecker)
}