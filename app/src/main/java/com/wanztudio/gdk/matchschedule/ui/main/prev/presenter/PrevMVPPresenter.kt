package com.wanztudio.gdk.matchschedule.ui.main.prev.presenter

import com.wanztudio.gdk.matchschedule.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.PrevMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.view.PrevMVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.prev.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

interface PrevMVPPresenter<V : PrevMVPView, I : PrevMVPInteractor> : MVPPresenter<V, I> {

    fun getPrevSchedule(idLeague : Int)
}