package com.wanztudio.gdk.footballapps.ui.detail.detailteamPlayer.player.presenter

import com.wanztudio.gdk.footballapps.data.network.AppApiHelper
import com.wanztudio.gdk.footballapps.data.network.Player
import com.wanztudio.gdk.footballapps.data.network.PlayerResponse
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.interactor.TeamPlayerInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.interactor.TeamPlayerMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.presenter.TeamPlayerPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view.TeamPlayerMVPView
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
 * com.wanztudio.gdk.footballapps.ui.detail.detailteamPlayer.player.presenter
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class TeamPlayerPresenterTest {

    @Mock
    lateinit var view: TeamPlayerMVPView

    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var appApiHelper: AppApiHelper

    lateinit var interactor: TeamPlayerInteractor
    lateinit var teamPlayerPresenter: TeamPlayerPresenter<TeamPlayerMVPView, TeamPlayerMVPInteractor>

    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { i -> Schedulers.trampoline() }

        schedulerProvider = SchedulerProvider()
        compositeDisposable = CompositeDisposable()

        interactor = TeamPlayerInteractor(appApiHelper)
        teamPlayerPresenter = TeamPlayerPresenter(interactor, schedulerProvider, compositeDisposable)
        teamPlayerPresenter.onAttach(view)
    }

    @Test
    fun getTeamPlayer() {
        val teamPlayers: MutableList<Player> = mutableListOf()
        val response = PlayerResponse(teamPlayers)

        Mockito.`when`(appApiHelper.getTeamPlayer(Constants.ID_PLAYER))
                .thenReturn(Observable.just(response))

        teamPlayerPresenter.getTeamPlayer(Constants.ID_PLAYER)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showPlayers(teamPlayers)
        Mockito.verify(view).hideLoading()
    }
}