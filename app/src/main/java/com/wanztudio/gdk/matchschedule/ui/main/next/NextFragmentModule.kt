package com.wanztudio.gdk.matchschedule.ui.main.next

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.matchschedule.di.ApplicationContext
import com.wanztudio.gdk.matchschedule.ui.main.ScheduleAdapter
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.DetailMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.NextMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.NextPresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.view.NextFragment
import com.wanztudio.gdk.matchschedule.ui.main.next.view.NextMVPView
import dagger.Module
import dagger.Provides

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.next
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

@Module
class NextFragmentModule {

    @Provides
    internal fun provideNextInteractor(interactor: NextInteractor): NextMVPInteractor = interactor

    @Provides
    internal fun provideNextPresenter(presenter: NextPresenter<NextMVPView, NextMVPInteractor>)
            : NextMVPPresenter<NextMVPView, NextMVPInteractor> = presenter


    @Provides
    internal fun provideScheduleAdapter(@ApplicationContext context: Context): ScheduleAdapter = ScheduleAdapter(context, ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(fragment: NextFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)
}