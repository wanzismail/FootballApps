package com.wanztudio.gdk.matchschedule.ui.main.view


import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.pressBack
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
import com.wanztudio.gdk.matchschedule.R
import com.wanztudio.gdk.matchschedule.R.id.schedule_next_recycler
import com.wanztudio.gdk.matchschedule.R.id.schedule_prev_recycler
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
    fun testRecyclerViewBehavior() {
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(withId(schedule_prev_recycler)).check(matches(isDisplayed()))
        onView(withId(schedule_prev_recycler)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(12))
        onView(withId(schedule_prev_recycler)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(12, click()))

        onView(withText("VS"))
                .check(matches(isDisplayed()))

        onView(withId(R.id.action_favorite)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(click())

        pressBack()
    }

    @Test
    fun testViewPagerBehavior() {
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(withId(R.id.content_viewpager)).check(matches(isDisplayed()))
        onView(withId(R.id.content_viewpager)).perform(ViewActions.swipeLeft())
        onView(withId(R.id.content_viewpager)).perform(ViewActions. swipeLeft())
        onView(withId(R.id.content_viewpager)).perform(ViewActions.swipeRight())

        onView(withId(R.id.schedule_next_recycler)).check(matches(isDisplayed()))
        onView(withId(R.id.schedule_next_recycler)).perform(actionOnItemAtPosition<ViewHolder>(5, click()))

        onView(withId(R.id.action_favorite)).check(matches(isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(click())

        pressBack()
    }

    @Test
    fun testBottomNavigationBehavior() {
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(allOf(withId(R.id.action_next), withContentDescription("Next Match"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navigation),
                                        0),
                                1),
                        isDisplayed())).perform(click())

        onView(allOf(withId(R.id.action_favorite), withContentDescription("Favorites"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottom_navigation),
                                        0),
                                2),
                        isDisplayed())).perform(click())


        onView(allOf(withId(R.id.action_prev), withContentDescription("Prev Match"),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.bottom_navigation),
                                0),
                        0),
                isDisplayed())).perform(click())
    }



    @Test
    fun testAppBehavior() {
        try {
            Thread.sleep(3000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        onView(allOf(withId(R.id.action_next), withContentDescription("Next Match"),
                childAtPosition(
                        childAtPosition(
                                withId(R.id.bottom_navigation),
                                0),
                        1),
                isDisplayed())).perform(click())

        onView(withId(schedule_next_recycler)).check(matches(isDisplayed()))
        onView(withId(schedule_next_recycler)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(12))
        onView(withId(schedule_next_recycler)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(12, click()))

        onView(withText("VS"))
                .check(matches(isDisplayed()))

        onView(withId(R.id.action_favorite)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(click())

        pressBack()

//        onView(withId(R.id.content_viewpager)).check(matches(isDisplayed()))
//        onView(withId(R.id.content_viewpager)).perform(ViewActions.swipeLeft())
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
