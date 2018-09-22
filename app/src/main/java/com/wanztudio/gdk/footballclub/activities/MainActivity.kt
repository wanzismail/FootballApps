package com.wanztudio.gdk.footballclub.activities

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.wanztudio.gdk.footballclub.R.array.*
import com.wanztudio.gdk.footballclub.adapters.FootballAppAdapter
import com.wanztudio.gdk.footballclub.models.ClubItem
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * For LEARNING
 * Created by Ridwan Ismail on 01 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL CLUB
 * com.wanztudio.gdk.footballclub.activities
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */
 
class MainActivity : AppCompatActivity() {

    var items: MutableList<ClubItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()

        MainActivityUI(items).setContentView(this)
    }

    class MainActivityUI(val items: List<ClubItem>) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            relativeLayout{
                backgroundColor = Color.WHITE
                recyclerView {
                    val orientation = LinearLayoutManager.VERTICAL
                    layoutManager = LinearLayoutManager(context, orientation, true)
                    adapter= FootballAppAdapter(context, items){
                        startActivity<DetailActivity>("image" to it.image,
                                "name" to it.name, "info" to it.info)
                    }
                }.lparams(width = matchParent)
            }
        }
    }

    private fun initData(){
        val image = resources.obtainTypedArray(club_image)
        val name = resources.getStringArray(club_name)
        val info = resources.getStringArray(club_info)
        items.clear()
        for (i in name.indices)
            items.add(ClubItem(image.getResourceId(i, 0),name[i], info[i]))
        image.recycle()
    }
}