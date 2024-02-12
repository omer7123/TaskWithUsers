package com.example.taskwithusers.ui.home_fragment

import androidx.recyclerview.widget.DiffUtil
import com.example.taskwithusers.data.remote.models.Result
import com.example.taskwithusers.data.remote.models.User

class UserDiffCallback : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }
}