package com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch

import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.interactor.NextMatchInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.interactor.NextMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.presenter.NextMatchMVPPresenter
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.presenter.NextMatchPresenter
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.view.NextMatchFragment
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.view.NextMatchMVPView
import dagger.Module
import dagger.Provides

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
class NextMatchFragmentModule {

    @Provides
    internal fun provideNextMatchInteractor(interactor: NextMatchInteractor): NextMatchMVPInteractor =interactor

    @Provides
    internal fun provideNextMatchPresenter(presenter: NextMatchPresenter<NextMatchMVPView, NextMatchMVPInteractor>)
            : NextMatchMVPPresenter<NextMatchMVPView, NextMatchMVPInteractor> = presenter

    @Provides
    internal fun provideNextMatchLinearLayoutManager(fragment: NextMatchFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)
}