package com.wanztudio.framework.mvp.ui.login.view

import com.wanztudio.gdk.matchschedule.data.network.Event
import com.wanztudio.gdk.matchschedule.data.network.Team
import com.wanztudio.gdk.matchschedule.ui.base.view.MVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.detail.view
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

interface DetailMVPView : MVPView{

    fun showLoading()
    fun hideLoading()
    fun showHomeTeam(team :Team)
    fun showAwayTeam(team: Team)
    fun showEvent(event: Event)
}