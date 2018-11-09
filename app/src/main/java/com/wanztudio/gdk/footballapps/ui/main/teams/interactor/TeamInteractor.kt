package com.wanztudio.gdk.footballapps.ui.main.teams.interactor

import com.wanztudio.gdk.footballapps.data.network.ApiHelper
import com.wanztudio.gdk.footballapps.ui.base.interactor.BaseInteractor
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.teams.interactor
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class TeamInteractor @Inject internal constructor(apiHelper: ApiHelper) : BaseInteractor(apiHelper), TeamMVPInteractor {

    override fun getTeamApiCall(idLeague : String) =
            apiHelper.getTeam(idLeague)

}