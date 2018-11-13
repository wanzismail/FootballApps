package com.wanztudio.gdk.footballapps.util

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.util
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

object DateUtils {

    fun convertToDayDate(date: String): String {
        try {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val newDateFormat = SimpleDateFormat("EEEE, dd MMM yyyy")
            return newDateFormat.format(dateFormat.parse(date))
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return ""
    }

    fun convertToTime(date: String): String {
        try {
            val dateFormat = SimpleDateFormat("HH:mm:ss")
            val newDateFormat = SimpleDateFormat("HH:mm")
            val finalDate = date.split("+")[0]
            newDateFormat.timeZone = TimeZone.getTimeZone(getCurrentTimezoneOffset())
            return newDateFormat.format(dateFormat.parse(finalDate))
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return ""
    }

    fun getCurrentTimezoneOffset(): String {
        val tz = TimeZone.getDefault()
        val cal = GregorianCalendar.getInstance(tz)
        val offsetInMillis = tz.getOffset(cal.timeInMillis)

        var offset = String.format("%02d:%02d", Math.abs(offsetInMillis / 3600000), Math.abs(offsetInMillis / 60000 % 60))
        offset = "GMT" + (if (offsetInMillis >= 0) "+" else "-") + offset

        return offset
    }
}