package com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.interactor.TeamPlayerMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view.TeamPlayerMVPView
import com.wanztudio.gdk.footballapps.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class TeamPlayerPresenter<V : TeamPlayerMVPView, I : TeamPlayerMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), TeamPlayerMVPPresenter<V, I> {

    override fun getTeamPlayer(idClub : String) {
        interactor?.let {
            getView()?.showLoading()
            compositeDisposable.add(it.getTeamPlayerApiCall(idClub)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ response ->
                        getView()?.showPlayers(response.players)
                        getView()?.hideLoading()
                    }, { err ->
                        println("Request failed.")
                        getView()?.hideLoading()
                    }))
        }
    }

}