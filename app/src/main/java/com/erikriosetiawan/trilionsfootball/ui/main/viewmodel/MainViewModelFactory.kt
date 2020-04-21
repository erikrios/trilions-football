package com.erikriosetiawan.trilionsfootball.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.erikriosetiawan.trilionsfootball.repository.LeagueRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val leagueRepository: LeagueRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(
                MainViewModel::class.java
            )
        )
            return MainViewModel(leagueRepository) as T
        throw IllegalArgumentException()
    }
}