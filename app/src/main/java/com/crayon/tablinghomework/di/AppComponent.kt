package com.crayon.tablinghomework.di

import android.app.Application
import androidx.databinding.DataBindingComponent
import com.bumptech.glide.RequestManager
import com.crayon.tablinghomework.App
import com.crayon.tablinghomework.di.modules.*
import com.crayon.tablinghomework.di.scopes.DataBindingScoped
import com.crayon.tablinghomework.di.viewmodel.ViewModelModule
import com.crayon.tablinghomework.presentation.navigation.store_interest.StoreBindingAdapter
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@DataBindingScoped
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DataModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        AdapterModule::class,
        BindingModule::class
    ]
)
interface AppComponent : AndroidInjector<App>, DataBindingComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

        @BindsInstance
        fun glide(glide: RequestManager): Builder
        fun bindingModule(bindingModule: BindingModule): Builder
    }

    override fun getStoreBindingAdapter(): StoreBindingAdapter
}