package com.crayon.tablinghomework.di.modules

import com.crayon.tablinghomework.presentation.MainActivity
import com.crayon.tablinghomework.di.scopes.ActivityScoped
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun getMainActivity(): MainActivity

}