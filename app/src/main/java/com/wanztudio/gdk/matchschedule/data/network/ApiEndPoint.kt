package com.wanztudio.gdk.matchschedule.data.network

import com.wanztudio.gdk.matchschedule.BuildConfig

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

object ApiEndPoint {

    val ENDPOINT_PREV_EVENT = BuildConfig.BASE_URL + "/eventspastleague.php"
    val ENDPOINT_NEXT_EVENT = BuildConfig.BASE_URL + "/eventsnextleague.php"
    val ENDPOINT_DETAIL_EVENT = BuildConfig.BASE_URL + "/lookupevent.php"
    val ENDPOINT_TEAM_DETAIL = BuildConfig.BASE_URL + "/lookupteam.php"

}