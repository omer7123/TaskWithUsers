package com.example.taskwithusers.domain.repository

import androidx.lifecycle.LiveData
import com.example.taskwithusers.core.network.result.Resource
import com.example.taskwithusers.domain.entity.Result
import com.example.taskwithusers.domain.entity.User

interface UserRepository {
    fun getUsers(count:String): LiveData<Resource<User>>
    fun getUsersFromDataBase(): List<Result>
    fun clearUsersInDataBase()
    fun addUsersInDataBase(users: List<Result>)
}