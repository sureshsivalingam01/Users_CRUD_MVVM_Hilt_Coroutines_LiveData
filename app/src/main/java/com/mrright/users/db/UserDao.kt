package com.mrright.users.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mrright.users.models.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user : User) : Long

    @Update
    suspend fun update(user: User) : Int

    @Delete
    suspend fun delete(user: User) : Int

    @Query("SELECT * FROM users_table")
    fun getUsers() : LiveData<List<User>>


}