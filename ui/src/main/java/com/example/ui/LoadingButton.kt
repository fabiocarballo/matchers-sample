package com.example.ui

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class LoadingButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {

    var isLoading: Boolean = false
        set(value) {
            // make the button show the loading state.
            text = if (value) {
                "Loading"
            } else {
                "Not loading"
            }

            field = value
        }

}
