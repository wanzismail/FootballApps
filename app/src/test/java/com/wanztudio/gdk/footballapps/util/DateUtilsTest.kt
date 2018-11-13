package com.wanztudio.gdk.footballapps.util

import org.junit.Test

import org.junit.Assert.*

/**
 * For Bridge Technology Services
 * Created by Ridwan Ismail on 04 November 2018
 * You can contact me at : ridwan.ismail@bridgetech.co.id
 * -------------------------------------------------
 * AHA
 * com.wanztudio.gdk.footballapps.util
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class DateUtilsTest {

    @Test
    fun convertToDayDate() {
        assertEquals("Thursday, 15 Jan 1998",  DateUtils.convertToDayDate("1998-01-15"))
    }
}