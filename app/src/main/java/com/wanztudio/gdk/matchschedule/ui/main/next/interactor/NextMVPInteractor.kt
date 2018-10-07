package com.wanztudio.gdk.matchschedule.ui.main.next.interactor

import com.wanztudio.gdk.matchschedule.data.network.ScheduleResponse
import com.wanztudio.gdk.matchschedule.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.next.interactor
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

interface NextMVPInteractor : MVPInteractor {

    fun getNextScheduleApiCall(idLeague : Int) : Observable<ScheduleResponse>
}