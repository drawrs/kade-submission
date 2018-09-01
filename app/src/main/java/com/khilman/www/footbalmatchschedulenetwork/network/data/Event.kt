package com.khilman.www.footbalmatchschedulenetwork.network.data

import com.google.gson.annotations.SerializedName

data class Event(
        @SerializedName("idEvent")
        var eventId: String? = null,

        @SerializedName("dateEvent")
        var eventDate: String? = null,

        @SerializedName("intHomeScore")
        var scoreHome: String? = null,

        @SerializedName("strHomeTeam")
        var teamHome: String? = null,

        @SerializedName("intAwayScore")
        var scoreAway: String? = null,

        @SerializedName("strAwayTeam")
        var teamAway: String? = null
)