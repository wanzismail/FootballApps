package com.wanztudio.gdk.matchschedule.ui.main.first

import com.wanztudio.gdk.matchschedule.ui.main.first.interactor.FirstInteractor
import com.wanztudio.gdk.matchschedule.ui.main.first.interactor.FirstMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.first.presenter.FirstMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.first.presenter.FirstPresenter
import com.wanztudio.gdk.matchschedule.ui.main.first.view.FirstMVPView
import dagger.Module
import dagger.Provides


/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

@Module
class FirstFragmentModule {

    @Provides
    internal fun provideFirstInteractor(interactor: FirstInteractor): FirstMVPInteractor = interactor

    @Provides
    internal fun provideFirstPresenter(presenter: FirstPresenter<FirstMVPView, FirstMVPInteractor>)
            : FirstMVPPresenter<FirstMVPView, FirstMVPInteractor> = presenter
}