package com.erikriosetiawan.trilionsfootball.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erikriosetiawan.trilionsfootball.data.model.League
import com.erikriosetiawan.trilionsfootball.databinding.ActivityLeagueDetailBinding

class LeagueDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeagueDetailBinding

    companion object {
        const val DATA_LEAGUE_KEY = "data_league_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun getDataIntent(): League? = intent.getParcelableExtra(DATA_LEAGUE_KEY)
}
