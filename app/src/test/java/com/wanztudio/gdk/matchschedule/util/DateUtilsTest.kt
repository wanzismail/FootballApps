package com.wanztudio.gdk.matchschedule.util

import com.wanztudio.gdk.matchschedule.util.DateUtils.convert
import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat

/**
 * For Bridge Technology Services
 * Created by Ridwan Ismail on 10 October 2018
 * You can contact me at : ridwan.ismail@bridgetech.co.id
 * -------------------------------------------------
 * AHA
 * com.wanztudio.gdk.matchschedule.util
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

class DateUtilsTest {

    @Test
    fun testConvert() {
        assertEquals("Thursday, 15 January 1998", convert("1998-01-15"))
    }
}