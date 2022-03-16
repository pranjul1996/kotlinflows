package com.macamps.kotlinflows.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Users(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    var status: String
)