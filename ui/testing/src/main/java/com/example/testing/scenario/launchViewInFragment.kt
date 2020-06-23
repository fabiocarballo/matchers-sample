package com.example.testing.scenario

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer

internal fun launchViewInFragment(instantiate: ViewBuilder.() -> View?): FragmentScenario<Fragment> =
    launchFragmentInContainer(
        instantiate = { ViewHostFragment(instantiate) }
    )

/**
 * An empty [Fragment]. This [Fragment] is used to host a [View] in [launchViewInFragment].
 *
 * @see [launchViewInFragment] for more details.
 */
internal class ViewHostFragment constructor(
    private val viewFactory: ViewBuilder.() -> View?
) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = ViewBuilder(requireContext(), inflater, container, savedInstanceState)
        return viewFactory(args)
    }
}

internal data class ViewBuilder internal constructor(
    val context: Context,
    val inflater: LayoutInflater,
    val container: ViewGroup? = null,
    val savedInstanceState: Bundle? = null
)
