package com.example.taskwithusers.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.taskwithusers.core.network.result.Resource
import com.example.taskwithusers.data.remote.RemoteDataSource
import com.example.taskwithusers.data.remote.models.User
import kotlinx.coroutines.Dispatchers

class Repository(val dataSource: RemoteDataSource) {

    fun getUsers(count: String): LiveData<Resource<User>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        val resp = dataSource.getUsers(count)
        emit(Resource.success(resp.data))
    }
}