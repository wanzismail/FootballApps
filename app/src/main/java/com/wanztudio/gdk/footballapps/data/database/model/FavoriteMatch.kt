package com.wanztudio.gdk.footballapps.data.database.model

/**
 * For LEARNING
 * Created by Ridwan Ismail on 04 November 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.data.database.model
 * or see link for more detail https://gitlab.com/iwanz98/FootballApps
 */


data class FavoriteMatch(val id: Long?,
                         val idEvent: String?,
                         val homeTeam: String?,
                         val awayTeam: String?,
                         val homeScore: String?,
                         val awayScore: String?,
                         val eventDate: String ?,
                         val eventTime: String ?,
                         val description: String ?) {

    companion object {
        const val TABLE_FAVORITE_EVENTS: String = "TABLE_FAVORITE_MATCHS"
        const val ID_FAVORITE_MATCH: String = "ID_FAVORITE"
        const val ID_EVENT: String = "ID_EVENT"
        const val HOME_TEAM: String = "HOME_TEAM"
        const val AWAY_TEAM: String = "AWAY_TEAM"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val AWAY_SCORE: String = "AWAY_SCORE"
        const val EVENT_DATE: String = "EVENT_DATE"
        const val EVENT_TIME: String = "EVENT_TIME"
        const val EVENT_DESC: String = "EVENT_DESC"
    }
}