package com.erikriosetiawan.trilionsfootball.data.model

import com.google.gson.annotations.SerializedName

data class LeagueResponse(
    @SerializedName("countrys")
    var leagues: List<League> = mutableListOf()
)