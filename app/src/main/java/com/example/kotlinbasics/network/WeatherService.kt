package com.example.kotlinbasics.network

import com.example.kotlinbasics.model.WeatherResponse

interface WeatherService {
    @GET("data/2.5/weather")
    fun getWeather(
        @Query("q") cityname: String,
        @Query("appid") apikey: String,
        @Query("units") units: String
    ): Call<WeatherResponse>
}