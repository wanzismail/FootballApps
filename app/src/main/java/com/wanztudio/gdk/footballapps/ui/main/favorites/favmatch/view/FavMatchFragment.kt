package com.wanztudio.gdk.footballapps.ui.main.favorites.favmatch.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.data.database.database
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteMatch
import com.wanztudio.gdk.footballapps.ui.base.view.BaseFragment
import com.wanztudio.gdk.footballapps.ui.main.favorites.adapter.FavoriteMatchAdapter
import com.wanztudio.gdk.footballapps.ui.main.favorites.favteam.view.FavTeamFragment
import kotlinx.android.synthetic.main.fragment_fav_team.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.favorites.favmatch.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class FavMatchFragment : Fragment(), FavMatchMVPView {

    internal val TAG = "FavMatchFragment"

    companion object {

        fun newInstance(): FavMatchFragment {
            return FavMatchFragment()
        }
    }

    private lateinit var favMatchAdapter: FavoriteMatchAdapter
    private lateinit  var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fav_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        favMatchAdapter = FavoriteMatchAdapter(requireContext(), ArrayList())
        layoutManager = LinearLayoutManager(activity)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        fav_team_recyclerview.layoutManager = layoutManager
        fav_team_recyclerview.itemAnimator = DefaultItemAnimator()
        fav_team_recyclerview.setHasFixedSize(true)
        fav_team_recyclerview.adapter = favMatchAdapter

        swipe_refresh_fav_team.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        swipe_refresh_fav_team.setOnRefreshListener {
            getFavorites()
        }
    }

    override fun onResume() {
        super.onResume()
         getFavorites()
    }


    fun getFavorites() {
        context?.database?.use {
            showLoading()
            val result = select(FavoriteMatch.TABLE_FAVORITE_EVENTS)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            showFavorites(favorite)
        }
    }

    private fun showFavorites(listEvent: List<FavoriteMatch>) {
        hideLoading()
        listEvent?.let{
            if (listEvent.size > 0) empty_fav_team_data.visibility =  View.GONE
            else empty_fav_team_data.visibility =  View.VISIBLE
            favMatchAdapter.updateFavoriteMatchsToList(listEvent)
        }
    }

    override fun showLoading() {
        swipe_refresh_fav_team.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_fav_team.isRefreshing = false
    }
}
