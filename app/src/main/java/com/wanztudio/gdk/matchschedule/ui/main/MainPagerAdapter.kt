package com.wanztudio.gdk.matchschedule.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.wanztudio.gdk.matchschedule.ui.main.prev.view.PrevFragment
import com.wanztudio.gdk.matchschedule.ui.main.next.view.NextFragment
import com.wanztudio.gdk.matchschedule.ui.main.prev.view.FavoriteFragment

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var tabCount = 0

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> PrevFragment.newInstance()
            1 -> NextFragment.newInstance()
            2 -> FavoriteFragment.newInstance()
            else -> null
        }
    }

    internal fun setCount(count: Int) {
        this.tabCount = count
    }

}