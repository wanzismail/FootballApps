package com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview

import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.view.TeamOverviewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


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
internal abstract class  OverviewFragmentProvider {

    @ContributesAndroidInjector(modules = [OverviewFragmentModule::class])
    internal abstract fun provideTeamOverviewFragmentFactory(): TeamOverviewFragment
}