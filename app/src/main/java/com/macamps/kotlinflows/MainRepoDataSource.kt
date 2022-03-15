package com.macamps.kotlinflows

import kotlinx.coroutines.flow.flow
import retrofit2.Callback
import javax.inject.Inject

class MainRepoDataSource @Inject constructor(private val api: ApiService) {

    suspend fun getUsers() = api.getUsers()

}