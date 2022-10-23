package com.app.mealsearch.utils

import com.app.mealsearch.BuildConfig

object Keys {

    init {
        System.loadLibrary("native-lib")
    }

    val BASE_URL: String = if (BuildConfig.DEBUG) devBaseURL() else prodBaseURL()

    private external fun devBaseURL(): String
    private external fun prodBaseURL(): String
}