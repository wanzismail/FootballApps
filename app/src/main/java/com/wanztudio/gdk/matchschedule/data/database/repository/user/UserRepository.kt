package com.wanztudio.gdk.matchschedule.data.database.repository.user

import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

class UserRepository @Inject internal constructor(private val userDao: UserDao) : UserRepo {

    override fun isUserRepoEmpty(): Observable<Boolean> = Observable.fromCallable({ userDao.loadAll().isEmpty() })

    override fun insertUser(users: List<User>): Observable<Boolean> {
        userDao.insertAll(users)
        return Observable.just(true)
    }

    override fun loadUser(): Observable<List<User>> = Observable.fromCallable({ userDao.loadAll() })
}


