package com.raywenderlich.android.plugins.weather.endpoint

import com.raywenderlich.android.plugins.api.InformationEndpoint
import com.raywenderlich.android.plugins.model.InfoMessage
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

const val BUSSO_SERVER_BASE_URL = "https://busso-server.herokuapp.com/api/v1/"

interface WeatherEndpoint : InformationEndpoint {
    @GET("${BUSSO_SERVER_BASE_URL}weather/{lat}/{lng}")
    override fun fetchInformation(
        @Path("lat") latitude: Double,
        @Path("lng") longitude: Double
    ): Single<InfoMessage>
}