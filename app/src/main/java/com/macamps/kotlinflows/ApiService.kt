package com.macamps.kotlinflows

import com.macamps.kotlinflows.data.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET
    suspend fun getUsers(): Call<List<Users>>
}