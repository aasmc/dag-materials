package com.raywenderlich.android.busso.di.fragments.busstop

import com.raywenderlich.android.busso.ui.view.busstop.BusStopFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [BusStopFragmentSubcomponent::class]
)
interface BusStopFragmentModule {

    @Binds
    @IntoMap
    @ClassKey(BusStopFragment::class)
    fun bindBusStopFragmentSubcomponentFactory(
        factory: BusStopFragmentSubcomponent.Factory
    ): AndroidInjector.Factory<*>
}