package com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.interactor.NextMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.view.NextMatchMVPView
import com.wanztudio.gdk.footballapps.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */


class NextMatchPresenter<V : NextMatchMVPView, I : NextMatchMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), NextMatchMVPPresenter<V, I> {

    override fun getNextMatch(idLeague: String) {
        getView()?.showLoading()
        interactor?.let {
            compositeDisposable.add(it.getNextMatchApiCall(idLeague)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ response ->
                        getView()?.showEvents(response.events)
                        getView()?.hideLoading()
                    }, { err ->
                        println("Request failed.")
                        getView()?.hideLoading()
                    }))
        }
    }

}