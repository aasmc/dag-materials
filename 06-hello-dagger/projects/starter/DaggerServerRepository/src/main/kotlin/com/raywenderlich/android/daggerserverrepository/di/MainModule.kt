package com.raywenderlich.android.daggerserverrepository.di

import com.raywenderlich.android.daggerserverrepository.FakeRepository
import com.raywenderlich.android.daggerserverrepository.Repository
import dagger.Module
import dagger.Provides

@Module
object MainModule {
    @Provides
    fun provideRepository(): Repository = FakeRepository()
}