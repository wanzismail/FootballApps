package com.wanztudio.gdk.footballapps.ui.main.matches.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R.layout.list_item_match
import com.wanztudio.gdk.footballapps.data.network.Event
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.DateUtils
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_match.*
import org.jetbrains.anko.intentFor
import java.util.*
import android.provider.CalendarContract.Events
import android.provider.CalendarContract
import android.content.Intent
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view.DetailMatchActivity


/**
 * For LEARNING
 * Created by Ridwan Ismail on 28 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.matches.adapter
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class MatchAdapter(private val context: Activity, private val items: MutableList<Event>)
    : RecyclerView.Adapter<MatchAdapter.ScheduleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder
            = ScheduleViewHolder(LayoutInflater.from(context).inflate(list_item_match, parent, false))

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    internal fun addEventsToList(events: List<Event>) {
        this.items.clear();
        this.items.addAll(events)
        notifyDataSetChanged()
    }

    inner class ScheduleViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(item : Event) {
            item_match_info_date.text = item.dateEvent?.let { DateUtils.convertToDayDate(item.dateEvent)}
            item_match_info_time.text = item.strTime?.let { DateUtils.convertToTime(item.strTime)}
            item_match_home_team_name.text = item.strHomeTeam
            item_match_home_score.text = item.intHomeScore?.let { item.intHomeScore.toString()}
            item_match_away_team_name.text = item.strAwayTeam
            item_match_away_score.text = item.intAwayScore?.let { item.intAwayScore.toString()}
            setItemClickListener(item)
        }

        private fun setItemClickListener(item: Event) {
            item_match_action_schedule.setOnClickListener {
                item?.let {
                    try {
                        var year =item.dateEvent.substring(0,4)
                        var month = item.dateEvent.substring(5,7)
                        var date = item.dateEvent.substring(8,10)
                        var hour= DateUtils.convertToTime(item.strTime).substring(0,2)
                        var minute= item.strTime.substring(3,5)

                        var fixtureCalendarBegin : Calendar = Calendar.getInstance()

                        fixtureCalendarBegin.set(year.toInt(),month.toInt(),date.toInt(),hour.toInt(),minute.toInt())

                        val intent = Intent(Intent.ACTION_INSERT)
                        intent.type = "vnd.android.cursor.item/event"

                        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, fixtureCalendarBegin.timeInMillis)
                        intent.putExtra(Events.TITLE, item.strHomeTeam+" VS "+ item.strAwayTeam)
                        intent.putExtra(Events.DESCRIPTION, item.strDescriptionEN)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

                        context.startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            item_match_main_action.setOnClickListener {
                item?.let {
                    try {
                        context.startActivity(context.intentFor<DetailMatchActivity>(Constants.EXTRA_EVENT_ID to item.idEvent)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

            }
        }
    }


}