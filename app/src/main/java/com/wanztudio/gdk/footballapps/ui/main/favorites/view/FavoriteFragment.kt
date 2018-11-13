package com.wanztudio.gdk.footballapps.ui.main.favorites.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.ui.base.view.BaseViewPagerAdapter
import com.wanztudio.gdk.footballapps.ui.main.favorites.favmatch.view.FavMatchFragment
import com.wanztudio.gdk.footballapps.ui.main.favorites.favteam.view.FavTeamFragment
import kotlinx.android.synthetic.main.fragment_favorite.*

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.favorites.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class FavoriteFragment : Fragment() {

    internal lateinit var favPagerAdapter: BaseViewPagerAdapter

    private val fragments: List<Fragment> = listOf(FavMatchFragment.newInstance(), FavTeamFragment.newInstance())
    private val titles = listOf(R.string.menu_match, R.string.menu_team)

    internal val TAG = "FavoriteFragment"

    companion object {

        fun newInstance(): FavoriteFragment {
            return FavoriteFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_favorite, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPagerAdapter()
    }

    private fun setUpPagerAdapter() {
        favPagerAdapter = BaseViewPagerAdapter(requireContext(), childFragmentManager, fragments, titles)

        favorite_viewpager.adapter = favPagerAdapter
        favorite_viewpager.offscreenPageLimit = 2
        favorite_tabs.setupWithViewPager(favorite_viewpager)
    }

}
