package com.raywenderlich.android.busso.di

import com.raywenderlich.android.busso.network.NetworkModule
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalFragment
import com.raywenderlich.android.busso.ui.view.busstop.BusStopFragment
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import com.raywenderlich.android.busso.ui.view.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, NetworkModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: SplashActivity)

    fun inject(activity: MainActivity)

    fun inject(fragment: BusStopFragment)

    fun inject(fragment: BusArrivalFragment)

}