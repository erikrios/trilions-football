package com.erikriosetiawan.trilionsfootball.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.erikriosetiawan.trilionsfootball.R
import com.erikriosetiawan.trilionsfootball.data.model.League
import com.erikriosetiawan.trilionsfootball.databinding.ItemLeagueBinding
import com.squareup.picasso.Picasso

class LeagueAdapter(private val context: Context, private val leagues: List<League>) :
    RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = ItemLeagueBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(leagues[position], position) {
            // Intent code here
        }

    inner class ViewHolder(private val binding: ItemLeagueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(league: League, position: Int, clickListener: (League) -> Unit) {
            Picasso.get().load(league.strBadge).into(binding.imgLeagueLogo)
            binding.tvLeagueName.text = league.strLeague
            if (position % 2 == 1)
                binding.viewBackground.background =
                    ContextCompat.getDrawable(context, R.drawable.bg_league_card_two)
            itemView.setOnClickListener { clickListener(league) }
        }
    }
}