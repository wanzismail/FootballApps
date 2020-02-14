package com.wanztudio.gdk.footballapps.ui.search.searchmatch

import com.wanztudio.gdk.footballapps.ui.search.searchmatch.view.SearchMatchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


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
internal abstract class SearchMatchFragmentProvider {

    @ContributesAndroidInjector(modules = [SearchMatchFragmentModule::class])
    internal abstract fun provideSearchMatchFragmentFactory(): SearchMatchFragment
}