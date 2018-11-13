package com.wanztudio.gdk.footballapps.ui.search.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.ui.base.view.BaseActivity
import com.wanztudio.gdk.footballapps.ui.search.searchmatch.view.SearchMatchFragment
import com.wanztudio.gdk.footballapps.ui.search.searchteam.view.SearchTeamFragment
import com.wanztudio.gdk.footballapps.util.Constants
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.search.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class SearchActivity : BaseActivity(), HasSupportFragmentInjector, SearchMVPView {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private  var keyWord : String =""
    private  var page : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = intent
        keyWord = intent.getStringExtra(Constants.EXTRA_KEYWORD)
        page = intent.getIntExtra(Constants.EXTRA_PAGE, 0)

        supportActionBar?.title = keyWord

        if (page == 0)
            showSearchMatchFragment()
        else
            showSearchTeamFragment()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun showSearchTeamFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.search_container,  SearchTeamFragment.newInstance(keyWord))
                .disallowAddToBackStack()
                .commit()
    }

    override fun showSearchMatchFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.search_container,  SearchMatchFragment.newInstance(keyWord))
                .disallowAddToBackStack()
                .commit()
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

}
