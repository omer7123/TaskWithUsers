package com.example.taskwithusers.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.taskwithusers.core.network.result.Resource
import com.example.taskwithusers.data.remote.models.Result
import com.example.taskwithusers.data.remote.models.User
import com.example.taskwithusers.data.remote.RemoteDataSource
import com.example.taskwithusers.data.remote.UserApi
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create



class Repository(val dataSource: RemoteDataSource) {

    fun getUsers(count: String): LiveData<Resource<User>> = liveData(Dispatchers.IO){
        emit(Resource.loading())
        val resp = dataSource.getUsers(count)
        emit(Resource.success(resp.data))
    }
}