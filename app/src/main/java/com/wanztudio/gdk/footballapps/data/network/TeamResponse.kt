package com.wanztudio.gdk.footballapps.data.network

import com.google.gson.annotations.SerializedName

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */


data class TeamResponse(

	@SerializedName("teams")
	val teams: List<Team>
)