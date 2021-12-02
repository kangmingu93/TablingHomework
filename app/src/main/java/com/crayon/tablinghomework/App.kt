package com.crayon.tablinghomework

import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.crayon.tablinghomework.di.DaggerAppComponent
import com.crayon.tablinghomework.di.modules.BindingModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.conscrypt.Conscrypt
import java.security.Security

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val bindingComponent = DaggerAppComponent.builder()
            .bindingModule(BindingModule)
            .application(this)
            .glide(Glide.with(this))
            .build()

        DataBindingUtil.setDefaultComponent(bindingComponent)

        return bindingComponent
    }

    override fun onCreate() {
        super.onCreate()
        Security.insertProviderAt(Conscrypt.newProvider(), 1)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this).onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this).onTrimMemory(level)
    }
}