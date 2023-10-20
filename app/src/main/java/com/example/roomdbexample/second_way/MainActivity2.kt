package com.example.roomdbexample.second_way

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomdbexample.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val database = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "user-databases").build()

        Thread {
            val usersCount = database.userDao().getAllUsers().size
            if (usersCount == 0) {
                val usersJsonString = resources.openRawResource(R.raw.users).bufferedReader().use { it.readText() }
                val users = Gson().fromJson<List<User>>(usersJsonString, object : TypeToken<List<User>>() {}.type)
                database.userDao().insertAll(users)
            }

            val users = database.userDao().getAllUsers()

            runOnUiThread {
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                val adapter = UserAdapter(users)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            }
        }.start()
    }
}
