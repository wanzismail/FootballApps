package com.wanztudio.gdk.matchschedule.ui.main.prev.view

import android.opengl.Visibility
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.R.id.swipe_refresh
import com.wanztudio.gdk.matchschedule.data.database.FavoriteMatch
import com.wanztudio.gdk.matchschedule.data.database.database
import com.wanztudio.gdk.matchschedule.data.network.Event
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseFragment
import com.wanztudio.gdk.matchschedule.ui.main.ScheduleAdapter
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.FavoriteMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.presenter.FavoriteMVPPresenter
import com.wanztudio.gdk.matchschedule.util.Constants
import com.wanztudio.gdk.matchschedule.util.NetworkUtils
import kotlinx.android.synthetic.main.fragment_schedule.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.prev.view
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class FavoriteFragment : BaseFragment(), FavoriteMVPView {

    internal val TAG = "FavoriteFragment"

    companion object {

        fun newInstance(): FavoriteFragment {
            return FavoriteFragment()
        }
    }

    @Inject
    internal lateinit var scheduleAdapter: ScheduleAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager

    private var favorites: MutableList<FavoriteMatch> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.fragment_schedule, container, false)

    override fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        schedule_recycler.layoutManager = layoutManager
        schedule_recycler.itemAnimator = DefaultItemAnimator()
        schedule_recycler.setHasFixedSize(true)
        schedule_recycler.adapter = scheduleAdapter

        swipe_refresh.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        swipe_refresh.setOnRefreshListener {
            getFavorites()
        }

        getFavorites()
    }

    fun getFavorites() {
        context?.database?.use {
            showLoading()
            val result = select(FavoriteMatch.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            favorites.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }

    override fun showEvents(listEvent: List<Event>) {
        hideLoading()
        listEvent?.let{
            empty_data.visibility = View.GONE
            scheduleAdapter.addEventsToList(listEvent)
        }
    }

    override fun showLoading() {
        swipe_refresh.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh.isRefreshing = false
    }
}
