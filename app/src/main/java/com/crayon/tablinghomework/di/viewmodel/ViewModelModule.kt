package com.crayon.tablinghomework.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.crayon.tablinghomework.presentation.navigation.store_interest.recent.RecentStoreViewModel
import com.crayon.tablinghomework.presentation.navigation.store_interest.save.SaveStoreViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SaveStoreViewModel::class)
    abstract fun bindSaveStoreViewModel(viewModel: SaveStoreViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RecentStoreViewModel::class)
    abstract fun bindRecentStoreViewModel(viewModel: RecentStoreViewModel): ViewModel

}