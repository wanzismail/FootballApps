package com.wanztudio.gdk.footballapps.ui.detail.detailmatch.presenter

import com.wanztudio.gdk.footballapps.data.network.*
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.DetailMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.interactor.DetailMatchInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view.DetailMatchMVPView
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
 * com.wanztudio.gdk.footballapps.ui.detail.detailmatch.presenter
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class DetailMatchPresenterTest {

    @Mock
    lateinit var view: DetailMatchMVPView

    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var appApiHelper: AppApiHelper

    lateinit var interactor: DetailMatchInteractor
    lateinit var detailPresenter: DetailMatchPresenter<DetailMatchMVPView, DetailMatchMVPInteractor>

    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { i -> Schedulers.trampoline() }

        schedulerProvider = SchedulerProvider()
        compositeDisposable = CompositeDisposable()

        interactor = DetailMatchInteractor(appApiHelper)
        detailPresenter = DetailMatchPresenter(interactor, schedulerProvider, compositeDisposable)
        detailPresenter.onAttach(view)
    }

    @Test
    fun getDetailEventApiCall() {
        var events: MutableList<Event> = mutableListOf()
        events.add(Event())
        val response = MatchResponse(events)

        Mockito.`when`(appApiHelper.getDetailEvent(Constants.ID_EVENT))
                .thenReturn(Observable.just(response))

        detailPresenter.getDetailEventApiCall(Constants.ID_EVENT)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEvent(events.get(0))
    }

    @Test
    fun getTeamHomeDetailApiCall() {
        val teams: MutableList<Team> = mutableListOf()
        teams.add(Team())
        val response = TeamResponse(teams)

        Mockito.`when`(appApiHelper.getTeamDetail(Constants.ID_TEAM))
                .thenReturn(Observable.just(response))

        detailPresenter.getTeamHomeDetailApiCall(Constants.ID_TEAM)

        Mockito.verify(view).showHomeTeam(teams.get(0))
        Mockito.verify(view).hideLoading()
    }

}