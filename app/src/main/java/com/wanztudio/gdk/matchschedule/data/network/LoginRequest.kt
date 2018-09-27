package com.wanztudio.gdk.matchschedule.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

class LoginRequest {

    data class ServerLoginRequest internal constructor(@Expose
                                                       @SerializedName("email") internal val email: String,
                                                       @Expose
                                                       @SerializedName("password") internal val password: String)
}