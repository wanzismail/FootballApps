package com.wanztudio.gdk.footballapps.ui.main.favorites.adapter

import android.content.Context
import android.content.Intent
import android.provider.CalendarContract
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R.layout.list_item_match
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteMatch
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view.DetailMatchActivity
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.DateUtils
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_match.*
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

class FavoriteMatchAdapter(private val context: Context, private val items: MutableList<FavoriteMatch>)
    : RecyclerView.Adapter<FavoriteMatchAdapter.FavoriteMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMatchViewHolder
            = FavoriteMatchViewHolder(LayoutInflater.from(context).inflate(list_item_match, parent, false))

    override fun onBindViewHolder(holder: FavoriteMatchViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    internal fun updateFavoriteMatchsToList(events: List<FavoriteMatch>) {
        this.items.clear();
        this.items.addAll(events)
        notifyDataSetChanged()
    }

    inner class FavoriteMatchViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(item: FavoriteMatch) {
            item_match_info_date.text = item.eventDate?.let { DateUtils.convertToDayDate(item.eventDate) }
            item_match_info_time.text = item.eventTime?.let { DateUtils.convertToTime(item.eventTime) }
            item_match_home_team_name.text = item.homeTeam
            item_match_home_score.text = item.homeScore?.let { item.homeScore.toString() }
            item_match_away_team_name.text = item.awayTeam
            item_match_away_score.text = item.awayScore?.let { item.awayScore.toString() }
            setItemClickListener(item)
        }

        private fun setItemClickListener(item: FavoriteMatch) {
            item_match_action_schedule.setOnClickListener {
                item?.let {
                    try {
                        var year = item.eventDate?.let { item.eventDate.substring(0, 4) }
                        var month = item.eventDate?.let { item.eventDate.substring(5, 7) }
                        var date = item.eventDate?.let { item.eventDate.substring(8, 10) }
                        var hour = item.eventTime?.let { DateUtils.convertToTime(item.eventTime).substring(0, 2) }
                        var minute = item.eventTime?.let { item.eventTime.substring(3, 5) }

                        var fixtureCalendarBegin: Calendar = Calendar.getInstance()

                        if (year != null && month != null && month != null && date != null && hour != null && minute != null)
                            fixtureCalendarBegin.set(year.toInt(), month.toInt(), date.toInt(), hour.toInt(), minute.toInt())

                        val intent = Intent(Intent.ACTION_INSERT)
                        intent.type = "vnd.android.cursor.item/event"

                        intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, fixtureCalendarBegin.timeInMillis)
                        intent.putExtra(CalendarContract.Events.TITLE, item.homeTeam + " VS " + item.awayTeam)
                        intent.putExtra(CalendarContract.Events.DESCRIPTION, item.description)
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