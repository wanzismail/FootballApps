package com.wanztudio.gdk.footballapps.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * For LEARNING
 * Created by Ridwan Ismail on 04 November 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.data.network
 * or see link for more detail https://gitlab.com/iwanz98/FootballApps
 */

data class Player (

    @SerializedName("idPlayer")
    val playerID : String? = null,

    @SerializedName("strPlayer")
    val strPlayerName : String? = null,

    @SerializedName("strPosition")
    val strPosition : String? = null,

    @SerializedName("strCutout")
    val strCutout : String? = null,

    @SerializedName("strHeight")
    val strHeight : String? = null,

    @SerializedName("strWeight")
    val strWeight : String? = null,

    @SerializedName("strFanart1")
    val strFanart1 : String? = null,

    @SerializedName("strDescriptionEN")
    val strDescriptionEN : String? = null
)