package com.wanztudio.gdk.footballapps.ui.detail.detailteam.player

import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view.TeamPlayerFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.overview
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
internal abstract class  PlayerFragmentProvider {

    @ContributesAndroidInjector(modules = [PlayerFragmentModule::class])
    internal abstract fun provideTeamPlayerFragmentFactory(): TeamPlayerFragment
}