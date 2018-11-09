package com.wanztudio.gdk.footballapps.ui.search.searchmatch.presenter

import com.wanztudio.gdk.footballapps.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.interactor.SearchMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.view.SearchMatchMVPView
import com.wanztudio.gdk.footballapps.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.matches.searchmatch.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */


class SearchMatchPresenter<V : SearchMatchMVPView, I : SearchMatchMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), SearchMatchMVPPresenter<V, I> {

    override fun searchMatch(keyWord: String) {
        getView()?.showLoading()
        interactor?.let {
            compositeDisposable.add(it.searchMatchApiCall(keyWord)
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