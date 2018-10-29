package com.wanztudio.gdk.matchschedule.ui.main.prev.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.data.database.FavoriteMatch
import com.wanztudio.gdk.matchschedule.data.database.database
import com.wanztudio.gdk.matchschedule.ui.main.FavoriteAdapter
import kotlinx.android.synthetic.main.fragment_schedule_fav.*
import kotlinx.android.synthetic.main.fragment_schedule_prev.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

/**
 * For LEARNING
 * Created by Ridwan Ismail on 07 October 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.favorite.view
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class FavoriteFragment : Fragment(), FavoriteMVPView {

    internal val TAG = "FavoriteFragment"

    companion object {

        fun newInstance(): FavoriteFragment {
            return FavoriteFragment()
        }
    }

    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit  var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule_fav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        favoriteAdapter = FavoriteAdapter(requireContext(), ArrayList())
        layoutManager = LinearLayoutManager(activity)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        schedule_fav_recycler.layoutManager = layoutManager
        schedule_fav_recycler.itemAnimator = DefaultItemAnimator()
        schedule_fav_recycler.setHasFixedSize(true)
        schedule_fav_recycler.adapter = favoriteAdapter

        swipe_refresh_fav.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        swipe_refresh_fav.setOnRefreshListener {
            getFavorites()
        }

        getFavorites()
    }

    override fun onResume() {
        super.onResume()
        getFavorites()
    }

    fun getFavorites() {
        context?.database?.use {
            showLoading()
            val result = select(FavoriteMatch.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<FavoriteMatch>())
           showFavorites(favorite)
        }
    }

    private fun showFavorites(listEvent: List<FavoriteMatch>) {
        hideLoading()
        listEvent?.let{
            if (listEvent.size > 0) empty_fav_data.visibility =  View.GONE
            favoriteAdapter.updateFavoriteMatchsToList(listEvent)
        }
    }

    override fun showLoading() {
        swipe_refresh_fav.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_fav.isRefreshing = false
    }
}
