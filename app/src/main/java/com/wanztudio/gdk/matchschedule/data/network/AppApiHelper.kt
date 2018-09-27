package com.wanztudio.gdk.matchschedule.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

class AppApiHelper @Inject constructor(private val apiHeader: ApiHeader) : ApiHelper {

    override fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                    .addHeaders(apiHeader.publicApiHeader)
                    .addBodyParameter(request)
                    .build()
                    .getObjectObservable(LoginResponse::class.java)

    override fun performLogoutApiCall(): Observable<LogoutResponse> =
            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                    .addHeaders(apiHeader.protectedApiHeader)
                    .build()
                    .getObjectObservable(LogoutResponse::class.java)

}