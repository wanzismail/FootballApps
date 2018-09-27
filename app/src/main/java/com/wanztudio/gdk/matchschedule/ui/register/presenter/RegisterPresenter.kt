package com.wanztudio.gdk.matchschedule.ui.register.presenter

import com.wanztudio.framework.mvp.ui.register.view.RegisterMVPView
import com.wanztudio.gdk.matchschedule.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.matchschedule.ui.register.interactor.RegisterMVPInteractor
import com.wanztudio.gdk.matchschedule.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

class RegisterPresenter<V : RegisterMVPView, I : RegisterMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), RegisterMVPPresenter<V, I> {

}