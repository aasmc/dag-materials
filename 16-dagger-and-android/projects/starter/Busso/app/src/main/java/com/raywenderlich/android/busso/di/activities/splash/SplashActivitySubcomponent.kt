package com.raywenderlich.android.busso.di.activities.splash

import com.raywenderlich.android.busso.di.activities.ActivityModule
import com.raywenderlich.android.busso.ui.view.splash.SplashActivity
import com.raywenderlich.android.di.scopes.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [
        ActivityModule::class
    ]
)
@ActivityScope
interface SplashActivitySubcomponent : AndroidInjector<SplashActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<SplashActivity>
}