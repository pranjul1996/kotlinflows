package com.macamps.kotlinflows.data

import com.macamps.kotlinflows.database.UsersDao
import com.macamps.kotlinflows.model.Users
import javax.inject.Inject

class MainDbSource @Inject constructor(private val userDao: UsersDao) {
    suspend fun insert(users: ArrayList<Users>) {
        users.forEach { userDao.insertUsers(it) }
    }

    suspend fun getUsers() = userDao.getUsers()
}