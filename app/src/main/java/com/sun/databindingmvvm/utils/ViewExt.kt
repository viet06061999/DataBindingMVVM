package com.sun.databindingmvvm.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


fun ImageView.setImage(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

@BindingAdapter("avatar")
fun loadImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
        .load(imageUrl)
        .into(view)
}