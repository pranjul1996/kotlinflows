package com.macamps.kotlinflows.di

import com.macamps.kotlinflows.BaseApiResponse
import com.macamps.kotlinflows.MainRepoDataSource
import com.macamps.kotlinflows.NetworkResult
import com.macamps.kotlinflows.data.Users
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepository @Inject constructor(private val mainRepoDataSource: MainRepoDataSource) :
    BaseApiResponse() {

    suspend fun getUsers(): Flow<NetworkResult<ArrayList<Users>>> {
        return flow {
            emit(safeApiCall { mainRepoDataSource.getUsers() })
        }.flowOn(Dispatchers.IO)
    }

}