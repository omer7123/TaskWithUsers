package com.example.taskwithusers.di

import com.example.taskwithusers.data.remote.RemoteDataSource
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get()) }
}