package com.wanztudio.footballclub.activities

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.wanztudio.footballclub.R.array.*
import com.wanztudio.footballclub.adapters.FootballClubAdapter
import com.wanztudio.footballclub.models.ClubItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * For Bridge Technology Services
 * Created by Ridwan Ismail on 01 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL CLUB
 * com.wanztudio.footballclub.activities
 * or see link for more detail https://github.com/iwanz98/FootballClub
 */
 
class MainActivity : AppCompatActivity() {

    var items: MutableList<ClubItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      setContentView(activity_main)
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
                    adapter= FootballClubAdapter(context, items){
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

        //Recycle the typed array
        image.recycle()
    }
}