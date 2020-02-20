package com.wanztudio.gdk.footballapps.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.wanztudio.gdk.footballapps.R
import com.wanztudio.gdk.footballapps.ui.base.view.BaseActivity
import com.wanztudio.gdk.footballapps.ui.base.view.BaseViewPagerAdapter
import com.wanztudio.gdk.footballapps.ui.main.favorites.view.FavoriteFragment
import com.wanztudio.gdk.footballapps.ui.main.matches.view.MatchFragment
import com.wanztudio.gdk.footballapps.ui.main.teams.view.TeamFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuInflater
import android.widget.EditText
import com.wanztudio.gdk.footballapps.ui.detail.detailteam.view.DetailTeamActivity
import com.wanztudio.gdk.footballapps.ui.search.view.SearchActivity
import com.wanztudio.gdk.footballapps.util.Constants
import com.wanztudio.gdk.footballapps.util.Constants.EXTRA_PAGE
import kotlinx.android.synthetic.main.activity_detail_team.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

/**
 * For LEARNING
 * Created by Ridwan Ismail on 27 September 2018
 * You can contact me at : ismail.ridwan98@gmail.com
 * -------------------------------------------------
 * FOOTBALL APPS
 * com.wanztudio.gdk.footballapps.ui.main.view
 * or see link for more detail https://github.com/iwanz98/FootballApps
 */

class MainActivity : BaseActivity(), HasSupportFragmentInjector {


    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    internal lateinit var mainPagerAdapter: BaseViewPagerAdapter

    private var searchMenu: MenuItem ? = null
    private var prevMenuItem: MenuItem? = null

    private val fragments = listOf(MatchFragment.newInstance(),
            TeamFragment.newInstance(), FavoriteFragment.newInstance())

    private val titles = listOf(R.string.menu_match, R.string.menu_team, R.string.menu_favorite)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(main_toolbar)

        setUpPagerAdapter()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

  private fun setUpPagerAdapter() {
        mainPagerAdapter = BaseViewPagerAdapter(this, supportFragmentManager, fragments, titles)

        main_viewpager.adapter = mainPagerAdapter
        main_viewpager.offscreenPageLimit = 3
        main_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null) {
                    prevMenuItem?.setChecked(false)
                } else {
                    main_bottom_navigation.getMenu().getItem(0).setChecked(false);
                }
                main_bottom_navigation.getMenu().getItem(position).setChecked(true)
                prevMenuItem = main_bottom_navigation.getMenu().getItem(position)

                when (position) {
                    0, 1 -> expandToolbar(true)
                    else -> expandToolbar(false)
                }
                
                searchMenu?.let {
                    if(position == 2)
                        it.setVisible(false)
                    else
                        it.setVisible(true)
                }
            }
        })

        main_bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    
    private fun expandToolbar(expandToolbar: Boolean) {
        var params = main_toolbar.getLayoutParams() as AppBarLayout.LayoutParams

        if (expandToolbar) {
            main_app_bar_layout.setExpanded(true, true)
            params.scrollFlags = 0
        } else {
            main_app_bar_layout.setExpanded(false, true)
            params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL or AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS
        }

        main_toolbar.layoutParams = params
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_match -> {
                main_viewpager.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_team -> {
                main_viewpager.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_favorite -> {
                main_viewpager.setCurrentItem(2, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        searchMenu = menu.getItem(0)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        val editext = searchView.findViewById<EditText>(android.support.v7.appcompat.R.id.search_src_text)
        editext.hint = getString(R.string.hint_search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                startActivity(intentFor<SearchActivity>(Constants.EXTRA_KEYWORD to query,
                        Constants.EXTRA_PAGE to main_viewpager.currentItem)
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
        return super.onCreateOptionsMenu(menu);
    }
}
