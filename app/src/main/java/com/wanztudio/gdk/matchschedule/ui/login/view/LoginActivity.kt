package com.wanztudio.gdk.matchschedule.ui.login.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.wanztudio.framework.mvp.ui.login.view.LoginMVPView
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseActivity
import com.wanztudio.gdk.matchschedule.ui.login.interactor.LoginMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.login.presenter.LoginMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.main.view.MainActivity
import com.wanztudio.gdk.matchschedule.util.Constants
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

class LoginActivity : BaseActivity(), LoginMVPView {

    @Inject
    internal lateinit var mPresenter: LoginMVPPresenter<LoginMVPView, LoginMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
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

    override fun showValidationMessage(errorCode: Int) {
        when (errorCode) {
            Constants.EMPTY_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.empty_email_error_message), Toast.LENGTH_LONG).show()
            Constants.INVALID_EMAIL_ERROR -> Toast.makeText(this, getString(R.string.invalid_email_error_message), Toast.LENGTH_LONG).show()
            Constants.EMPTY_PASSWORD_ERROR -> Toast.makeText(this, getString(R.string.empty_password_error_message), Toast.LENGTH_LONG).show()
            Constants.LOGIN_FAILURE -> Toast.makeText(this, getString(R.string.login_failure), Toast.LENGTH_LONG).show()
        }
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}