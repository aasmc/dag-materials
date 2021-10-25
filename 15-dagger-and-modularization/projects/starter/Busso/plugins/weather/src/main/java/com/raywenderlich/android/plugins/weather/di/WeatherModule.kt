package com.raywenderlich.android.plugins.weather.di

import com.raywenderlich.android.di.scopes.ApplicationScope
import com.raywenderlich.android.plugins.api.ComplexInfoKey
import com.raywenderlich.android.plugins.api.InformationPluginSpec
import com.raywenderlich.android.plugins.weather.endpoint.WeatherEndpoint
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

const val WEATHER_INFO_NAME = "Weather"

@Module
object WeatherModule {

    @Provides
    @ApplicationScope
    @IntoMap
    @ComplexInfoKey( // 1
        WeatherEndpoint::class,
        WEATHER_INFO_NAME
    )
    fun provideWeatherSpec(): InformationPluginSpec = InformationPluginSpec
}