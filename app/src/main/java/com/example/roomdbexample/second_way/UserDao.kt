package com.example.roomdbexample.second_way

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdbexample.second_way.User

@Dao
interface UserDao {
    @Insert
    fun insertAll(users: List<User>)

    @Query("SELECT * FROM contact_tae")
    fun getAllUsers(): List<User>
}
