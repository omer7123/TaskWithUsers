package com.example.taskwithusers.ui.detail_fragment

import android.annotation.SuppressLint
import android.graphics.Color
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.taskwithusers.R
import com.example.taskwithusers.core.ui.BaseFragment
import com.example.taskwithusers.core.ui.BaseViewModel
import com.example.taskwithusers.data.remote.models.Result
import com.example.taskwithusers.databinding.FragmentDetailBinding
import com.example.taskwithusers.extensions.load
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Locale


/**
 * Fragment for displaying user details.
 * This fragment extends BaseFragment and uses FragmentDetailBinding for layout binding.
 */
class DetailFragment : BaseFragment<BaseViewModel, FragmentDetailBinding>(R.layout.fragment_detail) {

    override val binding: FragmentDetailBinding by viewBinding()
    override val viewModel: BaseViewModel by viewModel()

    /**
     * Initializes views in the fragment.
     * Populates UI components with user details retrieved from arguments.
     */
    @SuppressLint("SetTextI18n")
    override fun initViews() {
        super.initViews()
        val user = arguments?.getSerializable("user") as? Result
        if (user != null) {
            binding.apply {
                nameTv.text = ("${user.name?.title} ${user.name?.first} ${user.name?.last}")
                avaIv.load(user.picture?.large)

                firstFill(user)
                secondFill(user)
                thirdFill(user)
                registerFill(user)
            }
        }
    }


    private fun registerFill(user: Result) {
        binding.apply {
            registrageTv.text = user.registered?.age.toString()

            val date = formatDate(user.registered?.date.toString())
            registrdateTv.text = date
        }

    }

    private fun thirdFill(user: Result) {
        binding.apply {
            emailTv.text = user.email
            phoneTv.text = user.phone
            cellTv.text = user.cell.toString()
        }
    }

    private fun secondFill(user: Result) {
        binding.apply {
            usernameTv.text = user.login?.username
            genderTv.text = user.gender
            if (user.gender == "male") genderTv.setTextColor(Color.CYAN)
            else genderTv.setTextColor(Color.MAGENTA)
            nationalityTv.text = user.nat
        }
    }

    private fun firstFill(user:Result) {
        binding.apply {
            countryTv.text = user.location?.country
            cityTv.text = user.location?.city
            streetTv.text = user.location?.street?.name
            houseTv.text = user.location?.street?.number.toString()
            postcodeTv.text = user.location?.postcode.toString()
        }
    }

    fun formatDate(dateTimeString: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val date = inputFormat.parse(dateTimeString)
        return outputFormat.format(date!!)
    }

}