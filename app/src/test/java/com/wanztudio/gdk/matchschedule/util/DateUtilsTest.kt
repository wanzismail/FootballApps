package com.wanztudio.gdk.matchschedule.util

import com.wanztudio.gdk.matchschedule.util.DateUtils.convert
import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat

/**
 * For LEARNING
 * Created by Ridwan Ismail on 14 October 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.util
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class DateUtilsTest {

    @Test
    fun testConvert() {
        assertEquals("Thursday, 15 January 1998", convert("1998-01-15"))
    }
}