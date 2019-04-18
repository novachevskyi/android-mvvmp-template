package com.novachevskyi.android.mvvmpCore

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import com.novachevskyi.android.mvvmpCore.LifecycleEvent.*
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.ActivityEvent.*
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.Observable
import javax.inject.Inject

abstract class MvvmpActivity<V> : RxAppCompatActivity(), MvvmpView<V>, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun getContext(): Context? {
        return this
    }

    override fun getLifecycleEvents(): Observable<LifecycleEvent> =

        lifecycle()
            .filter { it == CREATE || it == START || it == ActivityEvent.RESUME || it == STOP || it == DESTROY }
            .map {
                when (it) {
                    CREATE -> ENTER_SCOPE
                    START -> ATTACH_VIEW
                    ActivityEvent.RESUME -> LifecycleEvent.RESUME
                    STOP -> DETACH_VIEW
                    DESTROY -> EXIT_SCOPE
                    else -> throw IllegalStateException("Unexpected value for lifecycle: $it")
                }
            }
}
