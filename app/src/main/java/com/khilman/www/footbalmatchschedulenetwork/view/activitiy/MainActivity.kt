package com.khilman.www.footbalmatchschedulenetwork.view.activitiy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import com.khilman.www.footbalmatchschedulenetwork.R
import com.khilman.www.footbalmatchschedulenetwork.adapter.MainAdapter
import com.khilman.www.footbalmatchschedulenetwork.extentions.invisible
import com.khilman.www.footbalmatchschedulenetwork.extentions.visible
import com.khilman.www.footbalmatchschedulenetwork.network.ApiRepository
import com.khilman.www.footbalmatchschedulenetwork.network.data.Event
import com.khilman.www.footbalmatchschedulenetwork.presenter.MainPresenter
import com.khilman.www.footbalmatchschedulenetwork.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private var events: MutableList<Event> = mutableListOf()
    private lateinit var preseter: MainPresenter
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // List
        adapter = MainAdapter(events)
        rvMatchSchedule.adapter = adapter
        rvMatchSchedule.layoutManager = LinearLayoutManager(this)

        val request = ApiRepository()
        val gson = Gson()
        preseter = MainPresenter(this, request, gson)
        // Get match data
        preseter.getMatchList("4328", "LAST")

        btNavigaiton.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener {
            menuItem ->
            when (menuItem.itemId) {
                R.id.navPrevMatch -> {
                    preseter.getMatchList("4328", "LAST")
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navNextMatch -> {
                    preseter.getMatchList("4328", "NEXT")
                    return@OnNavigationItemSelectedListener true
                }
                else -> {
                    false
                }
            }
        })
    }
    override fun showLoading() {
        //TODO("not imcplemented") //To change body of created functions use File | Settings | File Templates.
        progressBar.visible()
    }

    override fun hideLoading() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        progressBar.invisible()
    }

    override fun showMatchList(data: List<Event>) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
