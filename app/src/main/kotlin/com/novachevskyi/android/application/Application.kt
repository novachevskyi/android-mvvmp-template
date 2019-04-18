package com.novachevskyi.android.application

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class Application : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .apply { inject(this@Application) }
}
