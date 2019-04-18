package com.novachevskyi.android.mvvmp.secondary.fragment

import com.novachevskyi.android.mvvmpCore.MvvmpView
import dagger.Module
import dagger.Provides

@Module
class DetailsModule {

    @Provides
    internal fun provideView(detailsFragment: DetailsFragment): MvvmpView<DetailsFragment> =
        detailsFragment
}
