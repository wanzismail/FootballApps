package com.wanztudio.gdk.matchschedule.ui.main.next.view

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.data.network.Event
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseFragment
import com.wanztudio.gdk.matchschedule.ui.main.ScheduleAdapter
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.DetailMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.NextMVPPresenter
import com.wanztudio.gdk.matchschedule.util.Constants
import com.wanztudio.gdk.matchschedule.util.NetworkUtils
import kotlinx.android.synthetic.main.fragment_schedule.*
import javax.inject.Inject


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main.next.view
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class NextFragment : BaseFragment(), NextMVPView {

    internal val TAG = "NextFragment"

    companion object {

        fun newInstance(): NextFragment {
            return NextFragment()
        }
    }
    @Inject
    internal lateinit var scheduleAdapter: ScheduleAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var mPresenter: NextMVPPresenter<NextMVPView, NextMVPInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_schedule, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mPresenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        schedule_recycler.layoutManager = layoutManager
        schedule_recycler.itemAnimator = DefaultItemAnimator()
        schedule_recycler.setHasFixedSize(true)
        schedule_recycler.adapter = scheduleAdapter

        swipe_refresh.setColorSchemeColors(ContextCompat.getColor(requireContext(),R.color.colorPrimary))
        swipe_refresh.setOnRefreshListener {
            getListEvent()
        }

        getListEvent()
    }

    fun getListEvent() {
        if (NetworkUtils.isNetworkAvailable(requireContext())) {
            mPresenter.getNextSchedule(Constants.ID_LEAGUE)
            showLoading()
        } else {
            Toast.makeText(context, getString(R.string.message_no_network), Toast.LENGTH_SHORT)
        }
    }

    override fun showEvents(listEvent: List<Event>) {
        hideLoading()
        listEvent?.let {
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
    override fun onDestroyView() {
        mPresenter.onDetach()
        super.onDestroyView()
    }
}