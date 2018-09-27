package com.wanztudio.gdk.matchschedule.ui.main.dialog

import com.wanztudio.gdk.matchschedule.ui.main.dialog.view.MainDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

@Module
abstract class MainDialogProvider{

    @ContributesAndroidInjector(modules = [MainDialogModule::class])
    internal abstract fun provideMainDialog() : MainDialog
}