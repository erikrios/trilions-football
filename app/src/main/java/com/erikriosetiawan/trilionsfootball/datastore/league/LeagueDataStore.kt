package com.erikriosetiawan.trilionsfootball.datastore.league

import com.erikriosetiawan.trilionsfootball.data.model.LeagueResponse

interface LeagueDataStore {

    suspend fun getLeagues(): LeagueResponse?
    suspend fun addAll(leagues: LeagueResponse?)
}