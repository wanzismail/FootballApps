package com.wanztudio.gdk.footballapps.ui.main.teams

import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.footballapps.ui.main.teams.interactor.TeamInteractor
import com.wanztudio.gdk.footballapps.ui.main.teams.interactor.TeamMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.teams.presenter.TeamMVPPresenter
import com.wanztudio.gdk.footballapps.ui.main.teams.presenter.TeamPresenter
import com.wanztudio.gdk.footballapps.ui.main.teams.view.TeamFragment
import com.wanztudio.gdk.footballapps.ui.main.teams.view.TeamMVPView
import dagger.Module
import dagger.Provides

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.teams
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
class TeamFragmentModule {

    @Provides
    internal fun provideTeamInteractor(interactor: TeamInteractor): TeamMVPInteractor = interactor

    @Provides
    internal fun provideTeamPresenter(presenter: TeamPresenter<TeamMVPView, TeamMVPInteractor>)
            : TeamMVPPresenter<TeamMVPView, TeamMVPInteractor> = presenter

    @Provides
    internal fun provideTeamLinearLayoutManager(fragment: TeamFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}