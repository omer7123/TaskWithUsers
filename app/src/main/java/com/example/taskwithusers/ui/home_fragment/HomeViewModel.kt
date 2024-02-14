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

/**
 * ViewModel for the home screen.
 * @param repository The repository used for fetching user data.
 */
class HomeViewModel(val repository: Repository) : BaseViewModel() {
    val loading = MutableLiveData<Boolean>()


    /**
     * Retrieves a LiveData object containing a Resource representing a list of users.
     * @param count The count of users to fetch.
     * @return LiveData<Resource<User>> containing the result of the operation.
     */
    fun getUsers(count: String): LiveData<Resource<User>> {
        return repository.getUsers(count)
    }
}