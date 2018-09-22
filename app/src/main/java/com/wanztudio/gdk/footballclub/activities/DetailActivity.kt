package com.wanztudio.gdk.footballclub.activities

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import com.bumptech.glide.Glide
import com.wanztudio.gdk.footballclub.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar


/**
 * For LEARNING
 * Created by Ridwan Ismail on 01 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL CLUB
 * com.wanztudio.gdk.footballclub.activities
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

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return false
    }

}
