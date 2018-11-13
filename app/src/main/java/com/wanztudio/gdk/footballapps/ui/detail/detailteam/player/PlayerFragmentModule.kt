package com.wanztudio.gdk.footballapps.ui.detail.detailteam.player

import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.footballapps.ui.detail.detailplayers.player.view.TeamPlayerFragment
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.interactor.TeamPlayerInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.interactor.TeamPlayerMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.presenter.TeamPlayerMVPPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.presenter.TeamPlayerPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view.TeamPlayerMVPView
import dagger.Module
import dagger.Provides


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.player
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
class PlayerFragmentModule {

    @Provides
    internal fun provideTeamPlayerInteractor(interactor: TeamPlayerInteractor): TeamPlayerMVPInteractor = interactor

    @Provides
    internal fun provideTeamPlayerPresenter(presenter: TeamPlayerPresenter<TeamPlayerMVPView, TeamPlayerMVPInteractor>)
            : TeamPlayerMVPPresenter<TeamPlayerMVPView, TeamPlayerMVPInteractor> = presenter

    @Provides
    internal fun provideTeamPlayerLayoutManager(fragment: TeamPlayerFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}