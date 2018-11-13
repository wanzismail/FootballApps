package com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.R.id.*
import com.wanztudio.gdk.footballapps.data.database.database
import com.wanztudio.gdk.footballapps.data.database.model.FavoriteMatch
import com.wanztudio.gdk.footballapps.data.network.Event
import com.wanztudio.gdk.footballapps.data.network.Team
import com.wanztudio.gdk.footballapps.ui.base.view.BaseActivity
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.DetailMatchMVPInteractor
import com.wanztudio.gdk.footballapps.ui.detail.detailmatch.presenter.DetailMatchMVPPresenter
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.DateUtils
import com.wanztudio.gdk.footballapps.util.NetworkUtils
import com.wanztudio.gdk.footballapps.util.WordUtils
import com.wanztudio.gdk.footballapps.util.extension.loadImage
import kotlinx.android.synthetic.main.activity_detail_match.*
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
 * com.wanztudio.gdk.footballapps.ui.detail.detailmatch.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class DetailMatchActivity : BaseActivity(), DetailMatchMVPView {

    private var eventId: String = ""
    private var event : Event? = null
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    @Inject
    internal lateinit var presenter: DetailMatchMVPPresenter<DetailMatchMVPView, DetailMatchMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        presenter.onAttach(this)

        supportActionBar?.setTitle(getString(R.string.title_match_detail))
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        eventId = intent.getStringExtra(Constants.EXTRA_EVENT_ID)

        checkFavoriteState()

        if (NetworkUtils.isNetworkAvailable(this)) {
            presenter.getDetailEventApiCall(eventId)
        } else {
            Toast.makeText(this, getString(R.string.message_no_network), Toast.LENGTH_SHORT)
        }
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun showEvent(event: Event) {
        this.event = event

        detail_match_info_date.text = DateUtils.convertToDayDate(event!!.dateEvent)
        detail_match_info_time.text = DateUtils.convertToTime(event!!.strTime)
        detail_match_home_team_name.text = event!!.strHomeTeam
        detail_match_away_team_name.text = event!!.strAwayTeam
        detail_match_info_home_score.text = event!!.intHomeScore
        detail_match_info_away_score.text = event!!.intAwayScore

        event.intHomeScore?.let { detail_match_info_home_score.text = event.intHomeScore }
        event.strHomeFormation?.let {
            detail_match_home_team_formation.text = event.strHomeFormation
            detail_match_home_team_formation.visibility = View.VISIBLE
        }
        event.strHomeGoalDetails?.let {
            var homeGoal = WordUtils.validateData(event.strHomeGoalDetails)
            detail_match_info_home_goals.text = homeGoal
        }

        event.intHomeShots?.let { detail_match_info_home_shots.text = event.intHomeShots }
        event.strHomeLineupGoalkeeper?.let { detail_match_info_home_goal_keeper.text = event.strHomeLineupGoalkeeper }
        event.strHomeLineupDefense?.let {
            var homeDefense = WordUtils.validateData(event.strHomeLineupDefense)
            detail_match_info_home_midfield.text = homeDefense
        }
        event.strHomeLineupMidfield?.let {
            var homeMidfield = WordUtils.validateData(event.strHomeLineupMidfield)
            detail_match_info_home_midfield.text = homeMidfield
        }
        event.strHomeLineupForward?.let {
            var homeForward = WordUtils.validateData(event.strHomeLineupForward)
            detail_match_info_home_forward.text = homeForward
        }
        event.strHomeLineupSubstitutes?.let {
            var homeSubstitutes = WordUtils.validateData(event.strHomeLineupSubstitutes)
            detail_match_info_home_substitutes.text = homeSubstitutes
        }

        event.intAwayScore?.let { detail_match_info_away_score.text = event.intAwayScore }
        event.strAwayFormation?.let {
            detail_match_away_team_formation.text = event.strAwayFormation
            detail_match_away_team_formation.visibility = View.VISIBLE
        }
        event.strAwayGoalDetails?.let {
            var awayGoal = WordUtils.validateData(event.strAwayGoalDetails)
            detail_match_info_away_goals.text = awayGoal
        }

        event.intAwayShots?.let { detail_match_info_away_shots.text = event.intAwayShots }
        event.strAwayLineupGoalkeeper?.let { detail_match_info_away_goal_keeper.text = event.strAwayLineupGoalkeeper }
        event.strAwayLineupDefense?.let {
            var awayDefense = WordUtils.validateData(event.strAwayLineupDefense)
            detail_match_info_away_midfield.text = awayDefense
        }
        event.strAwayLineupMidfield?.let {
            var awayMidfield = WordUtils.validateData(event.strAwayLineupMidfield)
            detail_match_info_away_midfield.text = awayMidfield
        }
        event.strAwayLineupForward?.let {
            var awayForward = WordUtils.validateData(event.strAwayLineupForward)
            detail_match_info_away_forward.text = awayForward
        }
        event.strAwayLineupSubstitutes?.let {
            var awaySubstitutes = WordUtils.validateData(event.strAwayLineupSubstitutes)
            detail_match_info_away_substitutes.text = awaySubstitutes
        }

        presenter.getTeamAwayDetailApiCall(event.idHomeTeam)
        presenter.getTeamAwayDetailApiCall(event.idAwayTeam)
    }

    override fun showHomeTeam(team: Team) {
        team.strTeamBadge?.let { detail_match_logo_home_team.loadImage(it) }
    }

    override fun showAwayTeam(team: Team) {
        team.strTeamBadge?.let { detail_match_logo_away_team.loadImage(it) }
    }

    override fun hideLoading() {
        detail_match_progress_circular.visibility = View.GONE
    }

    override fun showLoading() {
        detail_match_progress_circular.visibility = View.VISIBLE
    }

    private fun checkFavoriteState(){
        try{
            database.use {
                val result = select(FavoriteMatch.TABLE_FAVORITE_EVENTS)
                        .whereArgs("(ID_EVENT = {id})","id" to eventId)
                val favorite = result.parseList(classParser<FavoriteMatch>())
                if (!favorite.isEmpty()) isFavorite = true
            }
        }catch(e: SQLiteConstraintException){
            println("Error Getting data from database: ${ e?.message }")
        }
    }

    private fun addToFavorite(){
        try {
            database.use {
                insert(FavoriteMatch.TABLE_FAVORITE_EVENTS,
                        FavoriteMatch.ID_EVENT to eventId,
                        FavoriteMatch.HOME_TEAM to event!!.strHomeTeam,
                        FavoriteMatch.AWAY_TEAM to event!!.strAwayTeam,
                        FavoriteMatch.HOME_SCORE to event!!.intHomeScore,
                        FavoriteMatch.AWAY_SCORE to event!!.intAwayScore,
                        FavoriteMatch.EVENT_DATE to event!!.dateEvent,
                        FavoriteMatch.EVENT_TIME to event!!.strTime,
                        FavoriteMatch.EVENT_DESC to event!!.strDescriptionEN)
            }

            detail_match_progress_circular.snackbar(R.string.info_add_favorite)
        } catch (e: SQLiteConstraintException){
            println("Error while inserting data to database: ${ e?.message }")
            Log.getStackTraceString(e)
        }
    }

    private fun removeFromFavorite(){
        try {
            database.use {
                delete(FavoriteMatch.TABLE_FAVORITE_EVENTS, "(ID_EVENT = {id})","id" to eventId)
            }
            detail_match_progress_circular.snackbar(R.string.info_remove_favorite)
        } catch (e: SQLiteConstraintException){
            println("Error while Deleting data from database: ${ e.message }")
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
                if (event != null) {
                    if (isFavorite) removeFromFavorite() else addToFavorite()
                    isFavorite = !isFavorite
                    setFavorite()
                } else {
                    Toast.makeText(this, getString(R.string.alert_loading), Toast.LENGTH_SHORT)
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}