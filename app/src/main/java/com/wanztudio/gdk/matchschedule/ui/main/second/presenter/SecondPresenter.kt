package com.wanztudio.gdk.matchschedule.ui.main.second.presenter

import com.wanztudio.gdk.matchschedule.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.matchschedule.ui.main.second.interactor.SecondMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.second.view.SecondMVPView
import com.wanztudio.gdk.matchschedule.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

class SecondPresenter<V : SecondMVPView, I : SecondMVPInteractor> @Inject constructor(interactor: I, schedulerProvider: SchedulerProvider, compositeDisposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = compositeDisposable), SecondMVPPresenter<V, I> {

    override fun onViewPrepared() {

    }
}