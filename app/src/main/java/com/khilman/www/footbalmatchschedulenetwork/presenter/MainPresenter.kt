package com.khilman.www.footbalmatchschedulenetwork.presenter

import com.google.gson.Gson
import com.khilman.www.footbalmatchschedulenetwork.network.ApiRepository
import com.khilman.www.footbalmatchschedulenetwork.network.TheSportDBApi
import com.khilman.www.footbalmatchschedulenetwork.network.data.EventResponse
import com.khilman.www.footbalmatchschedulenetwork.view.MainView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {
    fun getMatchList(idleague: String?, matchType: String?){
        view.showLoading()
        var requestUrl: String
        if (matchType.equals("LAST")){
            requestUrl = TheSportDBApi.getLastMatch(idleague)
        } else {
            requestUrl = TheSportDBApi.getNextMatch(idleague)
        }
        // Get data
        doAsync {
            val data = gson.fromJson(apiRepository.doRequest(requestUrl), EventResponse::class.java)
            uiThread {
                view.hideLoading()
                view.showMatchList(data.events)
            }
        }
    }
}