package com.wanztudio.gdk.footballapps.data.network

import com.wanztudio.gdk.footballapps.util.Constants
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

/**
 * For Bridge Technology Services
 * Created by Ridwan Ismail on 04 November 2018
 * You can contact me at : ridwan.ismail@bridgetech.co.id
 * -------------------------------------------------
 * AHA
 * com.wanztudio.gdk.footballapps.data.network
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class AppApiHelperTest {

    @Test
    fun getLastMatch() {
        val apiHelper = Mockito.mock(AppApiHelper::class.java)
        apiHelper.getLastMatch(Constants.ID_LEAGUE)
        Mockito.verify(apiHelper).getLastMatch(Constants.ID_LEAGUE)
    }

    @Test
    fun getNextMatch() {
        val apiHelper = Mockito.mock(AppApiHelper::class.java)
        apiHelper.getNextMatch(Constants.ID_LEAGUE)
        Mockito.verify(apiHelper).getNextMatch(Constants.ID_LEAGUE)
    }

    @Test
    fun getDetailEvent() {
        val apiHelper = Mockito.mock(AppApiHelper::class.java)
        apiHelper.getDetailEvent(Constants.ID_EVENT)
        Mockito.verify(apiHelper).getDetailEvent(Constants.ID_EVENT)
    }

    @Test
    fun getTeam() {
        val apiHelper = Mockito.mock(AppApiHelper::class.java)
        apiHelper.getTeam(Constants.ID_TEAM)
        Mockito.verify(apiHelper).getTeam(Constants.ID_TEAM)
    }

    @Test
    fun getTeamDetail() {
        val apiHelper = Mockito.mock(AppApiHelper::class.java)
        apiHelper.getTeamDetail(Constants.ID_TEAM)
        Mockito.verify(apiHelper).getTeamDetail(Constants.ID_TEAM)
    }

    @Test
    fun getTeamPlayer() {
        val apiHelper= Mockito.mock(AppApiHelper::class.java)
        apiHelper.getTeamPlayer(Constants.ID_PLAYER)
        Mockito.verify(apiHelper).getTeamPlayer(Constants.ID_PLAYER)
    }

    @Test
    fun searchMatch() {
        val apiHelper= Mockito.mock(AppApiHelper::class.java)
        apiHelper.searchMatch(Constants.KEYWORD)
        Mockito.verify(apiHelper).searchMatch(Constants.KEYWORD)
    }

    @Test
    fun searchTeam() {
        val apiHelper= Mockito.mock(AppApiHelper::class.java)
        apiHelper.searchTeam(Constants.KEYWORD)
        Mockito.verify(apiHelper).searchTeam(Constants.KEYWORD)
    }
}