package com.novachevskyi.android.mvvmpCore

enum class LifecycleEvent {
    ENTER_SCOPE,
    ATTACH_VIEW,
    RESUME,
    DETACH_VIEW,
    EXIT_SCOPE
}

abstract class Presenter : HasMvvmpView
