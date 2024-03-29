package com.example.taskwithusers.di

import com.example.taskwithusers.presentation.home_fragment.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        HomeViewModel(
            getUsersUseCase = get(),
            getUsersFromDataBaseUseCase = get(),
            clearUsersInDataBaseUseCase = get(),
            addUsersInDataBaseUseCase = get()
        )
    }

}