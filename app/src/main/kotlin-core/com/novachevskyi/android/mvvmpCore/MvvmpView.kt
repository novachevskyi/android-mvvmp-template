package com.novachevskyi.android.mvvmpCore

import android.content.Context
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Observable

interface MvvmpView<V> {

    fun getContext(): Context?

    fun getLifecycleEvents(): Observable<LifecycleEvent>
}
