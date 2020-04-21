package com.erikriosetiawan.trilionsfootball.ui.main.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.erikriosetiawan.trilionsfootball.R
import com.erikriosetiawan.trilionsfootball.adapter.LeagueAdapter
import com.erikriosetiawan.trilionsfootball.data.model.League
import com.erikriosetiawan.trilionsfootball.databinding.ActivityMainBinding
import com.erikriosetiawan.trilionsfootball.repository.LeagueRepository
import com.erikriosetiawan.trilionsfootball.ui.main.state.LeagueViewState
import com.erikriosetiawan.trilionsfootball.ui.main.viewmodel.MainViewModel
import com.erikriosetiawan.trilionsfootball.ui.main.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: LeagueAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val factory = MainViewModelFactory(LeagueRepository.instance)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java).apply {
            viewState.observe(this@MainActivity, Observer(this@MainActivity::handleState))
        }
    }

    private fun handleState(viewState: LeagueViewState?) {
        viewState?.let {
            toggleLoading(it.loading)
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showData(data: MutableList<League>) {
        adapter = LeagueAdapter(this, data)
        binding.tvLeagueName.text = resources.getString(R.string.england_league)
        binding.rvLeague.visibility = View.VISIBLE
        binding.rvLeague.adapter = adapter
    }

    private fun showError(error: Exception) {
        binding.tvLeagueName.text = error.message
        binding.rvLeague.visibility = View.GONE
    }

    private fun toggleLoading(loading: Boolean) {
        if (loading) binding.progressBar.visibility = View.VISIBLE
        else binding.progressBar.visibility = View.GONE
    }
}
