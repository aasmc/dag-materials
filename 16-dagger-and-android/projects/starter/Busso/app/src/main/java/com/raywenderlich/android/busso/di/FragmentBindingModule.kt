package com.raywenderlich.android.busso.di

import com.raywenderlich.android.busso.di.fragments.FragmentModule
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalFragment
import com.raywenderlich.android.busso.ui.view.busstop.BusStopFragment
import com.raywenderlich.android.di.scopes.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentBindingModule {

    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class
        ]
    )
    @FragmentScope
    fun busStopFragment(): BusStopFragment

    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class
        ]
    )
    @FragmentScope
    fun busArrivalFragment(): BusArrivalFragment
}