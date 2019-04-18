package com.novachevskyi.android.mvvmp.primary

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.novachevskyi.android.R
import com.novachevskyi.android.databinding.ActivityPrimaryBinding
import com.novachevskyi.android.mvvmpCore.MvvmpActivity
import javax.inject.Inject

class PrimaryActivity : MvvmpActivity<PrimaryActivity>() {

    @Inject
    lateinit var presenter: PrimaryPresenter

    override fun getContext(): Context? {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityPrimaryBinding>(this, R.layout.activity_primary)
        binding.viewModel = presenter.viewModel
        binding.executePendingBindings()
    }
}
