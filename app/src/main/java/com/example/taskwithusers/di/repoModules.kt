package com.example.taskwithusers.di

import com.example.taskwithusers.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules = module {
    single{Repository(get())}
}