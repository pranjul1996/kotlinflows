package com.macamps.kotlinflows.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.macamps.kotlinflows.data.Users

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UsersDao
}