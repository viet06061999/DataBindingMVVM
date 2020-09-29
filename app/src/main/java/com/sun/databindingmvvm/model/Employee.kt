package com.sun.databindingmvvm.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName
import com.sun.databindingmvvm.R
import com.sun.databindingmvvm.utils.setImage

data class Employee(
    @SerializedName("avatar")
    var avatar: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("first_name")
    var firstName: String,
    @SerializedName("id")
    var id: Long,
    @SerializedName("last_name")
    var lastName: String
)

