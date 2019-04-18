package com.novachevskyi.android.mvvmpCore

import android.os.Bundle
import com.novachevskyi.android.mvvmpCore.LifecycleEvent.*
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.android.FragmentEvent.*
import com.trello.rxlifecycle2.components.support.RxFragment
import dagger.android.support.AndroidSupportInjection
import io.reactivex.Observable

abstract class MvvmpFragment<V> : RxFragment(), MvvmpView<V> {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun getLifecycleEvents(): Observable<LifecycleEvent> = lifecycle()
        .filter { it == CREATE_VIEW || it == START || it == FragmentEvent.RESUME || it == STOP || it == DESTROY }
        .map {
            when (it) {
                CREATE_VIEW -> ENTER_SCOPE
                START -> ATTACH_VIEW
                FragmentEvent.RESUME -> LifecycleEvent.RESUME
                STOP -> DETACH_VIEW
                DESTROY -> EXIT_SCOPE
                else -> throw IllegalStateException("Unexpected value for lifecycle: $it")
            }
        }
}
