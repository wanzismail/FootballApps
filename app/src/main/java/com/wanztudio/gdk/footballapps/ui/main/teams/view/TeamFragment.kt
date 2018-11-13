package com.wanztudio.gdk.footballapps.ui.main.teams.view

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.ui.base.view.BaseFragment
import com.wanztudio.gdk.footballapps.ui.main.teams.adapter.TeamAdapter
import com.wanztudio.gdk.footballapps.ui.main.teams.interactor.TeamMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.teams.presenter.TeamMVPPresenter
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.NetworkUtils
import kotlinx.android.synthetic.main.fragment_team.*
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.teams.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class TeamFragment : BaseFragment(), TeamMVPView {

    internal val TAG = "TeamFragment"

    var SELECTED_ID_LEAGUE = ""
    val LEAGUE_ID = Constants.LEAGUE_ID
    val LEAGUE_NAME = Constants.LEAGUE_NAME

    companion object {

        fun newInstance(): TeamFragment {
            return TeamFragment()
        }
    }

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var presenter: TeamMVPPresenter<TeamMVPView, TeamMVPInteractor>

    internal lateinit var teamAdapter: TeamAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.fragment_team, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        team_spinner.adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, LEAGUE_NAME)
        team_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                SELECTED_ID_LEAGUE = LEAGUE_ID[position]
                getTeam()
            }
        }

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        team_recyclerview.layoutManager = layoutManager
        team_recyclerview.itemAnimator = DefaultItemAnimator()
        team_recyclerview.setHasFixedSize(true)

        teamAdapter = TeamAdapter(requireActivity(), ArrayList())
        team_recyclerview.adapter = teamAdapter

        swipe_refresh_team.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        swipe_refresh_team.setOnRefreshListener {
            getTeam()
        }

        getTeam()
    }

    fun getTeam() {
        if (NetworkUtils.isNetworkAvailable(requireContext())) {
            presenter.getTeam(SELECTED_ID_LEAGUE)
        } else {
            Toast.makeText(context, getString(R.string.message_no_network), Toast.LENGTH_SHORT)
        }
    }

    override fun showTeams(listTeam: List<Team>) {
        listTeam?.let{
            empty_team_data.visibility = View.GONE
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
