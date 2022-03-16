package com.macamps.kotlinflows

import com.macamps.kotlinflows.data.ApiService
import javax.inject.Inject

class MainRepoDataSource @Inject constructor(private val api: ApiService) {
    suspend fun getUsers() = api.getUsers()
}