package com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.data.network.Player
import com.wanztudio.gdk.footballapps.ui.base.view.BaseFragment
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.adapter.TeamPlayerAdapter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.interactor.TeamPlayerMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.presenter.TeamPlayerMVPPresenter
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.NetworkUtils
import kotlinx.android.synthetic.main.fragment_player.*
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class TeamPlayerFragment : BaseFragment(), TeamPlayerMVPView {

    internal val TAG = "TeamPlayerFragment"

    companion object {
        fun newInstance(idClub: String): TeamPlayerFragment {
            val args = Bundle()
            args.putString(Constants.EXTRA_TEAM_ID, idClub)

            val fragment = TeamPlayerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var presenter: TeamPlayerMVPPresenter<TeamPlayerMVPView, TeamPlayerMVPInteractor>

    internal lateinit var teamPlayerAdapter: TeamPlayerAdapter

    private var idClub: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.fragment_player, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        arguments?.getString(Constants.EXTRA_TEAM_ID, "")?.let {
            idClub = it
        }

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        player_recyclerview.layoutManager = layoutManager
        player_recyclerview.itemAnimator = DefaultItemAnimator()
        player_recyclerview.setHasFixedSize(true)

        teamPlayerAdapter = TeamPlayerAdapter(requireActivity(), ArrayList())
        player_recyclerview.adapter = teamPlayerAdapter

        swipe_refresh_player.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        swipe_refresh_player.setOnRefreshListener {
            getPlayers()
        }

        getPlayers()
    }

    fun getPlayers() {
        if (NetworkUtils.isNetworkAvailable(requireContext())) {
            presenter.getTeamPlayer(idClub)
        } else {
            Toast.makeText(context, getString(R.string.message_no_network), Toast.LENGTH_SHORT).show()
        }
    }

    override fun showPlayers(listPlayer: List<Player>) {
      listPlayer.let {
        empty_player_data.visibility = View.GONE
        teamPlayerAdapter.addPlayersToList(listPlayer)
      }
    }

    override fun showLoading() {
        swipe_refresh_player.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_player.isRefreshing = false
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }
}
