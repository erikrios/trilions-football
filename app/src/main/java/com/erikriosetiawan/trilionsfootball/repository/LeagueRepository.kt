package com.erikriosetiawan.trilionsfootball.repository

import com.erikriosetiawan.trilionsfootball.data.model.League
import com.erikriosetiawan.trilionsfootball.datastore.league.LeagueDataStore

class LeagueRepository private constructor() : BaseRepository<LeagueDataStore>() {

    suspend fun getLeagues(): MutableList<League>? {
        val cache = localDataStore?.getLeagues()
        if (cache != null)
            return cache as MutableList<League>
        val response = remoteDataStore?.getLeagues()
        remoteDataStore?.getLeagues()
        localDataStore?.addAll(response)
        return response as MutableList<League>
    }

    companion object {
        val instance by lazy {
            LeagueRepository()
        }
    }
}