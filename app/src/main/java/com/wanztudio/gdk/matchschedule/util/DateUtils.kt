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
        var dateFormat = SimpleDateFormat("dd MMM yyyy HH:mm:ss Z")

        try {
            dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val formatedDate = dateFormat.parse(date)

            dateFormat  = SimpleDateFormat("EEEE, dd MMMM yyyy")
            return dateFormat.format(formatedDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return ""
    }
}