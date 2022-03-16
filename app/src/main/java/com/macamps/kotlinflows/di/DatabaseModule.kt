package com.macamps.kotlinflows.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.macamps.kotlinflows.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "Users.db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideUsersDao(database: AppDatabase) = database.userDao()
}