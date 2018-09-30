package com.wanztudio.gdk.matchschedule.di.builder

import com.wanztudio.gdk.matchschedule.ui.detail.view.DetailActivity
import com.wanztudio.gdk.matchschedule.ui.main.next.NextFragmentProvider
import com.wanztudio.gdk.matchschedule.ui.main.prev.PrevFragmentProvider
import com.wanztudio.gdk.matchschedule.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.di.builder
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(PrevFragmentProvider::class), (NextFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

}