package com.example.matchers

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testing.internal.ButtonMatchers.isLoading
import com.example.testing.internal.ButtonMatchers.isNotLoading

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun verifyButtonToggleBehavior() {
        launchActivity<MainActivity>()
        assertButtonIsNotLoading()

        clickButton()
        assertButtonIsLoading()

        clickButton()
        assertButtonIsNotLoading()
    }

    private fun assertButtonIsLoading() {
        onView(withId(R.id.loadingButton)).check(matches(isLoading()))
    }

    private fun assertButtonIsNotLoading() {
        onView(withId(R.id.loadingButton)).check(matches(isNotLoading()))
    }

    private fun clickButton() {
        onView(withId(R.id.loadingButton)).perform(click())
    }
}
