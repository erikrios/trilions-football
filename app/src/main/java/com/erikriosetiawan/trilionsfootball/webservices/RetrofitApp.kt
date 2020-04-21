package com.erikriosetiawan.trilionsfootball.webservices

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitApp {

    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"

    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val okHttp = OkHttpClient.Builder()
        .callTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(logger)

    private val client = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())
        .build()

    val THE_SPORT_DB_SERVICE: TheSportDbService = client.create(TheSportDbService::class.java)
}