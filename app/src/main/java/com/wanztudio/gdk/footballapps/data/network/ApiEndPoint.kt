package com.wanztudio.gdk.footballapps.data.network

import com.wanztudio.gdk.footballapps.BuildConfig

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

object ApiEndPoint {

    val ENDPOINT_PREV_EVENT = BuildConfig.BASE_URL + "/eventspastleague.php"
    val ENDPOINT_NEXT_EVENT = BuildConfig.BASE_URL + "/eventsnextleague.php"
    val ENDPOINT_DETAIL_EVENT = BuildConfig.BASE_URL + "/lookupevent.php"

    val ENDPOINT_TEAM = BuildConfig.BASE_URL + "/lookup_all_teams.php"
    val ENDPOINT_TEAM_DETAIL = BuildConfig.BASE_URL + "/lookupteam.php"
    val ENDPOINT_TEAM_PLAYER = BuildConfig.BASE_URL + "/lookup_all_players.php"

    val ENDPOINT_SEARCH_TEAM = BuildConfig.BASE_URL + "/searchteams.php"
    val ENDPOINT_SEARCH_MATCH = BuildConfig.BASE_URL + "/searchevents.php"

}