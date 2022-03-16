package com.macamps.kotlinflows.di

import com.macamps.kotlinflows.MainDbSource
import com.macamps.kotlinflows.MainRepoDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(mainRepoDataSource: MainRepoDataSource, mainDbSource: MainDbSource) =
        MainRepository(mainRepoDataSource, mainDbSource)

}