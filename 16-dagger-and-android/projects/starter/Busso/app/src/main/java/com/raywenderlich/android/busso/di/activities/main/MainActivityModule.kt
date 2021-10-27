package com.raywenderlich.android.busso.di.activities.main

import com.raywenderlich.android.busso.ui.view.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [MainActivitySubcomponent::class]
)
interface MainActivityModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    fun bindMainActivitySubcomponentFactory(
        factory: MainActivitySubcomponent.Factory
    ): AndroidInjector.Factory<*>
}