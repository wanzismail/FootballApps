package com.wanztudio.gdk.footballapps.ui.detail.detailplayer.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.extension.loadImage
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_detail_player.*


/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.detail.detailplayer.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class DetailPlayerActivity : AppCompatActivity() {

    private var playerName: String? = null
    private var playerHeight: String? = null
    private var playerWeight: String? = null
    private var playerPosition: String? = null
    private var playerFanart: String? = null
    private var playerDescription: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_player)

        setSupportActionBar(detail_player_toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        playerName = intent.getStringExtra(Constants.EXTRA_PLAYER_NAME)
        playerHeight = intent.getStringExtra(Constants.EXTRA_PLAYER_HEIGHT)
        playerWeight = intent.getStringExtra(Constants.EXTRA_PLAYER_WEIGHT)
        playerPosition = intent.getStringExtra(Constants.EXTRA_PLAYER_POSITION)
        playerFanart = intent.getStringExtra(Constants.EXTRA_PLAYER_FANART)
        playerDescription = intent.getStringExtra(Constants.EXTRA_PLAYER_DESCRIPTION)


        supportActionBar?.title = playerName
        detail_player_info_height.text = playerHeight
        detail_player_info_weight.text = playerWeight
        playerFanart?.let { detail_player_img_fanart.loadImage(it)}
        detail_player_info_position.text = playerPosition
        detail_player_info_description.text = playerDescription

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}