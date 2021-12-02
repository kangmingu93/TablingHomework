package com.crayon.tablinghomework.di.modules

import com.crayon.tablinghomework.data.repository.RestaurantsRepositoryImpl
import com.crayon.tablinghomework.domain.repository.RestaurantsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideRepository(repositoryImpl: RestaurantsRepositoryImpl) : RestaurantsRepository

}