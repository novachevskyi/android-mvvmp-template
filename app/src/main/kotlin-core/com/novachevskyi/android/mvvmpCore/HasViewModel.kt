package com.novachevskyi.android.mvvmpCore

interface HasViewModel<out VM : ViewModel> {
    val viewModel: VM
}
