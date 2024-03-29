package com.example.taskwithusers.di

import com.example.taskwithusers.domain.useCase.AddUsersInDataBaseUseCase
import com.example.taskwithusers.domain.useCase.ClearUsersInDataBaseUseCase
import com.example.taskwithusers.domain.useCase.GetUsersFromDataBaseUseCase
import com.example.taskwithusers.domain.useCase.GetUsersUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetUsersUseCase(get()) }
    factory { GetUsersFromDataBaseUseCase(get()) }
    factory { ClearUsersInDataBaseUseCase(get()) }
    factory { AddUsersInDataBaseUseCase(get()) }
}