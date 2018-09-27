package com.wanztudio.gdk.matchschedule.ui.main.dialog

import com.wanztudio.gdk.matchschedule.ui.main.dialog.interactor.MainDialogInteractor
import com.wanztudio.gdk.matchschedule.ui.main.dialog.interactor.MainDialogMVPInterator
import com.wanztudio.gdk.matchschedule.ui.main.dialog.presenter.MainDialogMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.dialog.presenter.MainDialogPresenter
import com.wanztudio.gdk.matchschedule.ui.main.dialog.view.MainDialogMVPView
import dagger.Module
import dagger.Provides

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

@Module
class MainDialogModule {

    @Provides
    internal fun provideMainDialogInteractor(interactor: MainDialogInteractor): MainDialogMVPInterator = interactor

    @Provides
    internal fun provideMainDialogPresenter(presenter: MainDialogPresenter<MainDialogMVPView, MainDialogMVPInterator>)
            : MainDialogMVPPresenter<MainDialogMVPView, MainDialogMVPInterator> = presenter
}