package com.wanztudio.gdk.footballapps.ui.main.favorites.favteam.view
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
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteTeam
import com.wanztudio.gdk.footballapps.ui.main.favorites.adapter.FavoriteTeamAdapter
import com.wanztudio.gdk.footballapps.ui.main.favorites.favmatch.view.FavTeamMVPView
import kotlinx.android.synthetic.main.fragment_fav_team.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.favorites.favteam.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class FavTeamFragment : Fragment(), FavTeamMVPView {

    internal val TAG = "FavTeamFragment"

    companion object {

        fun newInstance(): FavTeamFragment {
            return FavTeamFragment()
        }
    }
    private lateinit var favTeamAdapter: FavoriteTeamAdapter
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
        favTeamAdapter = FavoriteTeamAdapter(requireContext(), ArrayList())
        layoutManager = LinearLayoutManager(activity)

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        fav_team_recyclerview.layoutManager = layoutManager
        fav_team_recyclerview.itemAnimator = DefaultItemAnimator()
        fav_team_recyclerview.setHasFixedSize(true)
        fav_team_recyclerview.adapter = favTeamAdapter

        swipe_refresh_fav_team.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        swipe_refresh_fav_team.setOnRefreshListener {
            getTeams()
        }
    }

    override fun onResume() {
        super.onResume()
         getTeams()
    }


    fun getTeams() {
        context?.database?.use {
            showLoading()
            val result = select(FavoriteTeam.TABLE_FAVORITE_TEAMS)
            val favorite = result.parseList(classParser<FavoriteTeam>())
            showTeams(favorite)
        }
    }

    private fun showTeams(listEvent: List<FavoriteTeam>) {
        hideLoading()
        listEvent?.let{
            if (listEvent.size > 0) empty_fav_team_data.visibility =  View.GONE
            else empty_fav_team_data.visibility =  View.VISIBLE
            favTeamAdapter.updateFavoriteTeamsToList(listEvent)
        }
    }

    override fun showLoading() {
        swipe_refresh_fav_team.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_fav_team.isRefreshing = false
    }
}
