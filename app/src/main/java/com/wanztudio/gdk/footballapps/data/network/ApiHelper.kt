package com.wanztudio.gdk.footballapps.data.network

import io.reactivex.Observable

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface ApiHelper {

    fun getLastMatch(idLeague : String): Observable<MatchResponse>
    fun getNextMatch(idLeague : String): Observable<MatchResponse>
    fun getDetailEvent(idEvent : String): Observable<MatchResponse>
    fun searchMatch(keyword : String): Observable<SearchMatchResponse>

    fun getTeam(idLeague: String): Observable<TeamResponse>
    fun getTeamDetail(idTeam : String): Observable<TeamResponse>
    fun getTeamPlayer(idTeam : String): Observable<PlayerResponse>
    fun searchTeam(keyword: String): Observable<TeamResponse>

}