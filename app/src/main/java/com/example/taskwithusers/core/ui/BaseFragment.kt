package com.example.taskwithusers.core.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Abstract base class for fragments.
 * @param VM The type of ViewModel associated with the fragment.
 * @param VB The type of ViewBinding associated with the fragment.
 * @property layoutID The layout resource ID for the fragment.
 */
abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(layoutID: Int) :
    Fragment(layoutID) {

    /** The ViewModel associated with the fragment. */
    protected abstract val viewModel: VM

    /** The ViewBinding associated with the fragment. */
    protected abstract val binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        initListeners()
    }

    /**
     * Initializes the Navigation Controller if needed.
     * Override this method to provide custom initialization logic.
     */
    open fun initNavController() {}

    /**
     * Initializes views in the fragment.
     * Override this method to provide custom initialization logic.
     */
    open fun initViews() {}

    /**
     * Initializes listeners for UI components.
     * Override this method to provide custom initialization logic.
     */
    open fun initListeners() {}

    /**
     * Initializes observers for LiveData objects.
     * Override this method to provide custom initialization logic.
     */
    open fun initObservers() {}
}