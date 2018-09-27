package com.wanztudio.gdk.matchschedule.ui.main.second.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseFragment
import com.wanztudio.gdk.matchschedule.ui.main.second.interactor.SecondMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.second.presenter.SecondMVPPresenter
import javax.inject.Inject


/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

class SecondFragment : BaseFragment(), SecondMVPView {

    companion object {

        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    @Inject
    internal lateinit var mPresenter: SecondMVPPresenter<SecondMVPView, SecondMVPInteractor>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_first, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mPresenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setUp() {
        mPresenter.onViewPrepared()
    }

    override fun onDestroyView() {
        mPresenter.onDetach()
        super.onDestroyView()
    }
}