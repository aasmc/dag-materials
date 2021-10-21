package com.raywenderlich.android.busso.di

import android.app.Activity
import android.content.Context
import android.location.LocationManager
import com.raywenderlich.android.busso.permission.GeoLocationPermissionCheckerImpl
import com.raywenderlich.android.busso.ui.view.splash.SplashPresenter
import com.raywenderlich.android.busso.ui.view.splash.SplashPresenterImpl
import com.raywenderlich.android.busso.ui.view.splash.SplashViewBinder
import com.raywenderlich.android.busso.ui.view.splash.SplashViewBinderImpl
import com.raywenderlich.android.location.api.model.LocationEvent
import com.raywenderlich.android.location.rx.provideRxLocationObservable
import com.raywenderlich.android.ui.navigation.Navigator
import com.raywenderlich.android.ui.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.reactivex.Observable

@Module(
    includes = [
        AppModule.Bindings::class
    ]
)
class AppModule(
    private val activity: Activity
) {

    @Provides
    fun provideLocationObservable(): Observable<LocationEvent> {
        val locationManager = activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val geoLocationPermissionChecker = GeoLocationPermissionCheckerImpl(activity)
        return provideRxLocationObservable(locationManager, geoLocationPermissionChecker)
    }

    @Provides
    fun provideNavigator(): Navigator = NavigatorImpl(activity)

    @Module
    interface Bindings {

        @Binds
        fun bindSplashPresenter(impl: SplashPresenterImpl): SplashPresenter

        @Binds
        fun bindSplashViewBinder(impl: SplashViewBinderImpl): SplashViewBinder
    }

}