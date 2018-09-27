package com.wanztudio.gdk.matchschedule.ui.main.first

import com.wanztudio.gdk.matchschedule.ui.main.first.view.FirstFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

@Module
internal abstract class  FirstFragmentProvider {

    @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
    internal abstract fun provideFirstFragmentFactory(): FirstFragment
}