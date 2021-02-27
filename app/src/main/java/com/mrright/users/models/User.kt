package com.mrright.users.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String = "",
    val age: Int = 0
) {

}
