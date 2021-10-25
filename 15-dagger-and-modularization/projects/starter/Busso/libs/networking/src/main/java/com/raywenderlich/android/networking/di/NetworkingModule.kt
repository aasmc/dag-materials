package com.raywenderlich.android.networking.di

import android.app.Application
import com.google.gson.GsonBuilder
import com.raywenderlich.android.di.scopes.ApplicationScope
import com.raywenderlich.android.networking.NetworkingConfiguration
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkingModule {

    @Provides
    @ApplicationScope
    fun provideCache(
        networkingConfiguration: NetworkingConfiguration,
        application: Application
    ): Cache =
        Cache(
            application.cacheDir,
            networkingConfiguration.cacheSize
        )

    @Provides
    @ApplicationScope
    fun provideHttpClient(cache: Cache): OkHttpClient =
        OkHttpClient.Builder()
            .cache(cache)
            .build()

    @Provides
    @ApplicationScope
    fun provideRetrofit(
        networkingConfiguration: NetworkingConfiguration,
        httpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(networkingConfiguration.serverBaseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setDateFormat(networkingConfiguration.dateFormat)
                        .create()
                )
            )
            .client(httpClient)
            .build()

}