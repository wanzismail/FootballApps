package com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.interactor.TeamPlayerMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view.TeamPlayerMVPView


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface TeamPlayerMVPPresenter<V : TeamPlayerMVPView, I : TeamPlayerMVPInteractor> : MVPPresenter<V, I> {

    fun getTeamPlayer(idClub : String)
}