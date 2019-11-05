package com.wanztudio.gdk.footballapps.ui.detail.detailmatch

import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.interactor.DetailMatchInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.interactor.DetailMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.presenter.DetailMatchMVPPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.presenter.DetailMatchPresenter
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view.DetailMatchMVPView
import dagger.Module
import dagger.Provides

/**
 * For LEARNING
 * Created by Ridwan Ismail on 01 October 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailmatch
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

@Module
class DetailMatchActivityModule {

    @Provides
    internal fun provideDetailMatchInteractor(matchInteractor: DetailMatchInteractor): DetailMatchMVPInteractor = matchInteractor

    @Provides
    internal fun provideDetailMatchPresenter(matchPresenter: DetailMatchPresenter<DetailMatchMVPView, DetailMatchMVPInteractor>)
            : DetailMatchMVPPresenter<DetailMatchMVPView, DetailMatchMVPInteractor> = matchPresenter

}

