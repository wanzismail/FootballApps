package com.wanztudio.gdk.footballapps.ui.base.view

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


/**
 * For Bridge Technology Services
 * Created by Ridwan Ismail on 31 October 2018
 * You can contact me at : ridwan.ismail@bridgetech.co.id
 * -------------------------------------------------
 * AHA
 * com.wanztudio.gdk.footballapps.ui.base.view
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class BaseViewPagerAdapter(val context: Context, fm: FragmentManager?, val fragments: List<Fragment>, val titles: List<Int>) : FragmentStatePagerAdapter(fm) {

    // This determines the fragment for each tab
    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    // This determines the number of tabs
    override fun getCount(): Int {
        return fragments.size
    }

    // This determines the title for each tab
    override fun getPageTitle(position: Int): CharSequence? {
        // Generate title based on item position
        return context.getString(titles[position])
    }

}
