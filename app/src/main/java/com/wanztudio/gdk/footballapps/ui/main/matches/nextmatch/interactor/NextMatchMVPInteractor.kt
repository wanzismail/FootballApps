package com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.interactor

import com.wanztudio.gdk.footballapps.data.network.MatchResponse
import com.wanztudio.gdk.footballapps.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.interactor
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface NextMatchMVPInteractor : MVPInteractor {

    fun getNextMatchApiCall(idLeague : String) : Observable<MatchResponse>
}