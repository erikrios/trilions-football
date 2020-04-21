package com.erikriosetiawan.trilionsfootball.datastore.league

import com.erikriosetiawan.trilionsfootball.data.model.LeagueResponse

class LeagueLocalDataStore : LeagueDataStore {

    private var caches = LeagueResponse()

    override suspend fun getLeagues(): LeagueResponse? =
        if (caches.leagues.isNotEmpty()) caches
        else null

    override suspend fun addAll(leagues: LeagueResponse?) {
        leagues?.let { caches = it }
    }
}