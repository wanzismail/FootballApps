package com.wanztudio.gdk.footballapps.ui.search.searchteam.view


import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.ui.base.view.MVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.teams.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface SearchTeamMVPView : MVPView {

    fun showLoading()
    fun hideLoading()
    fun showTeams(listTeam: List<Team>)
}