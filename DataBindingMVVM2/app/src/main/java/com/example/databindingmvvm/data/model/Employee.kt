package com.example.databindingmvvm.data.model

import com.google.gson.annotations.SerializedName

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

