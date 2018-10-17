package com.wanztudio.gdk.matchschedule.ui.main.prev.view

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
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.PrevMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.presenter.PrevMVPPresenter
import com.wanztudio.gdk.matchschedule.util.Constants
import com.wanztudio.gdk.matchschedule.util.NetworkUtils
import kotlinx.android.synthetic.main.fragment_schedule_prev.*
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

class PrevFragment : BaseFragment(), PrevMVPView {

    internal val TAG = "PrevFragment"

    companion object {

        fun newInstance(): PrevFragment {
            return PrevFragment()
        }
    }

    @Inject
    internal lateinit var scheduleAdapter: ScheduleAdapter
    @Inject
    internal lateinit var layoutManager: LinearLayoutManager
    @Inject
    internal lateinit var mPresenter: PrevMVPPresenter<PrevMVPView, PrevMVPInteractor>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.fragment_schedule_prev, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mPresenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        schedule_prev_recycler.layoutManager = layoutManager
        schedule_prev_recycler.itemAnimator = DefaultItemAnimator()
        schedule_prev_recycler.setHasFixedSize(true)
        schedule_prev_recycler.adapter = scheduleAdapter

        swipe_refresh_prev.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.colorPrimary))
        swipe_refresh_prev.setOnRefreshListener {
            getListEvent()
        }

        getListEvent()
    }

    fun getListEvent() {
        if (NetworkUtils.isNetworkAvailable(requireContext())) {
            mPresenter.getPrevSchedule(Constants.ID_LEAGUE)
        } else {
            Toast.makeText(context, getString(R.string.message_no_network), Toast.LENGTH_SHORT)
        }
    }

    override fun showEvents(listEvent: List<Event>) {
        listEvent?.let{
            empty_prev_data.visibility = View.GONE
            scheduleAdapter.addEventsToList(listEvent)
        }
    }

    override fun showLoading() {
        swipe_refresh_prev.isRefreshing = true
    }

    override fun hideLoading() {
        swipe_refresh_prev.isRefreshing = false
    }

    override fun onDestroyView() {
        mPresenter.onDetach()
        super.onDestroyView()
    }
}
