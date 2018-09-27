package com.wanztudio.gdk.matchschedule.data.database.repository.user

import io.reactivex.Observable

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

interface UserRepo {

    fun isUserRepoEmpty(): Observable<Boolean>

    fun insertUser(users: List<User>): Observable<Boolean>

    fun loadUser(): Observable<List<User>>
}