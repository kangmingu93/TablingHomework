package com.crayon.tablinghomework.domain.repository

import com.crayon.tablinghomework.domain.model.RestaurantsResponse
import io.reactivex.rxjava3.core.Single

interface RestaurantsRepository {

    fun getSaveRestaurants(): Single<RestaurantsResponse>

    fun getRecentRestaurants(): Single<RestaurantsResponse>

}