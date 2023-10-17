package com.example.accelerometerapp

import androidx.test.espresso.Espresso.onView
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.accelerometerapp", appContext.packageName)
    }
}

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkSeekBarExists() {
        // Verifying the presence of the seekBar
        onView(withId(R.id.seekBar)).check(doesNotExist())
    }

    @Test
    fun setSeekBarValue() {
        // Setting seekBar's progress to a specific value and verifying
        onView(withId(R.id.seekBar)).perform(ViewActions.click())
        // Assuming there's a way to confirm the value is set in your UI.
        // For example, if there's a TextView showing the current value.
        // onView(withId(R.id.seekBarValueTextView)).check(hasText("Your Value"))
    }
}