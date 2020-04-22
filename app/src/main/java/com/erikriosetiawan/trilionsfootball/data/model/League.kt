package com.erikriosetiawan.trilionsfootball.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    val idLeague: String? = null,
    val strSport: String? = null,
    val strLeague: String? = null,
    val strLeagueAlternate: String? = null,
    val strDivision: String? = null,
    val strCurrentSeason: String? = null,
    val intFormedYear: String? = null,
    val strGender: String? = null,
    val strCountry: String? = null,
    val strWebsite: String? = null,
    val strDescriptionEN: String? = null,
    val strBadge: String? = null,
    val strLogo: String? = null
) : Parcelable