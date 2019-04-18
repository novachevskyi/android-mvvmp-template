package com.novachevskyi.android.mvvmp.secondary

import com.novachevskyi.android.mvvmp.secondary.fragment.DetailsFragment
import com.novachevskyi.android.mvvmp.secondary.fragment.DetailsModule
import com.novachevskyi.android.mvvmpCore.MvvmpView
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SecondaryModule {

    @Binds
    internal abstract fun provideView(detailActivity: SecondaryActivity): MvvmpView<SecondaryActivity>

    @ContributesAndroidInjector(modules = [(DetailsModule::class)])
    internal abstract fun provideDetailsFragment(): DetailsFragment
}
