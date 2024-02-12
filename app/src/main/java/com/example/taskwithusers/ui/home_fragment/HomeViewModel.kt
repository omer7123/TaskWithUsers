package com.example.taskwithusers.ui.home_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskwithusers.core.network.result.Resource
import com.example.taskwithusers.core.ui.BaseViewModel
import com.example.taskwithusers.data.remote.models.Result
import com.example.taskwithusers.data.remote.models.User
import com.example.taskwithusers.data.remote.RemoteDataSource
import com.example.taskwithusers.repository.Repository

class HomeViewModel(val repository: Repository) : BaseViewModel() {
    val loading = MutableLiveData<Boolean>()

    fun getUsers(count: String): LiveData<Resource<User>> {
        return repository.getUsers(count)
    }
}