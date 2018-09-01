package com.khilman.www.footbalmatchschedulenetwork.network

import java.net.URL

class ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}