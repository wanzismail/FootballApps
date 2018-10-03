package com.wanztudio.gdk.matchschedule.data.network

import io.reactivex.Observable

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

interface ApiHelper {

    fun getPrevSchedule(idLeague : Int): Observable<ScheduleResponse>
    fun getNextSchedule(idLeague : Int): Observable<ScheduleResponse>
    fun getEventsRound(idLeague : String, round: String, season : String): Observable<ScheduleResponse>
    fun getTeamDetail(idTeam : String): Observable<TeamResponse>
}