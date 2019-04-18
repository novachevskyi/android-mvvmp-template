package com.novachevskyi.android.mvvmp.secondary.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.novachevskyi.android.R
import com.novachevskyi.android.databinding.FragmentDetailsBinding
import com.novachevskyi.android.mvvmpCore.MvvmpFragment
import javax.inject.Inject

class DetailsFragment : MvvmpFragment<DetailsFragment>() {

    @Inject
    lateinit var presenter: DetailsPresenter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailsBinding>(inflater, R.layout.fragment_details, container, false)
        binding.viewModel = presenter.viewModel
        return binding.root
    }
}
