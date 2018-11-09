package com.wanztudio.gdk.footballapps.ui.detail.detailplayer.view

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.service.autofill.CustomDescription
import android.service.autofill.FieldClassification
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.R.drawable.ic_add_to_favorites
import com.wanztudio.gdk.footballapps.R.drawable.ic_added_to_favorites
import com.wanztudio.gdk.footballapps.R.id.detail_team_toolbar
import com.wanztudio.gdk.footballapps.data.database.database
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteMatch
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteTeam
import com.wanztudio.gdk.footballapps.data.network.Event
import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.ui.base.view.BaseActivity
import com.wanztudio.gdk.footballapps.ui.base.view.BaseViewPagerAdapter
import com.wanztudio.gdk.footballapps.ui.detail.detailplayers.player.view.TeamPlayerFragment
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.view.TeamOverviewFragment
import com.wanztudio.gdk.footballapps.ui.main.favorites.view.FavoriteFragment
import com.wanztudio.gdk.footballapps.ui.main.matches.view.MatchFragment
import com.wanztudio.gdk.footballapps.ui.main.teams.view.TeamFragment
import com.wanztudio.gdk.footballapps.util.*
import com.wanztudio.gdk.footballapps.util.extension.loadImage
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_detail_match.*
import kotlinx.android.synthetic.main.activity_detail_player.*
import kotlinx.android.synthetic.main.activity_detail_team.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.mtrl_layout_snackbar_include.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.design.snackbar
import javax.inject.Inject


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