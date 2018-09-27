package com.wanztudio.gdk.matchschedule.data.database.repository.user

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Ridwan Ismail on 23/September/2018
 * You can contact me at : iwanz@pm.me
 */

@Entity(tableName = "user")
data class User(
        @Expose
        @PrimaryKey
        var id: Long,

        @Expose
        @SerializedName("name")
        @ColumnInfo(name = "name")
        var name: String,

        @Expose
        @SerializedName("url_photo")
        @ColumnInfo(name = "url_photo")
        var imgUrl: String?,

        @Expose
        @SerializedName("created_at")
        @ColumnInfo(name = "created_at")
        var createdAt: String?,

        @Expose
        @SerializedName("updated_at")
        @ColumnInfo(name = "updated_at")
        var updatedAt: String?

)