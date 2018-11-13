package com.wanztudio.gdk.footballapps.ui.search.searchmatch.presenter

import com.wanztudio.gdk.footballapps.data.network.*
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.interactor.SearchMatchInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.interactor.SearchMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.view.SearchMatchMVPView
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
 * com.wanztudio.gdk.footballapps.ui.search.searchmatch.presenter
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class SearchMatchPresenterTest {

    @Mock
    lateinit var view: SearchMatchMVPView

    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    lateinit var appApiHelper: AppApiHelper

    lateinit var interactor: SearchMatchInteractor
    lateinit var matchPresenter: SearchMatchPresenter<SearchMatchMVPView, SearchMatchMVPInteractor>

    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { i -> Schedulers.trampoline() }

        schedulerProvider = SchedulerProvider()
        compositeDisposable = CompositeDisposable()

        interactor = SearchMatchInteractor(appApiHelper)
        matchPresenter = SearchMatchPresenter(interactor, schedulerProvider, compositeDisposable)
        matchPresenter.onAttach(view)
    }

    @Test
    fun getSearchMatch() {
        val matchs: MutableList<Event> = mutableListOf()
        matchs.add(Event())
        val response = SearchMatchResponse(matchs)

        Mockito.`when`(appApiHelper.searchMatch(Constants.KEYWORD))
                .thenReturn(Observable.just(response))

        matchPresenter.searchMatch(Constants.KEYWORD)

        Mockito.verify(view).showLoading()
        Mockito.verify(view).showEvents(matchs)
        Mockito.verify(view).hideLoading()
    }
}