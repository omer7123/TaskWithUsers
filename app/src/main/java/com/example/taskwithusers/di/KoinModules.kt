package com.example.taskwithusers.di

val koinModules =
    listOf(repoModules,
        networkModule,
        viewModule,
        remoteDataSource,
        databaseModule,
        useCaseModule)