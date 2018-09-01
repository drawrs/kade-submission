package com.khilman.www.footbalmatchschedulenetwork.view

import com.khilman.www.footbalmatchschedulenetwork.network.data.EventsItem
import com.khilman.www.footbalmatchschedulenetwork.network.data.TeamsItem

interface DetailView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<EventsItem?>?)
    fun getTeamDetails(data: List<TeamsItem?>?)
}