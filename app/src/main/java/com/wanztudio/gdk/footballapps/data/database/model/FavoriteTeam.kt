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

data class FavoriteTeam(val id: Long?,
                         val idTeam: String?,
                         val teamName: String?,
                         val teamLogoUrl: String?,
                         val teamStadium: String?,
                         val teamYear: String?,
                         val teamDesc: String?) {

    companion object {
        const val TABLE_FAVORITE_TEAMS: String = "TABLE_FAVORITE_TEAMS"
        const val ID_FAVORITE_TEAM: String = "ID_FAVORITE_TEAM"
        const val ID_TEAM: String = "ID_TEAM"
        const val TEAM_NAME : String = "TEAM_NAME"
        const val TEAM_LOGO_URL : String = "TEAM_LOGO_URL"
        const val TEAM_STADIUM : String = "TEAM_STADIUM"
        const val TEAM_YEAR : String = "TEAM_YEAR"
        const val TEAM_DESCRIPTION : String = "TEAM_DESCRIPTION"

    }
}