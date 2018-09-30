package com.wanztudio.gdk.matchschedule.ui.main.prev.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.data.network.Event
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseFragment
import com.wanztudio.gdk.matchschedule.ui.main.ScheduleAdapter
import com.wanztudio.gdk.matchschedule.ui.main.prev.interactor.PrevMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.prev.presenter.PrevMVPPresenter
import com.wanztudio.gdk.matchschedule.util.Constants
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


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_schedule, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mPresenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        mPresenter.getPrevSchedule(Constants.ID_LEAGUE)
    }

    override fun showEvents(listEvent: List<Event?>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
