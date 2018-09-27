package com.wanztudio.gdk.matchschedule.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.wanztudio.gdk.matchschedule.data.database.repository.user.User
import com.wanztudio.gdk.matchschedule.data.database.repository.user.UserDao

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

@Database(entities = [(User::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}