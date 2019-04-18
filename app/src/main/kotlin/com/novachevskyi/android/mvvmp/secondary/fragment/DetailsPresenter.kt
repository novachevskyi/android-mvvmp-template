package com.novachevskyi.android.mvvmp.secondary.fragment

import android.content.Intent
import com.novachevskyi.android.mvvmp.primary.PrimaryActivity
import com.novachevskyi.android.mvvmpCore.MvvmpView
import com.novachevskyi.android.mvvmpCore.ViewModelPresenter
import com.novachevskyi.android.mvvmpCore.attachView
import com.novachevskyi.android.mvvmpCore.exitScope
import javax.inject.Inject

class DetailsPresenter
@Inject constructor(
    override val view: MvvmpView<DetailsFragment>,
    override val viewModel: DetailsViewModel
) : ViewModelPresenter<DetailsViewModel>() {

    init {

        attachView()
            .doOnNext {
                viewModel.title.set(DetailsPresenter::class.java.simpleName)
            }
            .takeUntil(exitScope())
            .subscribe()

        viewModel.onNavigationClicked
            .doOnNext { navigateToMain() }
            .takeUntil(exitScope())
            .subscribe()
    }

    private fun navigateToMain() {
        view.getContext()?.startActivity(Intent(view.getContext(), PrimaryActivity::class.java))
    }
}
