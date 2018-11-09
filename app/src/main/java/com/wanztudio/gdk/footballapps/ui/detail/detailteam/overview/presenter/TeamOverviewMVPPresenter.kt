package com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.interactor.TeamOverviewMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.view.TeamOverviewMVPView


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface TeamOverviewMVPPresenter<V : TeamOverviewMVPView, I : TeamOverviewMVPInteractor> : MVPPresenter<V, I> {

}