package com.wanztudio.gdk.footballapps.ui.main.view


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.view.ViewGroup
import com.wanztudio.gdk.footballapps.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testAppBehavior() {
        delay()

        onView(allOf(withId(R.id.item_match_main_action),
                childAtPosition(childAtPosition(withClassName(`is`("android.support.v7.widget.CardView")),0),2),
                isDisplayed())).perform(click())

        onView(allOf(withId(R.id.action_favorite), withContentDescription("Favorite"),
                childAtPosition(childAtPosition(withId(R.id.action_bar),2),0),isDisplayed()))
                .perform(click())

        pressBack()

        delay()

        onView(allOf(withId(R.id.action_team), withContentDescription("Teams"),
                childAtPosition(childAtPosition(withId(R.id.main_bottom_navigation),0),1),isDisplayed()))
                .perform(click())

        onView(allOf(withId(R.id.main_viewpager),childAtPosition(childAtPosition(withClassName(`is`("android.support.constraint.ConstraintLayout")),0),1),
                isDisplayed())).perform(swipeLeft())

        onView(allOf(withId(R.id.team_recyclerview),childAtPosition(withClassName(`is`("android.support.constraint.ConstraintLayout")),0)))
                .perform(actionOnItemAtPosition<ViewHolder>(5, click()))

        delay()

        onView(allOf(withContentDescription("Players"),
                childAtPosition(childAtPosition(withId(R.id.detail_team_tabs),0),1),
                isDisplayed())).perform(click())

        onView(allOf(withId(R.id.detail_team_viewpager),childAtPosition(childAtPosition(withClassName(`is`("android.support.constraint.ConstraintLayout")),0),1),
                isDisplayed())).perform(swipeLeft())

        onView(allOf(withId(R.id.action_favorite), withContentDescription("Favorite"),
                childAtPosition(childAtPosition(withId(R.id.detail_team_toolbar), 1),0),
                isDisplayed())).perform(click())

        onView(allOf(withId(R.id.player_recyclerview),childAtPosition(withClassName(`is`("android.support.constraint.ConstraintLayout")),0)))
                .perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        pressBack()

        pressBack()

        delay()

        onView(allOf(withId(R.id.action_match), withContentDescription("Matches"),
                childAtPosition(childAtPosition(withId(R.id.main_bottom_navigation),0),0),
                isDisplayed())).perform(click())

        onView(allOf(withId(R.id.main_viewpager),childAtPosition(childAtPosition(withClassName(`is`("android.support.constraint.ConstraintLayout")),0),1),
                isDisplayed())).perform(swipeRight())

        onView(allOf(withId(R.id.match_viewpager),childAtPosition(withParent(withId(R.id.main_viewpager)),1),
                isDisplayed())).perform(swipeLeft())

        onView(allOf(withId(R.id.item_match_main_action),childAtPosition(childAtPosition(withClassName(`is`("android.support.v7.widget.CardView")),0),2),
                        isDisplayed())).perform(click())

        onView(allOf(withId(R.id.action_favorite), withContentDescription("Favorite"),
                childAtPosition(childAtPosition(withId(R.id.action_bar),2),0),
                isDisplayed())).perform(click())

        pressBack()

        delay()

        onView(allOf(withId(R.id.action_favorite), withContentDescription("Favorites"),
                childAtPosition(childAtPosition(withId(R.id.main_bottom_navigation),0),2),
                isDisplayed())).perform(click())

        onView(allOf(withId(R.id.main_viewpager),childAtPosition(childAtPosition(withClassName(`is`("android.support.constraint.ConstraintLayout")),0),1),
                isDisplayed())).perform(swipeLeft())

        onView(allOf(withId(R.id.item_match_main_action),childAtPosition(childAtPosition(withClassName(`is`("android.support.v7.widget.CardView")),0),2),
                isDisplayed())).perform(click())

        delay()

        onView(allOf(withId(R.id.action_favorite), withContentDescription("Favorite"),
                childAtPosition(childAtPosition(withId(R.id.action_bar),2),0),
                isDisplayed())).perform(click())

        onView(allOf(withId(R.id.action_favorite), withContentDescription("Favorite"),
                childAtPosition(childAtPosition(withId(R.id.action_bar),2),0),
                isDisplayed())).perform(click())

        pressBack()

        delay()

        onView(allOf(withId(R.id.favorite_viewpager),childAtPosition(withParent(withId(R.id.main_viewpager)),1),
                isDisplayed())).perform(swipeLeft())

        onView(allOf(withId(R.id.fav_team_recyclerview),childAtPosition(withClassName(`is`("android.support.constraint.ConstraintLayout")),0)))
                .perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        pressBack()

        pressBack()
    }

    private fun delay(){
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
