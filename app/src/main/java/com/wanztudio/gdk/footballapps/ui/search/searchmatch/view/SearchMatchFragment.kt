package com.wanztudio.gdk.footballapps.ui.search.searchmatch.view

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.data.network.Event
import com.wanztudio.gdk.footballapps.ui.base.view.BaseFragment
import com.wanztudio.gdk.footballapps.ui.main.matches.adapter.MatchAdapter
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.interactor.SearchMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.presenter.SearchMatchMVPPresenter
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.NetworkUtils
import kotlinx.android.synthetic.main.fragment_search_match.*
import javax.inject.Inject


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.matches.searchmatch.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class SearchMatchFragment : BaseFragment(), SearchMatchMVPView {

    internal val TAG = "SearchMatchFragment"

    private var keyWord  = ""

    companion object {

        fun newInstance(keyWord : String): SearchMatchFragment {
            val args = Bundle()
            args.putString(Constants.EXTRA_KEYWORD, keyWord)

            val fragment = SearchMatchFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var presenterMatch: SearchMatchMVPPresenter<SearchMatchMVPView, SearchMatchMVPInteractor>

    internal lateinit var matchAdapter: MatchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_search_match, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenterMatch.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        arguments?.let {
            keyWord = it.getString(Constants.EXTRA_KEYWORD)
        }
        
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        search_match_recyclerview.layoutManager = layoutManager
        search_match_recyclerview.itemAnimator = DefaultItemAnimator()
        search_match_recyclerview.setHasFixedSize(true)

        matchAdapter = MatchAdapter(requireActivity(), ArrayList())
        search_match_recyclerview.adapter = matchAdapter

        swipe_refresh_search_match.setColorSchemeColors(ContextCompat.getColor(requireContext(),R.color.colorPrimary))
        swipe_refresh_search_match.setOnRefreshListener {
            searchMatch()
        }

        searchMatch()
    }

    fun searchMatch() {
        if (NetworkUtils.isNetworkAvailable(requireContext())) {
            presenterMatch.searchMatch(keyWord)
        } else {
            Toast.makeText(context, getString(R.string.message_no_network), Toast.LENGTH_SHORT)
        }
    }

    override fun showEvents(listEvent: List<Event>) {
        listEvent?.let {
            empty_search_match_data.visibility = View.GONE
            matchAdapter.addEventsToList(listEvent)
        }
    }

    override fun showLoading() {
        swipe_refresh_search_match.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_search_match.isRefreshing = false
    }
    override fun onDestroyView() {
        presenterMatch.onDetach()
        super.onDestroyView()
    }
}