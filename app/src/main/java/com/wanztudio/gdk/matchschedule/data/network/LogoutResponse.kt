package com.wanztudio.gdk.matchschedule.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

data class LogoutResponse internal constructor(@Expose
                                               @SerializedName("status_code")
                                               private var statusCode: String? = null,
                                               @Expose
                                               @SerializedName("message")
                                               private var message: String? = null)

