package com.macamps.kotlinflows.data

import com.macamps.kotlinflows.base.BaseApiResponse
import com.macamps.kotlinflows.base.NetworkResult
import com.macamps.kotlinflows.model.Users
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class MainRepository @Inject constructor(
    private val mainRepoDataSource: MainRepoDataSource,
    private val mainDbSource: MainDbSource,
) :
    BaseApiResponse() {

    suspend fun getUsers(): Flow<NetworkResult<ArrayList<Users>>> {
        return flow {
            emit(safeApiCall { mainRepoDataSource.getUsers() })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getUsersFromDb(): Flow<List<Users>> {
        return flow {
            emit(mainDbSource.getUsers())
        }.flowOn(Dispatchers.IO)
    }


}