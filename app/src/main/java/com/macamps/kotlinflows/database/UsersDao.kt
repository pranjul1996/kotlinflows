package com.macamps.kotlinflows.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.macamps.kotlinflows.model.Users

@Dao
interface UsersDao {

    @Query("SELECT * FROM Users")
    suspend fun getUsers():List<Users>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(vararg users: Users)
}