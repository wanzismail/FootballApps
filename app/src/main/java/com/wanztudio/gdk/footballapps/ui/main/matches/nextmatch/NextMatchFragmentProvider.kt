package com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch

import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.view.NextMatchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
internal abstract class NextMatchFragmentProvider {

    @ContributesAndroidInjector(modules = [NextMatchFragmentModule::class])
    internal abstract fun provideNextFragmentFactory(): NextMatchFragment
}