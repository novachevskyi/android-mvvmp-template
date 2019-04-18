package com.novachevskyi.android.mvvmp.secondary

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.novachevskyi.android.R
import com.novachevskyi.android.databinding.ActivitySecondaryBinding
import com.novachevskyi.android.mvvmp.secondary.fragment.DetailsFragment
import com.novachevskyi.android.mvvmpCore.MvvmpActivity
import javax.inject.Inject

class SecondaryActivity : MvvmpActivity<SecondaryActivity>() {

    @Inject
    internal lateinit var presenter: SecondaryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        val binding = DataBindingUtil.setContentView<ActivitySecondaryBinding>(this, R.layout.activity_secondary)
        binding.executePendingBindings()

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, newFragmentInstance())
                .commitAllowingStateLoss()
        }
    }

    private fun newFragmentInstance(): DetailsFragment {
        val args = Bundle()
        val fragment = DetailsFragment()
        fragment.arguments = args
        return fragment
    }
}
