package com.wanztudio.gdk.footballapps.data.network

import com.google.gson.annotations.SerializedName


/**
 * For Bridge Technology Services
 * Created by Ridwan Ismail on 09 November 2018
 * You can contact me at : ridwan.ismail@bridgetech.co.id
 * -------------------------------------------------
 * AHA
 * com.wanztudio.gdk.footballapps.data.network
 * or see link for more detail https://gitlab.com/dev-bridgetech-aha/aha-mobile-android
 */

data class SearchMatchResponse(

        @SerializedName("event")
        val events: List<Event>
)