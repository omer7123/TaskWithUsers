package com.example.taskwithusers.di

import com.example.taskwithusers.data.repository.UserRepositoryImpl
import com.example.taskwithusers.domain.repository.UserRepository
import org.koin.dsl.module

val repoModules = module {
    single<UserRepository>{ UserRepositoryImpl(get(), get()) }

}