package com.example.taskwithusers.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskwithusers.data.remote.models.Result

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUsers(users: List<Result>)

    @Query("SELECT * FROM result")
    fun getUsers(): List<Result>

    @Query("DELETE FROM result")
    fun clearUsers()
}