package com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.interactor.NextMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.view.NextMatchMVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface NextMatchMVPPresenter<V : NextMatchMVPView, I : NextMatchMVPInteractor> : MVPPresenter<V, I> {

    fun getNextMatch(idLeague : String)
}