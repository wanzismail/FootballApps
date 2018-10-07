package com.wanztudio.gdk.matchschedule.data.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

data class Event(

	@field:SerializedName("intHomeShots")
	val intHomeShots: String? = null,

	@field:SerializedName("strSport")
	val strSport: String? = null,

	@field:SerializedName("strHomeLineupDefense")
	val strHomeLineupDefense: String? = null,

	@field:SerializedName("strAwayLineupSubstitutes")
	val strAwayLineupSubstitutes: String? = null,

	@field:SerializedName("idLeague")
	val idLeague: String,

	@field:SerializedName("idSoccerXML")
	val idSoccerXML: String? = null,

	@field:SerializedName("strHomeLineupForward")
	val strHomeLineupForward: String? = null,

	@field:SerializedName("strTVStation")
	val strTVStation: Any? = null,

	@field:SerializedName("strHomeGoalDetails")
	val strHomeGoalDetails: String? = null,

	@field:SerializedName("strAwayLineupGoalkeeper")
	val strAwayLineupGoalkeeper: String? = null,

	@field:SerializedName("strAwayLineupMidfield")
	val strAwayLineupMidfield: String? = null,

	@field:SerializedName("idEvent")
	val idEvent: String,

	@field:SerializedName("intRound")
	val intRound: String,

	@field:SerializedName("strHomeYellowCards")
	val strHomeYellowCards: String? = null,

	@field:SerializedName("idHomeTeam")
	val idHomeTeam: String,

	@field:SerializedName("intHomeScore")
	val intHomeScore : String,

	@field:SerializedName("dateEvent")
	val dateEvent: String,

	@field:SerializedName("strCountry")
	val strCountry: Any? = null,

	@field:SerializedName("strAwayTeam")
	val strAwayTeam: String? = null,

	@field:SerializedName("strHomeLineupMidfield")
	val strHomeLineupMidfield: String? = null,

	@field:SerializedName("strDate")
	val strDate: String? = null,

	@field:SerializedName("strHomeFormation")
	val strHomeFormation: String? = null,

	@field:SerializedName("strMap")
	val strMap: Any? = null,

	@field:SerializedName("idAwayTeam")
	val idAwayTeam: String,

	@field:SerializedName("strAwayRedCards")
	val strAwayRedCards: String? = null,

	@field:SerializedName("strBanner")
	val strBanner: Any? = null,

	@field:SerializedName("strFanart")
	val strFanart: Any? = null,

	@field:SerializedName("strDescriptionEN")
	val strDescriptionEN: Any? = null,

	@field:SerializedName("strResult")
	val strResult: Any? = null,

	@field:SerializedName("strCircuit")
	val strCircuit: Any? = null,

	@field:SerializedName("intAwayShots")
	val intAwayShots: String? = null,

	@field:SerializedName("strFilename")
	val strFilename: String? = null,

	@field:SerializedName("strTime")
	val strTime: String? = null,

	@field:SerializedName("strAwayGoalDetails")
	val strAwayGoalDetails: String? = null,

	@field:SerializedName("strAwayLineupForward")
	val strAwayLineupForward: String? = null,

	@field:SerializedName("strLocked")
	val strLocked: String? = null,

	@field:SerializedName("strSeason")
	val strSeason: String,

	@field:SerializedName("intSpectators")
	val intSpectators: Any? = null,

	@field:SerializedName("strHomeRedCards")
	val strHomeRedCards: String? = null,

	@field:SerializedName("strHomeLineupGoalkeeper")
	val strHomeLineupGoalkeeper: String? = null,

	@field:SerializedName("strHomeLineupSubstitutes")
	val strHomeLineupSubstitutes: String? = null,

	@field:SerializedName("strAwayFormation")
	val strAwayFormation: String? = null,

	@field:SerializedName("strEvent")
	val strEvent: String? = null,

	@field:SerializedName("strAwayYellowCards")
	val strAwayYellowCards: String? = null,

	@field:SerializedName("strAwayLineupDefense")
	val strAwayLineupDefense: String? = null,

	@field:SerializedName("strHomeTeam")
	val strHomeTeam: String? = null,

	@field:SerializedName("strThumb")
	val strThumb: Any? = null,

	@field:SerializedName("strLeague")
	val strLeague: String? = null,

	@field:SerializedName("intAwayScore")
	val intAwayScore: String,

	@field:SerializedName("strCity")
	val strCity: Any? = null,

	@field:SerializedName("strPoster")
	val strPoster: Any? = null
) : Serializable {}