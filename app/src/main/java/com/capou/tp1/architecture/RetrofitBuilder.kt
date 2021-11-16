package com.capou.tp1.architecture

import com.capou.tp1.remote.WeatherEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.chucknorris.io/jokes/https://www.metaweather.com/api/location/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
        .build()

    fun getChuckNorrisQuote(): WeatherEndpoint = retrofit.create(WeatherEndpoint::class.java)
}