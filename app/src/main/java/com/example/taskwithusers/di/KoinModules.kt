package com.example.taskwithusers.di

import com.example.taskwithusers.core.network.networkModule
import com.example.taskwithusers.data.remote.remoteDataSource

val koinModules = listOf(repoModules, networkModule, viewModule, remoteDataSource, databaseModule)