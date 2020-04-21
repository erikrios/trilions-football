package com.erikriosetiawan.trilionsfootball.webservices

import com.erikriosetiawan.trilionsfootball.data.model.LeagueResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheSportDbService {

    @GET("search_all_leagues.php")
    suspend fun getLeagues(
        @Query("c") country: String,
        @Query("s") sport: String
    ): LeagueResponse
}