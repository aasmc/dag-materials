package com.raywenderlich.android.busso

import android.app.Application
import android.content.Context
import com.raywenderlich.android.busso.di.ApplicationComponent
import com.raywenderlich.android.busso.di.DaggerApplicationComponent

class Main : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .factory()
            .create(this)
    }
}

val Context.appComp: ApplicationComponent
    get() = (applicationContext as Main).appComponent