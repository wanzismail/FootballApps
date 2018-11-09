package com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R.layout.list_item_player
import com.wanztudio.gdk.footballapps.data.network.Player
import com.wanztudio.gdk.footballapps.ui.detail.detailplayer.view.DetailPlayerActivity
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.extension.loadImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_player.*
import org.jetbrains.anko.intentFor


/**
 * For LEARNING
 * Created by Ridwan Ismail on 28 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.adapter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class TeamPlayerAdapter(private val context: Context, private val items: MutableList<Player>)
    : RecyclerView.Adapter<TeamPlayerAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder = PlayerViewHolder(LayoutInflater.from(context).inflate(list_item_player, parent, false))

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    internal fun addPlayersToList(item: List<Player>) {
        this.items.clear();
        this.items.addAll(item)
        notifyDataSetChanged()
    }

    inner class PlayerViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(item: Player) {
            item_player_name.text = item.strPlayerName?.let { item.strPlayerName }
            item.strCutout?.let { item_player_photo.loadImage(it) }
            setItemClickListener(item)
        }

        private fun setItemClickListener(item: Player) {
            itemView.setOnClickListener {
                item?.let {
                    try {
                        context.startActivity(context.intentFor<DetailPlayerActivity>(
                                Constants.EXTRA_PLAYER_NAME to item.strPlayerName,
                                Constants.EXTRA_PLAYER_FANART to item.strFanart1,
                                Constants.EXTRA_PLAYER_POSITION to item.strPosition,
                                Constants.EXTRA_PLAYER_HEIGHT to item.strHeight,
                                Constants.EXTRA_PLAYER_WEIGHT to item.strWeight,
                                Constants.EXTRA_PLAYER_DESCRIPTION to item.strDescriptionEN)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }
}