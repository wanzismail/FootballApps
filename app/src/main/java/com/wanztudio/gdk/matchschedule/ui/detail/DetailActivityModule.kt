package com.wanztudio.gdk.matchschedule.ui.detail

import com.wanztudio.framework.mvp.ui.login.view.DetailMVPView
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.DetailMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.DetailPresenter
import dagger.Module
import dagger.Provides

/**
 * For LEARNING
 * Created by Ridwan Ismail on 01 October 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.util
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

@Module
class DetailActivityModule {

    @Provides
    internal fun provideDetailInteractor(interactor: DetailInteractor): DetailMVPInteractor = interactor

    @Provides
    internal fun provideDetailPresenter(presenter: DetailPresenter<DetailMVPView, DetailMVPInteractor>)
            : DetailMVPPresenter<DetailMVPView, DetailMVPInteractor> = presenter

}

