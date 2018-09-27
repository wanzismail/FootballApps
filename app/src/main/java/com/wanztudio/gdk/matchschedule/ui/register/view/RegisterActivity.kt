package com.wanztudio.gdk.matchschedule.ui.login.view

import android.os.Bundle
import com.wanztudio.framework.mvp.ui.register.view.RegisterMVPView
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseActivity
import com.wanztudio.gdk.matchschedule.ui.register.interactor.RegisterMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.register.presenter.RegisterMVPPresenter
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

class RegisterActivity : BaseActivity(), RegisterMVPView {

    @Inject
    internal lateinit var mPresenter: RegisterMVPPresenter<RegisterMVPView, RegisterMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mPresenter.onAttach(this)
    }

    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun onFragmentAttached() {
    }
}