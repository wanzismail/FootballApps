package com.wanztudio.gdk.matchschedule.ui.main.next.presenter

import com.wanztudio.framework.mvp.ui.login.view.DetailMVPView
import com.wanztudio.gdk.matchschedule.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailMVPInteractor
import com.wanztudio.gdk.matchschedule.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.next.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */


class DetailPresenter<V : DetailMVPView, I : DetailMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), DetailMVPPresenter<V, I> {

    override fun getTeamHomeDetailApiCall(idTeam: String) {
        getView()?.showLoading()
        interactor?.let {
            compositeDisposable.add(it.getDetailTeamApiCall(idTeam)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ response ->
                        response.teams?.let { info ->
                            getView()?.showHomeTeam(info.get(0)!!)
                            getView()?.hideLoading()
                        }
                    }, { err ->
                        println("Request failed.")
                        getView()?.hideLoading()
                    }))
        }
    }

    override fun getTeamAwayDetailApiCall(idTeam: String) {
        getView()?.showLoading()
        interactor?.let {
            compositeDisposable.add(it.getDetailTeamApiCall(idTeam)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ response ->
                        response.teams?.let { info ->
                            getView()?.showAwayTeam(info.get(0)!!)
                            getView()?.hideLoading()
                        }
                    }, { err ->
                        println("Request failed.")
                        getView()?.hideLoading()
                    }))
        }
    }

    override fun getDetailEventApiCall(idEvent: String) {
        getView()?.showLoading()
        interactor?.let {
            compositeDisposable.add(it.getDetailEventApiCall(idEvent)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ response ->
                        getView()?.showEvent(response.events.get(0))
                        getView()?.hideLoading()
                    }, { err ->
                        println("Request failed.")
                        getView()?.hideLoading()
                    }))
        }
    }

}