package com.novachevskyi.android.mvvmp.primary

import android.databinding.ObservableField
import android.view.View
import com.novachevskyi.android.mvvmpCore.ViewModel
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class PrimaryViewModel
@Inject constructor() : ViewModel {

    val title = ObservableField<String>()

    val onNavigationClicked: PublishSubject<View> = PublishSubject.create()
}
