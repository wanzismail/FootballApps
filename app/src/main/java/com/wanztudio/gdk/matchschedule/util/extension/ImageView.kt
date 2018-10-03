package com.wanztudio.gdk.matchschedule.util.extension

import android.graphics.Bitmap
import android.widget.ImageView
import com.wanztudio.gdk.matchschedule.util.GlideApp

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.util.extension
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

internal fun ImageView.loadImage(url: String) {
    GlideApp.with(this.context)
            .load(url)
            .centerCrop()
            .into(this)
}