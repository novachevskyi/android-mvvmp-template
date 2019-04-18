package com.novachevskyi.android.mvvmp.primary

import com.novachevskyi.android.mvvmpCore.MvvmpView
import dagger.Binds
import dagger.Module

@Module
abstract class PrimaryPrimaryModule {

    @Binds
    internal abstract fun provideView(mainActivity: PrimaryActivity): MvvmpView<PrimaryActivity>
}
