package com.wanztudio.gdk.matchschedule.data.database

import com.wanztudio.gdk.matchschedule.util.DateUtils

/**
 * For LEARNING
 * Created by Ridwan Ismail on 01 October 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.util
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

data class FavoriteMatch(val id: Long?, val evenId: String?, val evenDate: String?,  val homeTeamName: String?, val homeTeamScore: Int?, val awayTeamName: String?, val awayTeamScore: Int?) {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE_MATCH"
        const val ID: String = "ID_"
        const val MATCH_ID: String = "MATCH_ID"
        const val MATCH_DATE : String = "MATCH_DATE"
        const val MATCH_HOME_TEAM: String = "MATCH_HOME_TEAM"
        const val MATCH_HOME_SCORE: String = "MATCH_HOME_SCORE"
        const val MATCH_AWAY_TEAM: String = "MATCH_AWAY_TEAM"
        const val MATCH_AWAY_SCORE: String = "MATCH_AWAY_SCORE"
    }
}