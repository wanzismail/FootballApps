package com.wanztudio.gdk.matchschedule.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.matchschedule.R.layout.list_item_schedule
import com.wanztudio.gdk.matchschedule.data.network.Event
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_schedule.*


/**
 * For LEARNING
 * Created by Ridwan Ismail on 28 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class ScheduleAdapter(private val context: Context, private val items: List<Event>, private val listener: (Event) -> Unit)
    : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder
            = ScheduleViewHolder(LayoutInflater.from(context).inflate(list_item_schedule, parent, false))

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ScheduleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {
        
        fun bindItem(item : Event, listener: (Event) -> Unit) {
            home_team_name.text = item.strHomeTeam
            home_score.text = item.intHomeScore.toString()
            away_team_name.text = item.strAwayTeam
            away_score.text = item.intAwayScore.toString()
            containerView.setOnClickListener { listener(item) }
        }
    }
}