package com.wanztudio.gdk.footballapps.ui.main.favorites.adapter

import android.content.Context
import android.content.Intent
import android.provider.CalendarContract
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R.layout.list_item_match
import com.wanztudio.gdk.footballapps.R.layout.list_item_team
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteTeam
import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view.DetailMatchActivity
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.view.DetailTeamActivity
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.DateUtils
import com.wanztudio.gdk.footballapps.util.extension.loadImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_match.*
import kotlinx.android.synthetic.main.list_item_team.*
import org.jetbrains.anko.intentFor
import java.util.*


/**
 * For LEARNING
 * Created by Ridwan Ismail on 04 November 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.favorites.adapter
 * or see link for more detail https://gitlab.com/iwanz98/FootballApps
 */

class FavoriteTeamAdapter(private val context: Context, private val items: MutableList<FavoriteTeam>)
    : RecyclerView.Adapter<FavoriteTeamAdapter.FavoriteTeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTeamViewHolder
            = FavoriteTeamViewHolder(LayoutInflater.from(context).inflate(list_item_team, parent, false))

    override fun onBindViewHolder(holder: FavoriteTeamViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    internal fun updateFavoriteTeamsToList(events: List<FavoriteTeam>) {
        this.items.clear();
        this.items.addAll(events)
        notifyDataSetChanged()
    }

    inner class FavoriteTeamViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(item: FavoriteTeam) {
            item_team_name.text = item.teamName?.let { item.teamName }
            item.teamLogoUrl?.let { item_team_logo.loadImage(it) }
            setItemClickListener(item)
        }

        private fun setItemClickListener(item: FavoriteTeam) {
            itemView.setOnClickListener {
                item?.let {
                    try {
                        context.startActivity(context.intentFor<DetailTeamActivity>(
                                Constants.EXTRA_TEAM_ID to item.idTeam,
                                Constants.EXTRA_TEAM_NAME to item.teamName,
                                Constants.EXTRA_TEAM_LOGO to item.teamLogoUrl,
                                Constants.EXTRA_TEAM_STADIUM to item.teamStadium,
                                Constants.EXTRA_TEAM_YEAR to item.teamYear,
                                Constants.EXTRA_TEAM_DESC to item.teamDesc)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

            }
        }
    }
}