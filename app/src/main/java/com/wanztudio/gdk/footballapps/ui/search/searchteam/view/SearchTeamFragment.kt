package com.wanztudio.gdk.footballapps.ui.search.searchteam.view

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.ui.base.view.BaseFragment
import com.wanztudio.gdk.footballapps.ui.main.teams.adapter.TeamAdapter
import com.wanztudio.gdk.footballapps.ui.search.searchteam.interactor.SearchTeamMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchteam.presenter.SearchTeamMVPPresenter
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.NetworkUtils
import kotlinx.android.synthetic.main.fragment_next_match.*
import kotlinx.android.synthetic.main.fragment_search_team.*
import kotlinx.android.synthetic.main.fragment_team.*
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.searchteam.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class SearchTeamFragment : BaseFragment(), SearchTeamMVPView {

    internal val TAG = "SearchTeamFragment"

    private var keyWord  = ""

    companion object {

        fun newInstance(keyWord : String): SearchTeamFragment {
            val args = Bundle()
            args.putString(Constants.EXTRA_KEYWORD, keyWord)

            val fragment = SearchTeamFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var presenter: SearchTeamMVPPresenter<SearchTeamMVPView, SearchTeamMVPInteractor>

    internal lateinit var teamAdapter: TeamAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.fragment_search_team, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        arguments?.let {
            keyWord = it.getString(Constants.EXTRA_KEYWORD)
        }

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        search_team_recyclerview.layoutManager = layoutManager
        search_team_recyclerview.itemAnimator = DefaultItemAnimator()
        search_team_recyclerview.setHasFixedSize(true)

        teamAdapter = TeamAdapter(requireActivity(), ArrayList())
        search_team_recyclerview.adapter = teamAdapter

        swipe_refresh_team.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        swipe_refresh_team.setOnRefreshListener {
            searchTeam()
        }

        searchTeam()
    }

    fun searchTeam() {
        if (NetworkUtils.isNetworkAvailable(requireContext())) {
            presenter.searchTeam(keyWord)
        } else {
            Toast.makeText(context, getString(R.string.message_no_network), Toast.LENGTH_SHORT)
        }
    }

    override fun showTeams(listTeam: List<Team>) {
        listTeam?.let{
            empty_search_team_data.visibility = View.GONE
            teamAdapter.addTeamsToList(listTeam)
        }
    }

    override fun showLoading() {
        swipe_refresh_team.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_team.isRefreshing = false
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }
}
