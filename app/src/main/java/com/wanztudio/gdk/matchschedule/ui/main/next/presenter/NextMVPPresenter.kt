package com.wanztudio.gdk.matchschedule.ui.main.next.presenter

import com.wanztudio.gdk.matchschedule.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.view.NextMVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.next.presenter
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

interface NextMVPPresenter<V : NextMVPView, I : NextMVPInteractor> : MVPPresenter<V, I> {

    fun getNextSchedule(idLeague : Int)
}