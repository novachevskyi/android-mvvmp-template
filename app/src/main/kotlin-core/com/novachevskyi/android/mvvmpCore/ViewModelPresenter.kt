package com.novachevskyi.android.mvvmpCore

abstract class ViewModelPresenter<out VM : ViewModel> : Presenter(), HasViewModel<VM>
