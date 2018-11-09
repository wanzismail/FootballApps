package com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view

import com.wanztudio.gdk.footballapps.data.network.Player
import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.ui.base.view.MVPView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

interface TeamPlayerMVPView : MVPView {

    fun showLoading()
    fun hideLoading()
    fun showPlayers(listPlayer : List<Player>)
}