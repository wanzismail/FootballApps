package com.wanztudio.gdk.matchschedule.ui.detail.view

import android.database.sqlite.SQLiteConstraintException
import android.opengl.Visibility
import android.os.Bundle
import android.provider.Contacts
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.wanztudio.framework.mvp.ui.login.view.DetailMVPView
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.data.database.FavoriteMatch
import com.wanztudio.gdk.matchschedule.data.database.database
import com.wanztudio.gdk.matchschedule.data.network.Event
import com.wanztudio.gdk.matchschedule.data.network.Team
import com.wanztudio.gdk.matchschedule.ui.base.view.BaseActivity
import com.wanztudio.gdk.matchschedule.ui.main.next.interactor.DetailMVPInteractor
import com.wanztudio.gdk.matchschedule.ui.main.next.presenter.DetailMVPPresenter
import com.wanztudio.gdk.matchschedule.util.Constants
import com.wanztudio.gdk.matchschedule.util.DateUtils
import com.wanztudio.gdk.matchschedule.util.NetworkUtils
import com.wanztudio.gdk.matchschedule.util.extension.loadImage
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.list_item_schedule.*
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
 * FOOTBALL MATCH CLUB
 * com.wanztudio.gdk.matchschedule.ui.detail.view
 * or see link for more detail https://github.com/iwanz98/FootballApp
 */

class DetailActivity : BaseActivity(), DetailMVPView {

    private var eventId: String = ""
    private var event : Event? = null 
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    private lateinit var id: String

    @Inject
    internal lateinit var mPresenter: DetailMVPPresenter<DetailMVPView, DetailMVPInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        mPresenter.onAttach(this)

        supportActionBar?.setTitle(getString(R.string.title_match_detail))
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        eventId = intent.getStringExtra(Constants.EXTRA_EVENT_ID)

        if (NetworkUtils.isNetworkAvailable(this)) {
            showLoading()
            mPresenter.getDetailEventApiCall(eventId)
        } else {
            Toast.makeText(this, getString(R.string.message_no_network), Toast.LENGTH_SHORT)
        }

        favoriteState()
    }

    override fun showHomeTeam(team: Team) {
        team.strTeamBadge?.let { logo_home_team.loadImage(it) }
    }

    override fun showAwayTeam(team: Team) {
        team.strTeamBadge?.let { logo_away_team.loadImage(it) }
    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEvent(event: Event) {
        this.event = event
        
        detail_info_date.text = DateUtils.convert(event!!.dateEvent)
        detail_home_team_name.text = event!!.strHomeTeam
        detail_away_team_name.text = event!!.strAwayTeam
        info_home_score.text = event!!.intHomeScore
        info_away_score.text = event!!.intAwayScore

        event.intHomeScore?.let { info_home_score.text = event.intHomeScore }
        event.strHomeFormation?.let {
            home_team_formation.text = event.strHomeFormation
            home_team_formation.visibility = View.VISIBLE
        }
        event.strHomeGoalDetails?.let {
            var homeGoal = ""

            for (s in event.strHomeGoalDetails.split("; ")) {
                homeGoal = homeGoal + s + "\n"
            }
            info_home_goals.text = homeGoal
        }

        event.intHomeShots?.let { info_home_shots.text = event.intHomeShots }
        event.strHomeLineupGoalkeeper?.let { info_home_goal_keeper.text = event.strHomeLineupGoalkeeper }
        event.strHomeLineupDefense?.let {
            var homeDefense = ""

            for (s in event.strHomeLineupDefense.split("; ")) {
                homeDefense = homeDefense + s + "\n"
            }
            info_home_midfield.text = homeDefense
        }
        event.strHomeLineupMidfield?.let {
            var homeMidfield = ""

            for (s in event.strHomeLineupMidfield.split("; ")) {
                homeMidfield = homeMidfield + s + "\n"
            }
            info_home_midfield.text = homeMidfield
        }
        event.strHomeLineupForward?.let {
            var homeForward = ""

            for (s in event.strHomeLineupForward.split("; ")) {
                homeForward = homeForward + s + ";\n"
            }
            info_home_forward.text = homeForward
        }
        event.strHomeLineupSubstitutes?.let {
            var homeSubstitutes = ""

            for (s in event.strHomeLineupSubstitutes.split("; ")) {
                homeSubstitutes = homeSubstitutes + s + "\n"
            }
            info_home_substitutes.text = homeSubstitutes
        }

        event.intAwayScore?.let { info_away_score.text = event.intAwayScore }
        event.strAwayFormation?.let {
            away_team_formation.text = event.strAwayFormation
            away_team_formation.visibility = View.VISIBLE
        }
        event.strAwayGoalDetails?.let {
            var awayGoal = ""

            for (s in event.strAwayGoalDetails.split("; ")) {
                awayGoal = awayGoal + s + "\n"
            }
            info_away_goals.text = awayGoal
        }

        event.intAwayShots?.let { info_away_shots.text = event.intAwayShots }
        event.strAwayLineupGoalkeeper?.let { info_away_goal_keeper.text = event.strAwayLineupGoalkeeper }
        event.strAwayLineupDefense?.let {
            var awayDefense = ""

            for (s in event.strAwayLineupDefense.split("; ")) {
                awayDefense = awayDefense + s + "\n"
            }
            info_away_midfield.text = awayDefense
        }
        event.strAwayLineupMidfield?.let {
            var awayMidfield = ""

            for (s in event.strAwayLineupMidfield.split("; ")) {
                awayMidfield = awayMidfield + s + "\n"
            }
            info_away_midfield.text = awayMidfield
        }
        event.strAwayLineupForward?.let {
            var awayForward = ""

            for (s in event.strAwayLineupForward.split("; ")) {
                awayForward = awayForward + s + "\n"
            }
            info_away_forward.text = awayForward
        }
        event.strAwayLineupSubstitutes?.let {
            var awaySubstitutes = ""

            for (s in event.strAwayLineupSubstitutes.split("; ")) {
                awaySubstitutes = awaySubstitutes + s + "\n"
            }
            info_away_substitutes.text = awaySubstitutes
        }

        mPresenter.getTeamHomeDetailApiCall(event.idHomeTeam)
        mPresenter.getTeamAwayDetailApiCall(event.idAwayTeam)

        hideLoading()
    }

    private fun favoriteState(){
        database.use {
            val result = select(FavoriteMatch.TABLE_FAVORITE)
                    .whereArgs("(MATCH_ID = {id})",
                            "id" to eventId)
            val favorite = result.parseList(classParser<FavoriteMatch>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }

    override fun hideLoading() {
        progress_circular.visibility = View.GONE
    }

    override fun showLoading() {
        progress_circular.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
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

    private fun addToFavorite(){
        try {
            database.use {
                insert(FavoriteMatch.TABLE_FAVORITE,
                        FavoriteMatch.MATCH_ID to eventId,
                        FavoriteMatch.MATCH_DATE to event!!.dateEvent,
                        FavoriteMatch.MATCH_HOME_TEAM to event!!.strHomeTeam,
                        FavoriteMatch.MATCH_HOME_SCORE to event!!.intHomeScore,
                        FavoriteMatch.MATCH_AWAY_TEAM to event!!.strAwayTeam,
                        FavoriteMatch.MATCH_AWAY_SCORE to event!!.intAwayScore
                        )
            }
            snackbar(progress_circular, "Added to favorite").show()
        } catch (e: SQLiteConstraintException){
            snackbar(progress_circular, e.localizedMessage).show()
        }
    }

    private fun removeFromFavorite(){
        try {
            database.use {
                delete(FavoriteMatch.TABLE_FAVORITE, "(MATCH_ID = {id})",
                        "id" to eventId)
            }
            snackbar(progress_circular, "Removed to favorite").show()
        } catch (e: SQLiteConstraintException){
            snackbar(progress_circular, e.localizedMessage).show()
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
    }

    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }

}