package com.wanztudio.gdk.matchschedule.data.network

import android.provider.SyncStateContract
import com.wanztudio.gdk.matchschedule.util.Constants
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

/**
 * For LEARNING
 * Created by Ridwan Ismail on 14 October 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.data.network
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class AppApiHelperTest {

    @Test
    fun getPrevSchedule() {
        val apiHelper= Mockito.mock(AppApiHelper::class.java)
        apiHelper.getPrevSchedule(Constants.ID_LEAGUE)
        Mockito.verify(apiHelper).getPrevSchedule(Constants.ID_LEAGUE)
    }

    @Test
    fun getNextSchedule() {
        val apiHelper= Mockito.mock(AppApiHelper::class.java)
        apiHelper.getNextSchedule(Constants.ID_LEAGUE)
        Mockito.verify(apiHelper).getNextSchedule(Constants.ID_LEAGUE)
    }

    @Test
    fun getDetailEvent() {
        val apiHelper= Mockito.mock(AppApiHelper::class.java)
        apiHelper.getDetailEvent(Constants.ID_EVENT)
        Mockito.verify(apiHelper).getDetailEvent(Constants.ID_EVENT)
    }

    @Test
    fun getTeamDetail() {
        val apiHelper= Mockito.mock(AppApiHelper::class.java)
        apiHelper.getTeamDetail(Constants.ID_TEAM)
        Mockito.verify(apiHelper).getTeamDetail(Constants.ID_TEAM)
    }
}