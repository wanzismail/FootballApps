package com.wanztudio.gdk.matchschedule.di.module

import android.app.Application
import android.content.Context
import com.wanztudio.gdk.matchschedule.data.network.ApiHelper
import com.wanztudio.gdk.matchschedule.data.network.AppApiHelper
import com.wanztudio.gdk.matchschedule.di.ApplicationContext
import com.wanztudio.gdk.matchschedule.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.di.module
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

@Module
class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

}