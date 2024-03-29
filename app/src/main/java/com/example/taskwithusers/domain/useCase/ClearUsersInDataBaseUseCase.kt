package com.example.taskwithusers.domain.useCase

import com.example.taskwithusers.domain.repository.UserRepository

class ClearUsersInDataBaseUseCase(val repository: UserRepository) {
    operator fun invoke()=
        repository.clearUsersInDataBase()
}
