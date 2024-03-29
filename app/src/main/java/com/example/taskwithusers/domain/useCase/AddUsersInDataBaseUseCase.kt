package com.example.taskwithusers.domain.useCase

import com.example.taskwithusers.domain.entity.Result
import com.example.taskwithusers.domain.repository.UserRepository

class AddUsersInDataBaseUseCase(val repository: UserRepository) {
    fun execute(users:List<Result>) {
        repository.addUsersInDataBase(users)
    }
}
