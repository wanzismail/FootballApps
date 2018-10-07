package com.wanztudio.gdk.matchschedule.ui.main.next.interactor

import com.wanztudio.gdk.matchschedule.data.network.ApiHelper
import com.wanztudio.gdk.matchschedule.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.next.interactor
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class NextInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), NextMVPInteractor {

    override fun getNextScheduleApiCall(idLeague : Int) =
            apiHelper.getNextSchedule(idLeague)

}