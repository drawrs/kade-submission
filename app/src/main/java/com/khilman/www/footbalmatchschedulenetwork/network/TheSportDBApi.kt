package com.khilman.www.footbalmatchschedulenetwork.network

import com.khilman.www.footbalmatchschedulenetwork.BuildConfig.BASE_URL
import com.khilman.www.footbalmatchschedulenetwork.BuildConfig.TSDB_API_KEY


//https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328
//=BASE_URL + "api/v1/json/$TSDB_API_KEY/eventspastleague.php?id=" + idleague
object TheSportDBApi {
    fun getLastMatch(idleague: String?): String = "${BASE_URL}/api/v1/json/$TSDB_API_KEY/eventspastleague.php?id=$idleague"
    fun getNextMatch(idleague: String?): String = "${BASE_URL}/api/v1/json/$TSDB_API_KEY/eventsnextleague.php?id=$idleague"
    fun getDetailMatch(idevent: String?): String = "${BASE_URL}/api/v1/json/$TSDB_API_KEY/lookupevent.php?id=$idevent"
    fun getDetailTeam(idteam: String?): String = "${BASE_URL}/api/v1/json/$TSDB_API_KEY/lookupteam.php?id=$idteam"
}