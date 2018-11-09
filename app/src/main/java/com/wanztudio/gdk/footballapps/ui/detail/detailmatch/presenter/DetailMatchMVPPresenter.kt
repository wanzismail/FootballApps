package com.wanztudio.gdk.footballapps.ui.detail.detailmatch.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.DetailMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view.DetailMatchMVPView


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailmatch.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

interface DetailMatchMVPPresenter<V : DetailMatchMVPView, I : DetailMatchMVPInteractor> : MVPPresenter<V, I> {

    fun getTeamHomeDetailApiCall(idTeam : String)
    fun getTeamAwayDetailApiCall(idTeam : String)
    fun getDetailEventApiCall(idEvent : String)
}