package com.example.taskwithusers.di

import com.example.taskwithusers.core.network.provideApi
import com.example.taskwithusers.core.network.provideOkHttpClient
import com.example.taskwithusers.core.network.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideRetrofit(get()) }
    factory { provideApi(get()) }
}