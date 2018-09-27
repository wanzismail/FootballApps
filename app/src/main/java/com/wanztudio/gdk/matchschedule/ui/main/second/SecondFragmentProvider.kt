package com.wanztudio.gdk.matchschedule.ui.main.second

import com.wanztudio.gdk.matchschedule.ui.main.second.view.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

@Module
internal abstract class SecondFragmentProvider {

    @ContributesAndroidInjector(modules = [SecondFragmentModule::class])
    internal abstract fun provideSecondFragmentFactory(): SecondFragment
}