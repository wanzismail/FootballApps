package com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.interactor.LastMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.view.LastMatchMVPView
import com.wanztudio.gdk.footballapps.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class LastMatchPresenter<V : LastMatchMVPView, I : LastMatchMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor,
        schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), LastMatchMVPPresenter<V, I> {

    override fun getLastMatch(idLeague: String) {
        interactor?.let {
            getView()?.showLoading()
            compositeDisposable.add(it.getLastMatchApiCall(idLeague)
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