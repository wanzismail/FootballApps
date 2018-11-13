package com.wanztudio.gdk.footballapps.util

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset


/**
 * For LEARNING
 * Created by Ridwan Ismail on 02 November 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.util
 * or see link for more detail https://gitlab.com/iwanz98/FootballApps
 */

object WordUtils {

    private fun addNewLine(wordList: String): String {
        var newString = wordList.replace(";", ";\n")
        newString = " $newString"
        return newString
    }

    fun validateData(data: String?): String {
        val dataReturn = ""
        return if (data == null) {
            dataReturn
        } else addNewLine(data)
    }
}