package com.novachevskyi.android.application

import com.novachevskyi.android.mvvmp.primary.PrimaryActivity
import com.novachevskyi.android.mvvmp.primary.PrimaryPrimaryModule
import com.novachevskyi.android.mvvmp.secondary.SecondaryActivity
import com.novachevskyi.android.mvvmp.secondary.SecondaryModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(PrimaryPrimaryModule::class)])
    internal abstract fun bindMainActivity(): PrimaryActivity

    @ContributesAndroidInjector(modules = [(SecondaryModule::class)])
    internal abstract fun bindDetailActivity(): SecondaryActivity
}
