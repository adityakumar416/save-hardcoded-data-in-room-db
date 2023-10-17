package com.example.roomdbexample.first_way.first_way

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbexample.R
import com.example.roomdbexample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var userRepository: UserRepository

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userDao = UserDatabase.getInstance(application).userDao()
        userRepository = UserRepository(userDao)

        userAdapter = UserAdapter()

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = userAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        lifecycleScope.launch(Dispatchers.IO) {


            // Insert hardcoded users into the Room database
          //  userRepository.insertUser(User(name = "Naman Kumar", email = "namanKumar@gmail.com"))



            // Retrieve users from the Room database
            val users = userRepository.getAllUsers()

            launch(Dispatchers.Main) {
                userAdapter.setUsers(users)
            }
        }
    }
}