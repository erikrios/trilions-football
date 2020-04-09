package com.erikriosetiawan.trilionsfootball.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erikriosetiawan.trilionsfootball.adapter.LeagueAdapter
import com.erikriosetiawan.trilionsfootball.data.model.League
import com.erikriosetiawan.trilionsfootball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val leagues: MutableList<League> = mutableListOf()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setUI()
    }

    private fun setUI() {
        setDummyData()
        val adapter = LeagueAdapter(this, leagues)
        binding.rvLeague.adapter = adapter
    }

    private fun setDummyData() {
        for (i in 0..9) {
            val league =
                League(
                    strBadge = "https://www.thesportsdb.com/images/media/league/badge/i6o0kh1549879062.png",
                    strLeague = "England League name of Football $i"
                )
            leagues.add(league)
        }
    }
}
