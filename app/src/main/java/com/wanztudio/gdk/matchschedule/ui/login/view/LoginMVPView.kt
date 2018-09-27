package com.wanztudio.framework.mvp.ui.login.view

import com.wanztudio.gdk.matchschedule.ui.base.view.MVPView

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

interface LoginMVPView : MVPView {

    fun showValidationMessage(errorCode: Int)
    fun openMainActivity()
}