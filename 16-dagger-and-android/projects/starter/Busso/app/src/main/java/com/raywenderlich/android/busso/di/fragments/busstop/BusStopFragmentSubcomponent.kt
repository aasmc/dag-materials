package com.raywenderlich.android.busso.di.fragments.busstop

import com.raywenderlich.android.busso.di.fragments.FragmentModule
import com.raywenderlich.android.busso.ui.view.busstop.BusStopFragment
import com.raywenderlich.android.di.scopes.FragmentScope
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [
        FragmentModule::class
    ]
)
@FragmentScope
interface BusStopFragmentSubcomponent : AndroidInjector<BusStopFragment> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<BusStopFragment> {

        override fun create(@BindsInstance instance: BusStopFragment): BusStopFragmentSubcomponent
    }

}