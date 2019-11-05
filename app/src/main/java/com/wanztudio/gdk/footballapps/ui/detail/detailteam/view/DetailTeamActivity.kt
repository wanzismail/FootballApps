package com.wanztudio.gdk.footballapps.ui.detail.detailteam.view

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.data.database.database
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteTeam
import com.wanztudio.gdk.footballapps.ui.base.view.BaseActivity
import com.wanztudio.gdk.footballapps.ui.base.view.BaseViewPagerAdapter
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.overview.view.TeamOverviewFragment
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.player.view.TeamPlayerFragment
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.GlideApp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_detail_team.*
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
 * com.wanztudio.gdk.footballapps.ui.detail.detailteam.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class DetailTeamActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var idClub: String
    private lateinit var urlClubLogo: String
    private lateinit var strClubName: String
    private lateinit var strClubStadium: String
    private lateinit var intFormedYear: String
    private lateinit var strDescription: String

    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false


    internal lateinit var teamPagerAdapter: BaseViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_team)

        setSupportActionBar(detail_team_toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        val intent = intent
        idClub = intent.getStringExtra(Constants.EXTRA_TEAM_ID)
        strClubName = intent.getStringExtra(Constants.EXTRA_TEAM_NAME)
        urlClubLogo = intent.getStringExtra(Constants.EXTRA_TEAM_LOGO)
        strClubStadium = intent.getStringExtra(Constants.EXTRA_TEAM_STADIUM)
        intFormedYear = intent.getStringExtra(Constants.EXTRA_TEAM_YEAR)
        strDescription = intent.getStringExtra(Constants.EXTRA_TEAM_DESC)

        GlideApp.with(this).load(urlClubLogo).into(detail_team_img_club)
        detail_team_name_club.text = strClubName
        detail_team_stadium_club.text = strClubStadium
        detail_team_year_club.text = intFormedYear

        checkFavoriteState()
        setUpPagerAdapter()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }


    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    private  fun setUpPagerAdapter() {
        val fragments = listOf(TeamOverviewFragment.newInstance(strDescription), TeamPlayerFragment.newInstance(idClub))
        val titles = listOf(R.string.menu_overview, R.string.menu_player)

        teamPagerAdapter = BaseViewPagerAdapter(this, supportFragmentManager, fragments, titles)

        detail_team_viewpager.adapter = teamPagerAdapter
        detail_team_viewpager.offscreenPageLimit = 2
        detail_team_tabs.setupWithViewPager(detail_team_viewpager)
    }

    private fun checkFavoriteState() {
        try {
            database.use {
                val result = select(FavoriteTeam.TABLE_FAVORITE_TEAMS)
                        .whereArgs("(ID_TEAM = {id})",
                                "id" to idClub)
                val favorite = result.parseList(classParser<FavoriteTeam>())
                if (!favorite.isEmpty()) isFavorite = true
            }
        } catch (e: SQLiteConstraintException) {
            println("Error Getting data from database: ${e.message}")
        }
    }

    private fun addToFavorite() {
        try {
            database.use {
                insert(FavoriteTeam.TABLE_FAVORITE_TEAMS,
                        FavoriteTeam.ID_TEAM to idClub,
                        FavoriteTeam.TEAM_NAME to strClubName,
                        FavoriteTeam.TEAM_LOGO_URL to urlClubLogo,
                        FavoriteTeam.TEAM_STADIUM to strClubStadium,
                        FavoriteTeam.TEAM_YEAR to intFormedYear,
                        FavoriteTeam.TEAM_DESCRIPTION to  strDescription)
            }

            detail_team_img_club.snackbar(R.string.info_add_favorite)
        } catch (e: SQLiteConstraintException) {
            println("Error while inserting data to database: ${e.message}")
            Log.getStackTraceString(e)
        }
    }

    private fun removeFromFavorite() {
        try {
            database.use {
                delete(FavoriteTeam.TABLE_FAVORITE_TEAMS, "(ID_TEAM = {id})", "id" to idClub)
            }
            detail_team_img_club.snackbar(R.string.info_remove_favorite)
        } catch (e: SQLiteConstraintException) {
            println("Error while Deleting data from database: ${e.message}")
            Log.getStackTraceString(e)
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_favorite -> {
                if (::idClub.isInitialized || ::strClubName.isInitialized || ::urlClubLogo.isInitialized) {
                    if (isFavorite) removeFromFavorite() else addToFavorite()
                    isFavorite = !isFavorite
                    setFavorite()
                } else {
                    Toast.makeText(this, getString(R.string.info_wait), Toast.LENGTH_SHORT).show()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}