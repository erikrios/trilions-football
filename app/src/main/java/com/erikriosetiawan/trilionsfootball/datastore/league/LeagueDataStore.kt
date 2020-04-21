package com.erikriosetiawan.trilionsfootball.datastore.league

import com.erikriosetiawan.trilionsfootball.data.model.League

interface LeagueDataStore {

    suspend fun getLeagues(): List<League>?
    suspend fun addAll(leagues: List<League>?)
}