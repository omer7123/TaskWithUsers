package com.example.taskwithusers.ui.detail_fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taskwithusers.data.remote.models.Result
import com.example.taskwithusers.databinding.FragmentDetailBinding
import com.example.taskwithusers.extensions.load


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.getSerializable("user") as? Result
        if (user != null) {
            binding.nameTv.text = ("${user.name?.title} ${user.name?.first} ${user.name?.last}")
            binding.avaIv.load(user.picture?.large)
            binding.addressTv.text =
                ("${user.location?.country}, city. ${user.location?.city}, street: ${user.location?.street?.name}, house: ${user.location?.street?.number}")
            binding.genderTv.text = user.gender

            if (user.gender == "male") binding.genderTv.setTextColor(Color.CYAN)
            else binding.genderTv.setTextColor(Color.MAGENTA)

        }
    }

}