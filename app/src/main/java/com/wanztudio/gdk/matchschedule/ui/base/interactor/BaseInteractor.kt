package com.wanztudio.gdk.matchschedule.ui.base.interactor

import com.wanztudio.gdk.matchschedule.data.network.ApiHelper

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.base.interactor
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

open class BaseInteractor() : MVPInteractor {

    protected lateinit var apiHelper: ApiHelper

    constructor(apiHelper: ApiHelper) : this() {
        this.apiHelper = apiHelper
    }
}