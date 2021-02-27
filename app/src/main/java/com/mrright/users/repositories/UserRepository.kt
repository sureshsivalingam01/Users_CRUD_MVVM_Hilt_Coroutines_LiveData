package com.mrright.users.repositories

import com.mrright.users.db.UserDao
import com.mrright.users.models.User
import javax.inject.Inject


class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun insert(user: User) = userDao.insert(user)

    suspend fun update(user: User) = userDao.update(user)

    suspend fun delete(user: User) = userDao.delete(user)

    fun getUsers() = userDao.getUsers()

}