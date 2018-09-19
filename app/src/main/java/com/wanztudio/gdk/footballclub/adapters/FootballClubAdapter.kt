package com.wanztudio.gdk.footballclub.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.wanztudio.gdk.footballclub.R
import com.wanztudio.gdk.footballclub.models.ClubItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_football_club.*
import org.jetbrains.anko.*


/**
 * For LEARNING
 * Created by Ridwan Ismail on 01 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL CLUB
 * com.wanztudio.gdk.footballclub.adapters
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class FootballAppAdapter(private val context: Context, private val items: List<ClubItem>, private val listener: (ClubItem) -> Unit)
    : RecyclerView.Adapter<FootballAppAdapter.ClubViewHolder>() {

//  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//         ViewHolder(LayoutInflater.from(context).inflate(list_item_football_club, parent, false))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubViewHolder {
        return ClubViewHolder(ClubItemUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ClubViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ClubItemUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui) {
                linearLayout {
                    padding = dip(16)
                    lparams(width = matchParent, height = wrapContent)
                    orientation = LinearLayout.HORIZONTAL
                    imageView(R.drawable.img_acm) {
                        id = R.id.image
                    }.lparams(width = dip(50), height = dip(50))
                    textView {
                        id = R.id.name
                        textSize = 14f
                    }.lparams(width = matchParent) {
                        margin = dip(10)
                        gravity = Gravity.CENTER_VERTICAL
                    }
                }
            }
        }
    }

    class ClubViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(items: ClubItem, listener: (ClubItem) -> Unit) {
            name.text = items.name
            Glide.with(containerView).load(items.image).into(image)
            containerView.setOnClickListener { listener(items) }
        }
    }
}