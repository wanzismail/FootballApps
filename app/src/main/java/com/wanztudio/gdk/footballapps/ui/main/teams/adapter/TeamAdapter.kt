package com.wanztudio.gdk.footballapps.ui.main.teams.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R.layout.list_item_team
import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.view.DetailTeamActivity
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.extension.loadImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_team.*
import org.jetbrains.anko.intentFor


/**
 * For LEARNING
 * Created by Ridwan Ismail on 28 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.teams.adapter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class TeamAdapter(private val context: Context, private val items: MutableList<Team>)
    : RecyclerView.Adapter<TeamAdapter.ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder = ScheduleViewHolder(LayoutInflater.from(context).inflate(list_item_team, parent, false))

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    internal fun addTeamsToList(item: List<Team>) {
        this.items.clear();
        this.items.addAll(item)
        notifyDataSetChanged()
    }

    inner class ScheduleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(item: Team) {
            item_team_name.text = item.strTeam?.let { item.strTeam }
            item.strTeamBadge?.let { item_team_logo.loadImage(it) }
            setItemClickListener(item)
        }

        private fun setItemClickListener(item: Team) {
            itemView.setOnClickListener {
                item?.let {
                    try {
                        context.startActivity(context.intentFor<DetailTeamActivity>(
                                Constants.EXTRA_TEAM_ID to item.idTeam,
                                Constants.EXTRA_TEAM_NAME to item.strTeam,
                                Constants.EXTRA_TEAM_LOGO to item.strTeamBadge,
                                Constants.EXTRA_TEAM_STADIUM to item.strStadium,
                                Constants.EXTRA_TEAM_YEAR to item.intFormedYear,
                                Constants.EXTRA_TEAM_DESC to item.strDescriptionEN)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

            }
        }
    }
}