package com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.ui.base.view.BaseFragment
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.interactor.TeamOverviewMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.presenter.TeamOverviewMVPPresenter
import com.wanztudio.gdk.footballapps.util.Constants
import kotlinx.android.synthetic.main.fragment_team_overview.*
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class TeamOverviewFragment : BaseFragment(), TeamOverviewMVPView {

    internal val TAG = "TeamOverviewFragment"

    companion object {

        fun newInstance(descritpion: String): TeamOverviewFragment {
            val args = Bundle()
            args.putString(Constants.EXTRA_TEAM_DESC, descritpion)

            val fragment = TeamOverviewFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var presenter: TeamOverviewMVPPresenter<TeamOverviewMVPView, TeamOverviewMVPInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.fragment_team_overview, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        val infoDescription = arguments?.getString(Constants.EXTRA_TEAM_DESC)
        infoDescription?.let{
            team_overview_description.text = infoDescription
        }
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }
}
