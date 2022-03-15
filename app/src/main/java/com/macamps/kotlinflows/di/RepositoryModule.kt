package com.macamps.kotlinflows.di

import com.macamps.kotlinflows.ApiService
import com.macamps.kotlinflows.MainRepoDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(mainRepoDataSource: MainRepoDataSource) = MainRepository(mainRepoDataSource)

}