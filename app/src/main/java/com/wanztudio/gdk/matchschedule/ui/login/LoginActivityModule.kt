package com.wanztudio.gdk.matchschedule.ui.login

import com.wanztudio.framework.mvp.ui.login.view.LoginMVPView
import com.wanztudio.gdk.matchschedule.ui.login.interactor.LoginInteractor
import com.wanztudio.gdk.matchschedule.ui.login.interactor.LoginMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.login.presenter.LoginMVPPresenter
import com.wanztudio.gdk.matchschedule.ui.login.presenter.LoginPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginInteractor(interactor: LoginInteractor): LoginMVPInteractor = interactor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginMVPView, LoginMVPInteractor>)
            : LoginMVPPresenter<LoginMVPView, LoginMVPInteractor> = presenter

}