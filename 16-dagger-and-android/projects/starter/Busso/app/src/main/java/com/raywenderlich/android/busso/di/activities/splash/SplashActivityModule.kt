package com.raywenderlich.android.busso.di.activities.splash

import com.raywenderlich.android.busso.ui.view.splash.SplashActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [SplashActivitySubcomponent::class]
)
interface SplashActivityModule {

    @Binds
    @IntoMap
    @ClassKey(SplashActivity::class)
    fun bindSplashActivitySubcomponentFactory(
        factory: SplashActivitySubcomponent.Factory
    ): AndroidInjector.Factory<*>
}