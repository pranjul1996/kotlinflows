package com.macamps.kotlinflows.di

import com.macamps.kotlinflows.ApiService
import com.macamps.kotlinflows.data.Users
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: ApiService) {
    val usersFlow: Flow<Call<List<Users>>> = flow {
        emit(api.getUsers())
    }
}