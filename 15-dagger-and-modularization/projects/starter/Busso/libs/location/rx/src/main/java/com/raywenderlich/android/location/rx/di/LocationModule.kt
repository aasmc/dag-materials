package com.raywenderlich.android.location.rx.di

import android.app.Application
import android.content.Context
import android.location.LocationManager
import com.raywenderlich.android.di.scopes.ApplicationScope
import com.raywenderlich.android.location.api.model.LocationEvent
import com.raywenderlich.android.location.api.permissions.GeoLocationPermissionChecker
import com.raywenderlich.android.location.rx.permission.GeoLocationPermissionCheckerImpl
import com.raywenderlich.android.location.rx.provideRxLocationObservable
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

@Module
class LocationModule {
    @ApplicationScope
    @Provides
    fun provideLocationManager(application: Application): LocationManager =
        application.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    @ApplicationScope
    @Provides
    fun providePermissionChecker(application: Application): GeoLocationPermissionChecker =
        GeoLocationPermissionCheckerImpl(application)

    @Provides
    fun provideLocationObservable(
        locationManager: LocationManager,
        permissionChecker: GeoLocationPermissionChecker
    ): Observable<LocationEvent> = provideRxLocationObservable(locationManager, permissionChecker)
}