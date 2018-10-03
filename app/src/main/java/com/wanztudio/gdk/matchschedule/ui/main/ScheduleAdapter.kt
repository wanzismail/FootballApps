package com.wanztudio.gdk.matchschedule.ui.main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.matchschedule.R.layout.list_item_schedule
import com.wanztudio.gdk.matchschedule.data.network.Event
import com.wanztudio.gdk.matchschedule.ui.detail.view.DetailActivity
import com.wanztudio.gdk.matchschedule.util.Constants
import com.wanztudio.gdk.matchschedule.util.DateUtils
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_schedule.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity


/**
 * For LEARNING
 * Created by Ridwan Ismail on 28 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.main
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class ScheduleAdapter(private val context: Context, private val items: MutableList<Event>)
    : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder
            = ScheduleViewHolder(LayoutInflater.from(context).inflate(list_item_schedule, parent, false))

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    internal fun addEventsToList(events: List<Event>) {
        this.items.addAll(events)
        notifyDataSetChanged()
    }

    inner class ScheduleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {
        
        fun bindItem(item : Event) {
            info_date.text = item.dateEvent?.let { DateUtils.convert(item.dateEvent)}
            home_team_name.text = item.strHomeTeam
            home_score.text = item.intHomeScore?.let { item.intHomeScore.toString()}
            away_team_name.text = item.strAwayTeam
            away_score.text = item.intAwayScore?.let { item.intAwayScore.toString()}
            setItemClickListener(item)
        }

        private fun setItemClickListener(item: Event) {
            itemView.setOnClickListener {
                item?.let {
                    try {
                        context.startActivity(context.intentFor<DetailActivity>(Constants.EXTRA_EVENT to item)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

            }
        }
    }
}