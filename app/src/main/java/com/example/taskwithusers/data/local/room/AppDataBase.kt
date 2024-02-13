package com.example.taskwithusers.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskwithusers.data.remote.models.Result

@Database(
    entities = [Result::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao
}