package com.raywenderlich.android.ui.navigation.di

import android.app.Activity
import com.raywenderlich.android.di.scopes.ActivityScope
import com.raywenderlich.android.ui.navigation.Navigator
import com.raywenderlich.android.ui.navigation.NavigatorImpl
import dagger.Module
import dagger.Provides

@Module
object NavigationModule {

    @Provides
    @ActivityScope
    fun provideNavigator(activity: Activity): Navigator = NavigatorImpl(activity)
}