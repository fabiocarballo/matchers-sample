package com.example.testing

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testing.ButtonMatchers.isLoading
import com.example.testing.ButtonMatchers.isNotLoading
import com.example.testing.scenario.launchViewInFragment
import com.example.ui.LoadingButton
import junit.framework.AssertionFailedError
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@Config(sdk = [28])
@RunWith(AndroidJUnit4::class)
class ButtonMatchersTest {

    @Test
    fun whenButtonIsLoading_isLoadingMatcher_ShouldNotThrowException() {
        launchViewInFragment {
            LoadingButton(context).apply { isLoading = true }
        }

        onView(instanceOf(LoadingButton::class.java)).check(matches(isLoading()))
    }

    @Test
    fun whenButtonIsNotLoading_isLoadingMatcher_ShouldThrowException() {
        launchViewInFragment {
            LoadingButton(context).apply { isLoading = false }
        }

        assertThrows(AssertionFailedError::class.java) {
            onView(instanceOf(LoadingButton::class.java)).check(matches(isLoading()))
        }
    }

    @Test
    fun whenButtonIsLoading_isNotLoadingMatcher_ShouldNotThrowException() {
        launchViewInFragment {
            LoadingButton(context).apply { isLoading = true }
        }

        assertThrows(AssertionFailedError::class.java) {
            onView(instanceOf(LoadingButton::class.java)).check(matches(isNotLoading()))
        }
    }

    @Test
    fun whenButtonIsNotLoading_isNotLoadingMatcher_ShouldNotThrowException() {
        launchViewInFragment {
            LoadingButton(context).apply { isLoading = false }
        }

        onView(instanceOf(LoadingButton::class.java)).check(matches(isNotLoading()))
    }
}
