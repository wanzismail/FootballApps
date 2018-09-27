package com.wanztudio.gdk.matchschedule.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.wanztudio.gdk.matchschedule.di.ApiKeyInfo
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

class ApiHeader @Inject constructor(internal val publicApiHeader: PublicApiHeader, internal val protectedApiHeader: ProtectedApiHeader) {

    class PublicApiHeader @Inject constructor(@ApiKeyInfo
                                              @Expose
                                              @SerializedName
                                              ("api_key") val apiKey: String)

    class ProtectedApiHeader @Inject constructor(@Expose
                                                 @SerializedName("api_key") val apiKey: String,
                                                 @Expose
                                                 @SerializedName("user_id") val userId: Long?,
                                                 @Expose
                                                 @SerializedName("access_token") val accessToken: String?)

}