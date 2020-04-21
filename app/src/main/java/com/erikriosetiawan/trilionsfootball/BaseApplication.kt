package com.erikriosetiawan.trilionsfootball

import android.app.Application
import com.erikriosetiawan.trilionsfootball.datastore.league.LeagueLocalDataStore
import com.erikriosetiawan.trilionsfootball.datastore.league.LeagueRemoteDataStore
import com.erikriosetiawan.trilionsfootball.repository.LeagueRepository
import com.erikriosetiawan.trilionsfootball.webservices.RetrofitApp

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val theSportDbService = RetrofitApp.THE_SPORT_DB_SERVICE
        LeagueRepository.instance.apply {
            init(
                LeagueLocalDataStore(),
                LeagueRemoteDataStore(theSportDbService)
            )
        }
    }
}