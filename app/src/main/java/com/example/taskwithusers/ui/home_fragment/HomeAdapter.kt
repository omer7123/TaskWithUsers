package com.example.taskwithusers.ui.home_fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskwithusers.data.remote.models.Result
import com.example.taskwithusers.databinding.ItemUserBinding
import com.example.taskwithusers.extensions.load

class HomeAdapter(private val listener: Listener) :
    ListAdapter<Result, HomeAdapter.ViewHolder>(UserDiffCallback()) {

    class ViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Result, listener: Listener) {
            binding.emailTv.text = item.email
            binding.phoneTv.text = item.phone
            binding.nameTv.text = ("${item.name?.title} ${item.name?.first} ${item.name?.last}")
            binding.flagIv.load(item.picture!!.large)
            binding.locationTv.text =
                ("Страна: " + item.location?.country + ", г. " + item.location?.city)

            itemView.setOnClickListener {
                listener.clickItem(item)
            }
            binding.emailTv.setOnClickListener {
                listener.clickEmail(item.email)
            }
            binding.phoneTv.setOnClickListener {
                listener.clickPhone(item.phone)
            }
            binding.locationTv.setOnClickListener {
                listener.clickLocation(item.location?.coordinates!!.latitude, item.location!!.coordinates!!.longitude)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position), listener)
    }

    interface Listener {
        fun clickItem(user: Result)
        fun clickEmail(email: String?)
        fun clickPhone(phone: String?)
        fun clickLocation(lat: String?, long: String?)
    }
}

