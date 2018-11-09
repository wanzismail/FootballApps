package com.wanztudio.gdk.footballapps.di.builder

import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.DetailMatchActivityModule
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view.DetailMatchActivity
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.OverviewFragmentProvider
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.PlayerFragmentProvider
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.view.DetailTeamActivity
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.LastMatchFragmentProvider
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.NextMatchFragmentProvider
import com.wanztudio.gdk.footballapps.ui.main.teams.TeamFragmentProvider
import com.wanztudio.gdk.footballapps.ui.main.view.MainActivity
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.SearchMatchFragmentProvider
import com.wanztudio.gdk.footballapps.ui.search.searchteam.SearchTeamFragmentProvider
import com.wanztudio.gdk.footballapps.ui.search.view.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.di.builder
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(NextMatchFragmentProvider::class), (LastMatchFragmentProvider::class), (TeamFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(DetailMatchActivityModule::class)])
    abstract fun bindDetailMatchActivity(): DetailMatchActivity

    @ContributesAndroidInjector(modules = [(OverviewFragmentProvider::class), (PlayerFragmentProvider::class)])
    abstract fun bindDetailTeamActivity(): DetailTeamActivity

    @ContributesAndroidInjector(modules = [(SearchTeamFragmentProvider::class), (SearchMatchFragmentProvider::class)])
    abstract fun bindSearchActivity(): SearchActivity

}