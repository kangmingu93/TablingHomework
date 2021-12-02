package com.crayon.tablinghomework.di.modules

import com.crayon.tablinghomework.presentation.navigation.store_interest.StoreAdapter
import dagger.Module
import dagger.Provides

@Module
object AdapterModule {

    @Provides
    fun provideStoreAdapter(): StoreAdapter {
        return StoreAdapter()
    }

}