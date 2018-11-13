package com.wanztudio.gdk.footballapps.ui.search.searchteam

import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.footballapps.ui.search.searchteam.interactor.SearchTeamInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchteam.interactor.SearchTeamMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchteam.presenter.SearchTeamMVPPresenter
import com.wanztudio.gdk.footballapps.ui.search.searchteam.presenter.SearchTeamPresenter
import com.wanztudio.gdk.footballapps.ui.search.searchteam.view.SearchTeamFragment
import com.wanztudio.gdk.footballapps.ui.search.searchteam.view.SearchTeamMVPView
import dagger.Module
import dagger.Provides

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.searchteam
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
class SearchTeamFragmentModule {

    @Provides
    internal fun provideSearchTeamInteractor(interactor: SearchTeamInteractor): SearchTeamMVPInteractor = interactor

    @Provides
    internal fun provideSearchTeamPresenter(presenter: SearchTeamPresenter<SearchTeamMVPView, SearchTeamMVPInteractor>)
            : SearchTeamMVPPresenter<SearchTeamMVPView, SearchTeamMVPInteractor> = presenter

    @Provides
    internal fun provideSearchTeamLinearLayoutManager(fragment: SearchTeamFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}