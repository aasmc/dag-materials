package com.raywenderlich.android.daggerserverrepository.di

import com.raywenderlich.android.daggerserverrepository.Server
import dagger.Component

/**
 * We use @Component to define classes with factory responsibilities.
 */
@Component(
    modules = [MainModule::class]
)
interface AppComponent {

    fun server(): Server
}