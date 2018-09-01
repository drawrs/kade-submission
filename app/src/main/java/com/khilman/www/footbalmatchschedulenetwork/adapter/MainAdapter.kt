package com.khilman.www.footbalmatchschedulenetwork.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.khilman.www.footbalmatchschedulenetwork.view.activitiy.DetailActivity
import com.khilman.www.footbalmatchschedulenetwork.R
import com.khilman.www.footbalmatchschedulenetwork.network.data.Event
import com.khilman.www.footbalmatchschedulenetwork.util.Helper
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MainAdapter (private val events: List<Event>): RecyclerView.Adapter<EvenViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): EvenViewHolder {
        val createView = LayoutInflater.from(parent.context).inflate(R.layout.list_match_item, parent, false)
        return  EvenViewHolder(createView)
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EvenViewHolder, position: Int) {
        holder.bindItem(events[position])
    }

}

class EvenViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val teamHome: TextView = view.find(R.id.tv_home_team)
    private val teamAway: TextView = view.find(R.id.tv_away_team)
    private val scoreHome: TextView = view.find(R.id.tv_home_team_score)
    private val scoreAway: TextView = view.find(R.id.tv_away_team_score)
    private val scheduleDate: TextView = view.find(R.id.tv_match_date)

    fun bindItem(event: Event){
        teamHome.text = event.teamHome
        teamAway.text = event.teamAway
        scoreHome.text = event.scoreHome
        scoreAway.text = event.scoreAway

        scheduleDate.text = Helper(itemView.context).localizeDate(event.eventDate)

        itemView.setOnClickListener {
            itemView.context.startActivity<DetailActivity>("EVENT_ID" to event.eventId)
        }
    }
}