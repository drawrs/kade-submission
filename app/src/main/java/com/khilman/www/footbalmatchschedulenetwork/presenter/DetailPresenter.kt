package com.khilman.www.footbalmatchschedulenetwork.presenter

import android.util.Log
import com.google.gson.Gson
import com.khilman.www.footbalmatchschedulenetwork.network.ApiRepository
import com.khilman.www.footbalmatchschedulenetwork.network.TheSportDBApi
import com.khilman.www.footbalmatchschedulenetwork.network.data.DetailEventResponse
import com.khilman.www.footbalmatchschedulenetwork.network.data.TeamDetailResponse
import com.khilman.www.footbalmatchschedulenetwork.network.data.TeamsItem
import com.khilman.www.footbalmatchschedulenetwork.view.DetailView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class DetailPresenter(private val view: DetailView,
                      private val apiRepository: ApiRepository,
                      private val gson: Gson) {

    fun getEventDetail(idEvent: String?) {
        view.showLoading()

        val requestUrl = TheSportDBApi.getDetailMatch(idEvent)

        // Get data
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(requestUrl), DetailEventResponse::class.java)
            uiThread {
                view.hideLoading()
                view.showEventList(data.events)
            }
        }
    }

    private val teamsData = mutableListOf<TeamsItem>()
    fun getTeamDetail(idTeams: Array<String?>) {


        doAsync {
            for (idTeam in idTeams) {
                val requestUrl = TheSportDBApi.getDetailTeam(idTeam.toString())
                val data = gson.fromJson(apiRepository.doRequest(requestUrl), TeamDetailResponse::class.java)
                Log.d("data from network", data.teams?.get(0)?.toString())
                teamsData.add(data.teams?.get(0)!!)
            }
            Log.d("teamsData", teamsData.size.toString())
            view.hideLoading()
            view.getTeamDetails(teamsData)
        }

    }
}