package com.wanztudio.gdk.matchschedule.ui.main.next.presenter

import com.wanztudio.gdk.matchschedule.data.network.AppApiHelper
import com.wanztudio.gdk.matchschedule.data.network.Event
import com.wanztudio.gdk.matchschedule.data.network.ScheduleResponse
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.view.NextMVPView
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.PrevInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.PrevMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.presenter.PrevPresenter
import com.wanztudio.gdk.matchschedule.ui.main.prev.view.PrevMVPView
import com.wanztudio.gdk.matchschedule.util.Constants
import com.wanztudio.gdk.matchschedule.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * For LEARNING
 * Created by Ridwan Ismail on 16 October 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.next.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */
class NextPresenterTest {

    @Mock
    lateinit var view: NextMVPView

    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var appApiHelper: AppApiHelper

    lateinit var interactor: NextInteractor
    lateinit var nextPresenter: NextPresenter<NextMVPView, NextMVPInteractor>

    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { i -> Schedulers.trampoline() }

        schedulerProvider = SchedulerProvider()
        compositeDisposable = CompositeDisposable()

        interactor = NextInteractor(appApiHelper)
        nextPresenter = NextPresenter(interactor, schedulerProvider, compositeDisposable)
        nextPresenter.onAttach(view)
    }

    @Test
    fun getNextSchedule() {
        val events: MutableList<Event> = mutableListOf()
        val response = ScheduleResponse(events)

        Mockito.`when`(appApiHelper.getNextSchedule(Constants.ID_LEAGUE))
                .thenReturn(Observable.just(response))

        nextPresenter.getNextSchedule(Constants.ID_LEAGUE)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEvents(events)
        Mockito.verify(view).hideLoading()

    }
}