package com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.interactor.TeamOverviewMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.view.TeamOverviewMVPView
import com.wanztudio.gdk.footballapps.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class TeamOverviewPresenter<V : TeamOverviewMVPView, I : TeamOverviewMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), TeamOverviewMVPPresenter<V, I> {

}