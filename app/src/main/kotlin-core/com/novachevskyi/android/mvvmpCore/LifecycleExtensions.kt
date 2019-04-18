package com.novachevskyi.android.mvvmpCore

import com.novachevskyi.android.mvvmpCore.LifecycleEvent.*
import io.reactivex.Observable

fun Presenter.enterScope() = lifecycle(ENTER_SCOPE)

fun Presenter.attachView() = lifecycle(ATTACH_VIEW)

fun Presenter.resume() = lifecycle(RESUME)

fun Presenter.detachView() = lifecycle(DETACH_VIEW)

fun Presenter.exitScope() = lifecycle(EXIT_SCOPE)

fun Presenter.lifecycle(event: LifecycleEvent): Observable<LifecycleEvent> =
    view.getLifecycleEvents().filter { it == event }
