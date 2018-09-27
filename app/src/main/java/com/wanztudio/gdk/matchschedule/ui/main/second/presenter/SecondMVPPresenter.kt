package com.wanztudio.gdk.matchschedule.ui.main.second.presenter

import com.wanztudio.gdk.matchschedule.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.second.interactor.SecondMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.second.view.SecondMVPView

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

interface SecondMVPPresenter<V : SecondMVPView, I : SecondMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()
}