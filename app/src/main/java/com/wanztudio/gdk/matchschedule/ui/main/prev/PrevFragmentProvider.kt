package com.wanztudio.gdk.matchschedule.ui.main.prev

import com.wanztudio.gdk.matchschedule.ui.main.prev.view.PrevFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.prev
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

@Module
internal abstract class  PrevFragmentProvider {

    @ContributesAndroidInjector(modules = [PrevFragmentModule::class])
    internal abstract fun providePrevFragmentFactory(): PrevFragment
}