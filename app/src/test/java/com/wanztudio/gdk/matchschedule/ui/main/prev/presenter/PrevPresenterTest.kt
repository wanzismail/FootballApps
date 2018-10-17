package com.wanztudio.gdk.matchschedule.ui.main.prev.presenter

import com.wanztudio.gdk.matchschedule.data.network.*
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.PrevInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.PrevMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.view.PrevMVPView
import com.wanztudio.gdk.matchschedule.util.Constants
import com.wanztudio.gdk.matchschedule.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.junit.runners.model.Statement


/**
 * For LEARNING
 * Created by Ridwan Ismail on 14 October 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.prev.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class PrevPresenterTest {

    @Mock
    lateinit var view: PrevMVPView

    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var appApiHelper: AppApiHelper

    lateinit var interactor: PrevInteractor
    lateinit var prevPresenter: PrevPresenter<PrevMVPView, PrevMVPInteractor>

    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { i -> Schedulers.trampoline() }

        schedulerProvider = SchedulerProvider()
        compositeDisposable = CompositeDisposable()

        interactor = PrevInteractor(appApiHelper)
        prevPresenter = PrevPresenter(interactor, schedulerProvider, compositeDisposable)
        prevPresenter.onAttach(view)
    }

    @Test
    fun getPrevSchedule() {
        val events: MutableList<Event> = mutableListOf()
        val response = ScheduleResponse(events)

        Mockito.`when`(appApiHelper.getPrevSchedule(Constants.ID_LEAGUE))
                .thenReturn(Observable.just(response))

        prevPresenter.getPrevSchedule(Constants.ID_LEAGUE)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEvents(events)
        Mockito.verify(view).hideLoading()

    }

}