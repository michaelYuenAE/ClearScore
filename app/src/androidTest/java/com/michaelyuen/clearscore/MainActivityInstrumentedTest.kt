package com.michaelyuen.clearscore

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.core.IsNot.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.michaelyuen.clearscore", appContext.packageName)
    }
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun checkInitialCreditInfoView() {
        onView(withId(R.id.tv_click)).check(matches(isDisplayed()))
        onView(withId(R.id.bt_getInfo)).check(matches(isDisplayed()))
        onView(withId(R.id.progressBar)).check(matches(not(isDisplayed())))
        onView(withId(R.id.tv_your_credit)).check(matches(not(isDisplayed())))
        onView(withId(R.id.tv_score)).check(matches(not(isDisplayed())))
        onView(withId(R.id.tv_out_of)).check(matches(not(isDisplayed())))
    }
    @Test
    fun checkInitialCreditInfoViewAfterCallAPI() {
        onView(withId(R.id.bt_getInfo)).perform(click())
        Thread.sleep(5000)
        onView(withId(R.id.tv_click)).check(matches(not(isDisplayed())))
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_your_credit)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_out_of)).check(matches(isDisplayed()))
    }
}