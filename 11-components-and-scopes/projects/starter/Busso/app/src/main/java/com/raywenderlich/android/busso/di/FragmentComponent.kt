package com.raywenderlich.android.busso.di

import com.raywenderlich.android.busso.di.scopes.FragmentScope
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalFragment
import com.raywenderlich.android.busso.ui.view.busstop.BusStopFragment
import dagger.Component

@Component(
    modules = [FragmentModule::class],
    dependencies = [ActivityComponent::class, ApplicationComponent::class]
)
@FragmentScope
interface FragmentComponent {

    fun inject(fragment: BusStopFragment)

    fun inject(fragment: BusArrivalFragment)

    @Component.Factory
    interface Factory {

        fun create(
            applicationComponent: ApplicationComponent,
            activityComponent: ActivityComponent
        ): FragmentComponent
    }
}