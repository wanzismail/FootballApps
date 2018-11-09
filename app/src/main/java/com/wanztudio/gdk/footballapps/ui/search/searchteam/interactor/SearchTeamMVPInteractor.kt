package com.wanztudio.gdk.footballapps.ui.search.searchteam.interactor

import com.wanztudio.gdk.footballapps.data.network.TeamResponse
import com.wanztudio.gdk.footballapps.ui.base.interactor.MVPInteractor
import io.reactivex.Observable


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.searchteam.interactor
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface SearchTeamMVPInteractor : MVPInteractor {

    fun searchTeamApiCall(keyWord : String) : Observable<TeamResponse>
}