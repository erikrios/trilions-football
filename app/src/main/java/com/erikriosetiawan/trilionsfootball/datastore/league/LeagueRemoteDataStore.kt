package com.erikriosetiawan.trilionsfootball.datastore.league

import com.erikriosetiawan.trilionsfootball.data.model.League
import com.erikriosetiawan.trilionsfootball.webservices.TheSportDbService

class LeagueRemoteDataStore(private val theSportDbService: TheSportDbService) : LeagueDataStore {

    override suspend fun getLeagues(): List<League>? {
        val response = theSportDbService.getLeagues("England", "Soccer")
        if (response.isSuccessful)
            return response.body()?.leagues

        throw Exception("A problem happened when request data, status error ${response.code()}")
    }

    override suspend fun addAll(leagues: List<League>?) {

    }
}