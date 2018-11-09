package com.wanztudio.gdk.footballapps.data.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

data class Event(

	@SerializedName("intHomeShots")
	val intHomeShots: String? = null,

	@SerializedName("strSport")
	val strSport: String? = null,

	@SerializedName("strHomeLineupDefense")
	val strHomeLineupDefense: String? = null,

	@SerializedName("strAwayLineupSubstitutes")
	val strAwayLineupSubstitutes: String? = null,

	@SerializedName("idLeague")
	val idLeague: String = "",

	@SerializedName("idSoccerXML")
	val idSoccerXML: String? = null,

	@SerializedName("strHomeLineupForward")
	val strHomeLineupForward: String? = null,

	@SerializedName("strTVStation")
	val strTVStation: Any? = null,

	@SerializedName("strHomeGoalDetails")
	val strHomeGoalDetails: String? = null,

	@SerializedName("strAwayLineupGoalkeeper")
	val strAwayLineupGoalkeeper: String? = null,

	@SerializedName("strAwayLineupMidfield")
	val strAwayLineupMidfield: String? = null,

	@SerializedName("idEvent")
	val idEvent: String = "",

	@SerializedName("intRound")
	val intRound: String = "",

	@SerializedName("strHomeYellowCards")
	val strHomeYellowCards: String? = null,

	@SerializedName("idHomeTeam")
	val idHomeTeam: String = "",

	@SerializedName("intHomeScore")
	val intHomeScore : String = "",

	@SerializedName("dateEvent")
	val dateEvent: String = "",

	@SerializedName("strCountry")
	val strCountry: Any? = null,

	@SerializedName("strAwayTeam")
	val strAwayTeam: String,

	@SerializedName("strHomeLineupMidfield")
	val strHomeLineupMidfield: String? = null,

	@SerializedName("strDate")
	val strDate: String? = null,

	@SerializedName("strHomeFormation")
	val strHomeFormation: String? = null,

	@SerializedName("strMap")
	val strMap: Any? = null,

	@SerializedName("idAwayTeam")
	val idAwayTeam: String = "",

	@SerializedName("strAwayRedCards")
	val strAwayRedCards: String? = null,

	@SerializedName("strBanner")
	val strBanner: Any? = null,

	@SerializedName("strFanart")
	val strFanart: Any? = null,

	@SerializedName("strDescriptionEN")
	val strDescriptionEN:String? = null,

	@SerializedName("strResult")
	val strResult: Any? = null,

	@SerializedName("strCircuit")
	val strCircuit: Any? = null,

	@SerializedName("intAwayShots")
	val intAwayShots: String? = null,

	@SerializedName("strFilename")
	val strFilename: String? = null,

	@SerializedName("strTime")
	val strTime: String,

	@SerializedName("strAwayGoalDetails")
	val strAwayGoalDetails: String? = null,

	@SerializedName("strAwayLineupForward")
	val strAwayLineupForward: String? = null,

	@SerializedName("strLocked")
	val strLocked: String? = null,

	@SerializedName("strSeason")
	val strSeason: String = "",

	@SerializedName("intSpectators")
	val intSpectators: Any? = null,

	@SerializedName("strHomeRedCards")
	val strHomeRedCards: String? = null,

	@SerializedName("strHomeLineupGoalkeeper")
	val strHomeLineupGoalkeeper: String? = null,

	@SerializedName("strHomeLineupSubstitutes")
	val strHomeLineupSubstitutes: String? = null,

	@SerializedName("strAwayFormation")
	val strAwayFormation: String? = null,

	@SerializedName("strEvent")
	val strEvent: String? = null,

	@SerializedName("strAwayYellowCards")
	val strAwayYellowCards: String? = null,

	@SerializedName("strAwayLineupDefense")
	val strAwayLineupDefense: String? = null,

	@SerializedName("strHomeTeam")
	val strHomeTeam: String,

	@SerializedName("strThumb")
	val strThumb: Any? = null,

	@SerializedName("strLeague")
	val strLeague: String? = null,

	@SerializedName("intAwayScore")
	val intAwayScore: String = "",

	@SerializedName("strCity")
	val strCity: Any? = null,

	@SerializedName("strPoster")
	val strPoster: Any? = null
)