package com.wanztudio.gdk.footballapps.ui.base.presenter

import com.wanztudio.gdk.footballapps.ui.base.interactor.MVPInteractor
import com.wanztudio.gdk.footballapps.ui.base.view.MVPView
import com.wanztudio.gdk.footballapps.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.base.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

abstract class BasePresenter<V : MVPView, I : MVPInteractor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) : MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}