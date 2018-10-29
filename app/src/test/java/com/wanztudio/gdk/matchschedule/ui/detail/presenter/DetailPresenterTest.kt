package com.wanztudio.gdk.matchschedule.ui.detail.presenter

import com.wanztudio.framework.mvp.ui.login.view.DetailMVPView
import com.wanztudio.gdk.matchschedule.data.network.*
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.DetailPresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.NextPresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.view.NextMVPView
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
 * com.wanztudio.gdk.matchschedule.ui.detail.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */
class DetailPresenterTest {
   
    @Mock
    lateinit var view: DetailMVPView

    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var appApiHelper: AppApiHelper

    lateinit var interactor: DetailInteractor
    lateinit var detailPresenter: DetailPresenter<DetailMVPView, DetailMVPInteractor>

    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { i -> Schedulers.trampoline() }

        schedulerProvider = SchedulerProvider()
        compositeDisposable = CompositeDisposable()

        interactor = DetailInteractor(appApiHelper)
        detailPresenter = DetailPresenter(interactor, schedulerProvider, compositeDisposable)
        detailPresenter.onAttach(view)
    }

    @Test
    fun getDetailEventApiCall() {
        var events: MutableList<Event> = mutableListOf()
        events.add(Event())
        val response = ScheduleResponse(events)

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