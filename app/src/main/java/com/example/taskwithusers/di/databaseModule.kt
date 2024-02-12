package com.example.taskwithusers.di

import androidx.room.Room
import com.example.taskwithusers.data.local.room.AppDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDataBase::class.java, "database")
            .allowMainThreadQueries().build()
    }
}