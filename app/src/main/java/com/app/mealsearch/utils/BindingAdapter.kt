package com.app.mealsearch.utils

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.app.mealsearch.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, url: String) {
    val options = RequestOptions
        .placeholderOf(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)

    Glide
        .with(view)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(view)
}