package com.example.taskwithusers.domain.useCase

import androidx.lifecycle.LiveData
import com.example.taskwithusers.core.network.result.Resource
import com.example.taskwithusers.domain.entity.User
import com.example.taskwithusers.domain.repository.UserRepository

class GetUsersUseCase(val repository: UserRepository) {
    fun execute(count: String):LiveData<Resource<User>>{
        return repository.getUsers(count)
    }
}