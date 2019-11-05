package com.wanztudio.gdk.footballapps.ui.detail.detailmatch.interactor

import com.wanztudio.gdk.footballapps.data.network.ApiHelper
import com.wanztudio.gdk.footballapps.ui.base.interactor.BaseInteractor
import javax.inject.Inject


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailmatch.interactor
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class DetailMatchInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), DetailMatchMVPInteractor {

    override fun getDetailEventApiCall(idEvent : String) =
            apiHelper.getDetailEvent(idEvent)

    override fun getDetailTeamApiCall(idTeam: String ) =
            apiHelper.getTeamDetail(idTeam)

}