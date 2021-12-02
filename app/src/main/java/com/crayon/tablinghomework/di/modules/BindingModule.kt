package com.crayon.tablinghomework.di.modules

import com.bumptech.glide.RequestManager
import com.crayon.tablinghomework.di.scopes.DataBindingScoped
import com.crayon.tablinghomework.presentation.navigation.store_interest.StoreBindingAdapter
import dagger.Module
import dagger.Provides

@Module
object BindingModule {

    @Provides
    @DataBindingScoped
    fun provideStoreBindingAdapter(glide: RequestManager): StoreBindingAdapter = StoreBindingAdapter(glide)

}