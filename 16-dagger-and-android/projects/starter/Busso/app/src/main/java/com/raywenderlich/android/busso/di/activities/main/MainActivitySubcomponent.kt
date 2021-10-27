package com.raywenderlich.android.busso.di.activities.main

import com.raywenderlich.android.busso.di.activities.ActivityModule
import com.raywenderlich.android.busso.di.fragments.busarrival.BusArrivalFragmentModule
import com.raywenderlich.android.busso.di.fragments.busstop.BusStopFragmentModule
import com.raywenderlich.android.busso.di.fragments.busstop.BusStopFragmentSubcomponent
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import com.raywenderlich.android.di.scopes.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [
        ActivityModule::class,
        BusStopFragmentModule::class,
        BusArrivalFragmentModule::class
    ]
)
@ActivityScope
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>

}