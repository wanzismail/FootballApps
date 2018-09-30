package com.wanztudio.gdk.matchschedule.ui.main.next.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.data.network.Event
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseFragment
import com.wanztudio.gdk.matchschedule.ui.main.ScheduleAdapter
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.NextMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.NextMVPPresenter
import com.wanztudio.gdk.matchschedule.util.Constants
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
        mPresenter.getNextSchedule(Constants.ID_LEAGUE)
    }

    override fun showEvents(listEvent: List<Event?>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroyView() {
        mPresenter.onDetach()
        super.onDestroyView()
    }
}