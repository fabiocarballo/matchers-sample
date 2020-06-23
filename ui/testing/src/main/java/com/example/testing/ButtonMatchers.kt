package com.example.testing

import android.view.View
import com.example.testing.internal.WithButtonLoadingMatcher
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher

object ButtonMatchers {

    fun isLoading(): Matcher<View> = WithButtonLoadingMatcher()

    fun isNotLoading(): Matcher<View> = not(WithButtonLoadingMatcher())
}
