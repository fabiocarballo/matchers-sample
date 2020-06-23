package com.example.testing.internal

import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import com.example.ui.LoadingButton
import org.hamcrest.Description

internal class WithButtonLoadingMatcher :
    BoundedMatcher<View, LoadingButton>(LoadingButton::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("with button in loading state")
    }

    override fun matchesSafely(item: LoadingButton): Boolean = item.isLoading
}
