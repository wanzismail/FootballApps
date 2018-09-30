package com.wanztudio.gdk.matchschedule.ui.detail.view

import android.os.Bundle
import com.wanztudio.framework.mvp.ui.login.view.DetailMVPView
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseActivity

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.detail.view
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class DetailActivity : BaseActivity(), DetailMVPView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }


    override fun onFragmentDetached(tag: String) {
    }

    override fun onFragmentAttached() {
    }
}