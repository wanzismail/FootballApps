package com.wanztudio.gdk.matchschedule.util

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Created by Ridwan Ismail on 23 September 2018
 * You can contact me at : iwanz@pm.me
 */

object ScreenUtils {

    fun getScreenWidth(context: Context): Int {
        val windowManager = context
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.let {
            val dm = DisplayMetrics()
            it.defaultDisplay.getMetrics(dm)
            return dm.widthPixels
        }
    }

    fun getScreenHeight(context: Context): Int {
        val windowManager = context
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.let {
            val dm = DisplayMetrics()
            it.defaultDisplay.getMetrics(dm)
            return dm.heightPixels
        }
    }
}
