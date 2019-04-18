package com.novachevskyi.android.mvvmp.primary

import android.content.Intent
import com.novachevskyi.android.mvvmp.secondary.SecondaryActivity
import com.novachevskyi.android.mvvmpCore.MvvmpView
import com.novachevskyi.android.mvvmpCore.ViewModelPresenter
import com.novachevskyi.android.mvvmpCore.attachView
import com.novachevskyi.android.mvvmpCore.exitScope
import javax.inject.Inject

class PrimaryPresenter
@Inject constructor(
    override val view: MvvmpView<PrimaryActivity>,
    override val viewModel: PrimaryViewModel
) : ViewModelPresenter<PrimaryViewModel>() {

    init {

        attachView()
            .doOnNext {
                viewModel.title.set(PrimaryPresenter::class.java.simpleName)
            }
            .takeUntil(exitScope())
            .subscribe()

        viewModel.onNavigationClicked
            .doOnNext { navigateToDetails() }
            .takeUntil(exitScope())
            .subscribe()
    }

    private fun navigateToDetails() {
        view.getContext()?.startActivity(Intent(view.getContext(), SecondaryActivity::class.java))
        (view.getContext() as? PrimaryActivity)?.finish()
    }
}
