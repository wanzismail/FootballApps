package com.wanztudio.gdk.matchschedule.ui.main.view

import android.os.Bundle
import android.support.v4.app.Fragment
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseActivity
import com.wanztudio.gdk.matchschedule.ui.main.MainPagerAdapter
import com.wanztudio.gdk.matchschedule.ui.main.dialog.view.MainDialog
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    internal lateinit var mainPagerAdapter: MainPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)
        setUpPagerAdapter()
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    private fun setUpPagerAdapter() {
        mainPagerAdapter.count = 2
    }

    private fun openMainDialog() = MainDialog.newInstance().let {
        it?.show(supportFragmentManager)
    }
}