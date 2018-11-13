package com.wanztudio.gdk.footballapps.ui.search.searchteam

import com.wanztudio.gdk.footballapps.ui.search.searchteam.view.SearchTeamFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import kotlin.text.Typography.dagger

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
internal abstract class  SearchTeamFragmentProvider {

    @ContributesAndroidInjector(modules = [SearchTeamFragmentModule::class])
    internal abstract fun provideSearchTeamFragmentFactory(): SearchTeamFragment
}