package com.wanztudio.gdk.footballapps.ui.main.teams.presenter

import com.wanztudio.gdk.footballapps.data.network.*
import com.wanztudio.gdk.footballapps.ui.main.teams.interactor.TeamInteractor
import com.wanztudio.gdk.footballapps.ui.main.teams.interactor.TeamMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.teams.view.TeamMVPView
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
 * com.wanztudio.gdk.footballapps.ui.main.teams.presenter
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class TeamPresenterTest {

    @Mock
    lateinit var view: TeamMVPView

    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var appApiHelper: AppApiHelper

    lateinit var interactor: TeamInteractor
    lateinit var teamPresenter: TeamPresenter<TeamMVPView, TeamMVPInteractor>

    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { i -> Schedulers.trampoline() }

        schedulerProvider = SchedulerProvider()
        compositeDisposable = CompositeDisposable()

        interactor = TeamInteractor(appApiHelper)
        teamPresenter = TeamPresenter(interactor, schedulerProvider, compositeDisposable)
        teamPresenter.onAttach(view)
    }

    @Test
    fun getTeam() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)

        Mockito.`when`(appApiHelper.getTeam(Constants.ID_LEAGUE))
                .thenReturn(Observable.just(response))

        teamPresenter.getTeam(Constants.ID_LEAGUE)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showTeams(teams)
        Mockito.verify(view).hideLoading()
    }
}