package com.example.roomdbexample.second_way

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 20)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
