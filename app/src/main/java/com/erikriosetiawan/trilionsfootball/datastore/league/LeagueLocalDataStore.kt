package com.erikriosetiawan.trilionsfootball.datastore.league

import com.erikriosetiawan.trilionsfootball.data.model.League
import com.erikriosetiawan.trilionsfootball.data.model.LeagueResponse

class LeagueLocalDataStore : LeagueDataStore {

    private var caches = mutableListOf<League>()

    override suspend fun getLeagues(): List<League>? =
        if (caches.isEmpty()) caches
        else null

    override suspend fun addAll(leagues: List<League>?) {
        leagues?.let { caches = it as MutableList<League> }
    }
}