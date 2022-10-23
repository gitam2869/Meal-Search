package com.app.mealsearch.utils

import android.view.View

class ViewListener {
    companion object{
        fun View.setOnSingleClickListener(intervalMillis: Long = 500L, doClick: (View) -> Unit)
        = setOnClickListener(SingleClickListener(intervalMillis, doClick))
    }
}