package com.example.taskwithusers.presentation.home_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskwithusers.core.network.result.Resource
import com.example.taskwithusers.core.ui.BaseViewModel
import com.example.taskwithusers.domain.entity.Result
import com.example.taskwithusers.domain.entity.User
import com.example.taskwithusers.domain.useCase.AddUsersInDataBaseUseCase
import com.example.taskwithusers.domain.useCase.ClearUsersInDataBaseUseCase
import com.example.taskwithusers.domain.useCase.GetUsersFromDataBaseUseCase
import com.example.taskwithusers.domain.useCase.GetUsersUseCase

/**
 * ViewModel for the home screen.
 * @param repository The repository used for fetching user data.
 */
class HomeViewModel(
    val getUsersUseCase: GetUsersUseCase,
    val clearUsersInDataBaseUseCase: ClearUsersInDataBaseUseCase,
    val addUsersInDataBaseUseCase: AddUsersInDataBaseUseCase,
    val getUsersFromDataBaseUseCase: GetUsersFromDataBaseUseCase,

    ) : BaseViewModel() {
    val loading = MutableLiveData<Boolean>()


    /**
     * Retrieves a LiveData object containing a Resource representing a list of users.
     * @param count The count of users to fetch.
     * @return LiveData<Resource<User>> containing the result of the operation.
     */
    fun getUsers(count: String): LiveData<Resource<User>> {
        return getUsersUseCase.execute(count)
    }

    fun getUsersFromDataBase(): List<Result>{
        return getUsersFromDataBaseUseCase()
    }

    fun clearUsersInDataBase(){
        clearUsersInDataBaseUseCase()
    }

    fun addUsersInDataBase(users: List<Result>){
        addUsersInDataBaseUseCase.execute(users)
    }
}