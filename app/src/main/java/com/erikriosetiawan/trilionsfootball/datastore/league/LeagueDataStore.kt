package com.erikriosetiawan.trilionsfootball.datastore.league

import com.erikriosetiawan.trilionsfootball.data.model.League
import com.erikriosetiawan.trilionsfootball.data.model.LeagueResponse

interface LeagueDataStore {

    suspend fun getLeagues(): List<League>?
    suspend fun addAll(leagues: List<League>?)
}