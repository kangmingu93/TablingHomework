package com.crayon.tablinghomework.data.repository

import com.crayon.tablinghomework.data.source.RetrofitService
import com.crayon.tablinghomework.domain.model.RestaurantsResponse
import com.crayon.tablinghomework.domain.repository.RestaurantsRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RestaurantsRepositoryImpl @Inject constructor(
    private val retrofitService: RetrofitService
) : RestaurantsRepository {

    override fun getSaveRestaurants(): Single<RestaurantsResponse> {
        return retrofitService.getSaveRestaurants()
    }

    override fun getRecentRestaurants(): Single<RestaurantsResponse> {
        return retrofitService.getRecentRestaurants()
    }
}