package com.wanztudio.gdk.matchschedule.ui.main.next.presenter

import com.wanztudio.gdk.matchschedule.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.view.NextMVPView
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


class NextPresenter<V : NextMVPView, I : NextMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), NextMVPPresenter<V, I> {

    override fun getNextSchedule(idLeague: Int) {
        getView()?.showLoading()
        interactor?.let {
            compositeDisposable.add(it.getNextScheduleApiCall(idLeague)
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