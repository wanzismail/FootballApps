package com.wanztudio.gdk.footballapps.ui.search.searchteam.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.footballapps.ui.search.searchteam.interactor.SearchTeamMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchteam.view.SearchTeamMVPView
import com.wanztudio.gdk.footballapps.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.searchteam.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class SearchTeamPresenter<V : SearchTeamMVPView, I : SearchTeamMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), SearchTeamMVPPresenter<V, I> {

    override fun searchTeam(keyWord: String) {
        interactor?.let {
            getView()?.showLoading()
            compositeDisposable.add(it.searchTeamApiCall(keyWord)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ response ->
                        getView()?.showTeams(response.teams)
                        getView()?.hideLoading()
                    }, { err ->
                        println("Request failed.")
                        getView()?.hideLoading()
                    }))
        }
    }

}