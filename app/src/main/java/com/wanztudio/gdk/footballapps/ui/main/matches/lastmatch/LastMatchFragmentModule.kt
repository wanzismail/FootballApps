package com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch

import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.interactor.LastMatchInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.interactor.LastMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.presenter.LastMatchMVPPresenter
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.presenter.LastMatchPresenter
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.view.LastMatchFragment
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.view.LastMatchMVPView
import dagger.Module
import dagger.Provides

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
class LastMatchFragmentModule {

    @Provides
    internal fun provideLastMatchInteractor(interactor: LastMatchInteractor): LastMatchMVPInteractor = interactor

    @Provides
    internal fun provideLastMatchPresenter(presenter: LastMatchPresenter<LastMatchMVPView, LastMatchMVPInteractor>)
            : LastMatchMVPPresenter<LastMatchMVPView, LastMatchMVPInteractor> = presenter

    @Provides
    internal fun provideLastMatchLinearLayoutManager(fragment: LastMatchFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)

}