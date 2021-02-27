package com.mrright.users.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrright.users.models.User

@Database(entities = [User::class], version = 1,exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        const val DATABASE_NAME = "users_db"
    }

}