package com.raywenderlich.android.busso.plugins.weather.endpoint

import com.raywenderlich.android.busso.plugins.model.InfoMessage
import com.raywenderlich.android.location.api.model.GeoLocation
import io.reactivex.Single
import javax.inject.Inject

class WeatherInformationEndpointImpl @Inject constructor(
    private val weatherEndpoint: WeatherEndpoint
) : WeatherInformationEndpoint {

    override fun fetchInformation(location: GeoLocation): Single<InfoMessage> {
        return weatherEndpoint.fetchWeatherCondition(location.latitude, location.longitude)
    }

}