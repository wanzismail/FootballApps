package com.wanztudio.gdk.footballapps.ui.main.matches.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.ui.base.view.BaseViewPagerAdapter
import com.wanztudio.gdk.footballapps.ui.main.matches.lastmatch.view.LastMatchFragment
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.view.NextMatchFragment
import kotlinx.android.synthetic.main.fragment_match.*


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class MatchFragment : Fragment() {

    internal lateinit var matchPagerAdapter: BaseViewPagerAdapter

    private val fragments = listOf(NextMatchFragment.newInstance(), LastMatchFragment.newInstance())
    private val titles = listOf(R.string.tab_next_match, R.string.tab_last_match)

    internal val TAG = "MatchFragment"

    companion object {

        fun newInstance(): MatchFragment {
            return MatchFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_match, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPagerAdapter()
    }

    private fun setUpPagerAdapter() {
        matchPagerAdapter = BaseViewPagerAdapter(requireContext(), childFragmentManager, fragments, titles)

        match_viewpager.adapter = matchPagerAdapter
        match_viewpager.offscreenPageLimit = 2
        match_tabs.setupWithViewPager(match_viewpager)
    }

}
