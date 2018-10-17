package com.wanztudio.gdk.matchschedule.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.MenuItem
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseActivity
import com.wanztudio.gdk.matchschedule.ui.detail.view.DetailActivity
import com.wanztudio.gdk.matchschedule.ui.main.MainPagerAdapter
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject
import android.app.Activity



/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.view
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class MainActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    internal lateinit var mainPagerAdapter: MainPagerAdapter

    var prevMenuItem: MenuItem? = null

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
        mainPagerAdapter.count = 3
        content_viewpager.adapter = mainPagerAdapter
        content_viewpager.offscreenPageLimit = 3
        content_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null) {
                    prevMenuItem?.setChecked(false)
                } else {
                    bottom_navigation.getMenu().getItem(0).setChecked(false);
                }

                Log.d("page", "onPageSelected: " + position)
                bottom_navigation.getMenu().getItem(position).setChecked(true)
                prevMenuItem = bottom_navigation.getMenu().getItem(position)
            }
        })

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_prev -> {
                content_viewpager.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_next -> {
                content_viewpager.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_favorite -> {
                content_viewpager.setCurrentItem(2, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}