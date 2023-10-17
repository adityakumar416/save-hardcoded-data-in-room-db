package com.example.roomdbexample.first_way.first_way

import android.app.Application
import androidx.room.Room

class MyApplication : Application() {
    companion object {
        lateinit var database: UserDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "app-database").build()
    }
}
