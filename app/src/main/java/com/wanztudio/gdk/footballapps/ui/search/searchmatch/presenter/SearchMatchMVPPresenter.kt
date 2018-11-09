package com.wanztudio.gdk.footballapps.ui.search.searchmatch.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.interactor.SearchMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.view.SearchMatchMVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.matches.searchmatch.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface SearchMatchMVPPresenter<V : SearchMatchMVPView, I : SearchMatchMVPInteractor> : MVPPresenter<V, I> {

    fun searchMatch(keyWord : String)
}