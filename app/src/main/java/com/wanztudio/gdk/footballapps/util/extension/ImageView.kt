package com.wanztudio.gdk.footballapps.util.extension

import android.widget.ImageView
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.util.GlideApp

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.util.extension
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

internal fun ImageView.loadImage(url: String) {
    GlideApp.with(this.context)
            .load(url)
            .placeholder(R.drawable.image_placeholder)
            .centerCrop()
            .into(this)
}