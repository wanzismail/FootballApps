package com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview

import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.interactor.TeamOverviewInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.interactor.TeamOverviewMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.presenter.TeamOverviewMVPPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.presenter.TeamOverviewPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.view.TeamOverviewFragment
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.view.TeamOverviewMVPView
import dagger.Module
import dagger.Provides


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
class OverviewFragmentModule {

    @Provides
    internal fun provideTeamOverviewInteractor(interactor: TeamOverviewInteractor): TeamOverviewMVPInteractor = interactor

    @Provides
    internal fun provideTeamOverviewPresenter(presenter: TeamOverviewPresenter<TeamOverviewMVPView, TeamOverviewMVPInteractor>)
            : TeamOverviewMVPPresenter<TeamOverviewMVPView, TeamOverviewMVPInteractor> = presenter

    @Provides
    internal fun provideTeamOverviewLayoutManager(fragment: TeamOverviewFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}