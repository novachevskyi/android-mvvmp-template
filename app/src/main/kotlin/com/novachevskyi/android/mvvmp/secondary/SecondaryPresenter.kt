package com.novachevskyi.android.mvvmp.secondary

import com.novachevskyi.android.mvvmpCore.MvvmpView
import com.novachevskyi.android.mvvmpCore.ViewModelPresenter
import javax.inject.Inject

class SecondaryPresenter
@Inject constructor(
    override val view: MvvmpView<SecondaryActivity>,
    override val viewModel: SecondaryViewModel
) : ViewModelPresenter<SecondaryViewModel>()
