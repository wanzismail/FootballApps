package com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.presenter

import com.wanztudio.gdk.footballapps.data.network.AppApiHelper
import com.wanztudio.gdk.footballapps.data.network.Event
import com.wanztudio.gdk.footballapps.data.network.MatchResponse
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.interactor.LastMatchInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.interactor.LastMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.view.LastMatchMVPView
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.SchedulerProvider
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * For Bridge Technology Services
 * Created by Ridwan Ismail on 04 November 2018
 * You can contact me at : ridwan.ismail@bridgetech.co.id
 * -------------------------------------------------
 * AHA
 * com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.presenter
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class LastMatchPresenterTest {

    @Mock
    lateinit var view: LastMatchMVPView

    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var appApiHelper: AppApiHelper

    lateinit var interactor: LastMatchInteractor
    lateinit var lastPresenter: LastMatchPresenter<LastMatchMVPView, LastMatchMVPInteractor>

    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { i -> Schedulers.trampoline() }

        schedulerProvider = SchedulerProvider()
        compositeDisposable = CompositeDisposable()

        interactor = LastMatchInteractor(appApiHelper)
        lastPresenter = LastMatchPresenter(interactor, schedulerProvider, compositeDisposable)
        lastPresenter.onAttach(view)
    }

    @Test
    fun getLastMatch() {
        val events: MutableList<Event> = mutableListOf()
        val response = MatchResponse(events)

        Mockito.`when`(appApiHelper.getLastMatch(Constants.ID_LEAGUE))
                .thenReturn(Observable.just(response))

        lastPresenter.getLastMatch(Constants.ID_LEAGUE)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEvents(events)
        Mockito.verify(view).hideLoading()
    }
}