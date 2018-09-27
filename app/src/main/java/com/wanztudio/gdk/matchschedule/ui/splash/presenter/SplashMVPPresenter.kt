package com.wanztudio.gdk.matchschedule.ui.splash.presenter

import com.wanztudio.gdk.matchschedule.ui.base.presenter.MVPPresenter
import com.wanztudio.gdk.matchschedule.ui.splash.interactor.SplashMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.splash.view.SplashMVPView

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

interface SplashMVPPresenter<V : SplashMVPView, I : SplashMVPInteractor> : MVPPresenter<V,I>