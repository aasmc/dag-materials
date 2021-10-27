package com.raywenderlich.android.busso.di

import com.raywenderlich.android.busso.di.activities.ActivityModule
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import com.raywenderlich.android.busso.ui.view.splash.SplashActivity
import com.raywenderlich.android.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class,
            FragmentBindingModule::class
        ]
    )
    @ActivityScope
    fun mainActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = [
            ActivityModule::class
        ]
    )
    @ActivityScope
    fun splashActivity(): SplashActivity
}