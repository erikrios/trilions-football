package com.erikriosetiawan.trilionsfootball.ui.main.state

import com.erikriosetiawan.trilionsfootball.data.model.League

data class LeagueViewState(
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<League>? = null
)