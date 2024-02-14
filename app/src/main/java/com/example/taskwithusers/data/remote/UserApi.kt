package com.example.taskwithusers.data.remote

import com.example.taskwithusers.data.remote.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Interface representing a User API service.
 * This interface defines methods for interacting with a user-related API.
 */
interface UserApi {


    /**
     * Retrieves a list of users from the API.
     * @param count The number of users to retrieve.
     * @return A Response object containing user data.
     */
    @GET("api")
    suspend fun getUsers(@Query("results") count: String): Response<User>
}