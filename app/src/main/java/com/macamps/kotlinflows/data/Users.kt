package com.macamps.kotlinflows.data


import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String
)