package com.wanztudio.gdk.matchschedule.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.wanztudio.gdk.matchschedule.BuildConfig
import com.wanztudio.gdk.matchschedule.data.database.AppDatabase
import com.wanztudio.gdk.matchschedule.data.database.repository.user.UserRepo
import com.wanztudio.gdk.matchschedule.data.database.repository.user.UserRepository
import com.wanztudio.gdk.matchschedule.data.network.ApiHeader
import com.wanztudio.gdk.matchschedule.data.network.ApiHelper
import com.wanztudio.gdk.matchschedule.data.network.AppApiHelper
import com.wanztudio.gdk.matchschedule.data.preferences.AppPreferenceHelper
import com.wanztudio.gdk.matchschedule.data.preferences.PreferenceHelper
import com.wanztudio.gdk.matchschedule.di.ApiKeyInfo
import com.wanztudio.gdk.matchschedule.di.PreferenceInfo
import com.wanztudio.gdk.matchschedule.util.Constants
import com.wanztudio.gdk.matchschedule.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, Constants.APP_DB_NAME).build()

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = Constants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
            userId = preferenceHelper.getCurrentUserId(),
            accessToken = preferenceHelper.getAccessToken())

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideUsernRepoHelper(appDatabase: AppDatabase): UserRepo = UserRepository(appDatabase.userDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()


}