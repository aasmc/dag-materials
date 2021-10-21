package com.raywenderlich.android.busso.di

import com.raywenderlich.android.busso.ui.view.splash.SplashActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: SplashActivity)

}