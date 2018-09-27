package com.wanztudio.gdk.matchschedule.ui.main.dialog.presenter

import com.wanztudio.gdk.matchschedule.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.dialog.interactor.MainDialogMVPInterator
import com.wanztudio.gdk.matchschedule.ui.main.dialog.view.MainDialogMVPView

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

interface MainDialogMVPPresenter<V : MainDialogMVPView, I : MainDialogMVPInterator> : MVPPresenter<V, I> {

    fun onLaterOptionClicked() : Unit?
    fun onSubmitOptionClicked() : Unit?
}