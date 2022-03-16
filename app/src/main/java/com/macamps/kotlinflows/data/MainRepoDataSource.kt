package com.macamps.kotlinflows.data

import com.macamps.kotlinflows.data.network.ApiService
import javax.inject.Inject

class MainRepoDataSource @Inject constructor(private val api: ApiService) {
    suspend fun getUsers() = api.getUsers()
}