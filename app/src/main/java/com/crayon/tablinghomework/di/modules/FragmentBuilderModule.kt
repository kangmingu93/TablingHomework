package com.crayon.tablinghomework.di.modules

import com.crayon.tablinghomework.presentation.navigation.home.HomeFragment
import com.crayon.tablinghomework.presentation.navigation.my.MyFragment
import com.crayon.tablinghomework.presentation.navigation.search.SearchFragment
import com.crayon.tablinghomework.presentation.navigation.store_interest.StoreInterestFragment
import com.crayon.tablinghomework.presentation.navigation.store_interest.recent.RecentStoreFragment
import com.crayon.tablinghomework.presentation.navigation.store_interest.save.SaveStoreFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun getHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun getSearchFragment(): SearchFragment

    @ContributesAndroidInjector
    abstract fun getStoreInterestFragment(): StoreInterestFragment

    @ContributesAndroidInjector
    abstract fun getMyFragment(): MyFragment

    @ContributesAndroidInjector
    abstract fun getSaveStoreFragment(): SaveStoreFragment

    @ContributesAndroidInjector
    abstract fun getRecentStoreFragment(): RecentStoreFragment

}