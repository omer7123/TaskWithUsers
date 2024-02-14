package com.example.taskwithusers.ui.home_fragment

import androidx.recyclerview.widget.DiffUtil
import com.example.taskwithusers.data.remote.models.Result
import com.example.taskwithusers.data.remote.models.User

/**
 * DiffUtil.ItemCallback implementation for comparing user items in a RecyclerView.
 * This class is used by RecyclerView adapters to efficiently update the list content.
 */
class UserDiffCallback : DiffUtil.ItemCallback<Result>() {

    /**
     * Called to check whether two objects represent the same item.
     * @param oldItem The old item object.
     * @param newItem The new item object.
     * @return True if the items represent the same object, false otherwise.
     */
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    /**
     * Called to check whether the contents of two items are the same.
     * @param oldItem The old item object.
     * @param newItem The new item object.
     * @return True if the item contents are the same, false otherwise.
     */
    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }
}