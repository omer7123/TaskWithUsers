package com.example.taskwithusers.di

import com.example.taskwithusers.repository.Repository
import com.example.taskwithusers.ui.home_fragment.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel { HomeViewModel(get()) }

}