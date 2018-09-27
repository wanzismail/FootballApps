package com.wanztudio.gdk.matchschedule.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

data class LoginResponse(@Expose
                         @SerializedName("status_code")
                         var statusCode: String? = null,

                         @Expose
                         @SerializedName("user_id")
                         var userId: Long? = null,

                         @Expose
                         @SerializedName("access_token")
                         var accessToken: String? = null,

                         @Expose
                         @SerializedName("user_name")
                         var userName: String? = null,

                         @Expose
                         @SerializedName("email")
                         var userEmail: String? = null,

                         @Expose
                         @SerializedName("profile_pic_url")
                         var profilePicUrl: String? = null,

                         @Expose
                         @SerializedName("message")
                         var message: String? = null)


