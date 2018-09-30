package com.wanztudio.gdk.matchschedule.ui.base.presenter

import com.wanztudio.gdk.matchschedule.ui.base.interactor.MVPInteractor
import com.wanztudio.gdk.matchschedule.ui.base.view.MVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.base.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */


interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}