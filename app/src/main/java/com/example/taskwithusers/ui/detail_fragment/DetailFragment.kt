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
            binding.apply {
                nameTv.text = ("${user.name?.title} ${user.name?.first} ${user.name?.last}")
                avaIv.load(user.picture?.large)

                countryTv.text = user.location?.country
                cityTv.text = user.location?.city
                streetTv.text = user.location?.street?.name
                houseTv.text = user.location?.street?.number.toString()
                postcodeTv.text = user.location?.postcode.toString()



                usernameTv.text = user.login?.username
                genderTv.text = user.gender
                if (user.gender == "male") genderTv.setTextColor(Color.CYAN)
                else genderTv.setTextColor(Color.MAGENTA)
                nationalityTv.text = user.nat


                emailTv.text = user.email
                phoneTv.text = user.phone
                cellTv.text = user.cell.toString()

                registrageTv.text = user.registered?.age.toString()
                registrdateTv.text = user.registered?.date

            }
        }

    }

}