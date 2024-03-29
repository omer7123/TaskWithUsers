package com.example.taskwithusers.ui.home_fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.taskwithusers.R
import com.example.taskwithusers.core.network.result.Status
import com.example.taskwithusers.core.ui.BaseFragment
import com.example.taskwithusers.databinding.FragmentHomeBinding
import com.example.taskwithusers.domain.entity.Result
import com.example.taskwithusers.extensions.showToast
import com.example.taskwithusers.presentation.home_fragment.HomeViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home),
    HomeAdapter.Listener {

    override val binding: FragmentHomeBinding by viewBinding()

    private val adapter = HomeAdapter(this)
    private lateinit var navController: NavController
    override val viewModel: HomeViewModel by viewModel()


    override fun initListeners() {
        super.initListeners()
        viewModel.loading.observe(requireActivity()) {
            binding.progressCircular.isVisible = it
        }

        binding.swipeRefresh.setOnRefreshListener {
            requestUsers()

            binding.usersRv.layoutManager?.smoothScrollToPosition(
                binding.usersRv,
                RecyclerView.State(),
                0
            )
            binding.swipeRefresh.isRefreshing = false
        }

        binding.refreshTv.setOnClickListener {
            requestUsers()
        }
    }

    override fun initNavController() {
        super.initNavController()
        navController = findNavController()
    }

    override fun initViews() {
        super.initViews()
        binding.usersRv.adapter = adapter
        val users = viewModel.getUsersFromDataBase()
        if (users.isNotEmpty()) {
            adapter.submitList(viewModel.getUsersFromDataBase())
            viewModel.loading.value = false
        } else requestUsers()

    }

    override fun clickItem(user: Result) {
        val bundle = Bundle()
        bundle.putSerializable("user", user)
        navController.navigate(R.id.detailFragment, bundle)
    }

    override fun clickEmail(email: String?) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
        }
        startActivity(intent)

    }

    override fun clickPhone(phone: String?) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phone")
        }
        startActivity(intent)

    }

    override fun clickLocation(lat: String?, long: String?) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("geo:$lat,$long")
        }

        startActivity(intent)
    }

    private fun requestUsers() {
        viewModel.getUsers(USER_COUNT).observe(requireActivity()) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.value = false

                    it.data?.let { users ->
                        viewModel.clearUsersInDataBase()
                        viewModel.addUsersInDataBase(users.results)
                        adapter.submitList(users.results)
                    } ?: run {
                        val snackbar = Snackbar.make(
                            binding.swipeRefresh,
                            R.string.error_request,
                            Snackbar.LENGTH_LONG
                        )
                        snackbar.show()

                    }
                }

                Status.ERROR -> {
                    requireContext().showToast(it.msg.toString())
                    val snackbar = Snackbar.make(
                        binding.swipeRefresh,
                        it.msg.toString(),
                        Snackbar.LENGTH_LONG
                    )
                    snackbar.show()
                    viewModel.loading.value = false
                }

                Status.LOADING -> {
                    viewModel.loading.value = true
                }
            }
        }
    }
    companion object {
        private const val USER_COUNT = "5"
    }
}