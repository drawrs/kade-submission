package com.khilman.www.footbalmatchschedulenetwork.view.activitiy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.khilman.www.footbalmatchschedulenetwork.R
import com.khilman.www.footbalmatchschedulenetwork.network.ApiRepository
import com.khilman.www.footbalmatchschedulenetwork.network.data.EventsItem
import com.khilman.www.footbalmatchschedulenetwork.network.data.TeamsItem
import com.khilman.www.footbalmatchschedulenetwork.presenter.DetailPresenter
import com.khilman.www.footbalmatchschedulenetwork.view.DetailView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {


    private lateinit var preseter: DetailPresenter

    private lateinit var idEvent: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        this.idEvent = intent.getStringExtra("EVENT_ID")

        getData()
    }

    private fun getData(){
        val request = ApiRepository()
        val gson = Gson()
        preseter = DetailPresenter(this, request, gson)
        preseter.getEventDetail(idEvent)
    }
    override fun showLoading() {
        //toast("Downloading")
    }

    override fun hideLoading() {
        //toast("Done")
    }

    override fun showEventList(data: List<EventsItem?>?) {
        Log.d("Detail Event", data.toString())
        val dataEvent = data?.get(0)
        // Detail Team
        val teamsId: Array<String?> = arrayOf(dataEvent?.idHomeTeam, dataEvent?.idAwayTeam)
        preseter.getTeamDetail(teamsId)

        //TODO: Set data to Widget
        date_match.text = dataEvent?.dateEvent
        club_home.text = dataEvent?.strHomeTeam
        formation_home.text = dataEvent?.strHomeFormation
        score_home.text = dataEvent?.intHomeScore
        goal_home.text = dataEvent?.strHomeGoalDetails
        shots_home.text = dataEvent?.intHomeShots
        goalkeeper_home.text = dataEvent?.strHomeLineupGoalkeeper
        defense_home.text = dataEvent?.strHomeLineupDefense
        midfield_home.text = dataEvent?.strHomeLineupMidfield
        forward_home.text = dataEvent?.strAwayLineupForward
        subtitutes_home.text = dataEvent?.strHomeLineupSubstitutes
        yellowcard_home.text = dataEvent?.strHomeYellowCards
        redcard_home.text = dataEvent?.strHomeRedCards
        // Away
        club_away.text = dataEvent?.strAwayTeam
        formation_away.text = dataEvent?.strAwayFormation
        score_away.text = dataEvent?.intAwayScore
        goal_away.text = dataEvent?.strAwayGoalDetails
        shots_away.text = dataEvent?.intAwayShots
        goalkeeper_away.text = dataEvent?.strAwayLineupGoalkeeper
        defense_away.text = dataEvent?.strAwayLineupDefense
        midfield_away.text = dataEvent?.strAwayLineupMidfield
        forward_away.text = dataEvent?.strAwayLineupForward
        subtitutes_away.text = dataEvent?.strAwayLineupSubstitutes
        yellowcard_away.text = dataEvent?.strAwayYellowCards
        redcard_away.text = dataEvent?.strAwayRedCards
    }

    override fun getTeamDetails(data: List<TeamsItem?>?) {
        val homeLogo: String? = data?.get(0)?.strTeamBadge
        val awayLogo: String? = data?.get(1)?.strTeamBadge
        runOnUiThread {
            Picasso.get().load(homeLogo).into(logo_home)
            Picasso.get().load(awayLogo).into(logo_away)
        }

    }

}
