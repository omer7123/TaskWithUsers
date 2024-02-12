package com.example.taskwithusers.data.remote

import com.example.taskwithusers.data.remote.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApi {

    @GET("api")
    suspend fun getUsers(@Query("results") count: String): Response<User>
}