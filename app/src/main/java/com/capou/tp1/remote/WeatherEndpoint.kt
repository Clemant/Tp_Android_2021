package com.capou.tp1.remote

import com.capou.tp1.model.WeatherRetrofit
import retrofit2.http.GET

interface WeatherEndpoint {
    @GET("766273")
    suspend fun getRandomQuote() : WeatherRetrofit
}