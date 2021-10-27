package com.raywenderlich.android.busso.di.fragments.busarrival

import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [BusArrivalFragmentSubcomponent::class]
)
interface BusArrivalFragmentModule {

    @Binds
    @IntoMap
    @ClassKey(BusArrivalFragment::class)
    fun bindBusArrivalFragmentSubcomponentFactory(
        factory: BusArrivalFragmentSubcomponent.Factory
    ): AndroidInjector.Factory<*>

}