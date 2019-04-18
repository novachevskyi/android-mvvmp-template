package com.novachevskyi.android.bindingAdapters

import android.databinding.BindingAdapter
import android.view.View
import io.reactivex.subjects.PublishSubject

object ButtonsBindingAdapters {

    @BindingAdapter("onClick")
    @JvmStatic
    fun onClick(view: View, subject: PublishSubject<View>) {
        view.setOnClickListener { subject.onNext(view) }
    }
}
