package com.wanztudio.gdk.matchschedule.ui.register.interactor

import com.wanztudio.gdk.matchschedule.data.network.ApiHelper
import com.wanztudio.gdk.matchschedule.data.preferences.PreferenceHelper
import com.wanztudio.gdk.matchschedule.ui.base.interactor.BaseInteractor
import javax.inject.Inject


/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

class RegisterInteractor @Inject internal constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(preferenceHelper, apiHelper), RegisterMVPInteractor {

}