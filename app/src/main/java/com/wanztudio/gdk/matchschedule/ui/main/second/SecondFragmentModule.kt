package com.wanztudio.gdk.matchschedule.ui.main.second

import com.wanztudio.gdk.matchschedule.ui.main.second.interactor.SecondInteractor
import com.wanztudio.gdk.matchschedule.ui.main.second.interactor.SecondMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.second.presenter.SecondMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.second.presenter.SecondPresenter
import com.wanztudio.gdk.matchschedule.ui.main.second.view.SecondMVPView
import dagger.Module
import dagger.Provides


/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

@Module
class SecondFragmentModule {

    @Provides
    internal fun provideSecondInteractor(interactor: SecondInteractor): SecondMVPInteractor = interactor

    @Provides
    internal fun provideSecondPresenter(presenter: SecondPresenter<SecondMVPView, SecondMVPInteractor>)
            : SecondMVPPresenter<SecondMVPView, SecondMVPInteractor> = presenter
}