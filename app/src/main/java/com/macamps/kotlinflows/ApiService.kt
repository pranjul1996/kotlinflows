package com.macamps.kotlinflows

import com.macamps.kotlinflows.data.Users
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<ArrayList<Users>>
}