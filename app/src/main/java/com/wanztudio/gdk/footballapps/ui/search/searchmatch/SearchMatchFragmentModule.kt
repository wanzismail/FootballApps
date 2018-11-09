package com.wanztudio.gdk.footballapps.ui.search.searchmatch

import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.interactor.SearchMatchInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.interactor.SearchMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.presenter.SearchMatchMVPPresenter
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.presenter.SearchMatchPresenter
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.view.SearchMatchFragment
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.view.SearchMatchMVPView
import dagger.Module
import dagger.Provides

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.matches.searchmatch
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
class SearchMatchFragmentModule {

    @Provides
    internal fun provideSearchMatchInteractor(interactor: SearchMatchInteractor): SearchMatchMVPInteractor = interactor

    @Provides
    internal fun provideSearchMatchPresenter(presenter: SearchMatchPresenter<SearchMatchMVPView, SearchMatchMVPInteractor>)
            : SearchMatchMVPPresenter<SearchMatchMVPView, SearchMatchMVPInteractor> = presenter

    @Provides
    internal fun provideSearchMatchLinearLayoutManager(fragment: SearchMatchFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)
}