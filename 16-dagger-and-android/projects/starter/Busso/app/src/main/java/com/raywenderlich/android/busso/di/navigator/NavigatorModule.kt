package com.raywenderlich.android.busso.di.navigator

import com.raywenderlich.android.busso.ui.view.main.MainActivity
import com.raywenderlich.android.busso.ui.view.splash.SplashActivity
import com.raywenderlich.android.di.scopes.ActivityScope
import com.raywenderlich.android.ui.navigation.Navigator
import com.raywenderlich.android.ui.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object NavigatorModule {

    @Provides
    @ActivityScope
    @Named("Main")
    fun providesMainActivityNavigator(owner: MainActivity): Navigator =
        NavigatorImpl(owner)

    @Provides
    @ActivityScope
    @Named("Splash")
    fun provideSplashActivityNavigator(owner: SplashActivity): Navigator =
        NavigatorImpl(owner)
}