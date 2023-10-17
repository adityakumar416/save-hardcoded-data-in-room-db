package com.example.roomdbexample.first_way.first_way

class UserRepository(private val userDao: UserDao) {
   fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    fun getAllUsers(): List<User> {
        return userDao.getAllUsers()
    }
}


