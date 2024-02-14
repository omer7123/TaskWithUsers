package com.example.taskwithusers.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.taskwithusers.core.network.result.Resource
import com.example.taskwithusers.data.remote.RemoteDataSource
import com.example.taskwithusers.data.remote.models.User
import kotlinx.coroutines.Dispatchers

/**
 * Repository class responsible for managing data operations.
 *
 * @param dataSource The remote data source to fetch user data from.
 */
class Repository(val dataSource: RemoteDataSource) {

    /**
     * Fetches a list of users from the remote data source.
     *
     * @param count The number of users to fetch.
     * @return A [LiveData] object emitting [Resource] of type [User] representing the result of the operation.
     */
    fun getUsers(count: String): LiveData<Resource<User>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val resp = dataSource.getUsers(count)
        emit(resp)

    }
}