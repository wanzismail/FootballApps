package com.wanztudio.gdk.footballapps.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class AppApiHelper @Inject internal constructor() : ApiHelper {
    override fun getLastMatch(idLeague: String): Observable<MatchResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_PREV_EVENT)
                    .addQueryParameter("id", idLeague)
                    .build()
                    .getObjectObservable(MatchResponse::class.java)

    override fun getNextMatch(idLeague: String): Observable<MatchResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_NEXT_EVENT)
                    .addQueryParameter("id", idLeague)
                    .build()
                    .getObjectObservable(MatchResponse::class.java)

    override fun getDetailEvent(idEvent: String): Observable<MatchResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_DETAIL_EVENT)
                    .addQueryParameter("id", idEvent)
                    .build()
                    .getObjectObservable(MatchResponse::class.java)


    override fun getTeam(idLeague: String): Observable<TeamResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TEAM)
                    .addQueryParameter("id", idLeague)
                    .build()
                    .getObjectObservable(TeamResponse::class.java)

    override fun getTeamDetail(idTeam: String): Observable<TeamResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TEAM_DETAIL)
                    .addQueryParameter("id", idTeam)
                    .build()
                    .getObjectObservable(TeamResponse::class.java)


    override fun getTeamPlayer(idTeam: String): Observable<PlayerResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_TEAM_PLAYER)
                    .addQueryParameter("id", idTeam)
                    .build()
                    .getObjectObservable(PlayerResponse::class.java)


    override fun searchMatch(keyword: String): Observable<SearchMatchResponse> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SEARCH_MATCH)
                .addQueryParameter("e", keyword)
                .build()
                .getObjectObservable(SearchMatchResponse::class.java)

    override fun searchTeam(keyword: String): Observable<TeamResponse> =
        Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_SEARCH_TEAM)
                .addQueryParameter("t", keyword)
                .build()
                .getObjectObservable(TeamResponse::class.java)

}
