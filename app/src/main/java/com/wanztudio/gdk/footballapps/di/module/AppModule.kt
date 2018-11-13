package com.wanztudio.gdk.footballapps.di.module

import android.app.Application
import android.content.Context
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.data.network.ApiHelper
import com.wanztudio.gdk.footballapps.data.network.AppApiHelper
import com.wanztudio.gdk.footballapps.di.ApplicationContext
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.di.module
 * or see link for more detail https://github.com/iwanz98/FootballApps
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

    @Provides
    @Singleton
    internal fun provideCalligraphyDefaultConfig(@ApplicationContext context: Context): CalligraphyConfig {
        return CalligraphyConfig.Builder()
                .setDefaultFontPath(context.getString(R.string.typeface_regular))
                .setFontAttrId(R.attr.fontPath)
                .build()
    }
}