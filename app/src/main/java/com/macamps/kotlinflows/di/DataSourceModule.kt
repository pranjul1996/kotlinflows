package com.macamps.kotlinflows.di

import com.macamps.kotlinflows.ApiService
import com.macamps.kotlinflows.MainRepoDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideMainRepoDataSource(apiService: ApiService) = MainRepoDataSource(apiService)


}