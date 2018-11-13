package com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.view

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
import com.wanztudio.gdk.footballapps.data.network.Event
import com.wanztudio.gdk.footballapps.ui.base.view.BaseFragment
import com.wanztudio.gdk.footballapps.ui.main.matches.adapter.MatchAdapter
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.interactor.NextMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.presenter.NextMatchMVPPresenter
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.NetworkUtils
import kotlinx.android.synthetic.main.fragment_next_match.*
import javax.inject.Inject


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.nextmatch.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class NextMatchFragment : BaseFragment(), NextMatchMVPView {

    internal val TAG = "NextMatchFragment"

    var SELECTED_ID_LEAGUE = ""
    val LEAGUE_ID = Constants.LEAGUE_ID
    val LEAGUE_NAME = Constants.LEAGUE_NAME

    companion object {

        fun newInstance(): NextMatchFragment {
            return NextMatchFragment()
        }
    }

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var presenter: NextMatchMVPPresenter<NextMatchMVPView, NextMatchMVPInteractor>

    internal lateinit var nextMatchAdapter: MatchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_next_match, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        next_match_spinner.adapter = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, LEAGUE_NAME)
        next_match_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                SELECTED_ID_LEAGUE = LEAGUE_ID[position]
                getListEvent()
            }
        }

        layoutManager.orientation = LinearLayoutManager.VERTICAL
        next_match_recyclerview.layoutManager = layoutManager
        next_match_recyclerview.itemAnimator = DefaultItemAnimator()
        next_match_recyclerview.setHasFixedSize(true)

        nextMatchAdapter = MatchAdapter(requireActivity(), ArrayList())
        next_match_recyclerview.adapter = nextMatchAdapter

        swipe_refresh_next_match.setColorSchemeColors(ContextCompat.getColor(requireContext(),R.color.colorPrimary))
        swipe_refresh_next_match.setOnRefreshListener {
            getListEvent()
        }
        
        getListEvent()
    }

    fun getListEvent() {
        if (NetworkUtils.isNetworkAvailable(requireContext())) {
            presenter.getNextMatch(SELECTED_ID_LEAGUE)
        } else {
            Toast.makeText(context, getString(R.string.message_no_network), Toast.LENGTH_SHORT)
        }
    }

    override fun showEvents(listEvent: List<Event>) {
        listEvent?.let {
            empty_next_match_data.visibility = View.GONE
            nextMatchAdapter.addEventsToList(listEvent)
        }
    }

    override fun showLoading() {
        swipe_refresh_next_match.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_next_match.isRefreshing = false
    }
    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }
}