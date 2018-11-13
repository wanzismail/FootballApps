package com.wanztudio.gdk.footballapps.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteMatch
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteTeam
import org.jetbrains.anko.db.*

/**
 * For LEARNING
 * Created by Ridwan Ismail on 04 November 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.data.database.model
 * or see link for more detail https://gitlab.com/iwanz98/FootballApps
 */


class DatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "football_fav.db", null, 1) {
    companion object {
        private var instance: DatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseOpenHelper {
            if (instance == null) {
                instance = DatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as DatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables

        db.createTable(FavoriteMatch.TABLE_FAVORITE_EVENTS, true,
                FavoriteMatch.ID_FAVORITE_MATCH to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteMatch.ID_EVENT to TEXT + UNIQUE,
                FavoriteMatch.HOME_TEAM to TEXT,
                FavoriteMatch.AWAY_TEAM to TEXT,
                FavoriteMatch.HOME_SCORE to TEXT,
                FavoriteMatch.AWAY_SCORE to TEXT,
                FavoriteMatch.EVENT_DATE to TEXT,
                FavoriteMatch.EVENT_TIME to TEXT,
                FavoriteMatch.EVENT_DESC to TEXT)

        db.createTable(FavoriteTeam.TABLE_FAVORITE_TEAMS,true,
                FavoriteTeam.ID_FAVORITE_TEAM to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteTeam.ID_TEAM to TEXT + UNIQUE,
                FavoriteTeam.TEAM_NAME to TEXT,
                FavoriteTeam.TEAM_LOGO_URL to TEXT,
                FavoriteTeam.TEAM_STADIUM to TEXT,
                FavoriteTeam.TEAM_YEAR to TEXT,
                FavoriteTeam.TEAM_DESCRIPTION  to TEXT)

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(FavoriteMatch.TABLE_FAVORITE_EVENTS, true)
        db.dropTable(FavoriteTeam.TABLE_FAVORITE_TEAMS, true)
    }
}

// Access property for Context
val Context.database: DatabaseOpenHelper
    get() = DatabaseOpenHelper.getInstance(applicationContext)