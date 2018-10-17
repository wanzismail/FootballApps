package com.wanztudio.gdk.matchschedule.ui.main.next.presenter

import com.wanztudio.framework.mvp.ui.login.view.DetailMVPView
import com.wanztudio.gdk.matchschedule.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.view.NextMVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.next.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

interface DetailMVPPresenter<V : DetailMVPView, I : DetailMVPInteractor> : MVPPresenter<V, I> {

    fun getTeamHomeDetailApiCall(idTeam : String)
    fun getTeamAwayDetailApiCall(idTeam : String)
    fun getDetailEventApiCall(idEvent : String)
}