package com.wanztudio.gdk.matchschedule.ui.main.first.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseFragment
import com.wanztudio.gdk.matchschedule.ui.main.first.interactor.FirstMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.first.presenter.FirstMVPPresenter
import javax.inject.Inject


/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

class FirstFragment : BaseFragment(), FirstMVPView {

    companion object {

        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }

    @Inject
    internal lateinit var presenter: FirstMVPPresenter<FirstMVPView, FirstMVPInteractor>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_first, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        presenter.onViewPrepared()
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }
}
