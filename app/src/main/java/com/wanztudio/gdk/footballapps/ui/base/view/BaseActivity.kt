package com.wanztudio.gdk.footballapps.ui.base.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.github.inflationx.viewpump.ViewPumpContextWrapper

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.base.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

abstract class BaseActivity : AppCompatActivity(), MVPView, BaseFragment.CallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
    }

    private fun performDI() = AndroidInjection.inject(this)

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}