package com.example.roomdbexample.second_way


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_tae")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val email: String
)