package com.macamps.kotlinflows.data.network

import com.macamps.kotlinflows.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<ArrayList<Users>>

}