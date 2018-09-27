package com.wanztudio.gdk.matchschedule.ui.login.presenter

import com.wanztudio.framework.mvp.ui.login.view.LoginMVPView
import com.wanztudio.gdk.matchschedule.data.network.LoginResponse
import com.wanztudio.gdk.matchschedule.ui.base.presenter.BasePresenter
import com.wanztudio.gdk.matchschedule.ui.login.interactor.LoginMVPInteractor
import com.wanztudio.gdk.matchschedule.util.Constants
import com.wanztudio.gdk.matchschedule.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

class LoginPresenter<V : LoginMVPView, I : LoginMVPInteractor> @Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider, disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable), LoginMVPPresenter<V, I> {

    override fun onServerLoginClicked(email: String, password: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(Constants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(Constants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.let {
                    compositeDisposable.add(it.doServerLoginApiCall(email, password)
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe({ loginResponse ->
                                updateUserInSharedPref(loginResponse = loginResponse,
                                        loggedInMode = Constants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                                getView()?.openMainActivity()
                            }, { err -> println(err) }))
                }

            }
        }
    }

    private fun updateUserInSharedPref(loginResponse: LoginResponse,
                                       loggedInMode: Constants.LoggedInMode) =
            interactor?.updateUserInSharedPref(loginResponse, loggedInMode)


}