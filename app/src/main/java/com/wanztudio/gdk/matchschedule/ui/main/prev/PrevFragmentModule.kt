package com.wanztudio.gdk.matchschedule.ui.main.prev

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.matchschedule.data.network.Event
import com.wanztudio.gdk.matchschedule.di.ApplicationContext
import com.wanztudio.gdk.matchschedule.ui.main.ScheduleAdapter
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.PrevInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.PrevMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.presenter.PrevMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.prev.presenter.PrevPresenter
import com.wanztudio.gdk.matchschedule.ui.main.prev.view.PrevFragment
import com.wanztudio.gdk.matchschedule.ui.main.prev.view.PrevMVPView
import dagger.Module
import dagger.Provides

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
class PrevFragmentModule {

    @Provides
    internal fun providePrevInteractor(interactor: PrevInteractor): PrevMVPInteractor = interactor

    @Provides
    internal fun providePrevPresenter(presenter: PrevPresenter<PrevMVPView, PrevMVPInteractor>)
            : PrevMVPPresenter<PrevMVPView, PrevMVPInteractor> = presenter

    @Provides
    internal fun provideScheduleAdapter(@ApplicationContext context: Context): ScheduleAdapter = ScheduleAdapter(context, ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: PrevFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}