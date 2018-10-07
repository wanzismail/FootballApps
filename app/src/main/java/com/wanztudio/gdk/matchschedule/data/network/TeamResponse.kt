package com.wanztudio.gdk.matchschedule.data.network

import com.google.gson.annotations.SerializedName

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */


data class TeamResponse(

	@field:SerializedName("teams")
	val teams: List<Team?>? = null
)