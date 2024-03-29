package com.example.taskwithusers.domain.useCase

import com.example.taskwithusers.domain.repository.UserRepository

class GetUsersFromDataBaseUseCase(val repository: UserRepository) {

    operator fun invoke()=
        repository.getUsersFromDataBase()
}