package com.wanztudio.gdk.matchschedule.di.component

import android.app.Application
import com.wanztudio.gdk.matchschedule.BaseApplication
import com.wanztudio.gdk.matchschedule.di.builder.ActivityBuilder
import com.wanztudio.gdk.matchschedule.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)

}