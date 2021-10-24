package com.raywenderlich.android.busso.plugins.weather.endpoint

import com.raywenderlich.android.busso.conf.BUSSO_SERVER_BASE_URL
import com.raywenderlich.android.busso.plugins.model.InfoMessage
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherEndpoint {

    @GET("${BUSSO_SERVER_BASE_URL}weather/{lat}/{lng}")
    fun fetchWeatherCondition(
        @Path("lat") latitude: Double,
        @Path("lng") longitude: Double
    ): Single<InfoMessage>

}