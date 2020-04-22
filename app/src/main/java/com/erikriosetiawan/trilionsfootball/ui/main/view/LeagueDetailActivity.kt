package com.erikriosetiawan.trilionsfootball.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erikriosetiawan.trilionsfootball.data.model.League
import com.erikriosetiawan.trilionsfootball.databinding.ActivityLeagueDetailBinding
import com.squareup.picasso.Picasso

class LeagueDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeagueDetailBinding

    companion object {
        const val DATA_LEAGUE_KEY = "data_league_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showData()
    }

    private fun showData() {
        val league = getDataIntent()
        league?.apply {
            Picasso.get().load(strLogo).into(binding.imgLeagueLogo)
            binding.tvLeagueName.text = strLeague
            binding.tvLeagueDescription.text = strDescriptionEN
        }
    }

    private fun getDataIntent(): League? = intent.getParcelableExtra(DATA_LEAGUE_KEY)
}
