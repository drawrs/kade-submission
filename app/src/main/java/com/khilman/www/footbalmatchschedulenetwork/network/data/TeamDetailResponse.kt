package com.khilman.www.footbalmatchschedulenetwork.network.data

import com.google.gson.annotations.SerializedName

data class TeamDetailResponse(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)