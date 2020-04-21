package com.erikriosetiawan.trilionsfootball.datastore.league

import com.erikriosetiawan.trilionsfootball.data.model.League

class LeagueLocalDataStore : LeagueDataStore {

    private var caches = mutableListOf<League>()

    override suspend fun getLeagues(): List<League>? =
        if (caches.isNotEmpty()) caches
        else null

    override suspend fun addAll(leagues: List<League>?) {
        leagues?.let { caches = it as MutableList<League> }
    }
}