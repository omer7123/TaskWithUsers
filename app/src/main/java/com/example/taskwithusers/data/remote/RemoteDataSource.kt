package com.example.taskwithusers.data.remote

import com.example.taskwithusers.core.network.BaseDataSource
import org.koin.dsl.module

val remoteDataSource = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(val userApi: UserApi) : BaseDataSource() {

    suspend fun getUsers(count: String) = getResult {
        userApi.getUsers(count)
    }
}