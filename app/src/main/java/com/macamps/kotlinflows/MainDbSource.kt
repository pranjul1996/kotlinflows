package com.macamps.kotlinflows

import com.macamps.kotlinflows.data.Users
import com.macamps.kotlinflows.database.UsersDao
import javax.inject.Inject

class MainDbSource @Inject constructor(private val userDao: UsersDao) {
    suspend fun insert(users: ArrayList<Users>) {
        users.forEach { userDao.insertUsers(it) }
    }

    suspend fun getUsers() = userDao.getUsers()
}