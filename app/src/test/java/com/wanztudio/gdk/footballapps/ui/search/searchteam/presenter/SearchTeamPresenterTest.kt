package com.wanztudio.gdk.footballapps.ui.search.searchteam.presenter

import com.wanztudio.gdk.footballapps.data.network.AppApiHelper
import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.data.network.TeamResponse
import com.wanztudio.gdk.footballapps.ui.search.searchteam.interactor.SearchTeamInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchteam.interactor.SearchTeamMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchteam.view.SearchTeamMVPView
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
 * com.wanztudio.gdk.footballapps.ui.search.searchteam.presenter
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class SearchTeamPresenterTest {

    @Mock
    lateinit var view: SearchTeamMVPView

    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var appApiHelper: AppApiHelper

    lateinit var interactor: SearchTeamInteractor
    lateinit var teamPresenter: SearchTeamPresenter<SearchTeamMVPView, SearchTeamMVPInteractor>

    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { i -> Schedulers.trampoline() }

        schedulerProvider = SchedulerProvider()
        compositeDisposable = CompositeDisposable()

        interactor = SearchTeamInteractor(appApiHelper)
        teamPresenter = SearchTeamPresenter(interactor, schedulerProvider, compositeDisposable)
        teamPresenter.onAttach(view)
    }

    @Test
    fun getSearchTeam() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)

        Mockito.`when`(appApiHelper.searchTeam(Constants.KEYWORD))
                .thenReturn(Observable.just(response))

        teamPresenter.searchTeam(Constants.KEYWORD)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showTeams(teams)
        Mockito.verify(view).hideLoading()
    }
}