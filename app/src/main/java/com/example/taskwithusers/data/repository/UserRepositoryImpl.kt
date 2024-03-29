package com.example.taskwithusers.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.taskwithusers.core.network.result.Resource
import com.example.taskwithusers.data.local.room.AppDataBase
import com.example.taskwithusers.data.remote.RemoteDataSource
import com.example.taskwithusers.domain.entity.Result
import com.example.taskwithusers.domain.entity.User
import com.example.taskwithusers.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers

/**
 * Repository class responsible for managing data operations.
 *
 * @param dataSource The remote data source to fetch user data from.
 */
class UserRepositoryImpl(private val dataSource: RemoteDataSource, private val db: AppDataBase): UserRepository {

    /**
     * Fetches a list of users from the remote data source.
     *
     * @param count The number of users to fetch.
     * @return A [LiveData] object emitting [Resource] of type [User] representing the result of the operation.
     */
    override fun getUsers(count: String): LiveData<Resource<User>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val resp = dataSource.getUsers(count)
        emit(resp)
    }

    override fun getUsersFromDataBase(): List<Result> {
        return db.userDao().getUsers()
    }

    override fun clearUsersInDataBase() {
        db.userDao().clearUsers()
    }

    override fun addUsersInDataBase(users: List<Result>) {
        db.userDao().addUsers(users)
    }
}