package com.wanztudio.gdk.matchschedule.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class AppApiHelper @Inject internal constructor() : ApiHelper {

    override fun getPrevSchedule(idLeague: Int): Observable<ScheduleResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_PREV_EVENT)
                    .addQueryParameter("id", idLeague.toString())
                    .build()
                    .getObjectObservable(ScheduleResponse::class.java)

    override fun getNextSchedule(idLeague: Int): Observable<ScheduleResponse> =
            Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_NEXT_EVENT)
                    .addQueryParameter("id", idLeague.toString())
                    .build()
                    .getObjectObservable(ScheduleResponse::class.java)

}