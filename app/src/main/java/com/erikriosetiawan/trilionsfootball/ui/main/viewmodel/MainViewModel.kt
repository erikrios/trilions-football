package com.erikriosetiawan.trilionsfootball.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erikriosetiawan.trilionsfootball.repository.LeagueRepository
import com.erikriosetiawan.trilionsfootball.ui.main.state.LeagueViewState
import kotlinx.coroutines.launch

class MainViewModel(private val leagues: LeagueRepository) : ViewModel() {

    private val mViewState = MutableLiveData<LeagueViewState>().apply {
        value = LeagueViewState(
            loading = true
        )
    }

    val viewState: LiveData<LeagueViewState>
        get() = mViewState

    init {
        getLeagues()
    }

    fun getLeagues() = viewModelScope.launch {
        try {
            val data = leagues.getLeagues()
            mViewState.value = mViewState.value?.copy(
                loading = false,
                error = null,
                data = data
            )
        } catch (ex: Exception) {
            mViewState.value = mViewState.value?.copy(
                loading = false,
                error = ex,
                data = null
            )
        }
    }
}