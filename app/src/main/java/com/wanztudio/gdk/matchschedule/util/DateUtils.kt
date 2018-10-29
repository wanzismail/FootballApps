package com.wanztudio.gdk.matchschedule.util

import android.util.Log
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.util
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

object DateUtils {

    fun convert(date : String): String {
        try {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val newDateFormat =  SimpleDateFormat("EEEE, dd MMMM yyyy")
            return newDateFormat.format(dateFormat.parse(date))
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return ""
    }
}