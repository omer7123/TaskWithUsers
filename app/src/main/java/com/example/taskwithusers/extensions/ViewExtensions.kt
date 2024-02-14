package com.example.taskwithusers.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.taskwithusers.R

/**
 * RequestOptions for loading images with Glide.
 * Includes a default placeholder image.
 */
val requestOptions = RequestOptions()
    .placeholder(R.drawable.ic_launcher_foreground)


/**
 * Extension function for ImageView to load images using Glide.
 * @param s String containing the image URL.
 */
fun ImageView.load(s: String?) {
    Glide.with(this).load(s).apply(requestOptions).into(this)
}