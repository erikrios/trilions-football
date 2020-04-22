package com.erikriosetiawan.trilionsfootball.ui.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erikriosetiawan.trilionsfootball.databinding.ActivityLeagueDetailBinding

class LeagueDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeagueDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
