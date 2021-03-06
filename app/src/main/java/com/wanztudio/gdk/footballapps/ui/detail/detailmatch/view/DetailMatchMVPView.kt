package com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view

import com.wanztudio.gdk.footballapps.data.network.Event
import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.ui.base.view.MVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.matchschedule.ui.detail.detailmatch.view
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

interface DetailMatchMVPView : MVPView {

    fun showLoading()
    fun hideLoading()
    fun showHomeTeam(team : Team)
    fun showAwayTeam(team: Team)
    fun showEvent(event: Event)
}
