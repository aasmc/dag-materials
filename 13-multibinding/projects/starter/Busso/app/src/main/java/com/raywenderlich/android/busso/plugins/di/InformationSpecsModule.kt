package com.raywenderlich.android.busso.plugins.di

import com.raywenderlich.android.busso.di.scopes.ApplicationScope
import com.raywenderlich.android.busso.plugins.api.InformationPluginSpec
import com.raywenderlich.android.busso.plugins.weather.di.WEATHER_INFO_NAME
import com.raywenderlich.android.busso.plugins.weather.di.WeatherModule
import com.raywenderlich.android.busso.plugins.whereami.di.WHEREAMI_INFO_NAME
import com.raywenderlich.android.busso.plugins.whereami.di.WhereAmIModule
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import javax.inject.Named

@Module(
    includes = [
        WhereAmIModule::class,
        WeatherModule::class
    ]
)
object InformationSpecsModule {

    @Provides
    @ElementsIntoSet
    @ApplicationScope
    fun provideWeatherSpec(
        @Named(WHEREAMI_INFO_NAME) whereAmISpec: InformationPluginSpec,
        @Named(WEATHER_INFO_NAME) weatherSpec: InformationPluginSpec,
    ): Set<InformationPluginSpec> {
        return mutableSetOf<InformationPluginSpec>().apply {
            add(whereAmISpec)
            add(weatherSpec)
        }
    }

}