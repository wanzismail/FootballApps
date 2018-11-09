package com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.interactor.LastMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.view.LastMatchMVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface LastMatchMVPPresenter<V : LastMatchMVPView, I : LastMatchMVPInteractor> : MVPPresenter<V, I> {

    fun getLastMatch(idLeague : String)
}