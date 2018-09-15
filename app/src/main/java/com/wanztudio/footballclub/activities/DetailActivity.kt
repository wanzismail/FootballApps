package com.wanztudio.footballclub.activities

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.wanztudio.footballclub.R
import kotlinx.android.synthetic.main.list_item_football_club.*
import org.jetbrains.anko.*


/**
 * For LEARNING
 * Created by Ridwan Ismail on 01 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL CLUB
 * com.wanztudio.footballclub.activities
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class DetailActivity : AppCompatActivity() {

    private var image: Int = 0
    private var name: String = ""
    private var info: String = ""

    private lateinit var logoClub: ImageView
    private lateinit var nameClub: TextView
    private lateinit var infoClub: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{
            padding = dip(16)
            logoClub = imageView(R.drawable.img_acm).
                    lparams(width= dip(50), height = dip(50)) {
                        margin = dip(10)
                        gravity = Gravity.CENTER
                    }
            nameClub = textView() {
                textSize = 14f
                gravity = Gravity.CENTER
                typeface = Typeface.DEFAULT_BOLD
            }.lparams(width = matchParent)
            infoClub = textView(){
                textSize = 12f
                typeface = Typeface.DEFAULT
            }.lparams(width = matchParent){
                topMargin = dip(15)
            }
        }

        val intent = intent
        image = intent.getIntExtra("image", 0)
        name = intent.getStringExtra("name")
        info = intent.getStringExtra("info")

        Glide.with(this).load(image).into(logoClub)
        nameClub.text = name
        infoClub.text = info
    }

}
