package com.wanztudio.gdk.footballapps.ui.main.teams.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.footballapps.ui.main.teams.interactor.TeamMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.teams.view.TeamMVPView


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.teams.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface TeamMVPPresenter<V : TeamMVPView, I : TeamMVPInteractor> : MVPPresenter<V, I> {

    fun getTeam(idLeague : String)
}