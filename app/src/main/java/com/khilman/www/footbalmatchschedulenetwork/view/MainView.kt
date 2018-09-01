package com.khilman.www.footbalmatchschedulenetwork.view

import com.khilman.www.footbalmatchschedulenetwork.network.data.Event

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data: List<Event>)
}