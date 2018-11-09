package com.wanztudio.gdk.footballapps.ui.search.searchteam.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.footballapps.ui.search.searchteam.interactor.SearchTeamMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchteam.view.SearchTeamMVPView


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.searchteam.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface SearchTeamMVPPresenter<V : SearchTeamMVPView, I : SearchTeamMVPInteractor> : MVPPresenter<V, I> {

    fun searchTeam(keyWord : String)
}