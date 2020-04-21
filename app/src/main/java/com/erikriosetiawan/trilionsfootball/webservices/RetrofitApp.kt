package com.erikriosetiawan.trilionsfootball.webservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApp {

    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"

    private val client = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val THE_SPORT_DB_SERVICE: TheSportDbService = client.create(TheSportDbService::class.java)
}