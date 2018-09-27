package com.wanztudio.gdk.matchschedule.di.builder

import com.wanztudio.gdk.matchschedule.ui.login.LoginActivityModule
import com.wanztudio.gdk.matchschedule.ui.login.view.LoginActivity
import com.wanztudio.gdk.matchschedule.ui.login.view.RegisterActivity
import com.wanztudio.gdk.matchschedule.ui.main.dialog.MainDialogProvider
import com.wanztudio.gdk.matchschedule.ui.main.first.FirstFragmentProvider
import com.wanztudio.gdk.matchschedule.ui.main.second.SecondFragmentProvider
import com.wanztudio.gdk.matchschedule.ui.main.view.MainActivity
import com.wanztudio.gdk.matchschedule.ui.register.RegisterActivityModule
import com.wanztudio.gdk.matchschedule.ui.splash.SplashActivityModule
import com.wanztudio.gdk.matchschedule.ui.splash.view.SplashMVPActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
    abstract fun bindSplashActivity(): SplashMVPActivity

    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    abstract fun bindLoginActivity(): LoginActivity
    
    @ContributesAndroidInjector(modules = [(RegisterActivityModule::class)])
    abstract fun bindRegisterActivity(): RegisterActivity

    @ContributesAndroidInjector(modules = [(MainDialogProvider::class), (FirstFragmentProvider::class), (SecondFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

}