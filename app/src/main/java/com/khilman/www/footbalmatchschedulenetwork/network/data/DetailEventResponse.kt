package com.khilman.www.footbalmatchschedulenetwork.network.data

import com.google.gson.annotations.SerializedName

data class DetailEventResponse(

	@field:SerializedName("events")
	val events: List<EventsItem?>? = null
)