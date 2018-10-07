package com.wanztudio.gdk.matchschedule.ui.main.prev.interactor

import com.wanztudio.gdk.matchschedule.data.network.ApiHelper
import com.wanztudio.gdk.matchschedule.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.prev.interactor
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class PrevInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), PrevMVPInteractor {

    override fun getPrevScheduleApiCall(idLeague : Int) =
            apiHelper.getPrevSchedule(idLeague)

}